package t8;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MarketAnalysis extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton dateButton;
	private JRadioButton dayButton;
	private JRadioButton weekButton;
	private JRadioButton monthButton;
	private ChartPanel popularPanel;
	private ChartPanel haltPanel;
	private ChartPanel preparePanel;
	private ChartPanel incomePanel;
	private ChartPanel efficiencyPanel;
	private JComboBox<String> incomeCombobox;
	private JComboBox typeCombobox;
	/**
	 * Create the panel.
	 */
	public MarketAnalysis() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, "name_395255497274500");
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextField dateEntry = new JTextField();
		dateEntry.setHorizontalAlignment(SwingConstants.CENTER);
		dateEntry.setEditable(false);
		dateEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 255, 255)));
		dateEntry.setFont(new Font("????????????", Font.PLAIN, 15));
		panel_4.add(dateEntry);
		dateEntry.setColumns(15);
		
		dateButton = new JButton("??????");
		dateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateDialog date = new DateDialog(dateEntry);
				date.setVisible(true);
			
			}
		});
		dateButton.setFont(new Font("????????????", Font.PLAIN, 15));
		panel_4.add(dateButton);
		
		dayButton = new JRadioButton("???");
		dayButton.setSelected(true);
		dayButton.setFont(new Font("????????????", Font.BOLD, 13));
		buttonGroup.add(dayButton);
		panel_2.add(dayButton);
		
		weekButton = new JRadioButton("???");
		weekButton.setFont(new Font("????????????", Font.BOLD, 13));
		buttonGroup.add(weekButton);
		panel_2.add(weekButton);
		
		monthButton = new JRadioButton("???");
		monthButton.setFont(new Font("????????????", Font.BOLD, 13));
		buttonGroup.add(monthButton);
		panel_2.add(monthButton);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_1.add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.33);
		splitPane.setLeftComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.5);
		splitPane_1.setRightComponent(splitPane_2);
		
		JPanel panel_7 = new JPanel();
		splitPane_2.setLeftComponent(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		panel_7.add(panel_12, BorderLayout.NORTH);
		
		JLabel haltTitle = new JLabel("??????????????????");
		haltTitle.setFont(new Font("????????????", Font.BOLD, 15));
		panel_12.add(haltTitle);

		double[] times = {
				2, 1.1, 1.2, 1.15, 0.9
			};
			
		LocalDate[] dates = {
				LocalDate.of(2022, 12, 23),
				LocalDate.of(2022, 12, 24),
				LocalDate.of(2022, 12, 25),
				LocalDate.of(2022, 12, 26),
				LocalDate.of(2022, 12, 27),
		};
		haltPanel = new ChartPanel(new HaltChart(times, dates).generate());
		panel_7.add(haltPanel, BorderLayout.CENTER);
		haltPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_8 = new JPanel();
		splitPane_2.setRightComponent(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		panel_8.add(panel_13, BorderLayout.NORTH);
		
		JLabel prepareTitle = new JLabel("??????????????????");
		prepareTitle.setFont(new Font("????????????", Font.BOLD, 15));
		panel_13.add(prepareTitle);
		

		preparePanel = new ChartPanel((JFreeChart) null);
		panel_8.add(preparePanel, BorderLayout.CENTER);
		double[] times1 = {
			0.7, 0.5, 0.55, 0.45, 0.45
		};
		
		LocalDate[] dates1 = {
				LocalDate.of(2022, 12, 23),
				LocalDate.of(2022, 12, 24),
				LocalDate.of(2022, 12, 25),
				LocalDate.of(2022, 12, 26),
				LocalDate.of(2022, 12, 27),
		};
		
		PrepareChart dataChart = new PrepareChart(times1, dates1);
		preparePanel.setChart(dataChart.generate());
		
		JPanel panel_6 = new JPanel();
		splitPane_1.setLeftComponent(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		panel_6.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel popularTitle = new JLabel("???????????????????????????");
		popularTitle.setHorizontalAlignment(SwingConstants.CENTER);
		popularTitle.setFont(new Font("????????????", Font.BOLD, 15));
		panel_11.add(popularTitle);
		
		JComboBox popularCombobox = new JComboBox();
		popularCombobox.setModel(new DefaultComboBoxModel(new String[] {"??????", "??????", "?????????", "??????", "??????"}));
		panel_11.add(popularCombobox);
		
		PopularChart chart = new PopularChart(PopularExample.allDish, PopularExample.allDishData);
		popularPanel = new ChartPanel(chart.generate());
		panel_6.add(popularPanel, BorderLayout.CENTER);
		popularPanel.setLayout(new BorderLayout(0, 0));
		popularCombobox.addActionListener(new PopularEvent(popularPanel));
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setResizeWeight(0.5);
		splitPane.setRightComponent(splitPane_3);
		
		JPanel panel_9 = new JPanel();
		splitPane_3.setLeftComponent(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		panel_9.add(panel_14, BorderLayout.NORTH);
		
		JLabel incomeTitle = new JLabel("???????????????????????????????????????");
		incomeTitle.setFont(new Font("????????????", Font.BOLD, 15));
		panel_14.add(incomeTitle);
		
		incomeCombobox = new JComboBox<String>();
		incomeCombobox.setName("incomeCombobox");
		incomeCombobox.setModel(new DefaultComboBoxModel(new String[] {"??????", "??????", "?????????", "??????", "??????"}));
		panel_14.add(incomeCombobox);
		
		typeCombobox = new JComboBox();
		typeCombobox.setName("typeCombobox");
		typeCombobox.setModel(new DefaultComboBoxModel(new String[] {"??????", "?????????"}));
		panel_14.add(typeCombobox);
		
		IncomeChart chart1 = new IncomeChart(PopularExample.all_dish, IncomeExample.allIncome);
		incomePanel = new ChartPanel(chart1.generateBar());
		panel_9.add(incomePanel, BorderLayout.CENTER);
		
		IncomeEvent ie = new IncomeEvent(incomePanel, incomeCombobox, typeCombobox);
		incomeCombobox.addActionListener(ie);
		typeCombobox.addActionListener(ie);
		
		JPanel panel_10 = new JPanel();
		splitPane_3.setRightComponent(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		panel_10.add(panel_15, BorderLayout.NORTH);
		
		JLabel efficencyTitle = new JLabel("????????????");
		efficencyTitle.setFont(new Font("????????????", Font.BOLD, 15));
		panel_15.add(efficencyTitle);
		
		efficiencyPanel = new ChartPanel((JFreeChart) null);
		panel_10.add(efficiencyPanel, BorderLayout.CENTER);
		
		EfficencyExample ee = new EfficencyExample();
		EfficencyChart chart2 = new EfficencyChart(ee.getData(), EfficencyChart.MULTIPLE);
		efficiencyPanel.setChart(chart2.generate());
	}

}
