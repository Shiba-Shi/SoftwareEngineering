package t8;

import java.awt.Font;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;

public class PopularChart {
	private DefaultPieDataset dataset = new DefaultPieDataset();
	private ArrayList<String> items = new ArrayList<String>();
	private ArrayList<Number> values = new ArrayList<Number>();
	
	public PopularChart(ArrayList<String> items, ArrayList<Number> values) {
		this.items = items;
		this.values = values;
		for(int i = 0; i < items.size(); i ++ ) {
			groupData(items.get(i), values.get(i));
		}
		
	}
	
	private void groupData(String item, Number value) {
		dataset.setValue(item, value);
	}

	public JFreeChart generate() {
		JFreeChart chart = ChartFactory.createPieChart( null, this.dataset);
		chart.getLegend().setItemFont(new Font("Dialog", Font.BOLD, 15));
		PiePlot pieChart = (PiePlot) chart.getPlot();
		pieChart.setLabelFont(new Font("Dialog", Font.BOLD, 20));
		return chart;
	}
}
