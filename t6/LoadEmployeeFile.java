package t6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.json.JSONArray;
import org.json.JSONException;

public class LoadEmployeeFile implements TreeSelectionListener {
	
	private DefaultListModel model;
	public LoadEmployeeFile(JList list) {
		this.model = (DefaultListModel) list.getModel();
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		JTree tree = (JTree)e.getSource();
		TreePath path = tree.getSelectionPath();
		StringBuilder sb = new StringBuilder(System.getProperty("user.dir"));
		for(Object node: path.getPath()) {
			DefaultMutableTreeNode n = (DefaultMutableTreeNode)node;
			sb.append(System.getProperty("file.separator"));
			sb.append((String)n.getUserObject());
		}
		model.clear();
		File file = new File(sb.toString());
		if(file.isFile()) {
			String[] infos = loadFile(file);
			for(int i = 0; i < infos.length; i ++) {
				model.addElement(infos[i]);
			}
		}
	}
	
	private String[] loadFile(File file) {
		BufferedReader reader;
		String[] infos = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String content = read(reader);
			JSONArray arr = new JSONArray(content);
			infos = new String[arr.length()];
			for(int i = 0; i < arr.length(); i ++) {
				infos[i] = arr.getString(i);
			}
		}
		catch (JSONException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return infos;
	}
	
	private String read(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			while(reader.ready()) {
				sb.append(reader.readLine());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
