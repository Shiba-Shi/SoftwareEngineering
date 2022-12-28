package t3;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.HashMap;

public class NewCardLayout extends CardLayout {
	private static HashMap<Object, Component> cardDict = new HashMap<Object, Component>();
	public NewCardLayout() {
		
	}

	public NewCardLayout(int hgap, int vgap) {
		super(hgap, vgap);
		
	}
	
	public boolean cardExist(Object key) {
		return cardDict.containsKey(key);
	}
	
	@Override
	public void addLayoutComponent(Component comp, Object constraints) {
		super.addLayoutComponent(comp, constraints);
		cardDict.put(constraints, comp);
	}
	
	public Component getValue(Object key) {
		return cardDict.get(key);
	}
	
	public void reset() {
		NewCardLayout.cardDict.clear();
	}
}
