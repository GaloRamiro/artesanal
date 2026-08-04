package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		
		boolean resultado;
		Maquina rubia = new Maquina("CO011","Pilsener", "Cerveza fria", 0.02, 8000);
		System.out.println("-------------ESTADO ACTUAL-------------");
		rubia.imprimir();
		
		resultado= rubia.RecargarCerveza(3000);
		System.out.println("Recarga 1 estado: "+resultado+"<----");
		rubia.imprimir();
		resultado= rubia.RecargarCerveza(2000);
		System.out.println("Recarga 2 estado: "+resultado+"<----");
		rubia.imprimir();
		resultado= rubia.RecargarCerveza(3000);
		System.out.println("Recarga 3 estado: "+resultado+"<----");
		rubia.imprimir();
	}

}
