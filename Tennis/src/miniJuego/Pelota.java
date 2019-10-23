package miniJuego;

import java.awt.Rectangle;

public class Pelota {
	
	private static final int DIAMETRO = 50;
	private int x;
	private int y;
	private int xa = 1;
	private int ya = 1;
	private Tenis juego;

	public Pelota(Tenis juego) {
		this.juego= juego;
	}

	void mover() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > juego.getWidth() - DIAMETRO)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if(colicion()) {
			ya = -1;
			y = juego.getRaqueta().getTop() - DIAMETRO;
		}
		if(y + ya > juego.getHeight() - DIAMETRO)
			juego.finDelJuego();
		x = x + xa;
		y = y + ya;
	}
	
	public Rectangle getLimites() {
		return new Rectangle(x,y,DIAMETRO,DIAMETRO);
	}
	
	public boolean colicion() {
		return juego.getRaqueta().getLimites().intersects(getLimites());
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
