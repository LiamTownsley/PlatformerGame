import java.awt.Dimension;
import java.awt.Toolkit;

public class PlatformerGame {
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setSize(700, 700);
		
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Platformer Game");
		frame.setVisible(true) ;
	}
}
