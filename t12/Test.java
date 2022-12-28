package t12;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;

import t16.CheckTableState;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Test {
    public static void main(String[] args) {
  	  JFrame frame = new JFrame();
  	  NotifyDishDone panel = new NotifyDishDone();
  	  frame.add(panel);
  	  frame.setVisible(true);
  	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	  frame.pack();
    }
}


