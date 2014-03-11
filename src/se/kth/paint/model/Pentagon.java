/**
 * Description: Represents a shape in the form of a pentagon
 * 
 * @author Helena Lindén
 * @since 2014-03-08
 * 
 */
package se.kth.paint.model;

import java.awt.Graphics2D;

public class Pentagon extends Shape {

	private static final long serialVersionUID = 1L;

	@Override
	protected void drawShape(Graphics2D g2) {
		g2.drawPolygon(getXPoints(), getYPoints(), 5);
	}

	@Override
	protected void drawFilledShape(Graphics2D g2) {
		g2.fillPolygon(getXPoints(), getYPoints(), 5);
	}

	@Override
	public Shape copy() {
		return new Pentagon();
	}
	
	private int[] getXPoints() {
		int x = this.getPos().getX();
		return new int[]{x, x + Shape.SIZE/2, x + Shape.SIZE/4, x - Shape.SIZE/4, x - Shape.SIZE/2};
	}
	
	private int[] getYPoints() {
		int y = this.getPos().getY();
		return new int[]{y, y + Shape.SIZE/3, y + Shape.SIZE, y + Shape.SIZE, y + Shape.SIZE/3};
	}

}
