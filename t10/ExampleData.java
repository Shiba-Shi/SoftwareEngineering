package t10;

import java.util.HashMap;

public class ExampleData {
	private HashMap<String[], HashMap<String, String[]>> map = new HashMap<String[], HashMap<String, String[]>>();
	private String[] E1 = {"2022/12/27 10:00", "服務生一", "一樓", "餐桌一"};
	private String[] E2 = {"2022/12/27 11:00", "服務生二", "二樓", "餐桌二"};
	private String[] E3 = {"2022/12/27 12:00", "服務生三", "三樓", "餐桌三"};
	private String[] E4 = {"2022/12/27 13:00", "服務生四", "四樓", "餐桌四"};
	
	public ExampleData() {
		
		HashMap<String, String[]> e1 = new HashMap<String, String[]>();
		e1.put("主餐", new String[] {"豬排", "牛排", "牛排"});
		e1.put("開胃菜", new String[] {"沙拉", "沙拉", "沙拉"});
		e1.put("湯品", new String[] {"玉米濃湯", "玉米濃湯", "牛肉湯"});
		e1.put("甜點", new String[] {"布朗尼", "布朗尼", "布丁"});
		map.put(E1, e1);
		
		HashMap<String, String[]> e2 = new HashMap<String, String[]>();
		e2.put("主餐", new String[] {"魚排", "牛排", "魚排"});
		e2.put("開胃菜", new String[] {"涼拌小黃瓜", "番茄乳酪沙拉", "凱薩沙拉"});
		e2.put("湯品", new String[] {"蛤蜊湯", "蛤蜊湯", "玉米濃湯"});
		e2.put("甜點", new String[] {"焦糖布丁", "戚風蛋糕", "戚風蛋糕"});
		map.put(E2, e2);

		HashMap<String, String[]> e3 = new HashMap<String, String[]>();
		e3.put("主餐", new String[] {"羊排", "豬排", "羊排"});
		e3.put("開胃菜", new String[] {"涼拌竹筍", "涼拌竹筍", "涼拌小黃瓜"});
		e3.put("湯品", new String[] {"酸辣湯", "牛肉湯", "酸辣湯"});
		e3.put("甜點", new String[] {"巧克力布丁", "巧克力布丁", "焦糖布丁"});
		map.put(E3, e3);
		
		HashMap<String, String[]> e4 = new HashMap<String, String[]>();
		e4.put("主餐", new String[] {"豬排", "魚排", "羊排"});
		e4.put("開胃菜", new String[] {"番茄乳酪沙拉", "凱薩沙拉", "涼拌小黃瓜"});
		e4.put("湯品", new String[] {"玉米濃湯", "牛肉湯", "蛤蜊湯"});
		e4.put("甜點", new String[] {"巧克力布丁", "巧克力布丁", "焦糖布丁"});
		map.put(E4, e4);	
	}
	
	public HashMap<String[], HashMap<String, String[]>> generate(){
		return map;
	}
	
	public String[][] exampleKeySet() {
		String[][] result = {E1, E2, E3, E4};
		return result;
	}
}
