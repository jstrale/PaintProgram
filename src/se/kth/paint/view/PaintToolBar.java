/**
 * Description: This class represents the toolbar where the user can
 * choose for example shape, color and line width
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import se.kth.paint.model.PaintFacade;

public class PaintToolBar extends JToolBar {
	
	private PaintFacade mModel;
	private JButton mButtonDelete, mButtonFill;
	private JComboBox<String> mComboBoxShape;

	public JButton getButtonDelete() {
		return mButtonDelete;
	}

	public JButton getButtonFill() {
		return mButtonFill;
	}

	private static final long serialVersionUID = 1L;
	
	public PaintToolBar(PaintFacade model) {
		mModel = model;
		
		mButtonDelete = new JButton("Delete");
		this.add(mButtonDelete);
		
		mComboBoxShape = new JComboBox<String>();
		mComboBoxShape.setModel(new DefaultComboBoxModel<String>(new String[] {"<Shapes>"}));
		this.add(mComboBoxShape);
		
		JComboBox<String> comboBoxLineWidth = new JComboBox<String>();
		comboBoxLineWidth.setModel(new DefaultComboBoxModel<String>(new String[] {"<LineWidth>"}));
		this.add(comboBoxLineWidth);
		
		JComboBox<String> comboBoxColor = new JComboBox<String>();
		comboBoxColor.setModel(new DefaultComboBoxModel<String>(new String[] {"<Color>"}));
		this.add(comboBoxColor);
		
		mButtonFill = new JButton("Fill");
		this.add(mButtonFill);
	}

}
