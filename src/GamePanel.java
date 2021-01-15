import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener { 
	int DESIRED_FPS = 60;
	
	Player player;
	ArrayList<Wall> walls = new ArrayList<>();
	
	Timer gameTimer;
	
	public GamePanel() {
		player = new Player(400, 300, this);
		
		makeWalls();
		
		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				player.set();
				repaint();
			}
			
		}, 0, 1000 / DESIRED_FPS);
	}
	
	public void makeWalls() {
		for (int i = 50; i < 650; i+= 50) {
			walls.add(new Wall(i, 600, 50, 50));
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gtd = (Graphics2D) g;
		
		player.draw(gtd);
		
		for(Wall wall : walls) {
			wall.draw(gtd);
		}
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'a') player.keyLeft = true;
		if(e.getKeyChar() == 'w') player.keyUp = true;
		if(e.getKeyChar() == 'd') player.keyRight = true;
		if(e.getKeyChar() == 's') player.keyDown = true;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'a') player.keyLeft = false;
		if(e.getKeyChar() == 'w') player.keyUp = false;
		if(e.getKeyChar() == 'd') player.keyRight = false;
		if(e.getKeyChar() == 's') player.keyDown = false;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	 
}
