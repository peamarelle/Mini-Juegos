package miniJuego;

public class Circulo {
	private int x;
	private int y;
	private int diametro;
	
	
	public Circulo() {
		this.diametro = 0;
	}
	public Circulo(int x,int y,int diametro) {
		this.x = x;
		this.y = y;
		this.diametro = diametro;
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}
	
}
