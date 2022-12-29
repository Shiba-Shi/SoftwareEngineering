package t16;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

public class Test {


  public static void main(String[] args) {
	  
//	  try {
//			UIManager.setLookAndFeel(new FlatIntelliJLaf());
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//	  }
	  JFrame frame = new JFrame();
	  CheckTableState panel = new CheckTableState();
	  frame.add(panel);
	  frame.setVisible(true);
	  frame.setPreferredSize(new Dimension(600, 600));
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.pack();
  }
}


