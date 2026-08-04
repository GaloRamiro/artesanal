package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maquina rubia = new Maquina("CO014","Pilsener", "Cerveza fria", 0.02, 8000);
		rubia.imprimir();
		rubia.llenarMaquina();
		System.out.println("========== MÁQUINA LLENA ===========");
		rubia.imprimir();
		Maquina negra= new Maquina("CO016","Club", "Cerveza buena", 0.03);
		negra.imprimir();
		negra.llenarMaquina();
		System.out.println("========== MÁQUINA LLENA ===========");
		negra.imprimir();
	}

}
