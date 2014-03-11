/**
 * Description: Represents a stack with a fixed size
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-11
 * 
 */
package se.kth.paint.model;

import java.util.Stack;

public class FixedStack<E> extends Stack<E> {

	private static final long serialVersionUID = 1L;
	private int mSize;
	
	public FixedStack(int size) {
		super();
		mSize = size;
	}

	@Override
	public E push(E item) {
		
		while(this.size() >= mSize) {
			this.remove(0);
		}
		
		return super.push(item);
	}
}
