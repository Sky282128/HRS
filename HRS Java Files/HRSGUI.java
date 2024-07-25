
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HRSGUI extends JFrame{
    private JButton btnEnter;
    public HRSGUI(){
        super("HRS");

        setLayout(new BorderLayout());
        init();

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.decode("#CE2211"));

        btnEnter = new JButton("Enter");
        panelSouth.South.add(btnAdd);
    }
}
