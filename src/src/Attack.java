import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class Attack {

	static int score = 0;
	
	/**
	 * The player shot a laser and it will be drawn on the screen.
	 * @param lasers where the spaceship's lasers are stored.
	 * @param firstRow
	 * @param secThirdRow first, second, third, and fourth row of aliens are needed for <code>GameLogic.gameplay()</code> to detect shots.
	 * @param fourthRow
	 * @param layeredPane where the lasers are being displayed
	 * @param scoreLabel is needed for the <code>GameLogic.gameplay()</code> method.
	 * @param background is needed for the <code>GameLogic.gameplay()</code> method.
	 * @param youWon is needed for the <code>GameLogic.gameplay()</code> method.
	 */
	
	public static void playerShoot(List<JLabel> lasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLayeredPane layeredPane, JLabel scoreLabel, JLabel background, JLabel youWon) {
		
		ActionListener task1 = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {

	            
	        	if(!lasers.isEmpty()) {
	        		
	        		try{for(JLabel l : lasers) {
	        			
	        			layeredPane.add(l);
	        			l.setBounds(l.getX(),l.getY()-3,l.getWidth(),l.getHeight());
	        			if(l.getY()<=64) {
	        				lasers.remove(l);
	        				l.setVisible(false);
	        			}
	        			
	        			GameLogic.gameplay(lasers, firstRow, secThirdRow, fourthRow, scoreLabel, layeredPane, background, youWon);
	        			
	        		}} catch(Exception ex) {
	        			
	        		}
	        		
	        	}
	          
	        }};
	    Timer timer1 = new Timer(10, task1);
	    timer1.setRepeats(true);
	    timer1.start();
		
	}
	
	/**
	 * The enemy shot so it will be displayed on the screen.
	 * @param enemyLasers where the enemy lasers are stored
	 * @param spaceship is needed for <code>GameLogic.gameLost()</code> method.
	 * @param layeredPane where the shot is stored.
	 * @param background is needed for <code>GameLogic.gameLost()</code> method.
	 * @param gameOverLabel is needed for <code>GameLogic.gameLost()</code> method.
	 */
	public static void enemyShoot(List<JLabel> enemyLasers, JLabel spaceship, JLayeredPane layeredPane, JLabel background, JLabel gameOverLabel) {
		        		
			ActionListener task = new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	
		        	if(!enemyLasers.isEmpty()) {
		        		
		        		try{for(JLabel l : enemyLasers) {
		        			
		        			layeredPane.add(l);
		        			l.setBounds(l.getX(),l.getY()+2,l.getWidth(),l.getHeight());
		        			if(l.getY()>=331) {
		        				enemyLasers.remove(l);
		        				l.setVisible(false);
		        				
		        			}
		        			
		        			GameLogic.gameLost(spaceship, enemyLasers, layeredPane, background, gameOverLabel);
		        			
		        		}} catch(Exception ex) {
		        			
		        		}
		        		
		        	}
		          
		        }};
		    Timer timer = new Timer(20, task);
		    timer.setRepeats(true);
		    timer.start();
		
	}
	
	
}
