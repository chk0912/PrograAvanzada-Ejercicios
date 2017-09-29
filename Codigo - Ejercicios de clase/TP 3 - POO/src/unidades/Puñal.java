package unidades;

public class Pu�al extends UnidadDecorator{
	
	public Pu�al (Elemento guerrero){
		  this.elemento = guerrero;
		 }
	 @Override
	 public double getDa�o() {
	  return this.elemento.getDa�o()  +3;
	 }
	 @Override
	 public double getEnergia() {
	  return this.elemento.getEnergia() ;
	 }
	 
	 @Override
	 public double getDefensa() {
		 return this.elemento.getDefensa() -3;
	 }

}
