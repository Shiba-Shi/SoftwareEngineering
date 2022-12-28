package t3;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PropertyForm extends JPanel implements KeyListener{
	private JTextField nameEntry;
	private JTextField widthEntry;
	private JTextField heightEntry;
	private MapUnit widget;
	/**
	 * Create the panel.
	 */
	public PropertyForm(MapUnit widget) {
		this.widget = widget;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel nameLabel = new JLabel("名稱");
		nameLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		add(nameLabel, "2, 4, right, default");
		
		nameEntry = new JTextField();
		nameEntry.setFont(new Font("新細明體", Font.PLAIN, 15));
		add(nameEntry, "4, 4, fill, default");
		nameEntry.setColumns(10);
		nameEntry.setName("name");
		nameEntry.addKeyListener(this);
		
		JLabel widthLabel = new JLabel("寬");
		widthLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		add(widthLabel, "2, 8, right, default");
		
		widthEntry = new JTextField();
		widthEntry.setFont(new Font("新細明體", Font.PLAIN, 15));
		add(widthEntry, "4, 8, fill, default");
		widthEntry.setColumns(10);
		widthEntry.setName("width");
		widthEntry.addKeyListener(this);
		
		JLabel hieghtLabel = new JLabel("高");
		hieghtLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		add(hieghtLabel, "2, 12, right, default");
		
		heightEntry = new JTextField();
		heightEntry.setFont(new Font("新細明體", Font.PLAIN, 15));
		add(heightEntry, "4, 12, fill, default");
		heightEntry.setColumns(10);
		heightEntry.setName("height");
		heightEntry.addKeyListener(this);
	}
	
	public void setInfo(int width, int height) {
		widthEntry.setText(width + "");
		heightEntry.setText(height + "");
	}
	
	public void setInfo(String name, int width, int height) {
		this.setInfo(width, height);
		nameEntry.setText(name);
	}
	
	private void changeSize(double width, double height) {
		JPanel parent = (JPanel)widget.getParent();
		double widthRatio = width / parent.getSize().width;
		double heightRatio = height / parent.getSize().height;
		widget.ImageResize(widthRatio, heightRatio);
		widget.setSize((int)width, (int)height);
	}

	private void change(KeyEvent e) {
		double width, height;
		JTextField entry = (JTextField) e.getSource();
		try {
			JPanel parent = (JPanel)widget.getParent();
			RestaurantLayout1.undoEventBox.add(FunctionBarEvent1.handleContent(parent));
			switch(entry.getName()) {
			case "name":
				widget.setName(entry.getText());
				break;
			case "width":
				width = Double.parseDouble(entry.getText());
				height = widget.getSize().height;
				changeSize(width, height);
				break;
			case "height":
				width = widget.getSize().width;
				height = Double.parseDouble(entry.getText());
				changeSize(width, height);
				break;
			}
		}
		catch(java.lang.NumberFormatException err){
			
		}
		catch(java.lang.IllegalArgumentException err) {
			
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		change(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		change(e);
	}
		
}
