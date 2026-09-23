package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquina {

	/*
	 * Prueba que se pueda recuperar una máquina existente.
	 * Se espera encontrar la máquina utilizando su código.
	 */
	@Test
	public void testRecuperarMaquinaExistente() {

		NegocioMejorado negocio = new NegocioMejorado();

		negocio.agregarMaquina("IPA", "Cerveza artesanal IPA", 0.02);

		Maquina maquinaAgregada = negocio.getMaquinas().get(0);

		String codigo = maquinaAgregada.getCodigo();

		Maquina maquinaRecuperada = negocio.recuperarMaquina(codigo);

		assertNotNull(maquinaRecuperada);
		assertEquals(codigo, maquinaRecuperada.getCodigo());
	}

	/*
	 * Prueba la búsqueda de una máquina que no existe.
	 * Se espera obtener null.
	 */
	@Test
	public void testRecuperarMaquinaNoExistente() {

		NegocioMejorado negocio = new NegocioMejorado();

		negocio.agregarMaquina("Pilsener", "Cerveza clara", 0.01);

		Maquina maquinaRecuperada = negocio.recuperarMaquina("M-999");

		assertNull(maquinaRecuperada);
	}
}