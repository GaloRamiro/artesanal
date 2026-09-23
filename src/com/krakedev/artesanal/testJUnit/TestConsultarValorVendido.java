package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsultarValorVendido {

	/*
	 * Prueba que el negocio calcule correctamente
	 * la suma de los consumos realizados por todos los clientes.
	 */
	@Test
	public void testConsultarValorVendido() {

		NegocioMejorado negocio = new NegocioMejorado();

		// Creamos una máquina con precio de $0.02 por ml
		negocio.agregarMaquina(
				"IPA",
				"Cerveza artesanal IPA",
				0.02);

		Maquina maquina = negocio.getMaquinas().get(0);

		String codigoMaquina = maquina.getCodigo();

		// Llenamos la máquina antes de realizar consumos
		negocio.cargarMaquinas();

		// Registramos dos clientes
		negocio.registrarCliente("Juan Perez", "1723456789");
		negocio.registrarCliente("Maria Lopez", "1755555555");

		// Juan tiene código 100
		// 200 ml * $0.02 = $4
		negocio.consumirCerveza(
				100,
				codigoMaquina,
				200);

		// Maria tiene código 101
		// 300 ml * $0.02 = $6
		negocio.consumirCerveza(
				101,
				codigoMaquina,
				300);

		// Total esperado: $4 + $6 = $10
		double totalVendido = negocio.consultarValorVendido();

		assertEquals(10.0, totalVendido, 0.001);
	}
}