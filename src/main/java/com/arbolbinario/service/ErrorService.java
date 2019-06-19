package com.arbolbinario.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;

import com.arbolbinario.datatransfer.Error;
import com.arbolbinario.exception.ArchivoNoEncontradoException;

@Controller
public class ErrorService {

	public Error getError(Exception e) {

		if (e instanceof ArchivoNoEncontradoException) {

			return new Error("ArchivoNoEncontradoException001", "Primero debe crear el arbol");

		}
		Map<String, String> params = new HashMap<>();
		params.put("Exception", e.getClass() + "-" + e.getMessage());
		params.put("Time", LocalDateTime.now().toString());

		return new Error("ArchivoNoEncontradoException9999", "Unknown Error");
	}
}
