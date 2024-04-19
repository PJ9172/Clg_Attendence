import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Stream extends JFrame implements ActionListener
{
    JPanel p;
    JButton bba,bca,bcom,bsc,cds,bk,addnew;
    Color buColor= new Color(0,122,122);
    Color bgColor= new Color(0,102,102);
    String tid;
    public Stream(String tid)
    {
        this.tid=tid;
        p=new JPanel();
        p.setLayout(null);
        p.setBounds(340,120,620,500);
        add(p);

        bba=new JButton("BBA");
        bba.setBounds(240,50,120,30);
        bba.setBackground(buColor);
        bba.setForeground(Color.white);
        p.add(bba);

        bca=new JButton("BBA(CA)");
        bca.setBounds(240,130,120,30);
        bca.setBackground(buColor);
        bca.setForeground(Color.white);
        p.add(bca);

        bcom=new JButton("B.Com");
        bcom.setBounds(240,210,120,30);
        bcom.setBackground(buColor);
        bcom.setForeground(Color.white);
        p.add(bcom);

        bsc=new JButton("BCS");
        bsc.setBounds(240,290,120,30);
        bsc.setBackground(buColor);
        bsc.setForeground(Color.white);
        p.add(bsc);

        cds=new JButton("BCS (CDS)");
        cds.setBounds(240,370,120,30);
        cds.setBackground(buColor);
        cds.setForeground(Color.white);
        p.add(cds);

        // addnew=new JButton("ADD NEW");
        // addnew.setBounds(100,380,100,30);
        // addnew.setBackground(buColor);
        // addnew.setForeground(Color.white);
        // p.add(addnew);

        bk=new JButton("Back");
        bk.setBounds(250, 450,100,30);
        bk.setBackground(buColor);
        bk.setForeground(Color.white);
        p.add(bk);

        bba.addActionListener(this);  
        bca.addActionListener(this);
        bcom.addActionListener(this);
        bsc.addActionListener(this);
        cds.addActionListener(this); 
        // addnew.addActionListener(this);  
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
        if(e.getSource()==bba)
        {
            new Years(tid,"bba");
            this.setVisible(false);
        }
        if(e.getSource()==bcom)
        {
            this.setVisible(false);
            new Years(tid,"bcom");
        }
        if(e.getSource()==bca)
        {
            this.setVisible(false);
            new Years(tid,"bca");
        }
        if(e.getSource()==bsc)
        {
            this.setVisible(false);
            new Years(tid,"bsc");
        }
        if(e.getSource()==cds)
        {
            this.setVisible(false);
            new Years(tid,"cds");
        }
        // if(e.getSource()==addnew)
        // {
        //     this.setVisible(false);
        //     new Addnew(tid);
        // }
        if(e.getSource()==bk)
        {
            this.setVisible(false);
            new Option(tid);
            
        }
    }
    public static void main(String[] args) {
        new Stream("admin");
    }
}
