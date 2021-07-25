/**
 * @file Shapes.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.visitors.ShapeVisitor;

/**
 * Shape a geometric shape in the canvas
 */
public abstract class Shape {
	/**
	   * the figure the shape is belonging to
	   */
	Figure fig;
	/**
	   * the thickness of the pen
	   */
	  public double thickness;
	  /**
	   * the color of the pen
	   */
	  public String color;
	  /**
	   * the fill of the shape
	   */
	  public String fill;
	  /**
	   * The constructor
	   * @param fig  the figure the shape is belonging to
	   */
	public Shape(Figure fig) {
		this.fig = fig;
	}

	/**
	 * @param shapeVisitor the shapeVisitor
	 * @param o            the info transmitted by the caller
	 * @return the info the shapeVisitor is returning
	 */
	public abstract Object accept(ShapeVisitor shapeVisitor, Object o);
}
