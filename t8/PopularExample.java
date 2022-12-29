package t8;

import java.util.ArrayList;
import java.util.Arrays;

public class PopularExample {
	public static final String[] main_dish = {"豬排", "牛排", "魚排", "羊排"};
	private static final Integer[] main_dish_data = {70, 80, 50, 50};
	public static final String[] side_dish = {"凱薩沙拉", "涼拌小黃瓜", "涼拌竹筍", "番茄乳酪沙拉"};
	private static final Integer[] side_dish_data = {50, 60, 70, 40};
	public static final String[] soup = {"牛肉湯", "玉米濃湯", "酸辣湯", "蛤蜊湯"};
	private static final Integer[] soup_data = {60, 90, 80, 60};
	public static final String[] dessert = {"布朗尼", "焦糖布丁", "巧克力布丁", "戚風蛋糕"};
	private static final Integer[] dessert_data = {80, 90, 80, 70};
	public static final String[] all_dish = {
			"豬排", "牛排", "魚排", "羊排",
			"凱薩沙拉", "涼拌小黃瓜", "涼拌竹筍", "番茄乳酪沙拉",
			"牛肉湯", "玉米濃湯", "酸辣湯", "蛤蜊湯",
			"布朗尼", "焦糖布丁", "巧克力布丁", "戚風蛋糕"
	};
	private static final Integer[] all_dish_data = {
			70, 80, 50, 50,
			50, 60, 70, 40,
			60, 90, 80, 60,
			80, 90, 80, 70
	};
	
	public static ArrayList<String>mainDish = new ArrayList<String>(Arrays.asList(main_dish));
	public static ArrayList<Number>mainDishData = new ArrayList<Number>(Arrays.asList(main_dish_data));
	public static ArrayList<String>sideDish = new ArrayList<String>(Arrays.asList(side_dish));
	public static ArrayList<Number>sideDishData = new ArrayList<Number>(Arrays.asList(side_dish_data));
	public static ArrayList<String>Soup = new ArrayList<String>(Arrays.asList(soup));
	public static ArrayList<Number>SoupData = new ArrayList<Number>(Arrays.asList(soup_data));
	public static ArrayList<String>Dessert = new ArrayList<String>(Arrays.asList(dessert));
	public static ArrayList<Number>DessertData = new ArrayList<Number>(Arrays.asList(dessert_data));
	public static ArrayList<String>allDish = new ArrayList<String>(Arrays.asList(all_dish));
	public static ArrayList<Number>allDishData = new ArrayList<Number>(Arrays.asList(all_dish_data));

}
