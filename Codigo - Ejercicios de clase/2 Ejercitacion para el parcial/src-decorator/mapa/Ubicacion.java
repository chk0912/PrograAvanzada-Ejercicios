package mapa;

public class Ubicacion {
	private int X;
	private int Y;
	
	public Ubicacion(int x, int y) {
		X = x;
		Y = y;
	}
	/*
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	*/
	public int distanciaHasta(Ubicacion u) {
		return (int) (Math.sqrt(
		Math.pow(this.X - u.X, 2)+
		Math.pow(this.X - u.Y, 2)
				)
		);	
	}
	@Override
	public String toString() {
		return "Ubicacion [X=" + X + ", Y=" + Y + "]";
	}
}
