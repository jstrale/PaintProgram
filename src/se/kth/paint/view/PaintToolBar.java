/**
 * Description: This class represents the toolbar where the user can
 * choose for example shape, color and line width
 * 
 * @author Helena Lindén, Johan Stråle
 * @since 2014-03-04
 * 
 */

package se.kth.paint.view;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import se.kth.paint.model.PaintFacade;
import se.kth.paint.model.Shape;

public class PaintToolBar extends JToolBar implements Observer {
	
	private static final long serialVersionUID = 1L;
	private PaintFacade mModel;
	private JButton mButtonDelete;
	private JComboBox<String> mComboBoxShape;
	private JComboBox<String> mComboBoxColor;
	private JComboBox<String> mComboBoxLineWidth;
	private JToggleButton mToggleButtonMark;
	private JToggleButton mToggleButtonFill;

	public PaintToolBar(PaintFacade model) {
		
		mModel = model;
		
		mToggleButtonMark = new JToggleButton("Mark");
		add(mToggleButtonMark);
		
		mButtonDelete = new JButton("Delete");
		this.add(mButtonDelete);
		
		mComboBoxShape = new JComboBox<String>();
		mComboBoxShape.setModel(fillComboBox(mModel.getPrototypeShapeNames()));
		this.add(mComboBoxShape);
		
		mComboBoxLineWidth = new JComboBox<String>();
		mComboBoxLineWidth.setModel(fillComboBox(mModel.getLineWidthOptions()));
		this.add(mComboBoxLineWidth);
		
		mComboBoxColor = new JComboBox<String>();
		mComboBoxColor.setModel(fillComboBox(mModel.getColors()));
		this.add(mComboBoxColor);
		
		mToggleButtonFill = new JToggleButton("Fill");
		add(mToggleButtonFill);
	}

	public JToggleButton getButtonFill() {
		return mToggleButtonFill;
	}

	public JButton getButtonDelete() {
		return mButtonDelete;
	}
	
	public JToggleButton getButtonMark() {
		return mToggleButtonMark;
	}
	
	public JComboBox<String> getComboBoxLineWidth() {
		return mComboBoxLineWidth;
	}
	
	public JComboBox<String> getComboBoxColor() {
		return mComboBoxColor;
	}
	
	public String getSelectedShape() {
		return (String) mComboBoxShape.getSelectedItem();
	}
	
	public String getSelectedColor() {
		return (String) mComboBoxColor.getSelectedItem();
	}
	
	public String getSelectedLineWidth() {
		return (String) mComboBoxLineWidth.getSelectedItem();
	}
	
	public boolean isButtonFillSelected() {
		return mToggleButtonFill.isSelected();
	}
	
	public boolean isMarkButtonSelected() {	
		return mToggleButtonMark.isSelected();
	}

	private DefaultComboBoxModel<String> fillComboBox(List<String> list) {
		
		DefaultComboBoxModel<String> box = new DefaultComboBoxModel<String>();
		
		for(String s : list) {
			box.addElement(s);
		}
		return box;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Shape markedShape = mModel.getMarkedShapeCopy();
		
		if(markedShape != null) {
			mComboBoxShape.setSelectedItem(markedShape.getName());
			mComboBoxShape.setEnabled(false);
			mComboBoxLineWidth.setSelectedItem(mModel.getLineWidthName(markedShape.getLineWidth()));
			mComboBoxColor.setSelectedItem(mModel.getColorName(markedShape.getColor()));
			mToggleButtonFill.setSelected(markedShape.isFilled());
		} else {
			mComboBoxShape.setEnabled(true);
			mToggleButtonFill.setSelected(false);
		}
	}
}
