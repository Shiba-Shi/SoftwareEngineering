package t16;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import t3.FileManager1;
import t3.MapUnit;

public class MapGenerator implements TreeSelectionListener, ActionListener{
	
	private JPanel mapPanel;
	private JButton button;
	private JTree tree;
	public MapGenerator(JTree tree, JPanel mapPanel, JButton button) {
		this.mapPanel = mapPanel;
		this.button = button;
		this.tree = tree;
	}
	

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		run();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		run();
	}

	private void run() {
		TreePath path = tree.getSelectionPath();
		if(path != null) {
			StringBuilder sb = new StringBuilder();
			sb.append(System.getProperty("user.dir"));
			for(Object node: path.getPath()) {
				DefaultMutableTreeNode n = (DefaultMutableTreeNode)node;
				sb.append(System.getProperty("file.separator"));
				sb.append((String)n.getUserObject());
			}
			if(FileManager1.identify(sb.toString()) == FileManager1.FILE) {
				mapPanel.removeAll();
				mapPanel.repaint();
				mapPanel.revalidate();
				this.generate(sb.toString());
			}	
		}

	}
	
	private void generate(String path) {
		ArrayList<HashMap<String, Object>> contents = FileManager1.getContents(path);
		for(HashMap<String, Object> content: contents) {
			MapUnit unit = new MapUnit((String)content.get("name"), (String)content.get("imagePath"));
			unit.removeMouseListener(unit.getMouseListeners()[0]);
			unit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			mapPanel.add(unit);
			unit.setColor1((String)content.get("color1"));
			unit.setColor2((String)content.get("color2"));
			
			if(this.button.getText().equals("人")) {
				if(unit.color1.length() != 0) {
					int colorCode = Color.decode(unit.color1).getRGB();
					unit.setBackground(new Color(colorCode));
				}
			}
			else {
				if(unit.color2.length() != 0) {
					int colorCode = Color.decode(unit.color2).getRGB();
					unit.setBackground(new Color(colorCode));
				}
			}
			
			unit.ImageResize((double)content.get("width"), (double)content.get("height"));
			unit.setPos((double)content.get("posx"), (double)content.get("posy"));
			int posx = (int)Math.round(mapPanel.getSize().width * (double)content.get("posx"));
			int posy = (int)Math.round(mapPanel.getSize().height * (double)content.get("posy"));
			int width = (int)Math.round(mapPanel.getSize().width * (double)content.get("width"));
			int height = (int)Math.round(mapPanel.getSize().height * (double)content.get("height"));
			unit.setBounds(posx, posy, width, height);				
		}
	}



}
