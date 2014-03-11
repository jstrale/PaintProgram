/**
 * Description: This class is responsible for all file handling
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-11
 * 
 */
package se.kth.paint.model.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import se.kth.paint.model.Shape;

public class FileHandler {
	
	public static final String FILE_ENDING = ".ser";

	public static boolean saveFile(File file, List<Shape> shapes) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(file + FILE_ENDING);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(shapes);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(oos!=null)
				try {
					oos.close();
				} catch (IOException e) {
					// Do nothing
				}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static List<Shape> openFile(File file) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Shape> shapes = null;
		
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			shapes = (List<Shape>) ois.readObject();
			
		} catch (Exception e) {
			return null;
		} finally {
			if(ois!=null)
				try {
					ois.close();
				} catch (IOException e) {
					// Do nothing
				}
		}
		return shapes;
	}
}
