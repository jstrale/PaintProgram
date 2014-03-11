/**
 * Description: Interface for prototype design pattern
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-05
 * 
 */
package se.kth.paint.model.interfaces;

import se.kth.paint.model.Shape;

public interface Copyable {

	public Shape copy();
}
