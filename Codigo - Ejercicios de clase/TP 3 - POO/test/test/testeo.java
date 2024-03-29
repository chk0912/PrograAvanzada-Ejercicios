package test;
import unidades.*;

import org.junit.Assert;
import org.junit.Test;

import items.*;
import mapa.Ubicacion;

public class testeo {
	@Test
	public void testSoldado() {
		Ubicacion ubi = new Ubicacion(0, 0);
		Unidad soldado = new Soldado(ubi);
		
		//System.out.println(soldado);
	}
	@Test
	public void testArquero() {
		Ubicacion ubi = new Ubicacion(0, 0);
		Unidad arquero = new Arquero(ubi);
		
		//System.out.println(arquero);
	}
	@Test
	public void testLancero() {
		Ubicacion ubi = new Ubicacion(0, 0);
		Unidad lancero = new Lancero(ubi);
		
		//System.out.println(lancero);
	}
	@Test
	public void testCaballero() {
		Ubicacion ubi = new Ubicacion(0, 0);
		Unidad caballero = new Caballero(ubi);
		
		//System.out.println(caballero);
	}

	@Test
	public void testSoldadoConItems() {
		Ubicacion ubi = new Ubicacion(0, 0);
		Unidad soldado = new Soldado(ubi);
		
		soldado = new Capa(soldado);
		
		Assert.assertEquals(200, soldado.getEnergia(), 0);
		Assert.assertEquals(9, soldado.getDa�o(), 0);

		soldado = new Pu�al(soldado);

		Assert.assertEquals(12, soldado.getDa�o(), 0);
		Assert.assertEquals(-3, soldado.getDefensa(), 0);
		Assert.assertEquals(12, soldado.getDa�o(), 0);
		Assert.assertEquals(-3, soldado.getDefensa(), 0);
	}
	@Test
	public void testArqueroConItems() {
		Ubicacion ubi = new Ubicacion(0, 0);
		Unidad arquero = new Arquero(ubi);
		
		arquero = new Capa(arquero);
		
		Assert.assertEquals(0, arquero.getEnergia(), 0);
		Assert.assertEquals(4.5, arquero.getDa�o(), 0);

		arquero = new Pu�al(arquero);

		Assert.assertEquals(7.5, arquero.getDa�o(), 0);
		Assert.assertEquals(-3, arquero.getDefensa(), 0);
	}
	@Test
	public void testLanceroConItems() {
		Ubicacion ubi = new Ubicacion(0, 0);
		Unidad lancero = new Lancero(ubi);
		
		lancero = new Capa(lancero);
		
		Assert.assertEquals(0, lancero.getEnergia(), 0);
		Assert.assertEquals(22.5, lancero.getDa�o(), 0);

		lancero = new Pu�al(lancero);

		Assert.assertEquals(25.5, lancero.getDa�o(), 0);
		Assert.assertEquals(-3, lancero.getDefensa(), 0);
	}
	@Test
	public void testCaballeroConItems() {
		Ubicacion ubi = new Ubicacion(0, 0);
		Unidad caballero = new Caballero(ubi);
		
		caballero = new Capa(caballero);
		
		Assert.assertEquals(0, caballero.getEnergia(), 0);
		Assert.assertEquals(45, caballero.getDa�o(), 0);

		caballero = new Pu�al(caballero);

		Assert.assertEquals(48, caballero.getDa�o(), 0);
		Assert.assertEquals(-3, caballero.getDefensa(), 0);
	}
	
	@Test
	public void testAtaquesPorDistancia() {
		Unidad soldado = new Soldado(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(1, 1));
		
		Assert.assertTrue(soldado.atacar(otro));
		
		otro = new Soldado(new Ubicacion(3, 3));
		Assert.assertFalse(soldado.atacar(otro));

		//######################################################
		
		Unidad arquero = new Arquero(new Ubicacion(1, 1));
		otro = new Arquero(new Ubicacion(3, 2));
		
		Assert.assertTrue(arquero.atacar(otro));

		otro = new Arquero(new Ubicacion(1, 1));
		Assert.assertFalse(arquero.atacar(otro));
		
		otro = new Arquero(new Ubicacion(500, 6));
		Assert.assertFalse(arquero.atacar(otro));
		
		//#####################################################
		Unidad lancero = new Lancero(new Ubicacion(1, 1));
		otro = new Lancero(new Ubicacion(1, 1));
		
		Assert.assertFalse(lancero.atacar(otro));
		
		otro = new Lancero(new Ubicacion(4, 3));
		Assert.assertTrue(lancero.atacar(otro));
		
		otro = new Lancero(new Ubicacion(2, 2));
		Assert.assertTrue(lancero.atacar(otro));
		
		otro = new Lancero(new Ubicacion(200, 1));
		
		Assert.assertFalse(lancero.atacar(otro));

		//#####################################################
		Unidad caballero = new Caballero(new Ubicacion(1, 1));
		otro = new Lancero(new Ubicacion(1, 1));
		
		Assert.assertFalse(caballero.atacar(otro));
		
		otro = new Lancero(new Ubicacion(2, 2));
		Assert.assertTrue(caballero.atacar(otro));
		
		otro = new Lancero(new Ubicacion(3, 3));
		Assert.assertTrue(caballero.atacar(otro));
		
		otro = new Lancero(new Ubicacion(200, 1));
		
		Assert.assertFalse(caballero.atacar(otro));	
	}
	
