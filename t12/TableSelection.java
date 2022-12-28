package t12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.tree.DefaultTreeModel;

import t3.FileManager1;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableSelection extends JDialog{

	private final JPanel contentPanel = new JPanel();
	public JLabel tableLabel;
	private JButton searchButton;
	public JTextField entry;
	private JPanel mapBodyPanel;
	private JTextField searchEntry;
	private JButton okButton;
	private JButton cancelButton;
	private JTree floorTree;
	private InputEvent IE;
	/**
	 * Create the dialog.
	 */
	public TableSelection(JTextField entry){
		this.entry = entry;
		setTitle("選擇餐桌");
		setBounds(100, 100, 729, 566);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				tableLabel = new JLabel("查詢餐桌");
				tableLabel.setBackground(new Color(255, 255, 255));
				tableLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
				tableLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				tableLabel.setHorizontalTextPosition(SwingConstants.CENTER);
				tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(tableLabel, BorderLayout.CENTER);
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.RIGHT);
				panel.add(panel_1, BorderLayout.EAST);
				{
					searchEntry = new JTextField();
					searchEntry.setFont(new Font("新細明體", Font.PLAIN, 15));
					panel_1.add(searchEntry);
					searchEntry.setColumns(15);
				}
				{
					searchButton = new JButton("查詢");
					searchButton.setFont(new Font("新細明體", Font.PLAIN, 13));
					panel_1.add(searchButton);
				}
			}
		}
		{
			JSplitPane splitPane = new JSplitPane();
			contentPanel.add(splitPane, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				splitPane.setLeftComponent(panel);
				panel.setLayout(new BorderLayout(0, 0));
				{
					floorTree = new JTree();
					floorTree.setFont(new Font("新細明體", Font.PLAIN, 13));
					floorTree.setModel(new DefaultTreeModel(
							FileManager1.listAll(FileManager1.rootName, FileManager1.rootPath)
					));
					panel.add(floorTree);
				}
			}
			{
				mapBodyPanel = new JPanel();
				mapBodyPanel.setBorder(new LineBorder(new Color(192, 192, 192)));
				splitPane.setRightComponent(mapBodyPanel);
				mapBodyPanel.setLayout(null);
				mapBodyPanel.addComponentListener(new SizeEvent());
				floorTree.addTreeSelectionListener(new MapGenerator(mapBodyPanel, this.tableLabel));
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
						if(!tableLabel.getText().equals("查詢餐桌")) {
							entry.setText(tableLabel.getText());
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
		IE = new InputEvent(mapBodyPanel);
		searchEntry.addFocusListener(IE);
		searchButton.addActionListener(IE);
	}

}
