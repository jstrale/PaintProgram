package se.kth.paint.model.handlers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class ColorHandler {
	
	private HashMap<String, Color> mColors;
	
	public ColorHandler() {
		mColors = new HashMap<String, Color>();
		
		initColors();
	}

	private void initColors() {
		
		mColors.put("Black", Color.BLACK);
		mColors.put("Blue", Color.BLUE);
		mColors.put("Green", Color.GREEN);
		mColors.put("Orange", Color.ORANGE);
		mColors.put("Pink", Color.PINK);
		mColors.put("Purple", Color.MAGENTA);
		mColors.put("Red", Color.RED);
		mColors.put("Yellow", Color.YELLOW);
	}
	
	public Color getColor(String name) {
		return mColors.get(name);
	}

	public ArrayList<String> getColors() {
		
		Set<String> keyColors = (Set<String>)mColors.keySet();
		
		ArrayList<String> list = new ArrayList<>(keyColors);
		
		Collections.sort(list);
		
		return list;
	}
	
	public static Color getMarkedColor() {
		return Color.GRAY;
	}
	
	public String getColorName(Color color) {
	
		for(String s : mColors.keySet()) {
			if(mColors.get(s).equals(color)) {
				return s;
			}
		}
		return null;
	}
}
