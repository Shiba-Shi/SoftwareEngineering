package t12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.tree.DefaultMutableTreeNode;

import org.json.JSONArray;
import org.json.JSONException;

public class OpenEmployeeFile {
	
	public static final String folderPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "員工";
	public OpenEmployeeFile() {
	}
	
	public static DefaultMutableTreeNode listAll(String rootName, String rootPath) {
		File root = new File(rootPath);
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(rootName);
		File[] items = root.listFiles();
		for(int i = 0; i < items.length; i ++ ) {
			if(items[i].isDirectory()) {
				node.add(listAll(items[i].getName(), rootPath + System.getProperty("file.separator") + items[i].getName()));
			}
			else {
				node.add(new DefaultMutableTreeNode(items[i].getName()));
			}
		}
		return node;
	}
	
	public static String[] getList(String filePath) {
		File file = new File(filePath);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String content = read(reader);
			JSONArray arr = new JSONArray(content);
			String[] data = new String[arr.length()];
			for(int i = 0; i < arr.length(); i ++) {
				data[i] = arr.getString(i);
			}
			return data;
		} 
		catch (FileNotFoundException | JSONException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	private static String read(BufferedReader reader){
		StringBuilder sb = new StringBuilder();
		try {
			while(reader.ready()) {
				sb.append(reader.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
