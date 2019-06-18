package com.arbolbinario.service;

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

import com.arbolbinario.datatransfer.ArbolBinarioDTO;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping("${arbol.endpoint.base}")
@RestController
public class ArbolService {
	
	@GetMapping(value = "/ancestro/buscar/{nodo1}/{nodo2}")
    public ResponseEntity<?> getAncestroComun(@PathVariable String nodo1, @PathVariable String nodo2){

        Either<Error, String> resultEither = Either.right("first endpoint");

        if (resultEither.isRight()) {
            return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
        }

        return new ResponseEntity<>(resultEither.left().value(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@PostMapping(value = "/ancestro/crear/arbol", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> crearArbol(@RequestBody ArbolBinarioDTO salaryLoandValidate) {

		 Either<Error, String> resultEither = Either.right("first endpoint");

	        if (resultEither.isRight()) {
	            return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
	        }

	        return new ResponseEntity<>(resultEither.left().value(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
