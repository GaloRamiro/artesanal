package com.krakedev.artesanal.testJUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquina {

	/*
	 * Prueba que una máquina pueda agregarse correctamente.
	 * Se espera true y una máquina almacenada en la lista.
	 */
	@Test
	public void testAgregarMaquina() {

		NegocioMejorado negocio = new NegocioMejorado();

		boolean resultado = negocio.agregarMaquina(
				"IPA",
				"Cerveza artesanal IPA",
				0.02);

		assertTrue(resultado);
		assertEquals(1, negocio.getMaquinas().size());
	}
	
	/*
	 * Prueba que no se permita agregar una máquina con código duplicado.
	 * Se fuerza el mismo código para comprobar la validación.
	 * Se espera false en el segundo intento.
	 */
	@Test
	public void testAgregarMaquinaDuplicada() {

		NegocioMejorado negocio = new NegocioMejorado() {

			@Override
			public String generarCodigo() {
				return "M-25";
			}
		};

		boolean primera = negocio.agregarMaquina(
				"IPA",
				"Cerveza IPA",
				0.02);

		boolean segunda = negocio.agregarMaquina(
				"Stout",
				"Cerveza negra",
				0.03);

		assertTrue(primera);
		assertFalse(segunda);
		assertEquals(1, negocio.getMaquinas().size());
	}
}