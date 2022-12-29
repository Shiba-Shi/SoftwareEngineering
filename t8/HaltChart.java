package t8;

import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class HaltChart {

	private TimeSeries series = new TimeSeries("平均周轉時間");
	private LocalDate[] dates;
	private double[] values;
	private TimeSeriesCollection dataset = new TimeSeriesCollection();
	
	public HaltChart(double[] values, LocalDate[] dates) {
		this.values = values;
		this.dates = dates;
		this.prepare();
	}

	public void prepare() {
		for(int i = 0; i < dates.length; i ++ ) {
			int day = this.dates[i].getDayOfMonth();
			int month = this.dates[i].getMonthValue();
			int year = this.dates[i].getYear();
			series.add(new Day(day, month, year), this.values[i]);
		}
		dataset.addSeries(series);
	}
	
	public JFreeChart generate() {
		JFreeChart chart = ChartFactory.createTimeSeriesChart(null, "日期", "時間(小時)", this.dataset);
		chart.getLegend().setItemFont(new Font("Dialog", Font.BOLD, 15));
		XYPlot plot = chart.getXYPlot();
		StandardXYItemRenderer renderer = new StandardXYItemRenderer();
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);
		plot.setRenderer(renderer);
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		AffineTransform rot = AffineTransform.getRotateInstance(Math.PI/4.0);
		axis.setTickLabelFont(axis.getTickLabelFont().deriveFont(rot));
		axis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));
		axis.setLabelFont(new Font("Dialog", Font.BOLD, 20));
		plot.getRangeAxis().setLabelFont(new Font("Dialog", Font.BOLD, 20));
		return chart;
	}

}
