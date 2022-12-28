package t12;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListEvent implements ListSelectionListener {
	private JLabel entry;
	public ListEvent(JLabel entry) {
		this.entry = entry;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		this.entry.setText((String)list.getSelectedValue());

	}

}
