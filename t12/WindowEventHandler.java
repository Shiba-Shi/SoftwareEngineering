package t12;

import java.awt.event.WindowListener;

public class WindowEventHandler implements WindowListener {
	
	public WindowEventHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void windowOpened(java.awt.event.WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(java.awt.event.WindowEvent e) {
		if(e.getSource() instanceof DishSelection) {
			DishSelection ds = (DishSelection) e.getSource();
			if(!ds.resultLabel.getText().equals("查詢餐點")) {
				ds.entry.setText(ds.resultLabel.getText());
			}
		}
		else if(e.getSource() instanceof TableSelection) {
			TableSelection ts = (TableSelection) e.getSource();
			if(!ts.tableLabel.getText().equals("查詢餐桌")) {
				ts.entry.setText(ts.tableLabel.getText());
			}
		}
		else if(e.getSource() instanceof SearchWaiter) {
			SearchWaiter sw = (SearchWaiter) e.getSource();
			sw.entry.setText(sw.resultLabel.getText());
		}

	}

	@Override
	public void windowClosed(java.awt.event.WindowEvent e) {

	}

	@Override
	public void windowIconified(java.awt.event.WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(java.awt.event.WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(java.awt.event.WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(java.awt.event.WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
