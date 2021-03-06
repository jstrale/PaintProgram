/**
 * Description: Represents a shape in the form of a triangle
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.model;

import java.awt.Graphics2D;

public class Triangle extends Shape {

	private static final long serialVersionUID = 1L;

	@Override
	protected void drawShape(Graphics2D g2) {
		g2.drawPolygon(getXPoints(), getYPoints(), 3);
	}
	
	@Override
	protected void drawFilledShape(Graphics2D g2) {
		g2.fillPolygon(getXPoints(), getYPoints(), 3);
	}
	
	@Override
	public Shape copy() {
		return new Triangle();
	}
	
	private int[] getXPoints() {
		int x = this.getPos().getX();
		return new int[]{x, x + Shape.SIZE, x - Shape.SIZE};
	}
	
	private int[] getYPoints() {
		int y = this.getPos().getY();
		return new int[]{y, y + Shape.SIZE, y + Shape.SIZE};
	}

}
