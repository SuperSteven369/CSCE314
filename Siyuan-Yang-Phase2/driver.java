// Author Name: Siyuan Yang
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class driver {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Primes p = new Primes();
                JFrame frame = new MainWindow(Config.APPLICATIONNAME, p);
                frame.setSize(1000, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
    });
        
    }
}
