package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestBuscarCliente {

	/*
	 * Prueba la búsqueda de un cliente por su cédula.
	 * Se espera recuperar correctamente al cliente registrado.
	 */
	@Test
	public void testBuscarClientePorCedula() {

		NegocioMejorado negocio = new NegocioMejorado();

		negocio.registrarCliente("Juan Perez", "1723456789");

		Cliente cliente = negocio.buscarClientePorCedula("1723456789");

		assertNotNull(cliente);
		assertEquals("Juan Perez", cliente.getNombre());
		assertEquals("1723456789", cliente.getCedula());
	}

	/*
	 * Prueba la búsqueda de un cliente por su código.
	 * El primer cliente recibe el código 100.
	 */
	@Test
	public void testBuscarClientePorCodigo() {

		NegocioMejorado negocio = new NegocioMejorado();

		negocio.registrarCliente("Maria Lopez", "1755555555");

		Cliente cliente = negocio.buscarClientePorCodigo(100);

		assertNotNull(cliente);
		assertEquals(100, cliente.getCodigo());
		assertEquals("Maria Lopez", cliente.getNombre());
	}

	/*
	 * Prueba la búsqueda de una cédula que no está registrada.
	 * Se espera obtener null.
	 */
	@Test
	public void testBuscarClientePorCedulaNoExiste() {

		NegocioMejorado negocio = new NegocioMejorado();

		negocio.registrarCliente("Pedro Torres", "1711111111");

		Cliente cliente = negocio.buscarClientePorCedula("1799999999");

		assertNull(cliente);
	}

	/*
	 * Prueba la búsqueda de un código que no está registrado.
	 * Se espera obtener null.
	 */
	@Test
	public void testBuscarClientePorCodigoNoExiste() {

		NegocioMejorado negocio = new NegocioMejorado();

		negocio.registrarCliente("Ana Ruiz", "1722222222");

		Cliente cliente = negocio.buscarClientePorCodigo(999);

		assertNull(cliente);
	}
}