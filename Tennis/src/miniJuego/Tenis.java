package miniJuego;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")

public class Tenis extends JPanel{
	
	private Pelota pelota = new Pelota(this);
	private Raqueta raqueta = new Raqueta(this);
	private ImageIcon bomba;
	
	public Tenis() {
		
		bomba = new ImageIcon("bomba.png");
		setBackground(Color.WHITE);
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				raqueta.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				raqueta.keyPressed(e);
			}
		});
		setFocusable(true);
		Sonido.BACK.loop();
	}
	
	public void finDelJuego() {
		Sonido.BACK.stop();
		Sonido.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "Fin del Juego", "Fin del Juego", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	private void mover() {
		pelota.mover();
		raqueta.mover();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		raqueta.paint(g2d);
		g.drawImage(bomba.getImage(),pelota.getX(),pelota.getY(), 50, 50, null);
	}
	
	public Raqueta getRaqueta() {
		return this.raqueta;
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tenis");
		Tenis game = new Tenis();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.mover();
			game.repaint();
			Thread.sleep(10);
		}
	}

}
