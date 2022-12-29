package t8;

public class IncomeExample {
	public static double[] mainDishIncome = {
			PopularExample.mainDishData.get(0).doubleValue() * 90,
			PopularExample.mainDishData.get(1).doubleValue() * 100,
			PopularExample.mainDishData.get(2).doubleValue() * 70,
			PopularExample.mainDishData.get(3).doubleValue() * 90
	};
	
	public static double[] sideDishIncome = {
			PopularExample.sideDishData.get(0).doubleValue() * 50,
			PopularExample.sideDishData.get(1).doubleValue() * 40,
			PopularExample.sideDishData.get(2).doubleValue() * 40,
			PopularExample.sideDishData.get(3).doubleValue() * 50
	};
	
	public static double[] soupIncome = {
			PopularExample.SoupData.get(0).doubleValue() * 80,
			PopularExample.SoupData.get(1).doubleValue() * 70,
			PopularExample.SoupData.get(2).doubleValue() * 80,
			PopularExample.SoupData.get(3).doubleValue() * 80
	};
	
	public static double[] dessertIncome = {
			PopularExample.DessertData.get(0).doubleValue() * 60,
			PopularExample.DessertData.get(1).doubleValue() * 50,
			PopularExample.DessertData.get(2).doubleValue() * 50,
			PopularExample.DessertData.get(3).doubleValue() * 60
	};
	
	public static double[] allIncome = {
			PopularExample.mainDishData.get(0).doubleValue() * 90,
			PopularExample.mainDishData.get(1).doubleValue() * 100,
			PopularExample.mainDishData.get(2).doubleValue() * 70,
			PopularExample.mainDishData.get(3).doubleValue() * 90,
			PopularExample.sideDishData.get(0).doubleValue() * 50,
			PopularExample.sideDishData.get(1).doubleValue() * 40,
			PopularExample.sideDishData.get(2).doubleValue() * 40,
			PopularExample.sideDishData.get(3).doubleValue() * 50,
			PopularExample.SoupData.get(0).doubleValue() * 80,
			PopularExample.SoupData.get(1).doubleValue() * 70,
			PopularExample.SoupData.get(2).doubleValue() * 80,
			PopularExample.SoupData.get(3).doubleValue() * 80,
			PopularExample.DessertData.get(0).doubleValue() * 60,
			PopularExample.DessertData.get(1).doubleValue() * 50,
			PopularExample.DessertData.get(2).doubleValue() * 50,
			PopularExample.DessertData.get(3).doubleValue() * 60
	};
}
