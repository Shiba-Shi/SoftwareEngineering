package SoftwareEngineering;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.json.JSONObject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class t14 extends JFrame{
    private JButton t1, t2, t3, t4, t5, t6, t7, t8, sel;
    boolean[] storage = new boolean[8];
    JSONObject json = new JSONObject();

    public t14() {
        this.setTitle("食材狀況");
        this.setLayout(null);
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t1 = new JButton("牛肉");
        t1.setBounds(100, 50, 100, 50);
        t1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                storage[0] = !storage[0];
                if (storage[0]) {
                    t1.setForeground(Color.RED);
                    json.put("牛肉", "缺貨");
                }else {
                    t1.setForeground(Color.BLACK);
                    json.remove("牛肉");
                }
            } 
        });
        add(t1);
        
        t2 = new JButton("豬肉");
        t2.setBounds(100, 115, 100, 50);
        t2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                storage[1] = !storage[1];
                if (storage[1]) {
                    t2.setForeground(Color.RED);
                    json.put("豬肉", "缺貨");
                }else {
                    t2.setForeground(Color.BLACK);
                    json.remove("豬肉");
                }
            }
        });
        add(t2);

        t3 = new JButton("雞肉");
        t3.setBounds(100, 180, 100, 50);
        t3.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                storage[2] = !storage[2];
                if (storage[0]) {
                    t3.setForeground(Color.RED);
                    json.put("雞肉", "缺貨");
                }else {
                    t3.setForeground(Color.BLACK);
                    json.remove("雞肉");
                }
            } 
        });
        add(t3);

        t4 = new JButton("米");
        t4.setBounds(100, 245, 100, 50);
        t4.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                storage[3] = !storage[3];
                if (storage[3]) {
                    t4.setForeground(Color.RED);
                    json.put("米", "缺貨");
                }else {
                    t4.setForeground(Color.BLACK);
                    json.remove("米");
                }
            } 
        });
        add(t4);

        t5 = new JButton("沙拉油");
        t5.setBounds(100, 310, 100, 50);
        t5.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                storage[4] = !storage[4];
                if (storage[4]) {
                    t5.setForeground(Color.RED);
                    json.put("沙拉油", "缺貨");
                }else {
                    t5.setForeground(Color.BLACK);
                    json.remove("沙拉油");
                }
            } 
        });
        add(t5);

        t6 = new JButton("鹽");
        t6.setBounds(100, 375, 100, 50);
        t6.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                storage[5] = !storage[5];
                if (storage[5]) {
                    t6.setForeground(Color.RED);
                    json.put("鹽", "缺貨");
                }else {
                    t6.setForeground(Color.BLACK);
                    json.remove("鹽");
                }
            } 
        });
        add(t6);

        t7 = new JButton("雞蛋");
        t7.setBounds(100, 440, 100, 50);
        t7.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                storage[6] = !storage[6];
                if (storage[6]) {
                    t7.setForeground(Color.RED);
                    json.put("雞蛋", "缺貨");
                }else {
                    t7.setForeground(Color.BLACK);
                    json.remove("雞蛋");
                }
            } 
        });
        add(t7);

        t8 = new JButton("蔥");
        t8.setBounds(100, 505, 100, 50);
        t8.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                storage[7] = !storage[7];
                if (storage[7]) {
                    t8.setForeground(Color.RED);
                    json.put("蔥", "缺貨");
                }else {
                    t8.setForeground(Color.BLACK);
                    json.remove("蔥");
                }
            } 
        });
        add(t8);

        sel = new JButton("缺貨");
        sel.setBounds(700, 500, 100, 50);
        sel.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                String path = "storage";
                new CreateFileUtil(path, json.toString());
            } 
        });
        add(sel);
    }
    public static void main(String[] args) {
        t14 frame = new t14();
        frame.setVisible(true);
    }
}
