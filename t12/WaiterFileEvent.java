package t12;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class WaiterFileEvent implements TreeSelectionListener {
	
	private DefaultListModel model;
	public WaiterFileEvent(JList list) {
		this.model = (DefaultListModel)list.getModel();
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		JTree tree = (JTree)e.getSource();
		StringBuilder filePath = new StringBuilder(System.getProperty("user.dir"));
		TreePath path = tree.getSelectionPath();
		for(Object p: path.getPath()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)p;
			filePath.append(System.getProperty("file.separator"));
			filePath.append((String)node.getUserObject());
		}
		model.clear();
		
		if(isFile(filePath.toString())) {
			String[] men = OpenEmployeeFile.getList(filePath.toString());	
			for(int i = 0; i < men.length; i ++) {
				this.model.addElement(men[i]);
			}	
		}
	}
	
	private boolean isFile(String path) {
		File file = new File(path);
		return file.isFile();
	}
}
