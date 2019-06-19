package com.arbolbinario.datatransfer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class ArbolBinarioDTO {

	private List<Integer> listNode;

	@JsonCreator
	public ArbolBinarioDTO(@JsonProperty("listNode") List<Integer> listNode) {
		super();
		this.listNode = listNode;
	}

	public List<Integer> getListNode() {
		return listNode;
	}

	public void setListNode(List<Integer> listNode) {
		this.listNode = listNode;
	}

}
