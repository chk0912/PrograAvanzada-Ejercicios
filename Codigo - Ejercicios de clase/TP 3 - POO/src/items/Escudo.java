package items;

import unidades.Unidad;

public class Escudo extends UnidadDecorator  {

	public Escudo(Unidad unidad) {
		super(unidad);
	}

	

	@Override
	public double calcularDa�oQueMeInflinjen(double da�o) {
		da�o = this.unidad.calcularDa�oQueMeInflinjen(da�o);
		if(da�o < 0)
			return 0;
		
		da�o = da�o*0.6;
		
		return da�o;
	}
}
