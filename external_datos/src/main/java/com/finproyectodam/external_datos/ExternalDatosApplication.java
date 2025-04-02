package com.finproyectodam.external_datos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Clase desde donde empiece el servidor
 * @author cristian && Joel
 * @version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class ExternalDatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalDatosApplication.class, args);
	}

	//TODO: configurando redis para el historial
}
