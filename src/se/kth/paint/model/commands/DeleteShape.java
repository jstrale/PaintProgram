/**
 * Description: Represents a command for deleting a shape
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-11
 * 
 */
package se.kth.paint.model.commands;

import java.util.List;

import se.kth.paint.model.Shape;
import se.kth.paint.model.interfaces.EditCommand;

public class DeleteShape implements EditCommand {

	private Shape mDeletedShape;
	private List<Shape> mDrawnShapes;
	
	public DeleteShape(Shape shape, List<Shape> shapes) {
		mDeletedShape = shape;
		mDrawnShapes = shapes;
		mDeletedShape.unsetMarked();
	}
	
	@Override
	public void undo() {
		mDrawnShapes.add(mDeletedShape);
	}

}
