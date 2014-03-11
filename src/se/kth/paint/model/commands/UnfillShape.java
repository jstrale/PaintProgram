/**
 * Description: Represents a command for remove the filling of a shape
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-11
 * 
 */
package se.kth.paint.model.commands;

import se.kth.paint.model.Shape;
import se.kth.paint.model.interfaces.EditCommand;

public class UnfillShape implements EditCommand {

	private Shape mFilledShape;
	
	public UnfillShape(Shape shape) {
		mFilledShape = shape;
	}
	
	@Override
	public void undo() {
		mFilledShape.setFilled();
	}

}
