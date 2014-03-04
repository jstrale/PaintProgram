/**
 * Description: This class implements the design pattern facade which 
 * hides the complexities of the model for the users.
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.model;

import java.util.ArrayList;
import java.util.Observable;

public class PaintFacade extends Observable {
	
	private ArrayList<Position> testPos;
	
	public PaintFacade() {
		testPos = new ArrayList<Position>();
	}
	
	public void testAddPos(int x, int y) {
		testPos.add(new Position(x, y));
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<Position> getTestPos() {
		return testPos;
	}
}
