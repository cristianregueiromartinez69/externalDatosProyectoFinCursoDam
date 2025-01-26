package com.finproyectodam.external_datos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExternalDatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalDatosApplication.class, args);
	}

	/*
	  TODO: inicio y registro de usuarios en la aplicación
	 */

}
