
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Controller implements ActionListener, DocumentListener{
    private HRSGUI gui;
    private Hotel hotel;

    public Controller(HRSGUI gui, HRS hrs){
        this.gui = gui;
        this.hrs = hrs;

        //updateView();

        gui.setActionListener(this);
        gui.setDocumentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
