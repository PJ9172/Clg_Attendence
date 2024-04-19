import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Home extends JFrame implements ActionListener
{
    JButton tbutton,pbutton,aButton;
    JPanel p;
    Color buColor= new Color(0,122,122);
    Color bgColor= new Color(0,102,102);
    public Home()
    {
        p=new JPanel();
        p.setLayout(null);
        p.setBounds(340,120,620,500);
        add(p);

        aButton=new JButton("Admin");
        aButton.setBounds(240, 100,130,30);
        aButton.setBackground(buColor);
        aButton.setForeground(Color.white);
        p.add(aButton);

        tbutton=new JButton("Teacher");
        tbutton.setBounds(240, 220,130,30);
        tbutton.setBackground(buColor);
        tbutton.setForeground(Color.white);
        p.add(tbutton);

        pbutton=new JButton("Parent");
        pbutton.setBounds(240, 340,130,30);
        pbutton.setBackground(buColor);
        pbutton.setForeground(Color.white);
        p.add(pbutton);

        
        aButton.addActionListener(this);
        tbutton.addActionListener(this);
        pbutton.addActionListener(this);

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
        if(e.getSource()==aButton)
        {
            new AdminLogin();
            this.setVisible(false);
        }
        if(e.getSource()==tbutton)
        {
            new TeacherLogin();
            this.setVisible(false);
        }
        if(e.getSource()==pbutton)
        {
            new Parent();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Home();
    }
}