package t12;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import t3.FileManager1;
import t3.MapUnit;

public class MapGenerator implements TreeSelectionListener {
	
	private JPanel mapPanel;
	private JLabel output;
	public MapGenerator(JPanel mapPanel, JLabel output) {
		this.mapPanel = mapPanel;
		this.output = output;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		run((JTree)e.getSource());
		
	}
	
	private void run(JTree tree) {
		TreePath path = tree.getSelectionPath();
		StringBuilder sb = new StringBuilder();
		sb.append(FileManager1.userDir);
		for(Object node: path.getPath()) {
			DefaultMutableTreeNode n = (DefaultMutableTreeNode)node;
			sb.append(FileManager1.sep);
			sb.append((String)n.getUserObject());
		}
		mapPanel.removeAll();
		mapPanel.repaint();
		mapPanel.revalidate();
		if(FileManager1.identify(sb.toString()) == FileManager1.FILE) {
			this.generate(sb.toString());
		}
	}
	
	private void generate(String path) {
		ArrayList<HashMap<String, Object>> contents = FileManager1.getContents(path);
		for(HashMap<String, Object> content: contents) {
			MapUnit unit = new MapUnit((String)content.get("name"), (String)content.get("imagePath"));
			unit.removeMouseListener(unit.getMouseListeners()[0]);
			if(unit.imagePath.equals(MapUnit.table)) {
				unit.setCursor(new Cursor(Cursor.HAND_CURSOR));
				unit.addMouseListener(new ShowEvent(this.output));	
			}
			else {
				unit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			mapPanel.add(unit);
			unit.setColor1((String)content.get("color1"));
			unit.setColor2((String)content.get("color2"));
			if(unit.color1.length() != 0) {
				int colorCode = Color.decode(unit.color1).getRGB();
				unit.setBackground(new Color(colorCode));
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
