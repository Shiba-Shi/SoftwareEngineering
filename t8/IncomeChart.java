package t8;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class IncomeChart {
	private String[] items;
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private DefaultPieDataset dataset1 = new DefaultPieDataset();
	private double[] values;
	public IncomeChart(String[] items, double[] values) {
		this.items = items;
		this.values = values;
		this.prepare();
	}
	
	private void prepare() {
		for(int i = 0; i < items.length; i ++) {
			dataset.addValue(values[i], items[i], items[i]);
			dataset1.setValue(items[i], values[i]);
		}
	}
	
	public JFreeChart generateBar() {
		JFreeChart chart = ChartFactory.createBarChart("", "項目", "收入", this.dataset, PlotOrientation.HORIZONTAL, true, true, false);
		CategoryPlot plot = chart.getCategoryPlot();
		chart.getLegend().setItemFont(new Font("Dialog", Font.BOLD, 15));
		CategoryAxis xaxis = plot.getDomainAxis();
		xaxis.setTickLabelFont(new Font("Dialog", Font.BOLD, 12));
		xaxis.setLabelFont(new Font("Dialog", Font.BOLD, 15));
		ValueAxis yaxis = plot.getRangeAxis();
		yaxis.setTickLabelFont(new Font("Dialog", Font.BOLD, 15));
		yaxis.setLabelFont(new Font("Dialog", Font.BOLD, 15));
		return chart;
	}
	
	public JFreeChart generatePie() {
		JFreeChart chart = ChartFactory.createPieChart("", this.dataset1);
		chart.getLegend().setItemFont(new Font("Dialog", Font.BOLD, 15));
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("Dialog", Font.BOLD, 20));
		return chart;
	}
}
