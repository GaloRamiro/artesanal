package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {

		// Creamos el negocio
		NegocioMejorado negocio = new NegocioMejorado();

		/*
		 * Intentamos registrar un cliente.
		 * Como la lista clientes todavía no está inicializada,
		 * esperamos obtener un NullPointerException.
		 */
		negocio.registrarCliente("Juan Perez", "1723456789");

		System.out.println("Cliente registrado");
	}
}