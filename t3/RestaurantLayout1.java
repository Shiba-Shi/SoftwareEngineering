package t3;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurantLayout1 extends JPanel {
	private JButton tableButton;
	private JButton chairButton;
	private JButton doorButton;
	private JButton counterButton;
	private JButton decoratorButton;
	private JButton wallButton;
	private JPanel propertyPanel;
	private JMenu fileMenu;
	private JMenuItem addItem;
	private JMenuItem deleteItem;
	private JMenuItem storeItem;
	private JMenu editMenu;
	private JMenuItem undoItem;
	private JMenuItem redoItem;
	private JMenuItem deleteAllItem;
	public static JLabel fileLabel;
	private JPanel graphicPanel;
	private String imageDir = System.getProperty("user.dir") + "\\image";
	private ImageIcon table = new ImageIcon(imageDir + "\\4007097_01.png"); 
	private ImageIcon chair = new ImageIcon(imageDir + "\\4000927_01.png");
	private ImageIcon door = new ImageIcon(imageDir + "\\smc_a05_003.png");
	private ImageIcon wall = new ImageIcon(imageDir + "\\000001_1551951229.jpg");
	private ImageIcon counter = new ImageIcon(imageDir + "\\111111.jpg");
	private ImageIcon decorator = new ImageIcon(imageDir + "\\img_resizer.png");
	private Dictionary<JButton, String> dict = new Hashtable<JButton, String>();
	public static NewArrayList<ArrayList<HashMap<String, Object>>> undoEventBox;
	public static NewArrayList<ArrayList<HashMap<String, Object>>> redoEventBox;
	private final double labelSizeRatio = 0.1;
	private PopMenuEvent PME;
	private DragDropEvent DDE;
	private FunctionBarEvent1 FBE;
	private FileManager1 manager = new FileManager1();
	/**
	 * Create the panel.
	 */
	public RestaurantLayout1() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar, BorderLayout.NORTH);
		
		fileMenu = new JMenu("檔案");
		fileMenu.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		menuBar.add(fileMenu);
		
		addItem = new JMenuItem("新增");
		addItem.setActionCommand("add");
		addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		fileMenu.add(addItem);
		
		deleteItem = new JMenuItem("刪除");
		deleteItem.setActionCommand("delete");
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_DOWN_MASK));
		fileMenu.add(deleteItem);
		
		storeItem = new JMenuItem("儲存");
		storeItem.setActionCommand("store");
		storeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		fileMenu.add(storeItem);
		
		editMenu = new JMenu("編輯");
		editMenu.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		menuBar.add(editMenu);
		
		undoItem = new JMenuItem("上一步");
		undoItem.setEnabled(false);
		undoItem.setActionCommand("undo");
		undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		editMenu.add(undoItem);
		
		redoItem = new JMenuItem("下一步");
		redoItem.setEnabled(false);
		redoItem.setActionCommand("redo");
		redoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		editMenu.add(redoItem);
		
		deleteAllItem = new JMenuItem("全部刪除");
		deleteAllItem.setActionCommand("deleteAll");
		deleteAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		editMenu.add(deleteAllItem);
		
		undoEventBox = new NewArrayList<ArrayList<HashMap<String, Object>>>(undoItem);
		redoEventBox = new NewArrayList<ArrayList<HashMap<String, Object>>>(redoItem);
		
		JPanel panel_11 = new JPanel();
		menuBar.add(panel_11);
		
		fileLabel = new JLabel("餐廳");
		fileLabel.setOpaque(true);
		fileLabel.setBackground(new Color(0, 255, 0));
		fileLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_11.add(fileLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		panel_1.add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.9);
		splitPane.setRightComponent(splitPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane_1);
		
		graphicPanel = new JPanel();
		scrollPane_1.setViewportView(graphicPanel);
		graphicPanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		splitPane_1.setRightComponent(scrollPane_2);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.5);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		scrollPane_2.setViewportView(splitPane_2);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		splitPane_2.setLeftComponent(scrollPane_4);
		
		JPanel panel_2 = new JPanel();
		scrollPane_4.setViewportView(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		tableButton = new JButton("桌子");
		tableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate(e);
			}
		});
		tableButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tableButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		tableButton.setFont(new Font("新細明體", Font.BOLD, 15));
		Image tableImg = table.getImage();
		Dimension tableImgSize = tableButton.getPreferredSize();
		tableImg = tableImg.getScaledInstance(tableImgSize.width, tableImgSize.width, Image.SCALE_SMOOTH);
		table.setImage(tableImg);
		tableButton.setIcon(table);
		panel_5.add(tableButton);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		chairButton = new JButton("椅子");
		chairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate(e);
			}
		});
		chairButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		chairButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		chairButton.setFont(new Font("新細明體", Font.BOLD, 15));
		chairButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chairButton.setHorizontalAlignment(SwingConstants.CENTER);
		Image chairImg = chair.getImage();
		Dimension chairImgSize = chairButton.getPreferredSize();
		chairImg = chairImg.getScaledInstance(chairImgSize.width, chairImgSize.width, Image.SCALE_SMOOTH);
		chair.setImage(chairImg);
		chairButton.setIcon(chair);
		panel_6.add(chairButton);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		doorButton = new JButton("門");
		doorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate(e);
			}
		});
		doorButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		doorButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		doorButton.setFont(new Font("新細明體", Font.BOLD, 15));
		doorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		doorButton.setHorizontalAlignment(SwingConstants.CENTER);
		Image doorImg = door.getImage();
		Dimension doorImgSize = doorButton.getPreferredSize();
		doorImg = doorImg.getScaledInstance(doorImgSize.width * 2, doorImgSize.width * 2, Image.SCALE_SMOOTH);
		door.setImage(doorImg);
		doorButton.setIcon(door);
		panel_7.add(doorButton);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		counterButton = new JButton("櫃台");
		counterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate(e);
			}
		});
		counterButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		counterButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		counterButton.setFont(new Font("新細明體", Font.BOLD, 15));
		counterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		counterButton.setHorizontalAlignment(SwingConstants.CENTER);
		Image counterImg = counter.getImage();
		Dimension counterImgSize = counterButton.getPreferredSize();
		counterImg = counterImg.getScaledInstance(counterImgSize.width, counterImgSize.width, Image.SCALE_SMOOTH);
		counter.setImage(counterImg);
		counterButton.setIcon(counter);
		panel_8.add(counterButton);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		decoratorButton = new JButton("裝飾品");
		decoratorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate(e);
			}
		});
		decoratorButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		decoratorButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		decoratorButton.setFont(new Font("新細明體", Font.BOLD, 15));
		decoratorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		decoratorButton.setHorizontalAlignment(SwingConstants.CENTER);
		Image decoratorImg = decorator.getImage();
		Dimension decoratorImgSize = decoratorButton.getPreferredSize();
		decoratorImg = decoratorImg.getScaledInstance(decoratorImgSize.width, decoratorImgSize.width, Image.SCALE_SMOOTH);
		decorator.setImage(decoratorImg);
		decoratorButton.setIcon(decorator);
		panel_9.add(decoratorButton);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		wallButton = new JButton("牆壁");
		wallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate(e);
			}
		});
		wallButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		wallButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		wallButton.setFont(new Font("新細明體", Font.BOLD, 15));
		wallButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wallButton.setHorizontalAlignment(SwingConstants.CENTER);
		Image wallImg = wall.getImage();
		Dimension wallImgSize = wallButton.getPreferredSize();
		wallImg = wallImg.getScaledInstance(wallImgSize.width, wallImgSize.width, Image.SCALE_SMOOTH);
		wall.setImage(wallImg);
		wallButton.setIcon(wall);
		panel_10.add(wallButton);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		splitPane_2.setRightComponent(scrollPane_5);
		
		propertyPanel = new JPanel();
		scrollPane_5.setViewportView(propertyPanel);
		propertyPanel.setLayout(new NewCardLayout(10, 0));
		
		JScrollPane treePanel = new JScrollPane();
		splitPane.setLeftComponent(treePanel);
		
		JTree fileTree = new JTree();
		fileTree.addTreeSelectionListener(new TreeSelectEvent(fileLabel, graphicPanel, propertyPanel));
		
		fileTree.setShowsRootHandles(true);
		fileTree.setFont(new Font("新細明體", Font.PLAIN, 15));
		treePanel.setViewportView(fileTree);
		DefaultMutableTreeNode treeRoot = FileManager1.listAll(FileManager1.rootName, FileManager1.rootPath);
		DefaultTreeModel treeModel = new DefaultTreeModel(treeRoot);
		fileTree.setModel(treeModel);
		fileTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)fileTree.getModel().getRoot();
		TreePath path = new TreePath(root.getPath());
		fileTree.setSelectionPath(path);
		
		dict.put(tableButton, "table.png");
		dict.put(chairButton, "chair.png");
		dict.put(doorButton, "door.png");
		dict.put(wallButton, "wall.png");
		dict.put(counterButton, "counter.png");
		dict.put(decoratorButton, "decorator.png");
		DDE = new DragDropEvent(propertyPanel);
		PME = new PopMenuEvent(propertyPanel, graphicPanel);
		graphicPanel.addComponentListener(new PanelResizeEvent((NewCardLayout) propertyPanel.getLayout(), fileTree));
		graphicPanel.addContainerListener(new PanelResizeEvent((NewCardLayout) propertyPanel.getLayout(), fileTree));
		graphicPanel.addMouseListener(PME);
		
		FBE = new FunctionBarEvent1(fileTree, graphicPanel, propertyPanel);
		addItem.addActionListener(FBE);
		deleteItem.addActionListener(FBE);
		storeItem.addActionListener(FBE);
		undoItem.addActionListener(FBE);
		redoItem.addActionListener(FBE);
		deleteAllItem.addActionListener(FBE);
		
	}
	private void generate(ActionEvent e) {
		this.undoEventBox.add(FunctionBarEvent1.handleContent(this.graphicPanel));
		String path = imageDir + FileManager1.sep + dict.get((JButton)e.getSource());
		MapUnit unit = new MapUnit("", path);
		unit.addMouseMotionListener(DDE);
		unit.addMouseListener(DDE);
		unit.addMouseListener(PME);
		graphicPanel.add(unit);
		unit.ImageResize(labelSizeRatio, labelSizeRatio);
		Dimension parentSize = graphicPanel.getSize();
		int posx = (int)Math.round(parentSize.width * unit.posx);
		int posy = (int)Math.round(parentSize.height * unit.posy);
		int width = (int)Math.round(parentSize.width * labelSizeRatio);
		int height = (int)Math.round(parentSize.height * labelSizeRatio);
		unit.setBounds( posx, posy, width, height );
		graphicPanel.revalidate();
	}
}
