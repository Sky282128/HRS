import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Contains the GUI for the HRS
*/
public class HRSGUI extends JFrame{
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    /**
     * Iniializes the HRS GUI
     */
    public HRSGUI(){
        super("HRS");
        setLayout(new BorderLayout());

        setSize(500, 500);
        setResizable(false);
        init();

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Creates the design elements for the GUI
     */
    private void init(){
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#FFD700"));
        JLabel lblHRS = new JLabel("Hotel Reservation System");
        lblHRS.setForeground(Color.BLACK);
        lblHRS.setFont(new Font("Roboto", Font.BOLD, 30));
        panelNorth.add(lblHRS);
        this.add(panelNorth, BorderLayout.NORTH);

        JPanel panelMiddle = new JPanel();
        //JLabel lblHRS = new JLabel("Hotel Reservation System");
        lblHRS.setForeground(Color.BLACK);
        lblHRS.setFont(new Font("Roboto", Font.BOLD, 30));
        btn1 = new JButton("Create Hotel");
        btn1.setFont(new Font("Roboto", Font.PLAIN, 20));
        btn2 = new JButton("Delete Hotel");
        btn2.setFont(new Font("Roboto", Font.PLAIN, 20));
        btn3 = new JButton("View Hotel");
        btn3.setFont(new Font("Roboto", Font.PLAIN, 20));
        btn4 = new JButton("Manage Hotel");
        btn4.setFont(new Font("Roboto", Font.PLAIN, 20));
        btn5 = new JButton("Make Booking");
        btn5.setFont(new Font("Roboto", Font.PLAIN, 20));
        btn6 = new JButton("Quit Program");
        btn6.setFont(new Font("Roboto", Font.PLAIN, 20));
        this.add(panelMiddle, CENTER);
        panelMiddle.add(btn1);
        panelMiddle.add(btn2);
        panelMiddle.add(btn3);
        panelMiddle.add(btn4);
        panelMiddle.add(btn5);
        panelMiddle.add(btn6);
    }
/* 
    public void setActionListener(ActionListener listener) {
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
        btn5.addActionListener(listener);
        btn6.addActionListener(listener);
    }
 
    public void setDocumentListener(DocumentListener listener) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
*/
}
