package t16;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SwitchButton extends JButton implements ActionListener {
	public double posx;
	public double posy;
	public double widthRatio;
	public double heightRatio;
	public SwitchButton() {

	}

	public SwitchButton(Icon icon) {
		super(icon);
		
	}

	public SwitchButton(String text) {
		super(text);
		this.addActionListener(this);
	}

	public SwitchButton(Action a) {
		super(a);
		
	}

	public SwitchButton(String text, Icon icon) {
		super(text, icon);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = this.getText();
		if(text.equals("人")) {
			this.setText("桌面");
		}
		else {
			this.setText("人");
		}

	}

}
