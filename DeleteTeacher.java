import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class DeleteTeacher extends JFrame implements ActionListener {
    JButton delete, back, clear;
    JPanel p;
    JLabel l1;
    JTextField t1;
    Color buColor = new Color(0, 122, 122);
    Color bgColor = new Color(0, 102, 102);

    public DeleteTeacher() {
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(340, 120, 620, 500);
        add(p);

        l1 = new JLabel("Enter Username To Delete Teacher : ");
        l1.setBounds(60, 160, 300, 20);
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        p.add(l1);

        t1 = new JTextField();
        t1.setBounds(350, 155, 200, 25);
        p.add(t1);

        back = new JButton("Back");
        back.setBounds(60, 280, 100, 30);
        back.setBackground(buColor);
        back.setForeground(Color.white);
        p.add(back);

        clear = new JButton("Clear");
        clear.setBounds(260, 280, 100, 30);
        clear.setBackground(buColor);
        clear.setForeground(Color.white);
        p.add(clear);

        delete = new JButton("Delete");
        delete.setBounds(450, 280, 100, 30);
        delete.setBackground(buColor);
        delete.setForeground(Color.white);
        p.add(delete);

        back.addActionListener(this);
        clear.addActionListener(this);
        delete.addActionListener(this);

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
        if (e.getSource() == back) {
            new Tcurd();
            this.setVisible(false);
        }
        if (e.getSource() == clear)
            t1.setText("");

        if (e.getSource() == delete) {
            String username = t1.getText();
            if (username.length() != 0) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clg", "root", "1234");
                    Statement st = con.createStatement();
                    String q = "select * from teacher where tid=" + "'" + username + "'";
                    ResultSet rs = st.executeQuery(q);
                    rs.next();
                    if (username.equals(rs.getString(1))) {
                        q = "delete from teacher where tid=" + "'" + username + "'";
                        st.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "   Teacher Deleted ! ! !");
                        t1.setText("");
                    }
                     else {
                         JOptionPane.showMessageDialog(null, "   No Data Found ! ! !");
                         t1.setText("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "   No Data Found ! ! !");

                }
            } else
                JOptionPane.showMessageDialog(null, "   Invalid Credentials ! ! !");
        }
    }

    public static void main(String[] args) {
        new DeleteTeacher();
    }
}