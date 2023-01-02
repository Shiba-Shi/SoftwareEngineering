package SoftwareEngineering;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import org.json.JSONObject;


public class staff extends JFrame{
    private JButton t1, t2, t3, t4, t5, t6, t7, t8, dayoff, leaving;
    boolean[] selected = new boolean[8];
    JSONObject cleared = new JSONObject();
    JSONObject leave = new JSONObject();

    public staff(){
        this.setTitle("員工出缺勤");
        this.setLayout(null);
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t1 = new JButton("001");
        t1.setBounds(100, 100, 100, 100);
        t1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[0] = !selected[0];
                if (selected[0]) {
                    t1.setForeground(Color.RED);
                    cleared.put("員工編號001", "請假");
                    leave.put("員工編號001", "早退");
                }else {
                    t1.setForeground(Color.BLACK);
                    cleared.remove("員工編號001");
                    leave.remove("員工編號001");
                }
            } 
        }); 
        add(t1);

        t2 = new JButton("002");
        t2.setBounds(300, 100, 100, 100);
        t2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[1] = !selected[1];
                if (selected[1]) {
                    t2.setForeground(Color.RED);
                    cleared.put("員工編號002", "請假");
                    leave.put("員工編號002", "早退");
                }else {
                    t2.setForeground(Color.BLACK);
                    cleared.remove("員工編號002");
                    leave.remove("員工編號002");
                }
            } 
        }); 
        add(t2);

        t3 = new JButton("003");
        t3.setBounds(500, 100, 100, 100);
        t3.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[2] = !selected[2];
                if (selected[2]) {
                    t3.setForeground(Color.RED);
                    cleared.put("員工編號003", "請假");
                    leave.put("員工編號003", "早退");
                }else {
                    t3.setForeground(Color.BLACK);
                    cleared.remove("員工編號003");
                    leave.remove("員工編號003");
                }
            } 
        }); 
        add(t3);

        t4 = new JButton("004");
        t4.setBounds(700, 100, 100, 100);
        t4.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[3] = !selected[3];
                if (selected[3]) {
                    t4.setForeground(Color.RED);
                    cleared.put("員工編號004", "請假");
                    leave.put("員工編號004", "早退");
                }else {
                    t4.setForeground(Color.BLACK);
                    cleared.remove("員工編號004");
                    leave.remove("員工編號004");
                }
            } 
        }); 
        add(t4);

        t5 = new JButton("005");
        t5.setBounds(100, 300, 100, 100);
        t5.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[4] = !selected[4];
                if (selected[4]) {
                    t5.setForeground(Color.RED);
                    cleared.put("員工編號005", "請假");
                    leave.put("員工編號005", "早退");
                }else {
                    t5.setForeground(Color.BLACK);
                    cleared.remove("員工編號005");
                    leave.remove("員工編號005");
                }
            } 
        }); 
        add(t5);

        t6 = new JButton("006");
        t6.setBounds(300, 300, 100, 100);
        t6.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[5] = !selected[5];
                if (selected[5]) {
                    t6.setForeground(Color.RED);
                    cleared.put("員工編號006", "請假");
                    leave.put("員工編號006", "早退");
                }else {
                    t6.setForeground(Color.BLACK);
                    cleared.remove("員工編號006");
                    leave.remove("員工編號006");
                }
            } 
        }); 
        add(t6);

        t7 = new JButton("007");
        t7.setBounds(500, 300, 100, 100);
        t7.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[6] = !selected[6];
                if (selected[6]) {
                    t7.setForeground(Color.RED);
                    cleared.put("員工編號007", "請假");
                    leave.put("員工編號007", "早退");
                }else {
                    t7.setForeground(Color.BLACK);
                    cleared.remove("員工編號007");
                    leave.remove("員工編號007");
                }
            } 
        }); 
        add(t7);

        t8 = new JButton("008");
        t8.setBounds(700, 300, 100, 100);
        t8.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                selected[7] = !selected[7];
                if (selected[7]) {
                    t8.setForeground(Color.RED);
                    cleared.put("員工編號008", "請假");
                    leave.put("員工編號008", "早退");
                }else {
                    t8.setForeground(Color.BLACK);
                    cleared.remove("員工編號008");
                    leave.remove("員工編號008");
                }
            } 
        }); 
        add(t8);

        dayoff = new JButton("請假");
        dayoff.setBounds(700, 500, 75, 50);
        dayoff.setFont(new Font("Dialog", Font.PLAIN, 9));
        dayoff.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                String path = "StaffDayOff";
                new CreateFileUtil(path, cleared.toString());
            } 
        }); 
        add(dayoff);

        leaving = new JButton("早退");
        leaving.setBounds(800, 500, 75, 50);
        leaving.setFont(new Font("Dialog", Font.PLAIN, 9));
        leaving.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                String path = "leaving";
                new CreateFileUtil(path, leave.toString());
            } 
        });
        add(leaving);
    }
    public static void main(String[] args) {
        staff frame = new staff();
        frame.setVisible(true);
    }
}
