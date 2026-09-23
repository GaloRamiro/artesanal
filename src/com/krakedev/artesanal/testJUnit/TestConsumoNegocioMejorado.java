package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumoNegocioMejorado {

	/*
	 * Prueba el consumo de cerveza de un cliente. Se espera que disminuya la
	 * cantidad de cerveza de la máquina y que el valor consumido se acumule en el
	 * cliente.
	 */
	@Test
	public void testConsumirCerveza() {

		NegocioMejorado negocio = new NegocioMejorado();

		// Agregamos una máquina con precio de $0.02 por ml
		negocio.agregarMaquina("IPA", "Cerveza artesanal IPA", 0.02);

		// Recuperamos la máquina creada
		Maquina maquina = negocio.getMaquinas().get(0);

		// Guardamos su código generado
		String codigoMaquina = maquina.getCodigo();

		// Llenamos todas las máquinas
		negocio.cargarMaquinas();

		// Registramos un cliente
		negocio.registrarCliente("Juan Perez", "1723456789");

		// Recuperamos al cliente, cuyo primer código es 100
		Cliente cliente = negocio.buscarClientePorCodigo(100);

		assertNotNull(cliente);

		// El cliente consume 200 ml
		negocio.consumirCerveza(100, codigoMaquina, 200);

		/*
		 * La máquina comenzó con 9800 ml. Después de servir 200 ml debe quedar con 9600
		 * ml.
		 */
		assertEquals(9600.0, maquina.getCantidadActual(), 0.001);

		/*
		 * 200 ml * $0.02 = $4.00. El total consumido del cliente debe ser $4.00.
		 */
		assertEquals(4.0, cliente.getTotalConsumido(), 0.001);
	}

	/*
	 * Prueba que varios consumos se acumulen correctamente. El segundo consumo debe
	 * sumarse al primero.
	 */
	@Test
	public void testAcumularConsumos() {

		NegocioMejorado negocio = new NegocioMejorado();

		negocio.agregarMaquina("Stout", "Cerveza negra", 0.02);

		Maquina maquina = negocio.getMaquinas().get(0);

		String codigoMaquina = maquina.getCodigo();

		negocio.cargarMaquinas();

		negocio.registrarCliente("Maria Lopez", "1755555555");

		// Primer consumo: 200 ml * $0.02 = $4
		negocio.consumirCerveza(100, codigoMaquina, 200);

		// Segundo consumo: 100 ml * $0.02 = $2
		negocio.consumirCerveza(100, codigoMaquina, 100);

		Cliente cliente = negocio.buscarClientePorCodigo(100);

		// $4 + $2 = $6
		assertEquals(6.0, cliente.getTotalConsumido(), 0.001);

		// 9800 - 200 - 100 = 9500 ml
		assertEquals(9500.0, maquina.getCantidadActual(), 0.001);
	}
}