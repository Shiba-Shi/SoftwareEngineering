package t12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DishSelection extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JButton mainDishButton;
	private JButton sideDishButton;
	private JButton soupButton;
	private JButton dessertButton;
	private JPanel dishBodyPanel;
	private JButton okButton;
	private JButton cancelButton;
	public JTextField entry;
	public JLabel resultLabel;
	private JList dishList;
	private OpenDishFile odf = new OpenDishFile();
	private HashMap<String, ArrayList<String>> dishDict = odf.getData();
	/**
	 * Create the dialog.
	 */
	public DishSelection(JTextField entry) {
		this.entry = entry;
		setTitle("選擇餐點");
		setBounds(100, 100, 819, 558);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JSplitPane splitPane = new JSplitPane();
			contentPanel.add(splitPane);
			{
				JPanel panel = new JPanel();
				splitPane.setLeftComponent(panel);
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					{
						mainDishButton = new JButton("主餐");
						mainDishButton.setFont(new Font("新細明體", Font.PLAIN, 18));
						panel_1.add(mainDishButton, BorderLayout.SOUTH);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					{
						sideDishButton = new JButton("開胃菜");
						sideDishButton.setFont(new Font("新細明體", Font.PLAIN, 18));
						panel_1.add(sideDishButton, BorderLayout.SOUTH);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					{
						soupButton = new JButton("湯品");
						soupButton.setFont(new Font("新細明體", Font.PLAIN, 18));
						panel_1.add(soupButton, BorderLayout.SOUTH);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					{
						dessertButton = new JButton("甜點");
						dessertButton.setFont(new Font("新細明體", Font.PLAIN, 18));
						panel_1.add(dessertButton, BorderLayout.SOUTH);
					}
				}
			}
			{
				JPanel panel = new JPanel();
				splitPane.setRightComponent(panel);
				panel.setLayout(new BorderLayout(0, 0));
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1, BorderLayout.NORTH);
					{
						resultLabel = new JLabel("查詢餐點");
						resultLabel.setFont(new Font("新細明體", Font.BOLD, 20));
						panel_1.add(resultLabel);
					}
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					panel.add(scrollPane, BorderLayout.CENTER);
					{
						dishBodyPanel = new JPanel();
						scrollPane.setViewportView(dishBodyPanel);
						dishBodyPanel.setLayout(new BorderLayout(0, 0));
						{
							dishList = new JList();
							dishList.setFont(new Font("新細明體", Font.PLAIN, 18));
							dishBodyPanel.add(dishList);
							DefaultListModel<String> model = new DefaultListModel<String>();
							dishList.setModel(model);
							dishList.addListSelectionListener(new ListSelectionListener() {
								@Override
								public void valueChanged(ListSelectionEvent e) {
									resultLabel.setText((String)dishList.getSelectedValue());
									
								}
								
							});
						}
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("確認");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!resultLabel.getText().equals("查詢餐點")) {
							entry.setText(resultLabel.getText());
						}
						dispose();
					}
				});
				okButton.setFont(new Font("新細明體", Font.PLAIN, 15));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("新細明體", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.addWindowListener(new WindowEventHandler());
		DishChooseEvent dce = new DishChooseEvent(this.dishList, this.dishDict);
		this.mainDishButton.addActionListener(dce);
		this.sideDishButton.addActionListener(dce);
		this.soupButton.addActionListener(dce);
		this.dessertButton.addActionListener(dce);
	}

}
