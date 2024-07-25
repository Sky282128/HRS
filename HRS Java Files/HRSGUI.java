
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HRSGUI extends JFrame{
    private JButton btnEnter;
    public HRSGUI(){
        super("HRS");
        setLayout(new BorderLayout());

        setSize(500, 600);
        init();

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#FFD700"));
        JLabel lblHRS = new JLabel("Hotel Reservation System");
        lblHRS.setForeground(Color.BLACK);
        lblHRS.setFont(new Font("Roboto", Font.BOLD, 30));
        panelNorth.add(lblHRS);
        this.add(panelNorth, BorderLayout.NORTH);

        btnEnter = new JButton("Enter");
        //panelNorth.add(btnAdd);
    }
}
