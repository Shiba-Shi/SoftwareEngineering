package t8;

import java.time.LocalDate;
import java.util.HashMap;

public class EfficencyExample {
	private HashMap<LocalDate, Double> data1 = new HashMap<LocalDate, Double>();
	private HashMap<LocalDate, Double> data2 = new HashMap<LocalDate, Double>();
	private HashMap<LocalDate, Double> data3 = new HashMap<LocalDate, Double>();
	private HashMap<LocalDate, Double> data4 = new HashMap<LocalDate, Double>();
	private HashMap<LocalDate, Double> data5 = new HashMap<LocalDate, Double>();
	
	public HashMap<String, HashMap<LocalDate, Double>>getData(){
		HashMap<String, HashMap<LocalDate, Double>> multiDayData = new HashMap<String, HashMap<LocalDate, Double>>();
		
		data2.put(LocalDate.of(2022, 12, 23), 10000.0);
		data2.put(LocalDate.of(2022, 12, 24), 10020.0);
		data2.put(LocalDate.of(2022, 12, 25), 10202.0);
		data2.put(LocalDate.of(2022, 12, 26), 9000.0);
		data2.put(LocalDate.of(2022, 12, 27), 11000.0);
		multiDayData.put("服務生二號", data2);
		
		data1.put(LocalDate.of(2022, 12, 23), 10100.0);
		data1.put(LocalDate.of(2022, 12, 24), 11000.0);
		data1.put(LocalDate.of(2022, 12, 25), 11020.0);
		data1.put(LocalDate.of(2022, 12, 26), 10000.0);
		data1.put(LocalDate.of(2022, 12, 27), 12020.0);
		multiDayData.put("服務生一號", data1);
		
		data3.put(LocalDate.of(2022, 12, 23), 9000.0);
		data3.put(LocalDate.of(2022, 12, 24), 9500.0);
		data3.put(LocalDate.of(2022, 12, 25), 9800.0);
		data3.put(LocalDate.of(2022, 12, 26), 8500.0);
		data3.put(LocalDate.of(2022, 12, 27), 9300.0);
		multiDayData.put("服務生三號", data3);


		data4.put(LocalDate.of(2022, 12, 23), 11000.0);
		data4.put(LocalDate.of(2022, 12, 24), 11500.0);
		data4.put(LocalDate.of(2022, 12, 25), 12200.0);
		data4.put(LocalDate.of(2022, 12, 26), 10500.0);
		data4.put(LocalDate.of(2022, 12, 27), 11700.0);
		multiDayData.put("服務生四號", data4);
		
		data5.put(LocalDate.of(2022, 12, 23), 12000.0);
		data5.put(LocalDate.of(2022, 12, 24), 12100.0);
		data5.put(LocalDate.of(2022, 12, 25), 10300.0);
		data5.put(LocalDate.of(2022, 12, 26), 12000.0);
		data5.put(LocalDate.of(2022, 12, 27), 13000.0);
		multiDayData.put("服務生五號", data5);
		
		return multiDayData;
	}
}
