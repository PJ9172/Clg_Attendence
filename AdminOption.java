import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AdminOption extends JFrame implements ActionListener
{
    JButton teacher,stream,student,back;
    JPanel p;
    Color buColor= new Color(0,122,122);
    Color bgColor= new Color(0,102,102);
    public AdminOption()
    {
        p=new JPanel();
        p.setLayout(null);
        p.setBounds(340,120,620,500);
        add(p);

        teacher=new JButton("Teacher");
        teacher.setBounds(240, 80,130,30);
        teacher.setBackground(buColor);
        teacher.setForeground(Color.white);
        p.add(teacher);

        stream=new JButton("Stream");
        stream.setBounds(240, 190,130,30);
        stream.setBackground(buColor);
        stream.setForeground(Color.white);
        p.add(stream);

        student=new JButton("Student");
        student.setBounds(240, 300,130,30);
        student.setBackground(buColor);
        student.setForeground(Color.white);
        p.add(student);

        back=new JButton("Back");
        back.setBounds(255, 420,100,30);
        back.setBackground(buColor);
        back.setForeground(Color.white);
        p.add(back);
        
        teacher.addActionListener(this);
        stream.addActionListener(this);
        student.addActionListener(this);
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
        if(e.getSource()==teacher)
        {
            new Tcurd();
            this.setVisible(false);
        }
        if(e.getSource()==stream)
        {
            
        }
        if(e.getSource()==student)
        {
            
        }
        if(e.getSource()==back)
        {
            new Home();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AdminOption();
    }
}
