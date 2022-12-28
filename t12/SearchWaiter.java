package t12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class SearchWaiter extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField searchEntry;
	public JLabel resultLabel;
	private JList menuList;
	public JTextField entry;
	private JTree floorTree;
	private JButton searchButton;

	/**
	 * Create the dialog.
	 */
	public SearchWaiter(JTextField entry) {
		this.entry = entry;
		setTitle("選擇服務生");
		setBounds(100, 100, 723, 567);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JSplitPane splitPane = new JSplitPane();
			contentPanel.add(splitPane, BorderLayout.CENTER);
			{
				JScrollPane scrollPane = new JScrollPane();
				splitPane.setLeftComponent(scrollPane);
				{
					JPanel panel = new JPanel();
					scrollPane.setViewportView(panel);
					panel.setLayout(new BorderLayout(0, 0));
					{
						floorTree = new JTree();
						floorTree.setFont(new Font("新細明體", Font.PLAIN, 13));
						DefaultMutableTreeNode node = OpenEmployeeFile.listAll("員工", OpenEmployeeFile.folderPath);
						floorTree.setModel(new DefaultTreeModel(node));
						panel.add(floorTree);
					}
				}
			}
			{
				JPanel menuBodyPanel = new JPanel();
				menuBodyPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
				splitPane.setRightComponent(menuBodyPanel);
				menuBodyPanel.setLayout(new BorderLayout(0, 0));
				{
					menuList = new JList();
					menuList.setFont(new Font("新細明體", Font.PLAIN, 20));
					menuList.setModel(new DefaultListModel());
					menuBodyPanel.add(menuList);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				resultLabel = new JLabel("查詢服務生");
				resultLabel.setFont(new Font("新細明體", Font.BOLD, 20));
				resultLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
				resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				resultLabel.setHorizontalTextPosition(SwingConstants.CENTER);
				resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(resultLabel, BorderLayout.CENTER);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.EAST);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					searchEntry = new JTextField();
					searchEntry.setFont(new Font("新細明體", Font.PLAIN, 15));
					panel_1.add(searchEntry);
					searchEntry.setColumns(15);
				}
				{
					searchButton = new JButton("查詢");
					searchButton.setFont(new Font("新細明體", Font.PLAIN, 15));
					panel_1.add(searchButton);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("確認");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!resultLabel.getText().equals("查詢服務生")) {
							entry.setText(resultLabel.getText());
						}
						dispose();
					}
				});
				okButton.setFont(new Font("新細明體", Font.PLAIN, 18));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("新細明體", Font.PLAIN, 18));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		menuList.addListSelectionListener(new ListEvent(this.resultLabel));
		this.addWindowListener(new WindowEventHandler());
		this.floorTree.addTreeSelectionListener(new WaiterFileEvent(this.menuList));
		InputEvent ie = new InputEvent(this.menuList);
		this.searchEntry.addFocusListener(ie);
		this.searchButton.addActionListener(ie);
	}
}
