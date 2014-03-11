/**
 * Description: Represents a command for changing line width of a shape
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-11
 * 
 */
package se.kth.paint.model.commands;

import se.kth.paint.model.Shape;
import se.kth.paint.model.interfaces.EditCommand;

public class LineWidthShape implements EditCommand {

	private int mPreviousLineWidth;
	private Shape mShape;
	
	public LineWidthShape(Shape shape) {
		mShape = shape;
		mPreviousLineWidth = mShape.getLineWidth();
	}
	
	@Override
	public void undo() {
		mShape.setLineWidth(mPreviousLineWidth);
	}
}
