package se.kth.paint.model.handlers;


import java.util.ArrayList;

import se.kth.paint.model.Oval;
import se.kth.paint.model.Pentagon;
import se.kth.paint.model.Rectangle;
import se.kth.paint.model.Shape;
import se.kth.paint.model.Triangle;

public class ShapeHandler {

	public static ArrayList<Shape> getAllShapes() {
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		shapes.add(new Oval());
		shapes.add(new Rectangle());
		shapes.add(new Triangle());
		shapes.add(new Pentagon());
		
		return shapes;
	}
}
