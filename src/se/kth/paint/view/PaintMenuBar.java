/**
 * Description: This class represents the menu bar where the user can 
 * choose different alternatives
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintMenuBar extends JMenuBar {
	
	private JMenuItem mMenuItemNew, mMenuItemSave, mMenuItemOpen, mMenuItemUndo;

	private static final long serialVersionUID = 1L;
	
	public PaintMenuBar() {
		JMenu menuFile = new JMenu("File");
		this.add(menuFile);
		
		mMenuItemNew = new JMenuItem("New");
		menuFile.add(mMenuItemNew);
		
		mMenuItemSave = new JMenuItem("Save as");
		menuFile.add(mMenuItemSave);
		
		mMenuItemOpen = new JMenuItem("Open");
		menuFile.add(mMenuItemOpen);
		
		JMenu menuEdit = new JMenu("Edit");
		this.add(menuEdit);
		
		mMenuItemUndo = new JMenuItem("Undo");
		menuEdit.add(mMenuItemUndo);
	}

	public JMenuItem getMenuItemUndo() {
		return mMenuItemUndo;
	}
}
