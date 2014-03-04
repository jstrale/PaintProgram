/**
 * Description: The abstract class that describes a shape
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import se.kth.paint.model.handlers.ColorHandler;
import se.kth.paint.model.interfaces.Copyable;

public abstract class Shape implements Copyable {

	public final static int SIZE = 50;
	private Color mColor;
	private int mLineWidth;
	private boolean mIsFilled;
	private Position mPos;
	private boolean mIsMarked;

	public final void init(Color color, int lineWidth, boolean isFilled, int x,
			int y) {
		mColor = color;
		mLineWidth = lineWidth;
		mIsFilled = isFilled;
		mPos = new Position(x, y);
		mIsMarked = false;
	}

	public final void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		if (mIsMarked) {
			g2.setColor(ColorHandler.getMarkedColor());
		} else {
			g2.setColor(mColor);
		}
		g2.setStroke(new BasicStroke(mLineWidth));

		if (mIsFilled) {
			drawFilledShape(g2);
		} else {
			drawShape(g2);
		}
	}

	public boolean isCoordinateWithinShape(Position pos) {

		if (pos.getX() >= mPos.getX() && pos.getX() <= mPos.getX() + SIZE
				&& pos.getY() >= mPos.getY()
				&& pos.getY() <= mPos.getY() + SIZE) {
			return true;
		}
		return false;
	}
	
	public boolean isMarked() {
		return mIsMarked;
	}

	public void setMarked() {
		mIsMarked = true;
	}

	public void unsetMarked() {
		mIsMarked = false;
	}
	
	public void setFilled() {
		mIsFilled = true;
	}
	
	public void unsetFilled() {
		mIsFilled = false;
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

	public Color getColor() {
		return mColor;
	}
	
	public void setColor(Color color) {
		mColor = color;
	}

	public int getLineWidth() {
		return mLineWidth;
	}
	
	public void setLineWidth(int lineWidth) {
		mLineWidth = lineWidth;
	}

	public boolean isFilled() {
		return mIsFilled;
	}

	public Position getPos() {
		return mPos;
	}

	protected void drawShape(Graphics2D g2) {
	}

	protected void drawFilledShape(Graphics2D g2) {
	}
}
