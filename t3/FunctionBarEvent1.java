package t3;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class FunctionBarEvent1 implements ActionListener {
	private JPanel graphicPanel;
	private JPanel propertyPanel;
	private JTree fileTree;
	public FunctionBarEvent1(JTree fileTree, JPanel graphicPanel, JPanel propertyPanel) {
		this.graphicPanel = graphicPanel;
		this.propertyPanel = propertyPanel;
		this.fileTree = fileTree;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "add":
				add();
				break;
				
			case "delete":
				delete();
				break;
				
			case "store":
				store();
				break;
				
			case "undo":
				undo();
				break;
				
			case "redo":
				redo();
				break;
				
			case "deleteAll":
				deleteAll();
				break;
	
		}

	}
	public void add() {
		new NewFileFrame(fileTree);
	}
	
	public void delete() {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
		StringBuilder sb = new StringBuilder(FileManager1.userDir);
		for(Object n: node.getPath()) {
			DefaultMutableTreeNode n1 = (DefaultMutableTreeNode) n;
			sb.append(FileManager1.sep);
			sb.append((String)n1.getUserObject());
		}
		if(FileManager1.identify(sb.toString()) == FileManager1.FILE) {
			FileManager1.deleteChildFile(sb.toString());
		}
		else {
			FileManager1.deleteChildFolder(sb.toString());
		}
		node.removeFromParent();
		fileTree.updateUI();
	}
	
	public void store() {
		ArrayList<HashMap<String, Object>> contents = handleContent(this.graphicPanel);
		TreePath nodes = fileTree.getSelectionPath();
		StringBuilder sb = new StringBuilder(FileManager1.userDir);
		for(Object node: nodes.getPath()) {
			sb.append(FileManager1.sep);
			DefaultMutableTreeNode n = (DefaultMutableTreeNode)node;
			sb.append((String)n.getUserObject());
		}
		FileManager1.storeData(sb.toString(), contents);
		RestaurantLayout1.fileLabel.setBackground(Color.GREEN);
	}
	
	public static ArrayList<HashMap<String, Object>> handleContent(JPanel graphicPanel){
		Component[] children = graphicPanel.getComponents();
		ArrayList<HashMap<String, Object>> contents = new ArrayList<HashMap<String, Object>>();
		for(Component child: children) {
			MapUnit unit = (MapUnit) child;
			if(unit.widthRatio == 0.0 && unit.heightRatio == 0.0) {
				continue;
			}
			contents.add(unit.getInfo());
		}
		return contents;
	}
	
	public static void restore(ArrayList<HashMap<String, Object>> contents, JPanel graphicPanel, JPanel propertyPanel) {
		for(HashMap<String, Object> content: contents) {
			MapUnit unit = new MapUnit((String)content.get("name"), (String)content.get("imagePath"));
			graphicPanel.add(unit);
			unit.setColor1((String)content.get("color1"));
			unit.setColor2((String)content.get("color2"));
			unit.ImageResize((double)content.get("width"), (double)content.get("height"));
			unit.setPos((double)content.get("posx"), (double)content.get("posy"));
			int posx = (int)Math.round(graphicPanel.getSize().width * (double)content.get("posx"));
			int posy = (int)Math.round(graphicPanel.getSize().height * (double)content.get("posy"));
			int width = (int)Math.round(graphicPanel.getSize().width * (double)content.get("width"));
			int height = (int)Math.round(graphicPanel.getSize().height * (double)content.get("height"));
			unit.setBounds(posx, posy, width, height);
			unit.addMouseListener(new DragDropEvent(propertyPanel));
			unit.addMouseMotionListener(new DragDropEvent(propertyPanel));
			unit.addMouseListener(new PopMenuEvent(propertyPanel, graphicPanel));				
		}
	}
	
	private void deleteAll() {
		RestaurantLayout1.undoEventBox.add(handleContent(this.graphicPanel));
		this.graphicPanel.removeAll();
		NewCardLayout layout = (NewCardLayout)this.propertyPanel.getLayout();
		layout.reset();
		this.graphicPanel.revalidate();
		this.graphicPanel.repaint();
	}
	
	private void undo() {
		ArrayList<HashMap<String, Object>> previous = RestaurantLayout1.undoEventBox.remove(RestaurantLayout1.undoEventBox.size() - 1);
		if(RestaurantLayout1.undoEventBox.size() == 0) {
			RestaurantLayout1.undoEventBox.setItemEnabled(true);
		}
		RestaurantLayout1.redoEventBox.add(handleContent(this.graphicPanel));
		this.graphicPanel.removeAll();
		this.graphicPanel.revalidate();
		this.graphicPanel.repaint();
		NewCardLayout layout = (NewCardLayout)this.propertyPanel.getLayout();
		layout.reset();
		restore(previous, this.graphicPanel, this.propertyPanel);
	}
	
	private void redo() {
		ArrayList<HashMap<String, Object>> latter = RestaurantLayout1.redoEventBox.remove(RestaurantLayout1.redoEventBox.size() - 1);
		if(RestaurantLayout1.redoEventBox.size() == 0) {
			RestaurantLayout1.redoEventBox.setItemEnabled(true);
		}
		RestaurantLayout1.undoEventBox.add(handleContent(this.graphicPanel));
		this.graphicPanel.removeAll();
		this.graphicPanel.revalidate();
		this.graphicPanel.repaint();
		NewCardLayout layout = (NewCardLayout)this.propertyPanel.getLayout();
		layout.reset();
		restore(latter, this.graphicPanel, this.propertyPanel);
	}
}
