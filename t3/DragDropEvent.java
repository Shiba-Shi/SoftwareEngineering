package t3;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class DragDropEvent implements MouseMotionListener, MouseListener{
	
	private JPanel propertyPanel;
	public DragDropEvent(JPanel propertyPanel) {
		this.propertyPanel = propertyPanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		RestaurantLayout1.fileLabel.setBackground(Color.RED);
		MapUnit widget = (MapUnit) e.getSource();
		JPanel parentWidget = (JPanel) widget.getParent();
		ocurrEvent(e);
		widget.setVisible(true);
		parentWidget.revalidate();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		MapUnit widget = (MapUnit) e.getSource();
		PropertyForm form;
		JPanel parent = (JPanel)widget.getParent();
		RestaurantLayout1.undoEventBox.add(FunctionBarEvent1.handleContent(parent));
		NewCardLayout layout = (NewCardLayout) propertyPanel.getLayout();
		String code = widget.hashCode() + "";
		if(!layout.cardExist(code)) {
			form = new PropertyForm(widget);
			int width = (int)Math.round(parent.getSize().width * widget.widthRatio);
			int height = (int)Math.round(parent.getSize().height * widget.heightRatio);
			if(widget.name.equals("")){
				form.setInfo(width, height);
			}
			else {
				form.setInfo(widget.name, width, height);
			}
			layout.addLayoutComponent(form, code);
			propertyPanel.add(form);
		}
		layout.show(propertyPanel, code);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MapUnit widget = (MapUnit)e.getSource();
		JPanel parent = (JPanel)widget.getParent();
		RestaurantLayout1.undoEventBox.add(FunctionBarEvent1.handleContent(parent));
		double[] posRatio = ocurrEvent(e);
		widget.setPos(posRatio[0], posRatio[1]);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	private double[] ocurrEvent(MouseEvent e) {
		MapUnit widget = (MapUnit) e.getSource();
		JPanel parentWidget = (JPanel) widget.getParent();
		int x = e.getXOnScreen() - parentWidget.getLocationOnScreen().x - (widget.getSize().width / 2);
		int y = e.getYOnScreen() - parentWidget.getLocationOnScreen().y - (widget.getSize().height / 2);
		widget.setBounds(x, y, widget.getSize().width, widget.getSize().height);
		double x_ratio = (double)(x) / (double)parentWidget.getSize().width;
		double y_ratio = (double)(y) / (double)parentWidget.getSize().height;
		double[] result = {x_ratio, y_ratio};
		return result;
	}
}
