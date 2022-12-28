package t3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileManager1 {
	public static String userDir = System.getProperty("user.dir");
	public static String sep = System.getProperty("file.separator");
	public static String rootName = "餐廳";
	public static String rootPath = userDir + sep + rootName;
	public static int FILE = 0;
	public static int FOLDER = 1;
	
	public FileManager1() {
		this.detectRoot();
	}
	
	private void detectRoot() {
		Path path = Paths.get(userDir + sep + rootName);
		if(!Files.exists(path)) {
			File folder = new File(rootPath);
			folder.mkdir();
		}
	}
	
	public static DefaultMutableTreeNode listAll(String rootName, String rootPath) {
		File root = new File(rootPath);
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(rootName);
		File[] items = root.listFiles();
		for(int i = 0; i < items.length; i ++ ) {
			if(items[i].isDirectory()) {
				node.add(listAll(items[i].getName(), rootPath + sep + items[i].getName()));
			}
			else {
				node.add(new DefaultMutableTreeNode(items[i].getName()));
			}
		}
		return node;
	}
	
	public static void addChildFolder(String parentPath, String name) {
		File folder = new File(parentPath + sep + name);
		folder.mkdir();
	}
	
	public static void addChildFile(String parentPath, String name) {
		File file = new File(parentPath + sep + name + ".json");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteChildFolder(String folderPath) {
		File folder = new File(folderPath);
		File[] files = folder.listFiles();
		for(int i = 0; i < files.length; i ++) {
			if(files[i].isDirectory()) {
				deleteChildFolder(files[i].getAbsolutePath());
			}
			else {
				files[i].delete();
			}
		}
		folder.delete();
	}
	
	public static void deleteChildFile(String filePath) {
		File file = new File(filePath);
		file.delete();
	}
	
	public static boolean checkDumplicate(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}
	
	public static int identify(String filePath) {
		File file = new File(filePath);
		if(file.isDirectory()) {
			return FOLDER;
		}
		else if(file.isFile()) {
			return FILE;
		}
		else {
			return -1;
		}
	}
	
	public static void storeData(String path, ArrayList<HashMap<String, Object>> contents) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			JSONArray arr = parse(contents);
			writer.write(arr.toString());
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static JSONArray parse(ArrayList<HashMap<String, Object>> contents) {
		JSONObject obj;
		JSONArray arr = new JSONArray();
		for(HashMap<String, Object> content: contents) {
			obj = new JSONObject();
			for(String key: content.keySet()) {
				try {
					obj.put(key, content.get(key));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			arr.put(obj);
		}
		return arr;
	}
	
	public static ArrayList<HashMap<String, Object>> getContents(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String content = readContent(reader);
			reader.close();
			JSONArray arr = new JSONArray(content);
			JSONObject obj;
			HashMap<String, Object> dict;
			String[] keys;
			ArrayList<HashMap<String, Object>> contents = new ArrayList<HashMap<String, Object>>();
			for(int i = 0; i < arr.length(); i ++) {
				obj = arr.getJSONObject(i);
				keys = JSONObject.getNames(obj);
				if(obj.get("width") instanceof Integer && obj.get("height") instanceof Integer) {
					continue;
				}
				dict = new HashMap<String, Object>();
				for(String key: keys) {
					dict.put(key, obj.get(key));
				}
				contents.add(dict);
			}
			return contents;
		}
		catch (IOException | JSONException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private static String readContent(BufferedReader reader) {
		try {
			String content = new String();
			String s;
			while(( s = reader.readLine()) != null) {
				content += s;
			}
			
			if(content.equals("")) {
				content = "[]";
			}
			return content;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
