package com.arbolbinario.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.arbolbinario.datatransfer.ArbolBinarioDTO;
import com.arbolbinario.datatransfer.Error;
import com.arbolbinario.domain.Node;
import com.arbolbinario.exception.ArchivoNoEncontradoException;
import com.arbolbinario.service.ErrorService;

import fj.data.Either;

@Controller
public class OperacionController {

	@Autowired
	private Node node;

	@Autowired
	private ErrorService errorService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OperacionController.class);

	public Either<Exception, String> crearArbol(ArbolBinarioDTO listNode) {
		try {

			File file = new File("target/arbol.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			Path path = Paths.get(file.getPath());
			try (BufferedWriter writer = Files.newBufferedWriter(path)) {
				listNode.getListNode().stream().forEach(i -> {
					try {
						writer.write(i.toString() + "\r\n");
					} catch (IOException e) {
						LOGGER.error("OperacionController:crearArbol", e);
					}
				});
			}
			return Either.right("Arbol creado");
		} catch (Exception e) {

			return Either.left(e);
		}
	}

	public Either<Error, String> leerArchivoNodo(Integer nodo1, Integer nodo2) throws ArchivoNoEncontradoException {

		try {
			File file = new File("target/arbol.txt");
			if (!file.exists()) {
				throw new ArchivoNoEncontradoException();
			}

			Path path = Paths.get(file.getPath());
			try (BufferedReader reader = Files.newBufferedReader(path)) {
				String nodo = "";

				while ((nodo = reader.readLine()) != null) {
					if (null == node.getValue()) {
						node.setValue(Integer.valueOf(nodo));
					} else {
						node.add(Integer.valueOf(nodo));
					}
				}

				Node root1 = findLowestCommonAncestor(node, nodo1, nodo2);
				return Either.right("Ancestro comun mas cercano entre " + nodo1 + ":" + nodo2 + " -> "
						+ root1.getValue().toString());
			} catch (Exception e) {

				return Either.left(errorService.getError(e));
			}
		} catch (Exception e) {

			return Either.left(errorService.getError(e));
		}

	}

	public Node findLowestCommonAncestor(Node node, int node1, int node2) {

		// Base case
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (node.getValue() == node1 || node.getValue() == node2)
			return node;

		// Look for keys in left and right subtrees
		Node leftLCA = findLowestCommonAncestor(node.getLeft(), node1, node2);
		Node rightLCA = findLowestCommonAncestor(node.getRight(), node1, node2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (leftLCA != null && rightLCA != null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (leftLCA != null) ? leftLCA : rightLCA;
	}
}