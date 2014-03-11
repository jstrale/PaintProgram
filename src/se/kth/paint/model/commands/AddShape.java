/**
 * Description: Represents a command for adding a shape
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-11
 * 
 */
package se.kth.paint.model.commands;

import java.util.List;

import se.kth.paint.model.Shape;
import se.kth.paint.model.interfaces.EditCommand;

public class AddShape implements EditCommand{

	private Shape mAddedShape;
	private List<Shape> mDrawnShapes;
	
	
	public AddShape(Shape shape, List<Shape> shapes) {
		mAddedShape = shape;
		mDrawnShapes = shapes;
	}
	
	@Override
	public void undo() {
		mDrawnShapes.remove(mAddedShape);
	}
}
