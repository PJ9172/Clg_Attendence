import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Years extends JFrame implements ActionListener
{
    JPanel p;
    JButton fy,sy,ty,bk;
    Color buColor= new Color(0,122,122);
    Color bgColor= new Color(0,102,102);
    String tid,stream;
    public Years(String tid,String stream)
    {
        this.tid=tid;
        this.stream=stream;
        p=new JPanel();
        p.setLayout(null);
        p.setBounds(340,120,620,500);
        add(p);

        fy=new JButton("First Year");
        fy.setBounds(240, 100,130,30);
        fy.setBackground(buColor);
        fy.setForeground(Color.white);
        p.add(fy);

        sy=new JButton("Second Year");
        sy.setBounds(240, 180,130,30);
        sy.setBackground(buColor);
        sy.setForeground(Color.white);
        p.add(sy);

        ty=new JButton("Third Year");
        ty.setBounds(240, 260,130,30);
        ty.setBackground(buColor);
        ty.setForeground(Color.white);
        p.add(ty);

        bk=new JButton("Back");
        bk.setBounds(255, 360,100,30);
        bk.setBackground(buColor);
        bk.setForeground(Color.white);
        p.add(bk);

        fy.addActionListener(this);
        sy.addActionListener(this);
        ty.addActionListener(this);
        bk.addActionListener(this);
        
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
        if(e.getSource()==fy)
        {
            new Presenty(tid,stream,"first_year","fy_presenty","fy_sub");
            this.setVisible(false);
        }
        if(e.getSource()==sy)
        {
            new Presenty(tid,stream,"second_year","sy_presenty","sy_sub");
            this.setVisible(false);
        }
        if(e.getSource()==ty)
        {
            new Presenty(tid,stream,"third_year","ty_presenty","ty_sub");
            this.setVisible(false);
        }
        if(e.getSource()==bk)
        {
            new Stream(tid);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        
    }
}
