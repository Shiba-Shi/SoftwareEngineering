package t3;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewFileFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel nameLabel;
	private JLabel typeLabel;
	private JRadioButton fileButton;
	private JRadioButton folderButton;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField nameEntry;
	private JLabel tipLabel;

	/**
	 * Create the frame.
	 */
	public NewFileFrame(JTree tree) {
		setVisible(true);
		setTitle("新增");
		setResizable(false);
		setBounds(100, 100, 586, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel titleLabel = new JLabel("創建");
		titleLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		panel.add(titleLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(513, Short.MAX_VALUE))
		);
		
		typeLabel = new JLabel("種類");
		typeLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_3.add(typeLabel);
		
		fileButton = new JRadioButton("文件");
		fileButton.setSelected(true);
		fileButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		buttonGroup.add(fileButton);
		panel_3.add(fileButton);
		
		folderButton = new JRadioButton("資料夾");
		folderButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		buttonGroup.add(folderButton);
		panel_3.add(folderButton);
		
		nameLabel = new JLabel("名稱");
		nameLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_2.add(nameLabel);
		
		nameEntry = new JTextField();
		nameEntry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!checkText(tree)) {
					tipLabel.setText("名稱錯誤");
					tipLabel.setForeground(Color.red);
				}
				else {
					tipLabel.setText("名稱正確");
					tipLabel.setForeground(Color.green);
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(!checkText(tree)) {
					tipLabel.setText("名稱錯誤");
					tipLabel.setForeground(Color.red);
				}
				else {
					tipLabel.setText("名稱正確");
					tipLabel.setForeground(Color.green);
				}
			}
		});
		nameEntry.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel_2.add(nameEntry);
		nameEntry.setColumns(20);
		
		tipLabel = new JLabel("");
		panel_2.add(tipLabel);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		okButton = new JButton("確定");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameEntry.getText().trim();
				if(!name.isEmpty()) {
					if(fileButton.isSelected()) {
						FileManager1.addChildFile(getParentPath(tree), nameEntry.getText());
						name += ".json";
					}
					else{
						FileManager1.addChildFolder(getParentPath(tree), nameEntry.getText());
					}
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					node.add(new DefaultMutableTreeNode(name));
					dispose();
				}
				
			}
		});
		okButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_4.add(okButton);
		
		cancelButton = new JButton("取消");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_4.add(cancelButton);
	}
	
	private boolean checkText(JTree tree) {
		if(!this.nameEntry.getText().matches("^[a-zA-Z0-9\u4e00-\u9fa5]+")) {
			return false;
		}
		StringBuilder sb = new StringBuilder(this.getParentPath(tree));
		sb.append(this.nameEntry.getText());
		return !FileManager1.checkDumplicate(sb.toString());
	}
	
	private String getParentPath(JTree tree) {
		TreePath path = tree.getSelectionPath();
		StringBuilder sb = new StringBuilder(FileManager1.userDir);
		for(Object p: path.getPath()) {
			sb.append(FileManager1.sep);
			DefaultMutableTreeNode p1 = (DefaultMutableTreeNode)p;
			sb.append((String)p1.getUserObject());
		}
		return sb.toString();
	}
}
