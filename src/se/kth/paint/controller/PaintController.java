/**
 * Description: This controller listens for changes in the canvas and toolbar
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import se.kth.paint.model.PaintFacade;
import se.kth.paint.view.PaintCanvas;
import se.kth.paint.view.PaintToolBar;

public class PaintController {

	private PaintFacade mModel;
	private PaintToolBar mToolBar;
	private PaintCanvas mCanvas;

	public PaintController(PaintToolBar toolBar, PaintCanvas canvas,
			PaintFacade model) {
		mToolBar = toolBar;
		mCanvas = canvas;
		mModel = model;

		mCanvas.addMouseListener(new CanvasMouseListener());
		mToolBar.getButtonDelete()
				.addActionListener(new ButtonDeleteListener());
		mToolBar.getButtonFill().addActionListener(new ButtonFillListener());
		mToolBar.getButtonMark().addActionListener(new ButtonMarkListener());
		mToolBar.getComboBoxLineWidth().addActionListener(new ComboBoxLineWidthListener());
		mToolBar.getComboBoxColor().addActionListener(new ComboBoxColorListener());
	}

	private class CanvasMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (mToolBar.isMarkButtonSelected()) {
				mModel.markShape(e.getX(), e.getY());
			} else {
				mModel.drawShape(mToolBar.getSelectedShape(),
						mToolBar.isButtonFillSelected(), e.getX(), e.getY(),
						mToolBar.getSelectedColor(),
						mToolBar.getSelectedLineWidth());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class ButtonDeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			mModel.deleteShape();
		}

	}

	private class ButtonFillListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			mModel.toggleFillShape();
		}
	}

	private class ButtonMarkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (!mToolBar.isMarkButtonSelected()) {
				mModel.unmarkAllShapes();
			}
		}
	}
	
	private class ComboBoxLineWidthListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			mModel.setMarkedShapeLineWidth(mToolBar.getSelectedLineWidth());
		}
	}
	
	private class ComboBoxColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			mModel.setMarkedShapeColor(mToolBar.getSelectedColor());
		}
	}
}
