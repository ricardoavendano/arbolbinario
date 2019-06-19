package com.arbolbinario.domain;

import org.springframework.stereotype.Component;

@Component
public class Node {

	private Integer value;
	private Node left;
	private Node right;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void add(Integer value) {
		if (value < this.value) {
			if (left != null) {
				left.add(value);
			} else {
				left = new Node();
				left.setValue(value);
			}
		} else {
			if (right != null) {
				right.add(value);
			} else {
				right = new Node();
				right.setValue(value);
			}
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
}