	@Test
	public void testAtaquesSoldado() {
		Unidad soldado = new Soldado(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(1, 1));
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(190, otro.getSalud(), 0);
		Assert.assertEquals(90, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(180, otro.getSalud(), 0);
		Assert.assertEquals(80, soldado.getEnergia(), 0);

		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(170, otro.getSalud(), 0);
		Assert.assertEquals(70, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(160, otro.getSalud(), 0);
		Assert.assertEquals(60, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(150, otro.getSalud(), 0);
		Assert.assertEquals(50, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(140, otro.getSalud(), 0);
		Assert.assertEquals(40, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(130, otro.getSalud(), 0);
		Assert.assertEquals(30, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(120, otro.getSalud(), 0);
		Assert.assertEquals(20, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(110, otro.getSalud(), 0);
		Assert.assertEquals(10, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(100, otro.getSalud(), 0);
		Assert.assertEquals(0, soldado.getEnergia(), 0);
		
		Assert.assertFalse(soldado.atacar(otro));
		Assert.assertEquals(100, otro.getSalud(), 0);
		Assert.assertEquals(0, soldado.getEnergia(), 0);
		
		soldado.tomaPocion();
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(90, otro.getSalud(), 0);
		Assert.assertEquals(90, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(80, otro.getSalud(), 0);
		Assert.assertEquals(80, soldado.getEnergia(), 0);

		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(70, otro.getSalud(), 0);
		Assert.assertEquals(70, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(60, otro.getSalud(), 0);
		Assert.assertEquals(60, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(50, otro.getSalud(), 0);
		Assert.assertEquals(50, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(40, otro.getSalud(), 0);
		Assert.assertEquals(40, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(30, otro.getSalud(), 0);
		Assert.assertEquals(30, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(20, otro.getSalud(), 0);
		Assert.assertEquals(20, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(10, otro.getSalud(), 0);
		Assert.assertEquals(10, soldado.getEnergia(), 0);
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(0, otro.getSalud(), 0);
		Assert.assertEquals(0, soldado.getEnergia(), 0);

		Assert.assertFalse(soldado.atacar(otro));
		Assert.assertEquals(0, otro.getSalud(), 0);
		Assert.assertEquals(0, soldado.getEnergia(), 0);

		soldado.tomaPocion();
		
		Assert.assertFalse(soldado.atacar(otro));
		Assert.assertEquals(0, otro.getSalud(), 0);
		Assert.assertEquals(100, soldado.getEnergia(), 0);
	}
	@Test
	public void testAtaquesArqueros() {
		Unidad arquero = new Arquero(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(3, 3));
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(195, otro.getSalud(), 0);
		Assert.assertEquals(19, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(190, otro.getSalud(), 0);
		Assert.assertEquals(18, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(185, otro.getSalud(), 0);
		Assert.assertEquals(17, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(180, otro.getSalud(), 0);
		Assert.assertEquals(16, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(175, otro.getSalud(), 0);
		Assert.assertEquals(15, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(170, otro.getSalud(), 0);
		Assert.assertEquals(14, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(165, otro.getSalud(), 0);
		Assert.assertEquals(13, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(160, otro.getSalud(), 0);
		Assert.assertEquals(12, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(155, otro.getSalud(), 0);
		Assert.assertEquals(11, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(150, otro.getSalud(), 0);
		Assert.assertEquals(10, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(145, otro.getSalud(), 0);
		Assert.assertEquals(9, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(140, otro.getSalud(), 0);
		Assert.assertEquals(8, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(135, otro.getSalud(), 0);
		Assert.assertEquals(7, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(130, otro.getSalud(), 0);
		Assert.assertEquals(6, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(125, otro.getSalud(), 0);
		Assert.assertEquals(5, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(120, otro.getSalud(), 0);
		Assert.assertEquals(4, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(115, otro.getSalud(), 0);
		Assert.assertEquals(3, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(110, otro.getSalud(), 0);
		Assert.assertEquals(2, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(105, otro.getSalud(), 0);
		Assert.assertEquals(1, arquero.getCant_flechas(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(100, otro.getSalud(), 0);
		Assert.assertEquals(0, arquero.getCant_flechas(), 0);
		
		Assert.assertFalse(arquero.atacar(otro));
		
		arquero.recarga();
		
		Assert.assertEquals(6, arquero.getCant_flechas(), 0);		
	}
	@Test
	public void testAtaquesLanceros() {
		Unidad lancero = new Lancero(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(2, 2));
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(175, otro.getSalud(), 0);
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(150, otro.getSalud(), 0);
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(125, otro.getSalud(), 0);
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(100, otro.getSalud(), 0);
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(75, otro.getSalud(), 0);
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(50, otro.getSalud(), 0);
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(25, otro.getSalud(), 0);
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(0, otro.getSalud(), 0);
		
		Assert.assertFalse(lancero.atacar(otro));		
	}
	@Test
	public void testAtaquesCaballero() {
		Unidad caballero = new Caballero(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(2, 2));
		
		Assert.assertTrue(caballero.atacar(otro));
		Assert.assertEquals(150, otro.getSalud(), 0);
		Assert.assertEquals(1, caballero.getCaballoRebelde(), 0);
		
		Assert.assertTrue(caballero.atacar(otro));
		Assert.assertEquals(100, otro.getSalud(), 0);
		Assert.assertEquals(2, caballero.getCaballoRebelde(), 0);
		
		Assert.assertTrue(caballero.atacar(otro));
		Assert.assertEquals(50, otro.getSalud(), 0);
		Assert.assertEquals(3, caballero.getCaballoRebelde(), 0);
		
		Assert.assertFalse(caballero.atacar(otro));
		
		caballero.tomaPocion();
		
		Assert.assertTrue(caballero.atacar(otro));
		Assert.assertEquals(0, otro.getSalud(), 0);
		Assert.assertEquals(1, caballero.getCaballoRebelde(), 0);
		
		Assert.assertFalse(caballero.atacar(otro));			
	}

	@Test
	public void testAtaquesSoldadoConItems() {
		Unidad soldado = new Soldado(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(1, 1));		

		soldado = new Capa(soldado);
		Assert.assertEquals(200, soldado.getEnergia(), 0);
		Assert.assertEquals(9, soldado.getDa�o(), 0);
		
		soldado = new Capa(soldado);
		Assert.assertEquals(400, soldado.getEnergia(), 0);
		Assert.assertEquals(8.1, soldado.getDa�o(), 0);
		
		soldado = new Pu�al(soldado);

		Assert.assertEquals(11.1, soldado.getDa�o(), 0.01);
		Assert.assertEquals(-3, soldado.getDefensa(), 0.01);
		
		soldado = new Pu�al(soldado);
		Assert.assertEquals(14.1, soldado.getDa�o(), 0);
		Assert.assertEquals(-6, soldado.getDefensa(), 0);		

		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(185.9, otro.getSalud(), 0);		
		
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(171.8, otro.getSalud(), 0);	

		otro = new Escudo(otro);
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(163.34, otro.getSalud(), 0.01);
		
		otro = new Escudo(otro);
		Assert.assertTrue(soldado.atacar(otro));
		Assert.assertEquals(158.264, otro.getSalud(), 0.01);
	}
	@Test
	public void testAtaquesArqueroConItems() {
		Unidad arquero = new Arquero(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(3, 3));
		
		arquero = new Pu�al(arquero);
		Assert.assertEquals(8, arquero.getDa�o(), 0);
		Assert.assertEquals(-3, arquero.getDefensa(), 0);
				
		arquero = new Pu�al(arquero);
		Assert.assertEquals(11, arquero.getDa�o(), 0);
		Assert.assertEquals(-6, arquero.getDefensa(), 0);
		
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(189, otro.getSalud(), 0);

		otro = new Escudo(otro);
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(182.4, otro.getSalud(), 0.001);
		
		otro = new Escudo(otro);
		Assert.assertTrue(arquero.atacar(otro));
		Assert.assertEquals(178.44, otro.getSalud(), 0.001);
	}
	@Test
	public void testAtaquesLanceroConItems() {
		Unidad lancero = new Lancero(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(2, 2));
		
		lancero = new Pu�al(lancero);
		Assert.assertEquals(28, lancero.getDa�o(), 0);
		Assert.assertEquals(-3, lancero.getDefensa(), 0);
		
		lancero = new Pu�al(lancero);
		Assert.assertEquals(31, lancero.getDa�o(), 0);
		Assert.assertEquals(-6, lancero.getDefensa(), 0);
		
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(169, otro.getSalud(), 0);

		otro = new Escudo(otro);
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(150.4, otro.getSalud(), 0.001);
		
		otro = new Escudo(otro);
		Assert.assertTrue(lancero.atacar(otro));
		Assert.assertEquals(139.24, otro.getSalud(), 0.001);		
	}
	@Test
	public void testAtaquesCaballeroConItems() {
		Unidad caballero = new Caballero(new Ubicacion(1, 1));
		Unidad otro = new Soldado(new Ubicacion(2, 2));
		
		caballero = new Pu�al(caballero);
		Assert.assertEquals(53, caballero.getDa�o(), 0);
		Assert.assertEquals(-3, caballero.getDefensa(), 0);
		
		caballero = new Pu�al(caballero);
		Assert.assertEquals(56, caballero.getDa�o(), 0);
		Assert.assertEquals(-6, caballero.getDefensa(), 0);
		
		Assert.assertTrue(caballero.atacar(otro));
		Assert.assertEquals(144, otro.getSalud(), 0);

		otro = new Escudo(otro);
		Assert.assertTrue(caballero.atacar(otro));
		Assert.assertEquals(110.4, otro.getSalud(), 0.001);
				
		otro = new Escudo(otro);
		Assert.assertTrue(caballero.atacar(otro));
		Assert.assertEquals(90.24, otro.getSalud(), 0.001);
	}	
}
