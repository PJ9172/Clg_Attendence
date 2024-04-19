import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Presenty extends JFrame implements ActionListener {
    JPanel p;
    JScrollPane scroll;
    JComboBox cb1;
    JTextField t1;
    JLabel l1, l2;
    JLabel rno[], name[];
    JCheckBox check[];
    JButton submit[],ok;
    Color buColor = new Color(0, 122, 122);
    Color bgColor = new Color(0, 102, 102);
    int i, count;
    String tid, stream, year,table,date,sub,subject[],q;
    ResultSet rs;

    public Presenty(String tid, String stream, String year,String table, String sub) {
        this.tid = tid;
        this.stream = stream;
        this.year = year;
        this.table=table;
        this.sub=sub;
        p = new JPanel();
        p.setLayout(null);
        // p.setBounds(340,120,620,500);
        // add(p);

        l1 = new JLabel("Select Subject :");
        l1.setBounds(400, 60, 150, 20);
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        l1.setForeground(Color.white);
        add(l1);

        l2 = new JLabel("Enter Date :");
        l2.setBounds(870, 60, 150, 20);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        l2.setForeground(Color.white);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(870, 100, 150, 25);
        add(t1);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!!!");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + stream, "root", "1234");
            System.out.println("Connection Created!!!");
            Statement s = con.createStatement();

            q="select count(sid) from "+sub;
            rs=s.executeQuery(q);
            rs.next();
            count= rs.getInt(1);
            subject= new String[count];
            q="select sid from "+sub;
            rs=s.executeQuery(q);
            for(i=0;i<count;i++)
            {
                rs.next();
                subject[i]=rs.getString(1);
            }
            cb1 = new JComboBox<>(subject);
            cb1.setBounds(400, 100, 180, 25);
            add(cb1);


            q = "select count(*) from "+year;
            rs = s.executeQuery(q);
            rs.next();
            count = rs.getInt(1);

            q = "select rno, sname from "+year;
            rs = s.executeQuery(q);
            rno = new JLabel[count];
            name = new JLabel[count];
            submit = new JButton[count];
            check = new JCheckBox[count];

            int y = 20;
            for (i = 0; i < count; i++) {
                rs.next();
                rno[i] = new JLabel(rs.getString(1));
                name[i] = new JLabel(rs.getString(2));
                check[i] = new JCheckBox();
                submit[i] = new JButton("Submit");

                rno[i].setBounds(80, y, 100, 20);
                p.add(rno[i]);

                name[i].setBounds(170, y, 200, 20);
                p.add(name[i]);

                check[i].setBounds(320, y, 30, 30);
                p.add(check[i]);

                submit[i].setBounds(430, y, 100, 30);
                p.add(submit[i]);
                submit[i].addActionListener(this);
                y += 40;
            }
            scroll = new JScrollPane(p);
            // scroll.setPreferredSize(new Dimension(450, 200));
            scroll.setBounds(400,160,620,450);
            add(scroll);

            ok=new JButton("DONE");
            ok.setBounds(660, 660, 100, 30);
            add(ok);
            ok.addActionListener(this);

            // while (rs.next()) {
            // System.out.println(rs.getString(1));
            // System.out.println(rs.getString(2));
            // }
            con.close();
            System.out.println("connection closed!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        try {
            int student_rno;
            String status,student_name,subject,q;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!!!");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + stream, "root", "1234");
            System.out.println("Connection Created!!!");
            for (i = 0; i < count; i++) {
                if (e.getSource() == submit[i]) {
                    subject = (String) cb1.getSelectedItem();
                    date = t1.getText();
                    student_rno = Integer.parseInt(rno[i].getText());
                    student_name = name[i].getText();
                    if (check[i].isSelected())
                        status = "Present";
                    else
                        status = "Absent";
                    if(date.length()!=0)
                    {
                        q = "insert into "+table+" values(?,?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(q);
                        ps.setString(1, subject);
                        ps.setString(2, date);
                        ps.setString(3, tid);
                        ps.setInt(4, student_rno);
                        ps.setString(5, student_name);
                        ps.setString(6, status);
                        ps.executeUpdate();
                        System.out.println("Record Inserted!!!");
                        submit[i].setEnabled(false);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"   Please Enter Date ! ! !");
                }

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"   Error to Add Presenty ! ! !");
        }
        if(e.getSource()==ok)
        {
            try{
                if(date.length()!=0)
                {
                    JOptionPane.showMessageDialog(null,"   Presenty Sucessfully Done ! ! !");
                    new Stream(tid);
                    this.setVisible(false);
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"   Error to Add Presenty ! ! !");
            }
        }
    }

    public static void main(String[] args) {
       new Presenty("admin", "bba", "third_year","ty_presenty","ty_sub");
    }
}