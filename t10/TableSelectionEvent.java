package t10;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class TableSelectionEvent implements MouseListener {

	private JTextArea mainDishText;
	private JTextArea sideDishText;
	private JTextArea soupText;
	private JTextArea dessertText;
	private HashMap<String[], HashMap<String, String[]>> example;
	private static final String[] types = {"主餐", "開胃菜", "湯品", "甜點"};
	public TableSelectionEvent(HashMap<String[], HashMap<String, String[]>> example, 
			JTextArea mainDishText, JTextArea sideDishText,
			JTextArea soupText, JTextArea dessertText) {
		this.example = example;
		this.mainDishText = mainDishText;
		this.sideDishText = sideDishText;
		this.soupText = soupText;
		this.dessertText = dessertText;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			String[] infos = new String[4];
			JTable table = (JTable)e.getSource();
			int rowID = table.getSelectedRow();
			for(int i = 0; i < 4; i ++) {
				infos[i] = (String) table.getValueAt(rowID, i);
			}
			clear();
			putInTextArea(infos);
		}
	}
	
	private void putInTextArea(String[] infos) {
		for(String[] key: this.example.keySet()) {
			boolean isFound = true;
			for(int i = 0; i < key.length; i ++) {
				if(!key[i].equals(infos[i])) {
					isFound = false;
				}
			}
			if(isFound) {
				HashMap<String, String[]> map = this.example.get(key);
				String[] info = map.get(this.types[0]);
				this.write(info, mainDishText);
				String[] info1 = map.get(this.types[1]);
				this.write(info1, sideDishText);
				String[] info2 = map.get(this.types[2]);
				this.write(info2, soupText);
				String[] info3 = map.get(this.types[3]);
				this.write(info2, dessertText);
				break;
			}
		}
	}
	
	private void write(String[] info, JTextArea text) {
		for(int i = 0; i < info.length; i ++) {
			text.append(info[i] + "\n");
		}
	}
	
	private void clear() {
		this.mainDishText.setText("");
		this.sideDishText.setText("");
		this.soupText.setText("");
		this.dessertText.setText("");
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
