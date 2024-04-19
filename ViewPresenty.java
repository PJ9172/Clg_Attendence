import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ViewPresenty extends JFrame implements ActionListener {
    JLabel l1,sub,d,r,n,sta,t;
    JPanel p;
    JButton ok;
    Color buColor = new Color(0, 122, 122);
    Color bgColor = new Color(0, 102, 102);
    int i,count;
    String sname, stream, year,rno;
    JLabel subject[],date[],srno[],name[],status[],tid[];
    public ViewPresenty(String sname, String rno, String stream, String table) {
        this.sname = sname;
        this.rno=rno;
        this.stream = stream;
        this.year = year;

        p = new JPanel();
        p.setLayout(null);
        // p.setBounds(340,120,620,500);
        // add(p);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!!!");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + stream, "root", "1234");
            System.out.println("Connection Created!!!");
            Statement s = con.createStatement();

            String query = "select count(*) from "+table+" where student_rno="+rno;
            ResultSet crs = s.executeQuery(query);
            crs.next();
            count = crs.getInt(1);
            System.out.println("Count query executed!! count : "+count);

            // String q="SELECT * FROM "+table;
            String q = "select * from " +table+" where student_rno="+rno;
            ResultSet rs = s.executeQuery(q);

            subject=new JLabel[count];
            date=new JLabel[count];
            tid=new JLabel[count];
            srno=new JLabel[count];
            name=new JLabel[count];
            status=new JLabel[count];
            
            sub=new JLabel("Subject");
            d=new JLabel("Date");
            t=new JLabel("T-Id");
            r=new JLabel("Roll-no");
            n=new JLabel("Name");
            sta=new JLabel("Status");

            sub.setBounds(40, 20, 100, 20);
            sub.setFont(new Font("Arial", Font.BOLD, 16));

            d.setBounds(140, 20, 100, 20);
            d.setFont(new Font("Arial", Font.BOLD, 16));

            t.setBounds(240, 20, 100, 20);
            t.setFont(new Font("Arial", Font.BOLD, 16));

            r.setBounds(320, 20, 100, 20);
            r.setFont(new Font("Arial", Font.BOLD, 16));

            n.setBounds(400, 20, 100, 20);
            n.setFont(new Font("Arial", Font.BOLD, 16));

            sta.setBounds(520, 20, 100, 20);
            sta.setFont(new Font("Arial", Font.BOLD, 16));

            p.add(sub);
            p.add(d);
            p.add(t);
            p.add(r);
            p.add(n);
            p.add(sta);


            int y = 60;
            for (i = 0; i < count; i++) {
                rs.next();
                subject[i] = new JLabel(rs.getString(1));
                date[i] = new JLabel(rs.getString(2));
                tid[i]= new JLabel(rs.getString(3));
                srno[i] = new JLabel(rs.getString(4));
                name[i] = new JLabel(rs.getString(5));
                status[i]= new JLabel(rs.getString(6));

                subject[i].setBounds(40, y, 100, 20);
                p.add(subject[i]);

                date[i].setBounds(140, y, 200, 20);
                p.add(date[i]);

                tid[i].setBounds(240, y, 100, 20);
                p.add(tid[i]);

                srno[i].setBounds(320, y, 100, 20);
                p.add(srno[i]);

                name[i].setBounds(400, y, 30, 20);
                p.add(name[i]);
                
                status[i].setBounds(520, y, 80, 20);
                p.add(status[i]);

                y += 40;

            }

            JScrollPane scroll = new JScrollPane(p);
            // scroll.setPreferredSize(new Dimension(450, 200));
            scroll.setBounds(360,120,620,450);
            add(scroll);

            ok=new JButton("DONE");
            ok.setBounds(620, 620, 100, 30);
            add(ok);
            ok.addActionListener(this);

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
        if(e.getSource()==ok)
        {
            new Home();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewPresenty("Fara","110", "bca", "ty_presenty");
    }
}