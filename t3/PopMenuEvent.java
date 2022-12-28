package t3;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PopMenuEvent implements MouseListener, ActionListener {
	
	private JPopupMenu menu = new JPopupMenu();
	private JMenuItem copyItem = new JMenuItem("複製");
	private JMenuItem pasteItem = new JMenuItem("貼上");
	private JMenuItem cutItem = new JMenuItem("剪下");
	private static ArrayList<Component> copyBox = new ArrayList<Component>();
	private int posx;
	private int posy;
	private static MapUnit widget;
	private JPanel propertyPanel;
	private JPanel graphicPanel;
	public PopMenuEvent(JPanel propertyPanel, JPanel graphicPanel) {
		this.propertyPanel = propertyPanel;
		this.graphicPanel = graphicPanel;
		menu.add(copyItem);
		menu.add(pasteItem);
		menu.add(cutItem);
		copyItem.addActionListener(this);
		pasteItem.addActionListener(this);
		cutItem.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			if(copyBox.size() != 0) {
				pasteItem.setEnabled(true);
			}
			else {
				pasteItem.setEnabled(false);
			}
			if(e.getSource() instanceof JPanel) {
				copyItem.setEnabled(false);
				cutItem.setEnabled(false);
			}
			else {
				widget = (MapUnit) e.getSource();
				copyItem.setEnabled(true);
				cutItem.setEnabled(true);
			}
			menu.show((Component) e.getSource(), e.getX(), e.getY());
			this.posx = e.getXOnScreen();
			this.posy = e.getYOnScreen();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	public void actionPerformed(ActionEvent e) {
		MapUnit newWidget;
		switch(e.getActionCommand()) {
			case "複製":
				newWidget = widget.clone();
				graphicPanel.add(newWidget);
				copyBox.add(newWidget);
				break;
				
			case "貼上":
				RestaurantLayout1.undoEventBox.add(FunctionBarEvent1.handleContent(graphicPanel));
				newWidget = (MapUnit) copyBox.remove(copyBox.size()-1);
				newWidget.addMouseMotionListener(new DragDropEvent(this.propertyPanel));
				newWidget.addMouseListener(new DragDropEvent(this.propertyPanel));
				newWidget.addMouseListener(new PopMenuEvent(this.propertyPanel, graphicPanel));
				graphicPanel.add(newWidget);
				newWidget.setColor1(widget.color1);
				newWidget.setColor2(widget.color2);
				newWidget.ImageResize(widget.widthRatio, widget.heightRatio);
				Dimension parentSize = graphicPanel.getSize();
				int posx = this.posx - graphicPanel.getLocationOnScreen().x - (widget.getSize().width / 2);
				int posy = this.posy - graphicPanel.getLocationOnScreen().y - (widget.getSize().height / 2);
				int width = (int)Math.round(parentSize.width * newWidget.widthRatio);
				int height = (int)Math.round(parentSize.height * newWidget.heightRatio);
				newWidget.setBounds( posx, posy, width, height );
				double xRatio = (double)posx / (double)parentSize.width;
				double yRatio = (double)posy / (double)parentSize.height;
				newWidget.setPos(xRatio, yRatio);
				graphicPanel.revalidate();
				break;
			
			case "剪下":
				RestaurantLayout1.undoEventBox.add(FunctionBarEvent1.handleContent(graphicPanel));
				newWidget = widget.clone();
				graphicPanel.add(newWidget);
				copyBox.add(newWidget);
				graphicPanel.remove(widget);
				graphicPanel.revalidate();
				graphicPanel.repaint();
				break;
		}
		
	}

}
