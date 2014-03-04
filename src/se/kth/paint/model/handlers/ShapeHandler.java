package se.kth.paint.model.handlers;

import java.util.ArrayList;

import se.kth.paint.model.Oval;
import se.kth.paint.model.Shape;

public class ShapeHandler {

	public static ArrayList<Shape> getAllShapes() {
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		shapes.add(new Oval());
		
		return shapes;
	}
}
