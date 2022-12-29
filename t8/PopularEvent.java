package t8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import org.jfree.chart.ChartPanel;

public class PopularEvent implements ActionListener {
	
	private ChartPanel panel;
	public PopularEvent(ChartPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox combobox = (JComboBox) e.getSource();
		String selected = (String) combobox.getModel().getSelectedItem();
		PopularChart generator;
		switch(selected) {
			case "全部":
				generator = new PopularChart(PopularExample.allDish, PopularExample.allDishData);
				panel.setChart(generator.generate());
				break;
			case "主餐":
				generator = new PopularChart(PopularExample.mainDish, PopularExample.mainDishData);
				panel.setChart(generator.generate());
				break;
			case "開胃菜":
				generator = new PopularChart(PopularExample.sideDish, PopularExample.sideDishData);
				panel.setChart(generator.generate());
				break;
			case "湯品":
				generator = new PopularChart(PopularExample.Soup, PopularExample.SoupData);
				panel.setChart(generator.generate());
				break;
			case "甜點":
				generator = new PopularChart(PopularExample.Dessert, PopularExample.DessertData);
				panel.setChart(generator.generate());
				break;
		}
	}

}
