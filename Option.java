import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Option extends JFrame implements ActionListener
{
    JButton addnew,presenty,back;
    JPanel p;
    String tid;
    Color buColor= new Color(0,122,122);
    Color bgColor= new Color(0,102,102);
    public Option(String tid)
    {
        this.tid=tid;
        p=new JPanel();
        p.setLayout(null);
        p.setBounds(340,120,620,500);
        add(p);

        addnew=new JButton("ADD NEW");
        addnew.setBounds(240, 120,130,30);
        addnew.setBackground(buColor);
        addnew.setForeground(Color.white);
        p.add(addnew);

        presenty=new JButton("PRESENTY");
        presenty.setBounds(240, 240,130,30);
        presenty.setBackground(buColor);
        presenty.setForeground(Color.white);
        p.add(presenty);

        back=new JButton("BACK");
        back.setBounds(240, 360,130,30);
        back.setBackground(buColor);
        back.setForeground(Color.white);
        p.add(back);

        addnew.addActionListener(this);
        presenty.addActionListener(this);
        back.addActionListener(this);

        setTitle("  Attendence System");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setSize(700,600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,screenSize.width, screenSize.height);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(bgColor);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==presenty)
        {
            new Stream(tid);
            this.setVisible(false);
        }
        if(e.getSource()==addnew)
        {
            new Addnew(tid);
            this.setVisible(false);
        }
        if(e.getSource()==back)
        {
            new Home();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Option("admin");
    }
}