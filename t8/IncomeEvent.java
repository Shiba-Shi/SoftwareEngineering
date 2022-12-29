package t8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import org.jfree.chart.ChartPanel;

public class IncomeEvent implements ActionListener {
	private ChartPanel panel;
	private JComboBox incomebox;
	private JComboBox typebox;
	public IncomeEvent(ChartPanel panel, JComboBox incomebox, JComboBox typebox) {
		this.panel = panel;
		this.incomebox = incomebox;
		this.typebox = typebox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selected1 = (String) incomebox.getModel().getSelectedItem();
		String selected2 = (String) typebox.getModel().getSelectedItem();
		IncomeChart generator;
		switch(selected1) {
			case "全部":
				generator = new IncomeChart(PopularExample.all_dish, IncomeExample.allIncome);
				if(selected2.equals("數據")) {
					panel.setChart(generator.generateBar());
				}
				else {
					panel.setChart(generator.generatePie());
				}
				break;
			case "主餐":
				generator = new IncomeChart(PopularExample.main_dish, IncomeExample.mainDishIncome);
				if(selected2.equals("數據")) {
					panel.setChart(generator.generateBar());
				}
				else {
					panel.setChart(generator.generatePie());
				}
				break;
			case "開胃菜":
				generator = new IncomeChart(PopularExample.side_dish, IncomeExample.sideDishIncome);
				if(selected2.equals("數據")) {
					panel.setChart(generator.generateBar());
				}
				else {
					panel.setChart(generator.generatePie());
				}
				break;
			case "湯品":
				generator = new IncomeChart(PopularExample.soup, IncomeExample.soupIncome);
				if(selected2.equals("數據")) {
					panel.setChart(generator.generateBar());
				}
				else {
					panel.setChart(generator.generatePie());
				}
				break;
			case "甜點":
				generator = new IncomeChart(PopularExample.dessert, IncomeExample.dessertIncome);
				if(selected2.equals("數據")) {
					panel.setChart(generator.generateBar());
				}
				else {
					panel.setChart(generator.generatePie());
				}
				break;
		}
	}

}
