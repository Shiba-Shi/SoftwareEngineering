package t3;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.formdev.flatlaf.FlatIntelliJLaf;
public class Test {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JFrame win = new JFrame();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RestaurantLayout1 panel = new RestaurantLayout1();
		panel.setPreferredSize(new Dimension(600, 600));
		win.getContentPane().add(panel);
		win.pack();
		win.setLocationRelativeTo(null);
		win.setVisible(true);
		
		
	}

}
