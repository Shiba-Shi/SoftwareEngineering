package t3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class TreeSelectEvent implements TreeSelectionListener {
	private JLabel label;
	private JPanel graphicPanel;
	private JPanel propertyPanel;
	public TreeSelectEvent(JLabel label, JPanel graphicPanel, JPanel propertyPanel) {
		this.label = label;
		this.graphicPanel = graphicPanel;
		this.propertyPanel = propertyPanel;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		JTree tree = (JTree)e.getSource();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		label.setText((String)node.getUserObject());
		this.refresh();
		String path = this.getCurrentPath(tree);
		if(FileManager1.identify(path) == FileManager1.FOLDER) {
			label.setBackground(Color.WHITE);
		}
		else {
			this.putContent(path);
			label.setBackground(Color.GREEN);
		}
	}
	
	private String getCurrentPath(JTree tree) {
		TreePath path = tree.getSelectionPath();
		StringBuilder sb = new StringBuilder(FileManager1.userDir);
		for(Object p: path.getPath()) {
			sb.append(FileManager1.sep);
			DefaultMutableTreeNode p1 = (DefaultMutableTreeNode)p;
			sb.append((String)p1.getUserObject());
		}
		return sb.toString();
	}
	
	private void putContent(String path) {
		ArrayList<HashMap<String, Object>> contents = FileManager1.getContents(path);
		FunctionBarEvent1.restore(contents, graphicPanel, propertyPanel);
	}
	
	private void refresh() {
		graphicPanel.removeAll();
		NewCardLayout layout = (NewCardLayout)propertyPanel.getLayout();
		layout.reset();
		graphicPanel.revalidate();
		graphicPanel.repaint();
	}
}
