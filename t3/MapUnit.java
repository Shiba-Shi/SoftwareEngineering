package t3;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MapUnit extends JLabel implements MouseListener{
	public static final String imageDir = System.getProperty("user.dir") + FileManager1.sep + "image";
	public static final String table = imageDir + FileManager1.sep + "table.png";
	public static final String chair = imageDir + FileManager1.sep + "chair.png";
	public static final String door = imageDir + FileManager1.sep + "door.png";
	public static final String wall = imageDir + FileManager1.sep + "wall.png";
	public static final String counter = imageDir + FileManager1.sep + "counter.png";
	public static final String decorator = imageDir + FileManager1.sep + "decorator.png";
	public String name;
	public double posx;
	public double posy;
	public double widthRatio;
	public double heightRatio;
	public String imagePath;
	public String color1 = "";
	public String color2 = "";
	private LineBorder lineBorder = new LineBorder(Color.BLACK);
	public MapUnit() {
		this.posx = 0.5;
		this.posy = 0.5;
		this.setOpaque(true);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		this.addMouseListener(this);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setFont(new Font("Dialog", Font.BOLD, 15));
	}
	
	public MapUnit(String name, String imagePath) {
		this();
		this.name = name;
		this.setText(name);
		this.imagePath = imagePath;
		setImagePath(this.imagePath);
		
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
		this.name = name;
		this.setText(name);
	}
	
	public void setColor1(String color) {
		this.color1 = color1;
	}
	
	public void setColor2(String color) {
		this.color2 = color2;
	}
	
	public void setImagePath(String path) {
		this.imagePath = path;
		this.setIcon(new ImageIcon(path));
	}
	
	public void setPos(double posx, double posy) {
		this.posx = posx;
		this.posy = posy;
	}
	
	public void ImageResize(double widthRatio, double heightRatio) {
		this.widthRatio = widthRatio;
		this.heightRatio = heightRatio;
		ImageIcon image = new ImageIcon(this.imagePath);
		Image img = image.getImage();
		Dimension parentSize = this.getParent().getSize();
		int width = (int)Math.round(parentSize.width * widthRatio);
		int height = (int)Math.round(parentSize.height * heightRatio);
		img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		image.setImage(img);
		this.setIcon(image);
	}
	
	public MapUnit clone() {
		MapUnit newOne = new MapUnit(this.name, this.imagePath);
		return newOne;
	}
	
	public HashMap<String, Object> getInfo() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", this.name);
		map.put("imagePath", this.imagePath);
		map.put("posx", this.posx);
		map.put("posy", this.posy);
		map.put("width", this.widthRatio);
		map.put("height", this.heightRatio);
		map.put("color1", this.color1);
		map.put("color2", this.color2);
		return map;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.setBorder(lineBorder);
		this.setBackground(Color.RED);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.setBorder(null);
		this.setBackground(this.getParent().getBackground());
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
