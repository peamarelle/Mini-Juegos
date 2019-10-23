package miniJuego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raqueta {
	private static final int LARGO = 60;
	private static final int ALTO = 10;
	private static final int Y = 330;
	int x;
	int xa;
	private Tenis juego;

	public Raqueta(Tenis juego) {
		this.juego= juego;
	}

	public void mover() {
		if (x + xa > 0 && x + xa < juego.getWidth()-60)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, LARGO, ALTO);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
	}
	
	public Rectangle getLimites() {
		return new Rectangle(x,Y,LARGO,ALTO);
	}
	
	public int getTop() {
		return Y - ALTO;
	}
}
