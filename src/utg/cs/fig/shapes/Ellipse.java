/**
 * @file Ellipse.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes;

import java.util.Vector;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.visitors.ShapeVisitor;
import utg.cs.fig.utils.Point2D;

/**
 * The Ellipse class
 */
public class Ellipse extends Shape{
	/**
	   * the position of the center of the ellipse
	   */
	public Point2D center;
	/**
	   * the radius along the x axis of the ellipse
	   */
	public double xradius;
	/**
	   * the radius along the y axis of the ellipse
	   */
	public double yradius;
	/**
	   * the points on the circumference of the ellipse
	   */
	public Vector<Point2D> points = new Vector<Point2D>();
	/**
	 * The simple constructor
	   * @param fig  the figure the ellipse is belonging to
	   * @param center the position of the center of the ellipse
	   * @param x the radius of the ellipse along the x axis
	   * @param y the radius of the ellipse along the y axis
	   */
	public Ellipse(Figure fig,Point2D center, double x, double y) {
		super(fig);
		this.color = fig.color;
		this.thickness = fig.thickness;
		this.fill = fig.fill;
		this.center = center;
		xradius = x;
		yradius = y;
		double nop = ((xradius + yradius)/2) / fig.RESOLUTION;
		for (int i = 0; i <= nop ; ++i) {
			double angle = Math.toRadians((i / nop)*360);
			points.add(new Point2D(Math.cos(angle)* xradius + center.x,Math.sin(angle)* yradius + center.y));
		}
	}
	/**
	 * The complex constructor
	   * @param fig  the figure for the ellipse
	   * @param color the color of the ellipse
	   * @param fill the fill of the ellipse
	   * @param thickness the thickness of the ellipse
	   * @param center the position of the center of the ellipse
	   * @param x the radius of the ellipse along the x axis
	   * @param y the radius of the ellipse along the y axis
	   */
	public Ellipse(Figure fig, String color,String fill,double thickness,Point2D center, double x, double y) {
		super(fig);
		this.color = color;
		this.thickness = thickness;
		this.fill = fill;
		this.center = center;
		xradius = x;
		yradius = y;
		double nop = ((xradius + yradius)/2) / fig.RESOLUTION;
		for (int i = 0; i <= nop ; ++i) {
			double angle = Math.toRadians((i / nop)*360);
			points.add(new Point2D(Math.cos(angle)* xradius + center.x,Math.sin(angle)* yradius + center.y));
		}
	}
	/**
	   * Sets the color of the ellipse
	   *
	   * @param c the color of the pen
	   */
	public void setColor(String c) {
		this.color = c;
	}
	/**
	   * Sets the fill of the ellipse
	   *
	   * @param f the fill
	   */
	public void setFill(String f) {
		this.fill = f;
	}
	/**
	   * Sets the thickness of the ellipse
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
		String result = "Ellipse c "+ color + " f "+ fill + " t " + thickness + " center " + center + " xradius " + xradius+ " yradius " + yradius;
		return result;
	}
	/**
	 * overrides the clone method
	 *
	 * @return a clone of the object 
	 */
	@Override
	public Object clone(){
		return new Ellipse(this.fig,this.color,this.fill,this.thickness,this.center,this.xradius,this.yradius);
	}
	/**
	 * Overrides the shape accept method
	 * @param shapeVisitor the shapeVisitor
	 * @param o            the info transmitted by the caller
	 * @return the info the shapeVisitor is returning
	 */
	@Override
	public Object accept(ShapeVisitor shapeVisitor, Object o) {
		return shapeVisitor.visitEllipse(this, o);
	}
}
