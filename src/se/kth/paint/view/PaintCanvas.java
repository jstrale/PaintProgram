/**
 * Description: This class represents the canvas onto which the shapes are drawn
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import se.kth.paint.model.PaintFacade;
import se.kth.paint.model.Position;

public class PaintCanvas extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private PaintFacade mModel;
	
	public PaintCanvas(PaintFacade model) {
		this.setBackground(Color.WHITE);
		mModel = model; 
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		ArrayList<Position> posList = mModel.getTestPos();
		
		for(Position p: posList) {
			paintOval(g, p.getX(), p.getY());
		}
	}

	private void paintOval(Graphics g, int x, int y) {
		g.drawOval(x, y, 10, 10);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	

}
