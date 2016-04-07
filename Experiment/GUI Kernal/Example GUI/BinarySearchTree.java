/*
 * Author: Domino
 * Created: 03/15/2003 14:26:16
 * Modified: 03/15/2003 14:26:16
 */


public class BinarySearchTree implements Dictionary
{
	Comparator C;
	BinaryTree T;
	protected Position actionPos;
	
	public BinarySearchTree(Comparator c){
		C = c;
		T = (BinaryTree) new LinkedBinaryTree();
	}
	
	protected Object key(Position position){
		return ((Item)position.element()).key();
	}
	
	protected Object element(Position position){
		return ((Item)position.element()).element();
	}
	
	protected void checkKey(Object key) throws InvalidKeyException {
		if (!C.isComparable(key)) throw new InvalidKeyException("Key is not comparable");
	}
	
	protected void swap(Position swapPos, Position remPos){
		T.replaceElement(swapPos,remPos.element());
	}
	
	protected Position findPosition(Object key, Position pos){
		if (T.isExternal(pos))
			return pos;
		else {
			Object curKey = key(pos);
			if (C.isLessThan(key, curKey))
				return findPosition(key, T.leftChild(pos));
			else if (C.isGreaterThan(key,curKey))
				return findPosition(key, T.rightChild(pos));
			else
				return pos;
		}
	}
	
	public int size() {
		return (T.size()-1)/2;
	}
	
	public boolean isEmpty(){
		return T.size() == 1;
	}
	
	public Object findElement(Object key) throws InvalidKeyException {
		checkKey(key);
		Position curPos = findPosition(key, T.root());
		actionPos = curPos;
		if (T.isInternal(curPos))
			return element(curPos);
		else 
			return null;
	}
	
	public void insertItem(Object key, Object element) throws InvalidKeyException {
		checkKey(key);
		Position insPos = T.root();
		do {
			insPos = findPosition(key, insPos);
			if (T.isExternal(insPos))
				break;
			else
				insPos = T.rightChild(insPos);
		} while (true);
		((LinkedBinaryTree)T).expandExternal(insPos);
		Item newItem = new Item(key, element);
		T.replaceElement(insPos,newItem);
		actionPos = insPos;
	}
	
	public Object removeElement(Object key) throws InvalidKeyException{
		Object toReturn;
		checkKey(key);
		Position remPos = findPosition(key,T.root());
		if (T.isExternal(remPos)){
			actionPos = remPos;
			return null;
		} else {
			toReturn = element(remPos);
			if (T.isExternal(T.leftChild(remPos)))
				remPos = T.leftChild(remPos);
			else if (T.isExternal(T.rightChild(remPos)))
				remPos = T.rightChild(remPos); 
			else {
				Position swapPos = remPos;
				remPos = T.rightChild(swapPos);
				do 
					remPos = T.leftChild(remPos);
				while (T.isInternal(remPos));
			}
			actionPos = T.sibling(remPos);
			((LinkedBinaryTree)T).removeAboveExternal(remPos);
			return toReturn;
		}
	}
	
	public BinaryTree getTree(){
		return T;
	}
}