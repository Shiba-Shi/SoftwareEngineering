package t12;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import t3.MapUnit;

public class ShowEvent implements MouseListener {
	private JLabel outputLabel;
	public ShowEvent(JLabel outputLabel) {
		this.outputLabel = outputLabel;
	}
	
	private void selected(MapUnit unit) {
		unit.setBackground(Color.RED);
		unit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	
	private void unselected(MapUnit unit, Color color) {
		unit.setBackground(color);
		unit.setBorder(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		MapUnit unit = (MapUnit)e.getSource();
		Color bgColor = unit.getBackground();
		selected(unit);
		this.outputLabel.setText(unit.name);
		if(bgColor != Color.RED) {
			JPanel panel = (JPanel)unit.getParent();
			for(Component component: panel.getComponents()) {
				MapUnit u = (MapUnit)component;
				if(unit != u) {
					unselected(u, bgColor);
				}
			}
		}
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
