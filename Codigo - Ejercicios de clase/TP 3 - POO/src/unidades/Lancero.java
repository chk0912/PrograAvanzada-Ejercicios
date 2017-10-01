package unidades;

import mapa.Ubicacion;

public class Lancero  implements Unidad {
	private final static int RANGO_MINIMO = 1;
	private final static int RANGO_MAXIMO = 3;
	private double defensa;
	private double salud;
	private double da�o;
	private Ubicacion ubicacion;

	
	public Lancero(Ubicacion u) {
		salud = 150;
		da�o = 25;
		ubicacion = u;
	}


	@Override
	public double getDa�o() {
		return this.da�o;
	}
	
	@Override
	public int getCaballoRebelde() {
		return 0;
	}
	@Override
	public double getEnergia() {
		return 0;
	}

	@Override
	public double getDefensa() {
		return this.defensa;
	}

	@Override
	public double getSalud() {
		return this.salud;
	}

	@Override
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	
	@Override
	public int getCant_flechas() {
		return 0;
	}
	
	@Override
	public void tomaPocion() {
	}
	@Override
	public void recarga() {
	}

	@Override
	public void ataca(Unidad unidad) {
	}
	
	@Override
	public void meAtacanCon(double da�o) {		
		if(da�o > 0)
		{
			if(this.salud - da�o < 0)
				this.salud = 0;
			else
				this.salud -= da�o;
		}
	}

	@Override
	public boolean puedoAtacar(Unidad unidad) {
		if(this.getSalud() == 0 || unidad.getSalud() == 0)
			return false;
		
		if(this.ubicacion.distanciaHasta(unidad.getUbicacion()) < RANGO_MINIMO || this.ubicacion.distanciaHasta(unidad.getUbicacion()) > RANGO_MAXIMO)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Lancero [defensa=" + defensa + ", salud=" + salud + ", da�o=" + da�o + ", ubicacion=" + ubicacion + "]";
	}

	
	
}
