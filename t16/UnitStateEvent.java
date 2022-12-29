package t16;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import t3.MapUnit;

public class UnitStateEvent implements ContainerListener {
	private DefaultListModel<String>[] lists = new DefaultListModel[5];
	public UnitStateEvent(JXTaskPaneContainer container) {
		int i = 0;
		for(Component component: container.getComponents()) {
			JPanel panel = (JPanel)component;
			JXCollapsiblePane pane = (JXCollapsiblePane)panel.getComponent(0);
			JList list = (JList)pane.getContentPane().getComponent(0);
			lists[i] = (DefaultListModel<String>)list.getModel();
			i ++;
		}
	}

	@Override
	public void componentAdded(ContainerEvent e) {
		clean();
		listAllState(e);
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		

	}
	
	private void clean() {
		for(DefaultListModel<String> model: lists) {
			model.clear();
		}
	}
	
	private void listAllState(ContainerEvent e) {
		JPanel mapPanel = (JPanel)e.getSource();
		Component[] component = mapPanel.getComponents();
		for(Component c: component) {
			MapUnit unit = (MapUnit) c;
			if(unit.getInfo().get("imagePath").equals(MapUnit.table)) {
				String color1 = (String)unit.getInfo().get("color1");
				String name = (String)unit.getInfo().get("name");
				if(color1.length() == 0) {
					if(!lists[1].contains(name)) {
						this.lists[1].addElement(name);
					}
				}
				else {
					int colorCode = Color.decode(unit.color1).getRGB();
					Color cl = new Color(colorCode);
					if(cl.equals(Color.WHITE)) {
						if(!lists[1].contains(name)) {
							this.lists[1].addElement(name);
						}
					}
					else if(cl.equals(Color.RED)) {
						if(!lists[0].contains(name)) {
							this.lists[0].addElement(name);
						}
					}
					else if(cl.equals(Color.YELLOW)) {
						if(!lists[2].contains(name)) {
							this.lists[2].addElement(name);
						}
					}
				}
				
				String color2 = (String)unit.getInfo().get("color2");
				if(color2.length() == 0) {
					if(!lists[3].contains(name)) {
						this.lists[3].addElement(name);
					}
				}
				else {
					int colorCode = Color.decode(unit.color2).getRGB();
					Color cl = new Color(colorCode);
					if(cl.equals(Color.WHITE)) {
						if(!lists[3].contains(name)) {
							this.lists[3].addElement(name);
						}
					}
					else {
						if(!lists[4].contains(name)) {
							this.lists[4].addElement(name);
						}
					}
				}
				
			}
		}
	}
}
