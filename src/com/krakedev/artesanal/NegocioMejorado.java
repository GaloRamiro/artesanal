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
	
	/*
	 * Agrega una nueva máquina al negocio.
	 * Antes de agregarla verifica que el código generado no esté repetido.
	 * Retorna true si se agregó y false si el código ya existe.
	 */
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {

		String codigo = generarCodigo();

		// Buscamos si ya existe una máquina con el código generado
		Maquina maquinaExistente = recuperarMaquina(codigo);

		if (maquinaExistente == null) {

			Maquina maquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);

			maquinas.add(maquina);

			return true;
		}

		return false;
	}
	
	/*
	 * Llena todas las máquinas registradas en el negocio.
	 * Se recorre el ArrayList utilizando un for.
	 */
	public void cargarMaquinas() {

		for (int i = 0; i < maquinas.size(); i++) {

			Maquina maquina = maquinas.get(i);

			maquina.llenarMaquina();
		}
	}
	
	/*
	 * Busca una máquina por su código.
	 * Retorna la máquina encontrada o null si no existe.
	 */
	public Maquina recuperarMaquina(String codigo) {

		for (int i = 0; i < maquinas.size(); i++) {

			Maquina maquina = maquinas.get(i);

			if (maquina.getCodigo().equals(codigo)) {
				return maquina;
			}
		}

		return null;
	}
}