package com.arbolbinario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arbolbinario.controller.OperacionController;
import com.arbolbinario.datatransfer.ArbolBinarioDTO;
import com.arbolbinario.datatransfer.Error;
import com.arbolbinario.exception.ArchivoNoEncontradoException;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping("${arbol.endpoint.base}")
@RestController
public class ArbolService {

	@Autowired
	private OperacionController operacionController;

	@GetMapping(value = "/ancestro/buscar/{nodo1}/{nodo2}")
	public ResponseEntity<?> getAncestroComun(@PathVariable Integer nodo1, @PathVariable Integer nodo2)
			throws ArchivoNoEncontradoException {

		Either<Error, String> resultEither = operacionController.leerArchivoNodo(nodo1, nodo2);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		return new ResponseEntity<>(resultEither.left().value(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping(value = "/ancestro/crear/arbol", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> crearArbol(@RequestBody ArbolBinarioDTO arbloBinario) {

		Either<Exception, String> resultEither = operacionController.crearArbol(arbloBinario);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		return new ResponseEntity<>(resultEither.left().value(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
