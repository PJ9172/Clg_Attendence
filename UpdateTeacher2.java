import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class UpdateTeacher2 extends JFrame implements ActionListener {
    JButton update;
    JPanel p;
    JLabel l1, l2, l3;
    JTextField t1, t2;
    Color buColor = new Color(0, 122, 122);
    Color bgColor = new Color(0, 102, 102);
    String username,tid,pass;
    public UpdateTeacher2(String username) {
        this.username=username;
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(340, 120, 620, 500);
        add(p);

        l1 = new JLabel("Update Teacher Details . . .");
        l1.setBounds(150, 50, 300, 20);
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        p.add(l1);

        l2 = new JLabel("Username : ");
        l2.setBounds(120, 180, 100, 20);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l2);

        t1 = new JTextField();
        t1.setBounds(280, 175, 200, 25);
        p.add(t1);

        l3 = new JLabel("Password : ");
        l3.setBounds(120, 280, 100, 20);
        l3.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l3);

        t2 = new JTextField();
        t2.setBounds(280, 275, 200, 25);
        p.add(t2);

        update = new JButton("Update");
        update.setBounds(240, 380, 130, 30);
        update.setBackground(buColor);
        update.setForeground(Color.white);
        p.add(update);
        update.addActionListener(this);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clg", "root", "1234");
            Statement st = con.createStatement();
            String q = "select * from teacher where tid="+"'"+username+"'";
            ResultSet rs = st.executeQuery(q);
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            // JOptionPane.showMessageDialog(null,"   No Record Found ! ! !");
            // new UpdateTeacher();
            // this.setVisible(false);
        }

        setTitle("  Attendence System");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setSize(700,600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(bgColor);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            tid=t1.getText();
            pass=t1.getText();
            if(tid.length()!=0&&pass.length()!=0)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clg", "root", "1234");
                    String q="update teacher set tid='"+tid+"'"+" where tid='"+username+"'";
                    Statement st=con.createStatement();
                    st.execute(q);
                    System.out.println("Record inserted!!!");
                    JOptionPane.showMessageDialog(null,"   Update Teacher Sucessfull ! ! !");
                    new Tcurd();
                    this.setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"   Erro with Database ! ! !");

                }
            }
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher2("teacher1");
    }
}