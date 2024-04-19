import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class TeacherLogin extends JFrame implements ActionListener{
    JPanel p;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton next,clear,back;
    Color buColor= new Color(0,122,122);
    Color bgColor= new Color(0,102,102);
    public TeacherLogin()
    {
        p=new JPanel();
        p.setLayout(null);
        p.setBounds(340,120,620,500);
        add(p);

        l1 = new JLabel("Enter Username : ");
        l1.setBounds(100, 120, 200, 20);
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l1);

        t1 = new JTextField();
        t1.setBounds(300, 120, 240, 25);
        p.add(t1);

        l2 = new JLabel("Enter Password : ");
        l2.setBounds(100, 220, 200, 20);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l2);

        t2 = new JTextField();
        t2.setBounds(300, 220, 240, 25);
        p.add(t2);

        back = new JButton("BACK");
        back.setBounds(50, 360, 100, 30);
        back.setBackground(buColor);
        back.setForeground(Color.white);
        p.add(back);

        clear = new JButton("CLEAR");
        clear.setBounds(260, 360, 100, 30);
        clear.setBackground(buColor);
        clear.setForeground(Color.white);
        p.add(clear);

        next = new JButton("NEXT");
        next.setBounds(470, 360, 100, 30);
        next.setBackground(buColor);
        next.setForeground(Color.white);
        p.add(next);

        back.addActionListener(this);
        clear.addActionListener(this);
        next.addActionListener(this);

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
        if(e.getSource()==back)
        {
            new Home();
            this.setVisible(false);
        }
        if(e.getSource()==clear)
        {
            t1.setText("");
            t2.setText(""); 
        }
        if(e.getSource()==next)
        {
            String username = t1.getText();
            String password = t2.getText();
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/clg","root","1234");
                Statement st=con.createStatement();
                String q="select count(*) from teacher";
                ResultSet rs= st.executeQuery(q);
                rs.next();
                int count=rs.getInt(1);
                String tid[],pass[];
                int i,t=0;
                tid=new String[count];
                pass=new String[count];
                q="select * from teacher";
                rs=st.executeQuery(q);
                for(i=0;i<count;i++)
                {
                    rs.next();
                    tid[i]=rs.getString(1);
                    pass[i]=rs.getString(2);
                }
                for(i=0;i<count;i++)
                {
                    if(username.equals(tid[i]) && password.equals(pass[i]))
                    {
                        t=1;
                    }
                }
                if(t==1)
                {
                    this.setVisible(false);
                    new Option(username);
                }
                else
                    JOptionPane.showMessageDialog(null,"   Invalid Credentials ! ! !");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"   Invalid Credentials ! ! !");
                ex.printStackTrace();
            }
            
        }
    }  
    public static void main(String[] args) {
        new TeacherLogin();
    } 
}
