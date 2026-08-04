package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

	// Valida que se sirva cerveza correctamente cuando hay suficiente cantidad
	// utilizando el constructor con capacidad máxima personalizada.
	@Test
	public void testServirConCapacidadPersonalizada() {
		Maquina maquina = new Maquina("CO024","Pilsener", "Rubia", 0.02, 5000);

		maquina.RecargarCerveza(2000);

		double valor = maquina.servirCerveza(500);

		assertEquals(10.0, valor, 0.001);
		assertEquals(1500.0, maquina.getCantidadActual(), 0.001);
	}

	// Valida que se sirva cerveza correctamente utilizando el constructor con
	// capacidad máxima por defecto.
	@Test
	public void testServirConConstructorPorDefecto() {
		Maquina maquina = new Maquina("CO016","Club", "Premium", 0.03);

		maquina.RecargarCerveza(3000);

		double valor = maquina.servirCerveza(1000);

		assertEquals(30.0, valor, 0.001);
		assertEquals(2000.0, maquina.getCantidadActual(), 0.001);
	}

	// Valida el caso límite donde se sirve exactamente toda la cerveza disponible.
	@Test
	public void testServirCantidadExactaDisponible() {
		Maquina maquina = new Maquina("CO034","Budweiser", "Lager", 0.05);

		maquina.RecargarCerveza(1500);

		double valor = maquina.servirCerveza(1500);

		assertEquals(75.0, valor, 0.001);
		assertEquals(0.0, maquina.getCantidadActual(), 0.001);
	}

	// Valida que no se sirva cerveza cuando la cantidad solicitada es mayor que la
	// disponible.
	@Test
	public void testNoServirPorCantidadInsuficiente() {
		Maquina maquina = new Maquina("CO034","Corona", "Light", 0.04);

		maquina.RecargarCerveza(800);

		double valor = maquina.servirCerveza(1000);

		assertEquals(0.0, valor, 0.001);
		assertEquals(800.0, maquina.getCantidadActual(), 0.001);
	}

	// Valida que no se sirva cerveza cuando la máquina está vacía.
	@Test
	public void testNoServirConMaquinaVacia() {
		Maquina maquina = new Maquina("CO034","Heineken", "Premium", 0.03);

		double valor = maquina.servirCerveza(500);

		assertEquals(0.0, valor, 0.001);
		assertEquals(0.0, maquina.getCantidadActual(), 0.001);
	}

	// Valida que al servir 0 ml no cambie la cantidad disponible y el valor a pagar
	// sea 0.
	@Test
	public void testServirCantidadCero() {
		Maquina maquina = new Maquina("CO043","Stella", "Belgian", 0.02);

		maquina.RecargarCerveza(1000);

		double valor = maquina.servirCerveza(0);

		assertEquals(0.0, valor, 0.001);
		assertEquals(1000.0, maquina.getCantidadActual(), 0.001);
	}

	// Valida que después de llenar la máquina se pueda servir cerveza correctamente.
	@Test
	public void testServirDespuesDeLlenarMaquina() {
		Maquina maquina = new Maquina("CO023","Modelo", "Especial", 0.02, 5000);

		maquina.llenarMaquina();

		double valor = maquina.servirCerveza(1000);

		assertEquals(20.0, valor, 0.001);
		assertEquals(3800.0, maquina.getCantidadActual(), 0.001);
	}

}