package t3;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class PanelResizeEvent implements ComponentListener, ContainerListener {
	private NewCardLayout layout;
	private JTree tree;
	public PanelResizeEvent(NewCardLayout layout, JTree tree) {
		this.layout = layout;
		this.tree = tree;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		JPanel graphicPanel = (JPanel) e.getSource();
		Component[] children = (Component[]) graphicPanel.getComponents();
		for(Component child: children) {
			MapUnit ch = (MapUnit) child;
			int posx = (int) Math.round(graphicPanel.getSize().width * ch.posx);
			int posy = (int) Math.round(graphicPanel.getSize().height * ch.posy);
			int width = (int) Math.round(graphicPanel.getSize().width * ch.widthRatio);
			int height = (int) Math.round(graphicPanel.getSize().height * ch.heightRatio);
			ch.setBounds(posx, posy, width, height);
			ch.ImageResize(ch.widthRatio, ch.heightRatio);
			if(layout.cardExist(ch.hashCode() + "")) {
				PropertyForm form = (PropertyForm) layout.getValue(ch.hashCode() + "");
				form.setInfo(ch.name, width, height);
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

	@Override
	public void componentAdded(ContainerEvent e) {
		RestaurantLayout1.fileLabel.setBackground(Color.RED);
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		String path = this.getCurrentPath();
		if(FileManager1.identify(path) == FileManager1.FOLDER) {
			RestaurantLayout1.fileLabel.setBackground(Color.WHITE);
		}
		else {
			RestaurantLayout1.fileLabel.setBackground(Color.RED);
		}
	}
	
	private String getCurrentPath() {
		TreePath path = tree.getSelectionPath();
		StringBuilder sb = new StringBuilder(FileManager1.userDir);
		for(Object p: path.getPath()) {
			sb.append(FileManager1.sep);
			DefaultMutableTreeNode p1 = (DefaultMutableTreeNode)p;
			sb.append((String)p1.getUserObject());
		}
		return sb.toString();
	}
}
