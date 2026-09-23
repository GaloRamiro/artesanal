package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestGenerarCodigo {

	/*
	 * Prueba que generarCodigo retorne un código válido.
	 * Se espera un valor no nulo que empiece con "M-".
	 */
	@Test
	public void testGenerarCodigo() {

		NegocioMejorado negocio = new NegocioMejorado();

		String codigo = negocio.generarCodigo();

		System.out.println("Código generado: " + codigo);

		assertNotNull(codigo);
		assertTrue(codigo.startsWith("M-"));
	}
}