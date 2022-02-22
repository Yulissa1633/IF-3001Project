package Domain.BinaryTree;

public class Node {

	private Object element;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node() {
		this.element = null;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	
	public Node(Object element) {
		this.element = element;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	public Object getElement() {
		return element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
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
	
	
}
