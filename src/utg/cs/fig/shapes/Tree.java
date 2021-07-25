/**
 * @file Tree.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes;

import java.util.Vector;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.visitors.ShapeVisitor;
import utg.cs.fig.utils.Point2D;

public class Tree extends Shape{
	/**
	   * the root node
	   */
	public Node rootNode;
	/**
	   * The constructor
	   * @param fig  the figure the shape is belonging to
	   * @param root the root node
	   */
	public Tree(Figure fig,Node root) {
		super(fig);
		rootNode = root;
		this.color = fig.color;
		this.thickness = fig.thickness;
		this.fill = fig.fill;
	}
	/**
	   * The postoreder traversal of the tree
	   * @param root  the root node
	   */
	public void traverseTree(Node root) {
		if(root.leftChild!=null) {
			fig.addLine(new Line(fig,color,thickness,new Point2D(root.point.x,root.point.y),new Point2D(root.leftChild.point.x,root.leftChild.point.y)));
			traverseTree(root.leftChild);
			}
			if(root.rightChild!=null) {
				fig.addLine(new Line(fig,color,thickness,new Point2D(root.point.x,root.point.y),new Point2D(root.rightChild.point.x,root.rightChild.point.y)));
				
			traverseTree(root.rightChild);
			
			}
			if(root!=null) {
				fig.addEllipse(new Ellipse(fig,color,"#FFFFFF",thickness,root.point,25,25));
				fig.addText(new Text(fig,color,thickness,new Point2D(root.point.x,root.point.y),root.data));
				}
	}
	/**
	   * Sets the color of the tree
	   *
	   * @param c the color of the pen
	   */
	public void setColor(String c) {
		this.color = c;
	}
	/**
	   * Sets the fill of the tree
	   *
	   * @param f the fill
	   */
	public void setFill(String f) {
		this.fill = f;
	}
	/**
	   * Sets the thickness of the tree
	   *
	   * @param t the thickness of the pen
	   */
	public void setThickness(double t) {
		this.thickness = t;
	}
	/**
	   * overrides the tostring method
	   *
	   * @return result the string representation of the ellipse
	   */
	public String toString() {
		String result = "Tree c " + color + " f "+ "#FFFFFF" + " t " + thickness + " Root coordinate "+ rootNode.point;
		return result;
	}
	/**
	 * overrides the clone method
	 *
	 * @return a clone of the tree
	 */
	@Override
	public Object clone(){
		return new Tree(this.fig,this.rootNode);
	}
	/**
	 * @param shapeVisitor the shapeVisitor
	 * @param o            the info transmitted by the caller
	 * @return null
	 */
	@Override
	public Object accept(ShapeVisitor shapeVisitor, Object o) {
		return null;
	}



}

