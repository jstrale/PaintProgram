/**
 * Description: Represents a command for filling a shape
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-11
 * 
 */
package se.kth.paint.model.commands;

import se.kth.paint.model.Shape;
import se.kth.paint.model.interfaces.EditCommand;

public class FillShape implements EditCommand {

	private Shape mUnfilledShape;

	public FillShape(Shape shape) {
		mUnfilledShape = shape;
	}

	@Override
	public void undo() {
		mUnfilledShape.unsetFilled();
	}
}
