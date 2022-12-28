package t3;

import java.util.ArrayList;

import javax.swing.JMenuItem;

public class NewArrayList<E> extends ArrayList<E> {
	private JMenuItem item;
	public NewArrayList(JMenuItem item) {
		super();
		this.item = item;
	}
	
	@Override
	public boolean add(E element) {
		item.setEnabled(true);
		return super.add(element);
	}
	
	public void setItemEnabled(boolean enable) {
		item.setEnabled(enable);
	}
}
