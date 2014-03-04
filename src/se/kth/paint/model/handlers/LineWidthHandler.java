package se.kth.paint.model.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class LineWidthHandler {

	private HashMap<String, Integer> mLineWidths;
	
	public LineWidthHandler() {
		mLineWidths = new HashMap<String, Integer>();
		
		initWidths();
	}

	private void initWidths() {
		
		mLineWidths.put("Small", 1);
		mLineWidths.put("Medium", 5);
		mLineWidths.put("Large", 10);
	}
	
	public int getLineWidth(String name) {
		return mLineWidths.get(name);
	}

	public ArrayList<String> getLineWidths() {
		
		Set<String> keyWidths = (Set<String>) mLineWidths.keySet();
		
		ArrayList<String> list = new ArrayList<>(keyWidths);
		
		Collections.sort(list);
		
		return list;
	}
	
	public String getLineWidthName(int width) {
		
		for(String s : mLineWidths.keySet()) {
			if(mLineWidths.get(s) == width) {
				return s;
			}
		}
		return null;
	}
}
