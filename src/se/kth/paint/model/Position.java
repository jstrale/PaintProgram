/**
 * Description: Represents a position (x, y)
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.model;

import java.io.Serializable;

public class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int mX, mY;

	public Position(int x, int y) {
		mX = x;
		mY = y;
	}

	public int getX() {
		return mX;
	}

	public int getY() {
		return mY;
	}
}
