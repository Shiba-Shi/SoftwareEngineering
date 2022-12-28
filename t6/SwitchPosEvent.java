package t6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.json.JSONArray;
import org.json.JSONException;

public class SwitchPosEvent implements ActionListener {
	
	private JList list1;
	private JList list2;
	private JTree tree1;
	private JTree tree2;
	public SwitchPosEvent(JTree tree1, JList list1, JTree tree2, JList list2) {
		this.list1 = list1;
		this.list2 = list2;
		this.tree1 = tree1;
		this.tree2 = tree2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultListModel model = (DefaultListModel) list1.getModel();
		DefaultListModel model1 = (DefaultListModel) list2.getModel();
		if(!model.isEmpty() && !model1.isEmpty()) {
			int index1 = list1.getSelectedIndex();
			int index2 = list2.getSelectedIndex();
			Object element1 = model.remove(index1);
			Object element2 = model1.remove(index2);
			model.insertElementAt(element2, index1);
			model1.insertElementAt(element1, index2);
			JSONArray arr1 = group(model);
			JSONArray arr2 = group(model1);
			String path1 = getPath(tree1);
			String path2 = getPath(tree2);
			this.putBack(arr1, new File(path1));
			this.putBack(arr2, new File(path2));
		}
	}
	
	private void putBack(JSONArray arr, File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(arr.toString(1));
			writer.close();
		}
		catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		
	}
	

	private JSONArray group(DefaultListModel model) {
		String[] data = new String[model.size()];
		for(int i = 0; i < model.size(); i ++) {
			data[i] = (String) model.get(i);
		}
		try {
			return new JSONArray(data);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	private String getPath(JTree tree) {
		TreePath path = tree.getSelectionPath();
		StringBuilder sb = new StringBuilder(System.getProperty("user.dir"));
		for(Object node: path.getPath()) {
			sb.append(System.getProperty("file.separator"));
			DefaultMutableTreeNode n = (DefaultMutableTreeNode)node;
			sb.append((String)n.getUserObject());
		}
		return sb.toString();
	}
	
}
