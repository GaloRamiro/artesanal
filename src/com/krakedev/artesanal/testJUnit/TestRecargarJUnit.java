package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

	@Test
	public void testRecargaExitosa() {
		Maquina rubia = new Maquina("CO014","Pilsener", "Cerveza", 0.03, 8000);

		boolean resultado = rubia.RecargarCerveza(3000);

		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual(), 0.001);
	}

	@Test
	public void testRecargaFallidaPorDesvorde() {
		Maquina negra = new Maquina("CO088","Club", "Cerveza Frias", 0.03, 8000);
		negra.RecargarCerveza(7000);
		boolean resultado = negra.RecargarCerveza(1000);

		assertTrue(resultado);
		assertEquals(3000, negra.getCantidadActual(), 0.001);
	}
}