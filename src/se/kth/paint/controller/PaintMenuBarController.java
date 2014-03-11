/**
 * Description: This controller listens for changes in the menubar
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.kth.paint.model.PaintFacade;
import se.kth.paint.view.PaintMenuBar;

public class PaintMenuBarController {

	private PaintFacade mModel;
	private PaintMenuBar mMenuBar;
	
	public PaintMenuBarController(PaintMenuBar menuBar, PaintFacade model) {
		mModel = model;
		mMenuBar = menuBar;
		
		mMenuBar.getMenuItemUndo().addActionListener(new UndoListener());
	}
	
	private class UndoListener implements  ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mModel.undo();
		}
	}
}
