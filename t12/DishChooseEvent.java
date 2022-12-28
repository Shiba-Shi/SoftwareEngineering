package t12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class DishChooseEvent implements ActionListener {
	
	private DefaultListModel<String> model;
	private HashMap<String, ArrayList<String>> dishDict;
	public DishChooseEvent(JList list, HashMap<String, ArrayList<String>> dishDict) {
		model = (DefaultListModel<String>) list.getModel();
		this.dishDict = dishDict;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.clear();
		switch(e.getActionCommand()) {
			case "主餐":
				this.putInList("主餐");
				break;
			case "開胃菜":
				this.putInList("開胃菜");
				break;
			case "湯品":
				this.putInList("湯品");
				break;
			case "甜點":
				this.putInList("甜點");
				break;
		}

	}
	
	private void putInList(String key) {
		ArrayList<String> items = this.dishDict.get(key);
		for(String item: items) {
			model.addElement(item);
		}
	}

}
