/**
 * Description: Represents a shape in the form of an oval
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.model;

import java.awt.Graphics2D;

public class Oval extends Shape {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void drawShape(Graphics2D g2) {
		g2.drawOval(this.getPos().getX(), this.getPos().getY(), Shape.SIZE, Shape.SIZE);
	}

	@Override
	protected void drawFilledShape(Graphics2D g2) {
		g2.fillOval(this.getPos().getX(), this.getPos().getY(), Shape.SIZE, Shape.SIZE);
	}

	@Override
	public Shape copy() {
		return new Oval();
	}
}
