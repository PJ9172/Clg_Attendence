import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Tcurd extends JFrame implements ActionListener
{
    JButton back,add,update,delete;
    JPanel p;
    Color buColor= new Color(0,122,122);
    Color bgColor= new Color(0,102,102);
    public Tcurd()
    {
        p=new JPanel();
        p.setLayout(null);
        p.setBounds(340,120,620,500);
        add(p);

        add=new JButton("Add Teacher");
        add.setBounds(240, 80,130,30);
        add.setBackground(buColor);
        add.setForeground(Color.white);
        p.add(add);

        update=new JButton("Update Teacher");
        update.setBounds(240, 190,130,30);
        update.setBackground(buColor);
        update.setForeground(Color.white);
        p.add(update);

        delete=new JButton("Delete Teacher");
        delete.setBounds(240, 300,130,30);
        delete.setBackground(buColor);
        delete.setForeground(Color.white);
        p.add(delete);

        back=new JButton("Back");
        back.setBounds(255, 420,100,30);
        back.setBackground(buColor);
        back.setForeground(Color.white);
        p.add(back);
        
        add.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
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
        if(e.getSource()==add)
        {
            new AddTeacher();
            this.setVisible(false);
        }
        if(e.getSource()==update)
        {
            new UpdateTeacher();
            this.setVisible(false);
        }
        if(e.getSource()==delete)
        {
            new DeleteTeacher();
            this.setVisible(false);
        }
        if(e.getSource()==back)
        {
            new AdminOption();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Tcurd();
    }
}