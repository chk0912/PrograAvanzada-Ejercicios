package items;

import mapa.Ubicacion;
import unidades.Unidad;

public abstract class UnidadDecorator implements Unidad {	
	protected Unidad unidad;
	
	boolean pu�al = false;

	public UnidadDecorator(Unidad unidad) {
		setUnidad(unidad);
	}


	public Unidad getUnidad() {
		return this.unidad;
	}

	public void setUnidad(Unidad unidad) {
			this.unidad = unidad;
	}
		
	@Override
	public double getDa�o() {
		return this.unidad.getDa�o();
	}
	@Override
	public double getEnergia() {
		return this.unidad.getEnergia();
	}
	@Override
	public double getDefensa() {
		return this.unidad.getDefensa();
	}
	@Override
	public double getSalud() {
		return this.unidad.getSalud();
	}
	
	@Override
	public int getCaballoRebelde() {
		return this.unidad.getCaballoRebelde();
	}
	

	@Override
	public int getCant_flechas() {
		return this.unidad.getCant_flechas();
	}
	@Override
	public Ubicacion getUbicacion() {
		return this.unidad.getUbicacion();
	}
	@Override
	public void tomaPocion() {
		this.unidad.tomaPocion();
	}
	@Override
	public void recarga() {
		this.unidad.recarga();
	}
	@Override
	public void ataca(Unidad unidad) {
		this.unidad.ataca(unidad);
	}
	@Override
	public void meAtacanCon(double da�o) {
		this.unidad.meAtacanCon(da�o);
	}
	@Override
	public boolean puedoAtacar(Unidad unidad) {
		return this.unidad.puedoAtacar(unidad);
	}
	@Override
	public double calcularDa�oQueMeInflinjen(double da�o) {
		return this.unidad.calcularDa�oQueMeInflinjen(da�o);
	}

	@Override
	public String toString() {
		return unidad.toString();
	}
	
}
