package ADT;

import java.util.ArrayList;
import java.util.Collection;

import Business.ADTBusiness;
import Domain.BinaryTree.Node;
import Domain.BinaryTree.Position;

public class BinaryTree {
	
	private int size;
	private Node root;
	
	public BinaryTree() {
		this.size = 0;
		this.root = null;
	}

	public BinaryTree(Node root) {
		this.size = 1;
		this.root = root;
	}
	
	public void insertLeft(Position p, Object o) {
		if(p.getNode()!=null) {
			p.getNode().setLeft(new Node(o));
			p.getNode().getLeft().setParent(p.getNode());
		}
	}
	
	public void insertRigth(Position p, Object o) {
		if(p.getNode()!=null) {
			p.getNode().setRight(new Node(o));
			p.getNode().getRight().setParent(p.getNode());
		}
	}
	
	public void remove(Position p) {
		if(p.getNode()!=null) {
			if(!(p.getNode().getLeft()!=null && p.getNode().getLeft()!=null)) {
				Node aux = root;
				while(aux.getLeft()!=null) {
					if(ADTBusiness.equals(aux.getElement(), p.getNode().getElement())) {
						p.setNode(null);
					}
					else {
						if(ADTBusiness.equals(aux.getLeft().getElement(), p.getNode().getElement())) {
							p.setNode(null);
						}
						else {
							if(ADTBusiness.equals(aux.getRight().getElement(), p.getNode().getElement())) {
								p.setNode(null);
							}
						}
					}
					aux = aux.getLeft();
				}
				
				aux = root;
				while(aux.getRight()!=null) {
					if(ADTBusiness.equals(aux.getElement(), p.getNode().getElement())) {
						p.setNode(null);
					}
					else {
						if(ADTBusiness.equals(aux.getLeft().getElement(), p.getNode().getElement())) {
							p.setNode(null);
						}
						else {
							if(ADTBusiness.equals(aux.getRight().getElement(), p.getNode().getElement())) {
								p.setNode(null);
							}
						}
					}
					aux = aux.getRight();
				}
			}
		}
	}
	
	public Position search(Object o) throws Exception {
		if(isEmpty()){
            throw new Exception("Binary Tree is empty");
        }
		
		Node aux = root;
		while(aux.getLeft()!=null) {
			if(ADTBusiness.equals(aux.getElement(), o)) {
				return new Position(aux);
			}
			else {
				if(ADTBusiness.equals(aux.getLeft().getElement(), o)) {
					return new Position(aux);
				}
				else {
					if(ADTBusiness.equals(aux.getRight().getElement(), o)) {
						return new Position(aux);
					}
				}
			}
			aux = aux.getLeft();
		}
		
		aux = root;
		while(aux.getRight()!=null) {
			if(ADTBusiness.equals(aux.getElement(), o)) {
				return new Position(aux);
			}
			else {
				if(ADTBusiness.equals(aux.getLeft().getElement(), o)) {
					return new Position(aux);
				}
				else {
					if(ADTBusiness.equals(aux.getRight().getElement(), o)) {
						return new Position(aux);
					}
				}
			}
			aux = aux.getRight();
		}
		
		return null;
	}
	
	public int size() throws Exception {
		if(isEmpty()){
            throw new Exception("Binary Tree is empty");
        }
        return size;
		
	}
	
	public boolean isEmpty() {
		return root==null;
		
	}
	
	public Position root() {
		return new Position(root);
		
	}
	
	public Position parent(Position p) {
		
		if(p.getNode()!=null) {
			return new Position(p.getNode().getParent());
		}
		
		return null;
		
	}
	
	public Collection<Position> children(Position p) {
		
		if(p.getNode()!=null) {
			Collection<Position> positionIterator = new ArrayList<>();
			Node aux = p.getNode();
			while(aux.getLeft()!=null) {
				positionIterator.add(new Position(aux));
				if(aux.getRight()!=null) {
					positionIterator.add(new Position(aux));
				}
				aux = aux.getLeft();
			}
			
			aux = p.getNode();
			while(aux.getRight()!=null) {
				positionIterator.add(new Position(aux));
				if(aux.getLeft()!=null) {
					positionIterator.add(new Position(aux));
				}
				aux = aux.getRight();
			
			}
			return positionIterator;
			
		}
		
		return null;
	}
	
	public boolean isInternal(Position p) {
		if(p.getNode()!=null) {
			return (p.getNode().getLeft() != null && p.getNode().getLeft() != null);
		}
		return false;
		
	}
	
	public boolean isExternal(Position p) {
		if(p.getNode()!=null) {
			return (p.getNode().getLeft() == null && p.getNode().getLeft() == null);
		}
		return false;
	}
	
	public boolean isRoot(Position p) {
		return parent(p)==null;
		
	}
	
	public Object replace(Position p, Object o) {
		if(p.getNode()!=null) {
			Node aux = p.getNode();
			p.setNode(new Node(o));
			return aux;
		}
		return null;
		
	}
	
	public void entreOrden(Position p, Object o) {
		String result="";
		if(p.getNode()!=null) {
			Node aux = p.getNode();
			while(aux.getLeft()!=null) {
				result+=""+aux.getLeft().getElement()+"";
				result+=""+aux.getElement()+"";
				if(aux.getRight()!=null) {
					result+=""+aux.getRight().getElement()+"";
				}
				aux = aux.getLeft();
			}
			
			aux = p.getNode();
			if(aux.getRight()!=null) {
				aux = aux.getRight();
				while(aux.getLeft()!=null) {
					result+=""+aux.getLeft().getElement()+"";
					result+=""+aux.getElement()+"";
					if(aux.getRight()!=null) {
						result+=""+aux.getRight().getElement()+"";
					}
					aux = aux.getLeft();
				}
			}
		}	
		System.out.println(result);
	}
	
	public String toStringEntreOrden() {
		String result="";
		if(root!=null) {
			Node aux = root;
			while(aux.getLeft()!=null) {
				result+=""+aux.getLeft().getElement()+"";
				result+=""+aux.getElement()+"";
				if(aux.getRight()!=null) {
					result+=""+aux.getRight().getElement()+"";
				}
				aux = aux.getLeft();
			}
			
			aux = root;
			if(aux.getRight()!=null) {
				aux = aux.getRight();
				while(aux.getLeft()!=null) {
					result+=""+aux.getLeft().getElement()+"";
					result+=""+aux.getElement()+"";
					if(aux.getRight()!=null) {
						result+=""+aux.getRight().getElement()+"";
					}
					aux = aux.getLeft();
				}
			}
		}
		return result;
	}

}
