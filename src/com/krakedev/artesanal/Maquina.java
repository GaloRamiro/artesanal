package com.krakedev.artesanal;

public class Maquina {

	private String codigo;
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;

	// Constructor con capacidad máxima personalizada
	public Maquina(String codigo, String nombreCerveza, String descripcion, double precioPorMl,
			double capacidadMaxima) {
		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;
	}

	// Constructor con capacidad máxima por defecto (10000 ml)
	public Maquina(String codigo, String nombreCerveza, String descripcion, double precioPorMl) {
		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 10000;
		this.cantidadActual = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void imprimir() {
		System.out.println("===== INFORMACIÓN DE LA MÁQUINA =====");
		System.out.println("Código: " + codigo);
		System.out.println("Nombre de la cerveza: " + nombreCerveza);
		System.out.println("Descripción: " + descripcion);
		System.out.println("Precio por ml: $" + precioPorMl);
		System.out.println("Capacidad máxima: " + capacidadMaxima + " ml");
		System.out.println("Cantidad actual: " + cantidadActual + " ml");
		System.out.println("====================================");
	}

	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMaxima - 200;
	}

	public boolean RecargarCerveza(double cantidad) {
		double limitePermitido;
		limitePermitido = capacidadMaxima - 200;
		if (cantidadActual + cantidad < limitePermitido) {
			cantidadActual = cantidadActual + cantidad;
			return true;
		} else {
			return false;
		}
	}

	public double servirCerveza(double cantidad) {
		if (cantidadActual >= cantidad) {
			cantidadActual = cantidadActual - cantidad;
			double valor;
			valor = cantidad * precioPorMl;
			return valor;
		} else {
			return 0;
		}
	}

}