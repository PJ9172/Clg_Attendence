import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Parent extends JFrame implements ActionListener {
    JPanel p;
    JButton next, clear, bk;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    JComboBox cb1,cb2;
    Color buColor= new Color(0,122,122);
    Color bgColor= new Color(0,102,102);
    String table;
    public Parent() {
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(340,120,620,500);
        add(p);

        l1 = new JLabel("Enter Student Name : ");
        l1.setBounds(100, 60, 200, 20);
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l1);

        t1 = new JTextField();
        t1.setBounds(320, 60, 200, 25);
        p.add(t1);

        l2 = new JLabel("Enter Student Roll No. : ");
        l2.setBounds(100, 120, 200, 20);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l2);

        t2 = new JTextField();
        t2.setBounds(320, 120, 200, 25);
        p.add(t2);

        l3 = new JLabel("Choose Stream : ");
        l3.setBounds(100, 180, 200, 20);
        l3.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l3);

        String stream[] = { "BBA", "BCA", "BCOM", "BSC", "CDS" };
        cb1 = new JComboBox<>(stream);
        cb1.setBounds(320, 180, 200, 25);
        p.add(cb1);

        l4 = new JLabel("Choose Year : ");
        l4.setBounds(100, 240, 200, 20);
        l4.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l4);

        String year[]={"First_Year","Second_Year","Third_Year"};
        cb2=new JComboBox<>(year);
        cb2.setBounds(320, 240, 200, 25);
        p.add(cb2);

        bk=new JButton("BACK");
        bk.setBounds(50, 360, 100, 30);
        bk.setBackground(buColor);
        bk.setForeground(Color.white);
        p.add(bk);

        clear=new JButton("CLEAR");
        clear.setBounds(260, 360, 100, 30);
        clear.setBackground(buColor);
        clear.setForeground(Color.white);
        p.add(clear);

        next=new JButton("NEXT");
        next.setBounds(470, 360, 100, 30);
        next.setBackground(buColor);
        next.setForeground(Color.white);
        p.add(next);


        next.addActionListener(this);
        clear.addActionListener(this);
        bk.addActionListener(this);

        setTitle("  Attendence System");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setSize(700, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,screenSize.width, screenSize.height);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(bgColor);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
        try{
                String sname=t1.getText();
                String rno=t2.getText();
                String stream = (String) cb1.getSelectedItem();
                String year=(String) cb2.getSelectedItem();
                stream = stream.toLowerCase();
                year = year.toLowerCase();
                System.out.println(sname);
                System.out.println(rno);
                System.out.println(stream);
                System.out.println(year);
                if(year=="first_year")
                    table="fy_presenty";
                else if(year=="second_year")
                    table="sy_presenty";
                else
                    table="ty_presenty";
                
                if(sname.length()!=0&&rno.length()!=0){
                    new ViewPresenty(sname,rno,stream,table);                
                    this.setVisible(false);   
                }
                else
                    JOptionPane.showMessageDialog(p,"   Error To Fetch Data ! ! !");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(p,"   Error To Fetch Data ! ! !");
                ex.printStackTrace();
            }
        }
        if(e.getSource()==clear){
            t1.setText("");
            t2.setText("");
            cb1.setSelectedItem("BBA");
            cb2.setSelectedItem("First Year");
        }
        if(e.getSource()==bk){
            this.setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new Parent();
    }
}