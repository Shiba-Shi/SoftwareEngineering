package SoftwareEngineering;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import org.json.JSONObject;


public class table extends JFrame{
    private JButton t1, t2, t3, t4, t5, t6, t7, t8, clear, prepared;
    boolean[] selected = new boolean[8];
    JSONObject json = new JSONObject();
    JSONObject cleared = new JSONObject();

    public table(){
        this.setTitle("桌面狀況");
        this.setLayout(null);
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t1 = new JButton("一桌");
        t1.setBounds(100, 100, 100, 100);
        t1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[0] = !selected[0];
                if (selected[0]) {
                    t1.setForeground(Color.RED);
                    json.put("第1"+"桌", "需要清潔");
                    cleared.put("第1" + "桌", "準備完成");

                }else {
                    t1.setForeground(Color.BLACK);
                    json.remove("第1"+"桌");
                    cleared.remove("第1"+"桌");
                }
            } 
        }); 
        add(t1);

        t2 = new JButton("二桌");
        t2.setBounds(300, 100, 100, 100);
        t2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[1] = !selected[1];
                if (selected[1]) {
                    t2.setForeground(Color.RED);
                    json.put("第2"+"桌", "需要清潔");
                    cleared.put("第2" + "桌", "準備完成");
                }else {
                    t2.setForeground(Color.BLACK);
                    json.remove("第2"+"桌");
                    cleared.remove("第2"+"桌");
                }
            } 
        }); 
        add(t2);

        t3 = new JButton("三桌");
        t3.setBounds(500, 100, 100, 100);
        t3.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[2] = !selected[2];
                if (selected[2]) {
                    t3.setForeground(Color.RED);
                    json.put("第3"+"桌", "需要清潔");
                    cleared.put("第3" + "桌", "準備完成");
                }else {
                    t3.setForeground(Color.BLACK);
                    json.remove("第3"+"桌");
                    cleared.remove("第3"+"桌");
                }
            } 
        }); 
        add(t3);

        t4 = new JButton("四桌");
        t4.setBounds(700, 100, 100, 100);
        t4.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[3] = !selected[3];
                if (selected[3]) {
                    t4.setForeground(Color.RED);
                    json.put("第4"+"桌", "需要清潔");
                    cleared.put("第4" + "桌", "準備完成");
                }else {
                    t4.setForeground(Color.BLACK);
                    json.remove("第4"+"桌");
                    cleared.remove("第4"+"桌");
                }
            } 
        }); 
        add(t4);

        t5 = new JButton("五桌");
        t5.setBounds(100, 300, 100, 100);
        t5.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[4] = !selected[4];
                if (selected[4]) {
                    t5.setForeground(Color.RED);
                    json.put("第5"+"桌", "需要清潔");
                    cleared.put("第5" + "桌", "準備完成");
                }else {
                    t5.setForeground(Color.BLACK);
                    json.remove("第5"+"桌");
                    cleared.remove("第5"+"桌");
                }
            } 
        }); 
        add(t5);

        t6 = new JButton("六桌");
        t6.setBounds(300, 300, 100, 100);
        t6.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[5] = !selected[5];
                if (selected[5]) {
                    t6.setForeground(Color.RED);
                    json.put("第6"+"桌", "需要清潔");
                    cleared.put("第6" + "桌", "準備完成");
                }else {
                    t6.setForeground(Color.BLACK);
                    json.remove("第6"+"桌");
                    cleared.remove("第6"+"桌");
                }
            } 
        }); 
        add(t6);

        t7 = new JButton("七桌");
        t7.setBounds(500, 300, 100, 100);
        t7.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[6] = !selected[6];
                if (selected[6]) {
                    t7.setForeground(Color.RED);
                    json.put("第7"+"桌", "需要清潔");
                    cleared.put("第7" + "桌", "準備完成");
                }else {
                    t7.setForeground(Color.BLACK);
                    json.remove("第7"+"桌");
                    cleared.remove("第7"+"桌");
                }
            } 
        }); 
        add(t7);

        t8 = new JButton("八桌");
        t8.setBounds(700, 300, 100, 100);
        t8.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[7] = !selected[7];
                if (selected[7]) {
                    t8.setForeground(Color.RED);
                    json.put("第8"+"桌", "需要清潔");
                    cleared.put("第8" + "桌", "準備完成");
                }else {
                    t8.setForeground(Color.BLACK);
                    json.remove("第8"+"桌");
                    cleared.remove("第8"+"桌");
                }
            } 
        }); 
        add(t8);

        clear = new JButton("需要清潔");
        clear.setBounds(700, 500, 75, 50);
        clear.setFont(new Font("Dialog", Font.PLAIN, 9));
        clear.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                String path = "NeedClear";
                new CreateFileUtil(path, json.toString());
            }   
        }); 
        add(clear);

        prepared = new JButton("準備完成");
        prepared.setBounds(800, 500, 75, 50);
        prepared.setFont(new Font("Dialog", Font.PLAIN, 9));
        prepared.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                String path = "cleared";
                new CreateFileUtil(path, cleared.toString());
            } 
        });
        add(prepared);
    }
    public static void main(String[] args) {
        table frame = new table();
        frame.setVisible(true);
    }
}
