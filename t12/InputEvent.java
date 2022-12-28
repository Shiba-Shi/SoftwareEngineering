package t12;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

import t3.MapUnit;

public class InputEvent implements FocusListener, ActionListener {
	private ArrayList<MapUnit> tables = new ArrayList<MapUnit>();
	private JPanel mapPanel;
	private String[] employees;
	private DefaultListModel model;
	private JList list;
	private JTextField entry;
	public InputEvent(JPanel mapPanel) {
		this.mapPanel = mapPanel;
	}
	
	public InputEvent(JList list) {
		this.list = list;
		model = (DefaultListModel) list.getModel();
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		this.entry = (JTextField)e.getSource();
		if(mapPanel != null) {
			this.getTables();
		}
		else {
			this.getAllList();
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
	private void getAllList() {
		this.employees = new String[model.size()];
		for(int i = 0; i < this.employees.length; i ++) {
			this.employees[i] = (String) model.get(i);
		}
	}
	
	private void getTables() {
		for(Component component: mapPanel.getComponents()) {
			MapUnit unit = (MapUnit)component;
			if(unit.imagePath.equals(MapUnit.table)) {
				tables.add(unit);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(mapPanel != null) {
			showSelectedSearch();
		}
		else {
			showListSearch();
		}
	}
	
	private void showSelectedSearch() {
		if(this.tables != null) {

			for(MapUnit unit: this.tables) {
				if(entry.getText().contains(unit.name) || unit.name.contains(entry.getText())) {
					unit.setBackground(Color.RED);
					unit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				}
			}			
		}
	}
	
	private void showListSearch() {
		if(!model.isEmpty()) {
			ArrayList<Integer> indice = new ArrayList<Integer>();
			for(int i = 0; i < this.employees.length; i ++) {
				if(entry.getText().contains(this.employees[i]) || this.employees[i].contains(entry.getText())) {
					indice.add(i);
				}
			}
			int[] indices = new int[indice.size()];
			for(int j = 0; j < indice.size(); j ++) {
				indices[j] = indice.get(j);
			}
			this.list.setSelectedIndices(indices);
		}
	}
}
