package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoCliente {
	@Test
	public void asignarCodigo() {
        Negocio barDeMoe= new Negocio();
        Cliente mario = new Cliente("Mario", "1722965895");
        Cliente andres = new Cliente("Andres", "1733333333");
        barDeMoe.asignaraCodigoCliente(andres);
        barDeMoe.asignaraCodigoCliente(mario);
        
        
        assertEquals(100, andres.getCodigo());
        assertEquals(101, mario.getCodigo());
        
	}

}
