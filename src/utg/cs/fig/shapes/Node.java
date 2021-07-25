/**
 * @file Node.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes;

import utg.cs.fig.utils.Point2D;
/**
 *The Node class
 */
public class Node {
	/**
	   * the data of the node
	   */
	public String data;
	/**
	   * the left child of the node
	   */
	public Node leftChild;
	/**
	   * the right of the node
	   */
	public Node rightChild;
	/**
	   * the position of the node
	   */
	public Point2D point;
	/**
	   * the x radius of the ellipse of the node
	   */
	public double xradius = 25;
	/**
	   * the y radius of the ellipse of the node
	   */
	public double yradius = 25;
	/**
	 * The constructor
	 * @param val the data of the node
	 * @param coord the position of the node
	 */
	public Node(String val,Point2D coord){
	data = val;
	leftChild = null;
	rightChild = null;
	point = coord;
	}
	/**
	   * adds the left child of the node
	   *
	   * @param left the left child of the node
	   */
	public void addLeft(Node left) {
	leftChild = left;
	}
	/**
	   * adds the right child of the node
	   *
	   * @param right the right child of the node
	   */
	public void addRight(Node right) {
	rightChild = right;
	}
	/**
	   * overrides the tostring method
	   *
	   * @return the string representation of the data
	   */
	public String toString() {
		return data;
	}
}
