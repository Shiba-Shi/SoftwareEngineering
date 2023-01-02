package SoftwareEngineering;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class t11 extends JFrame {
    private JLabel total, t1, t2, amounts, table, date, title;

    public t11 (){
        this.setTitle("帳單");
        this.setLayout(null);
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table = new JLabel("桌號: 一");
        table.setBounds(75, 25, 100, 100);
        add(table);

        date = new JLabel("日期: 2023/1/1");
        date.setBounds(75, 75, 100, 100);
        add(date);

        amounts = new JLabel("人數: 2");
        amounts.setBounds(75, 125, 100, 100);
        add(amounts);
        
        title = new JLabel("品項         數量        小計");
        title.setBounds(75, 180, 300, 100);
        add(title);

        t1 = new JLabel(".....    ");
        t1.setBounds(75, 200, 100, 100);
        add(t1);

        t2 = new JLabel("....l");
        t2.setBounds(75, 225, 100, 100);
        add(t2);

        total = new JLabel("合計: 1000");
        total.setBounds(75, 275, 100, 100);
        add(total);
    }
}
