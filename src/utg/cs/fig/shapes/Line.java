/**
 * @file Line.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.visitors.ShapeVisitor;
import utg.cs.fig.utils.Point2D;

/**
 * The Line class
 */
public class Line extends Shape{
	/**
	   * the beginning point of the line
	   */
	public Point2D from;
	/**
	   * the ending point of the line
	   */
	public Point2D to;

	/**
	 * The simple constructor
	 * @param fig the figure the line is belonging to
	 * @param from the first point on the line
	 * @param to the second point on the line
	 */
	public Line(Figure fig, Point2D from, Point2D to) {
		super(fig);
		this.color = fig.color;
		this.thickness = fig.thickness;
		this.fill = fig.fill;
		this.from = from;
		this.to = to;
	}
	/**
	 * The complex constructor
	 * @param fig the figure the line is belonging to
	 * @param color the color of the line
	 * @param thickness the thickness of the line
	 * @param from the first point on the line
	 * @param to the second point on the line
	 */
	public Line(Figure fig,String color,double thickness, Point2D from, Point2D to) {
		super(fig);
		this.color = color;
		this.thickness = thickness;
		this.fill = fig.fill;
		this.from = from;
		this.to = to;
	}
	/**
	   * Sets the color of the line
	   *
	   * @param c the color of the pen
	   */
	public void setColor(String c) {
		this.color = c;
	}
	/**
	   * Sets the fill of the line
	   *
	   * @param f the fill
	   */
	public void setFill(String f) {
		this.fill = f;
	}
	/**
	   * Sets the thickness of the line
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
	@Override
	public String toString() {
		String result = "line c " + color + " f "+ fill + " t "+ thickness + " points (" + from + ") (" + to + ")";
		return result;
	}
	/**
	 * overrides the clone method
	 *
	 * @return a clone of the line
	 */
	@Override
	public Object clone(){
		return new Line(this.fig,this.color,this.thickness,this.from,this.to);
	}
	/**
	 * Overrides the shape accept method
	 * @param shapeVisitor the shapeVisitor
	 * @param o            the info transmitted by the caller
	 * @return the info the shapeVisitor is returning
	 */
	@Override
	public Object accept(ShapeVisitor shapeVisitor, Object o) {
		return shapeVisitor.visitLine(this, o);
	}
}
