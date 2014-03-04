/**
 * Description: Represents a shape in the form of a rectangle
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */
package se.kth.paint.model;

import java.awt.Graphics2D;

public class Rectangle extends Shape {
	
	@Override
	protected void drawShape(Graphics2D g2) {
		g2.drawRect(this.getPos().getX(), this.getPos().getY(), Shape.SIZE, Shape.SIZE);
	}

	@Override
	protected void drawFilledShape(Graphics2D g2) {
		g2.fillRect(this.getPos().getX(), this.getPos().getY(), Shape.SIZE, Shape.SIZE);
	}	
	
	@Override
	public Shape copy() {
		return new Rectangle();
	}

}




