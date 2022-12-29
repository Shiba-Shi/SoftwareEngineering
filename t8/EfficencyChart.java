package t8;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;

import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class EfficencyChart {
	private TimeSeriesCollection dataset = new TimeSeriesCollection();
	public static final int SINGLE = 0;
	public static final int MULTIPLE = 1;
	private int id;
	public EfficencyChart(HashMap<String, HashMap<LocalTime, Double>> dayData, LocalDate date, int id) {
		this.id = id;
		for(String key: dayData.keySet()) {
			TimeSeries series = new TimeSeries(key);
			for(LocalTime time: dayData.get(key).keySet()) {
				double point = dayData.get(key).get(time);
				Hour day = new Hour(time.getHour(), date.getDayOfMonth(), date.getMonthValue(), date.getYear());
				series.add(new Minute(time.getMinute(), day), point);
			}
			dataset.addSeries(series);
		}
	}
	public EfficencyChart(HashMap<String, HashMap<LocalDate, Double>> multiDayData, int id) {
		this.id = id;
		for(String key: multiDayData.keySet()) {
			TimeSeries series = new TimeSeries(key);
			for(LocalDate date: multiDayData.get(key).keySet()) {
				double point = multiDayData.get(key).get(date);
				series.add(new Day(date.getDayOfMonth(), date.getMonthValue(), date.getYear()), point);
			}
			dataset.addSeries(series);
		}
	}
	
	public JFreeChart generate() {
		JFreeChart chart = ChartFactory.createTimeSeriesChart(null, "日期", "業績", this.dataset);
		chart.getLegend().setItemFont(new Font("Dialog", Font.BOLD, 15));
		XYPlot plot = chart.getXYPlot();
		StandardXYItemRenderer renderer = new StandardXYItemRenderer();
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);
		plot.setRenderer(renderer);
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		AffineTransform rot = AffineTransform.getRotateInstance(Math.PI/4.0);
		axis.setTickLabelFont(axis.getTickLabelFont().deriveFont(rot));
		if(this.id == SINGLE) {
			axis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
		}
		else if(this.id == MULTIPLE) {
			axis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));
		}
		axis.setLabelFont(new Font("Dialog", Font.BOLD, 20));
		plot.getRangeAxis().setLabelFont(new Font("Dialog", Font.BOLD, 20));
		return chart;
	}
}
