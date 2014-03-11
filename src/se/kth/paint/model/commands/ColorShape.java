/**
 * Description: Represents a command for changing color of a shape
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-11
 * 
 */
package se.kth.paint.model.commands;

import java.awt.Color;

import se.kth.paint.model.Shape;
import se.kth.paint.model.interfaces.EditCommand;

public class ColorShape implements EditCommand {

	private Color mPreviousColor;
	private Shape mShape;
	
	public ColorShape(Shape shape) {
		mShape = shape;
		mPreviousColor = mShape.getColor();
	}
	
	@Override
	public void undo() {
		mShape.setColor(mPreviousColor);
	}
}
