/**
 * Description: Represents a shape in the form of a star
 * 
 * @author Johan Stråle
 * @since 2014-03-10
 */
package se.kth.paint.model;

import java.awt.Graphics2D;

public class Star extends Shape {

	@Override
	protected void drawShape(Graphics2D g2) {
		g2.drawPolygon(getXPoints(), getYPoints(), 3);
		g2.drawPolygon(getXPoints(), getReverseYPoints(), 3);
	}
	
	@Override
	protected void drawFilledShape(Graphics2D g2) {
		g2.fillPolygon(getXPoints(), getYPoints(), 3);
		g2.fillPolygon(getXPoints(), getReverseYPoints(), 3);
	}
	
	@Override
	public Shape copy() {
		return new Star();
	}
	
	private int[] getReverseYPoints() {
		int y = this.getPos().getY() + Shape.SIZE + Shape.SIZE/3;
		return new int[]{y, y - Shape.SIZE, y - Shape.SIZE};
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
