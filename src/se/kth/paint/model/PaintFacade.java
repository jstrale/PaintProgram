/**
 * Description: This class implements the design pattern facade which 
 * hides the complexities of the model for the users.
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.model;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

import se.kth.paint.model.commands.AddShape;
import se.kth.paint.model.commands.ColorShape;
import se.kth.paint.model.commands.DeleteShape;
import se.kth.paint.model.commands.FillShape;
import se.kth.paint.model.commands.LineWidthShape;
import se.kth.paint.model.commands.UnfillShape;
import se.kth.paint.model.handlers.ColorHandler;
import se.kth.paint.model.handlers.FileHandler;
import se.kth.paint.model.handlers.LineWidthHandler;
import se.kth.paint.model.handlers.ShapeHandler;
import se.kth.paint.model.interfaces.EditCommand;

public class PaintFacade extends Observable {

	private static final int UNDO_STACK_SIZE = 10;
	private List<Shape> mDrawnShapes;
	private List<Shape> mPrototypeShapes;
	private Stack<EditCommand> mUndoStack;
	private List<String> mColors;
	private ColorHandler mColorHandler;
	private LineWidthHandler mLineWidthHandler;

	public PaintFacade() {

		mDrawnShapes = new ArrayList<Shape>();
		mPrototypeShapes = new ArrayList<Shape>();
		mUndoStack = new FixedStack<EditCommand>(UNDO_STACK_SIZE);
		mColorHandler = new ColorHandler();
		mLineWidthHandler = new LineWidthHandler();

		fillPrototypeList();
		fillColorList();
	}

	public void drawShape(String shapeType, boolean isFilled, int x, int y,
			String color, String lineWidth) {

		Shape shape = null;

		for (Shape s : mPrototypeShapes) {
			if (s.getName().equalsIgnoreCase(shapeType)) {
				shape = s.copy();
				break;
			}
		}

		if (shape != null) {
			shape.init(mColorHandler.getColor(color),
					mLineWidthHandler.getLineWidth(lineWidth), isFilled, x, y);
			mDrawnShapes.add(shape);

			mUndoStack.push(new AddShape(shape, mDrawnShapes));

			setChanged();
			notifyObservers();
		}
	}

	public void deleteShape() {

		Shape shapeToDelete = getMarkedShape();

		if (shapeToDelete != null) {
			mUndoStack.push(new DeleteShape(shapeToDelete, mDrawnShapes));
			mDrawnShapes.remove(shapeToDelete);
			notifyChange(true);
		}
	}

	public void markShape(int x, int y) {

		Position pos = new Position(x, y);
		boolean isChanged = false;
		boolean oneIsMarked = false;

		for (int i = mDrawnShapes.size() - 1; i >= 0; i--) {
			if (mDrawnShapes.get(i).isCoordinateWithinShape(pos)
					&& !oneIsMarked) {
				mDrawnShapes.get(i).setMarked();
				isChanged = true;
				oneIsMarked = true;
			} else if (mDrawnShapes.get(i).isMarked()) {
				mDrawnShapes.get(i).unsetMarked();
				isChanged = true;
			}
		}

		notifyChange(isChanged);
	}

	public void unmarkAllShapes() {

		Shape shape = getMarkedShape();

		if (shape != null) {
			shape.unsetMarked();
			notifyChange(true);
		}
	}

	public void toggleFillShape() {

		Shape shape = getMarkedShape();

		if (shape != null) {
			if (shape.isFilled()) {
				mUndoStack.push(new UnfillShape(shape));
				shape.unsetFilled();
			} else {
				mUndoStack.push(new FillShape(shape));
				shape.setFilled();
			}
			notifyChange(true);
		}
	}

	public void setMarkedShapeLineWidth(String width) {
		Shape shape = getMarkedShape();

		if (shape != null) {
			mUndoStack.push(new LineWidthShape(shape));
			shape.setLineWidth(mLineWidthHandler.getLineWidth(width));
			notifyChange(true);
		}
	}

	public void setMarkedShapeColor(String color) {
		Shape shape = getMarkedShape();
		if (shape != null) {
			mUndoStack.push(new ColorShape(shape));
			shape.setColor(mColorHandler.getColor(color));
			notifyChange(true);
		}
	}

	public List<Shape> getDrawnShapes() {
		return mDrawnShapes;
	}

	public Shape getMarkedShapeCopy() {

		Shape shape = getMarkedShape();

		if (shape != null) {
			Shape copy = shape.copy();
			copy.init(shape.getColor(), shape.getLineWidth(), shape.isFilled(),
					shape.getPos().getX(), shape.getPos().getY());
			return copy;
		}
		return shape;
	}

	public List<String> getPrototypeShapeNames() {
		List<String> shapeNames = new ArrayList<String>();

		for (Shape shape : mPrototypeShapes) {
			shapeNames.add(shape.getName());
		}
		return shapeNames;
	}

	public ArrayList<String> getLineWidthOptions() {
		return mLineWidthHandler.getLineWidths();
	}

	public List<String> getColors() {
		return mColors;
	}

	public String getLineWidthName(int width) {
		return mLineWidthHandler.getLineWidthName(width);
	}

	public String getColorName(Color color) {
		return mColorHandler.getColorName(color);
	}

	private void fillColorList() {
		mColors = mColorHandler.getColors();
	}

	private void fillPrototypeList() {
		mPrototypeShapes = ShapeHandler.getAllShapes();
	}

	private Shape getMarkedShape() {

		for (Shape shape : mDrawnShapes) {
			if (shape.isMarked())
				return shape;
		}
		return null;
	}

	private void notifyChange(boolean isChanged) {
		if (isChanged) {
			setChanged();
			notifyObservers();
		}
	}

	public void undo() {

		if (!mUndoStack.empty()) {
			EditCommand cmd = mUndoStack.pop();
			cmd.undo();
			notifyChange(true);
		}
	}
	
	public void clearCanvas() {
		mDrawnShapes.clear();
		mUndoStack.clear();
		notifyChange(true);
	}
	
	public boolean saveFile(File file) {
		return FileHandler.saveFile(file, mDrawnShapes);
	}
	
	public boolean openFile(File file) {
		List<Shape> shapes = FileHandler.openFile(file);
		
		if(shapes == null)
			return false;
		
		mDrawnShapes = shapes;
		mUndoStack.clear();
		notifyChange(true);
		return true;
	}
}
