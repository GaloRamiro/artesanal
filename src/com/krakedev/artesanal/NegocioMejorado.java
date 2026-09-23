package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	// Lista que permitirá administrar varias máquinas de cerveza
	private ArrayList<Maquina> maquinas;

	// Constructor
	public NegocioMejorado() {

		// Inicializamos la lista para poder agregar máquinas posteriormente
		maquinas = new ArrayList<Maquina>();
	}

	// Getter de la lista de máquinas
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	// Setter de la lista de máquinas
	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	/*
	 * Genera un código aleatorio para una máquina.
	 * El número generado estará entre 1 y 100.
	 * Ejemplos: M-25, M-78, M-100.
	 */
	public String generarCodigo() {

		int numero;

		numero = (int) (Math.random() * 100) + 1;

		return "M-" + numero;
	}
}