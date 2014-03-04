/**
 * Description: Starts the paint application including model, views and controllers and connects them
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.kth.paint.controller.PaintController;
import se.kth.paint.model.PaintFacade;
import se.kth.paint.view.PaintCanvas;
import se.kth.paint.view.PaintMenuBar;
import se.kth.paint.view.PaintToolBar;

public class RunPaint {
	public RunPaint() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					// Create frame with properties
					JFrame paintFrame = new JFrame("Painter");
					paintFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					paintFrame.setBounds(100, 100, 640, 480);
					paintFrame.setResizable(false);
					paintFrame.setLocationRelativeTo(paintFrame);
					
					// Create container where toolbar and canvas will lay in
					JPanel container = new JPanel();
					
					// Create model, views and controllers
					PaintFacade model = new PaintFacade();
					PaintMenuBar menuBar = new PaintMenuBar();
					PaintToolBar toolBar = new PaintToolBar(model);
					PaintCanvas canvas = new PaintCanvas(model);
					PaintController controller = new PaintController(toolBar, canvas, model);
					//PaintMenuBarController menuBarController = new PaintMenuBarController(model);
					
					// Add view observers to model
					model.addObserver(canvas);
					
					container.setBorder(new EmptyBorder(5, 5, 5, 5));
					container.setLayout(new BorderLayout(0, 0));
					container.add(toolBar, BorderLayout.NORTH);
					container.add(canvas, BorderLayout.CENTER);
					
					paintFrame.setJMenuBar(menuBar);
					paintFrame.add(container);
					paintFrame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
