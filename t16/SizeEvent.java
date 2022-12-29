package t16;

import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

import t3.MapUnit;
import t3.PropertyForm;

public class SizeEvent implements ComponentListener {

	public SizeEvent() {

	}

	@Override
	public void componentResized(ComponentEvent e) {
		JPanel mapPanel = (JPanel) e.getSource();
		Component[] children = (Component[]) mapPanel.getComponents();
		for(Component child: children) {
			if(child instanceof MapUnit) {
				MapUnit ch = (MapUnit) child;
				int posx = (int) Math.round(mapPanel.getSize().width * ch.posx);
				int posy = (int) Math.round(mapPanel.getSize().height * ch.posy);
				int width = (int) Math.round(mapPanel.getSize().width * ch.widthRatio);
				int height = (int) Math.round(mapPanel.getSize().height * ch.heightRatio);
				ch.setBounds(posx, posy, width, height);
				ch.ImageResize(ch.widthRatio, ch.heightRatio);
			}
		}

	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentShown(ComponentEvent e) {

	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}

}
