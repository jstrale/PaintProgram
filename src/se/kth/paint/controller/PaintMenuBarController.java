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
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import se.kth.paint.model.PaintFacade;
import se.kth.paint.view.PaintMenuBar;

public class PaintMenuBarController {

	private PaintFacade mModel;
	private PaintMenuBar mMenuBar;
	private final JFileChooser mFileChooser = new JFileChooser();
	
	public PaintMenuBarController(PaintMenuBar menuBar, PaintFacade model) {
		mModel = model;
		mMenuBar = menuBar;
		
		mMenuBar.getMenuItemUndo().addActionListener(new UndoListener());
		mMenuBar.getMenuItemNew().addActionListener(new NewListener());
		mMenuBar.getMenuItemSave().addActionListener(new SaveListener());
		mMenuBar.getMenuItemOpen().addActionListener(new OpenListener());
	}
	
	private class UndoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mModel.undo();
		}
	}
	
	private class NewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mModel.clearCanvas();		
		}	
	}
	
	private class SaveListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int returnValue = mFileChooser.showSaveDialog(null);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				File file = mFileChooser.getSelectedFile();
				if(!mModel.saveFile(file)) {
					JOptionPane.showMessageDialog(null, "File could not be saved");
				}
			}
		}
	}
	
	private class OpenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int returnValue = mFileChooser.showOpenDialog(null);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				File file = mFileChooser.getSelectedFile();
				if(!mModel.openFile(file)) {
					JOptionPane.showMessageDialog(null, "File could not be opened");
				}
			}
		}
	}
}
