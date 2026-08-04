package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double valor;
		Maquina rubia = new Maquina("CO074","Pilsener", "Cerveza rubia", 0.02, 10000);
		System.out.println("-------------ESTADO ACTUAL-------------");
		rubia.imprimir();
		System.out.println("-------------LLENANDO MAQUINA-------------");
		rubia.llenarMaquina();
		rubia.imprimir();
		System.out.println("-------------SERVIR 1000ML-------------");
		valor = rubia.servirCerveza(1000);
		rubia.imprimir();
		System.out.println("El valor es de $" + valor);
		System.out.println("-------------SERVIR 2000ML-------------");
		valor = rubia.servirCerveza(2000);
		rubia.imprimir();
		System.out.println("El valor es de $" + valor);

		System.out.println("-------------SERVIR 2000ML-------------");
		valor = rubia.servirCerveza(2000);
		rubia.imprimir();
		System.out.println("El valor es de $" + valor);
		System.out.println("-------------SERVIR 6000ML-------------");
		valor = rubia.servirCerveza(6000);
		rubia.imprimir();
		System.out.println("El valor es de $" + valor);

	}

}
