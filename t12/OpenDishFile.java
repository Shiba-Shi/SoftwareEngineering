package t12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenDishFile {
	private String folder = System.getProperty("user.dir") + System.getProperty("file.separator") + "餐點";
	private File file = new File(folder + System.getProperty("file.separator") + "餐點.json");
	private static final String[] type = {"主餐", "開胃菜", "湯品", "甜點"};
	private JSONObject obj;
	public OpenDishFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String content = read(reader);
			content = content.replaceAll("\n", "");
			obj = new JSONObject(content);
		} catch (FileNotFoundException | JSONException e) {
			e.printStackTrace();
		}
	}
	
	private String read(BufferedReader reader){
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
	
	public HashMap<String, ArrayList<String>>getData(){
		HashMap<String, ArrayList<String>> dishDict = new HashMap<String, ArrayList<String>>();
		for(int i = 0; i < OpenDishFile.type.length; i ++ ) {
			try {
				JSONArray arr = obj.getJSONArray(OpenDishFile.type[i]);
				ArrayList<String> strings = collect(arr);
				dishDict.put(OpenDishFile.type[i], strings);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return dishDict;
	}
	
	private ArrayList<String> collect(JSONArray arr) {
		ArrayList<String> strings = new ArrayList<String>();
		for(int i = 0; i < arr.length(); i ++) {
			try {
				strings.add(arr.getString(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return strings;
	}
}
