package unidades;

public class Capa extends UnidadDecorator {
	
	
	 public Capa (Elemento guerrero){
		  this.elemento = guerrero;
		 }
	 @Override
	 public double getDa�o() {
	  return this.elemento.getDa�o() * 0.9;
	 }
	 @Override
	 public double getEnergia() {
	  return this.elemento.getEnergia() *2;
	 }
	 
	 @Override
	 public double getDefensa() {
		 return this.elemento.getDefensa();
	 }

}