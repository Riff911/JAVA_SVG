/**
 * @file Circle.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes;

import java.util.Vector;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.visitors.ShapeVisitor;
import utg.cs.fig.utils.Point2D;

/**
 * The Circle class
 */
public class Circle extends Shape{
	/**
	   * the position of the center of the circle
	   */
	public Point2D center;
	/**
	   * the radius of the circle
	   */
	public double radius;
	/**
	   * the points on the circumference of the circle
	   */
	public Vector<Point2D> points = new Vector<Point2D>();
	/**
	 * The simple constructor
	   * @param fig  the figure the circle is belonging to
	   * @param center the position of the center of the circle
	   * @param x the radius of the circle
	   */
	public Circle(Figure fig, Point2D center, double x) {
		super(fig);
		this.color = fig.color;
		this.thickness = fig.thickness;
		this.fill = fig.fill;
		this.center = center;
		radius = x;
		double nop = radius / fig.RESOLUTION;
		for (int i = 0; i <= nop ; ++i) {
			double angle = Math.toRadians((i / nop)*360);
			points.add(new Point2D(Math.cos(angle)*radius + center.x,Math.sin(angle)*radius + center.y));
		}	
	}
	/**
	 * The complex constructor
	   * @param fig  the figure for the circle
	   * @param color the color of the circle
	   * @param fill the fill of the circle
	   * @param thickness the thickness of the circle
	   * @param center the position of the circle
	   * @param x the radius of the circle
	   */
	public Circle(Figure fig, String color,String fill,double thickness,Point2D center, double x) {
		super(fig);
		this.color = color;
		this.thickness = thickness;
		this.fill = fill;
		this.center = center;
		radius = x;
		double nop = radius / fig.RESOLUTION;
		for (int i = 0; i <= nop ; ++i) {
			double angle = Math.toRadians((i / nop)*360);
			points.add(new Point2D(Math.cos(angle)*radius + center.x,Math.sin(angle)*radius + center.y));
		}
	}
	/**
	   * Sets the color of the circle
	   *
	   * @param c the color of the pen
	   */
	public void setColor(String c) {
		this.color = c;
	}
	/**
	   * Sets the fill of the circle
	   *
	   * @param f the fill
	   */
	public void setFill(String f) {
		this.fill = f;
	}
	/**
	   * Sets the thickness of the circle
	   *
	   * @param t the thickness of the pen
	   */
	public void setThickness(double t) {
		this.thickness = t;
	}
	 /**
	   * overrides the tostring method
	   *
	   * @return result the string representation of the circle
	   */
@Override
public String toString() {
	String result = "Circle c "+ color + " f "+ fill + " t " + thickness + " center " + center + " radius " + radius;
	return result;
}
/**
 * overrides the clone method
 *
 * @return a clone of the circle
 */
@Override
public Object clone(){
	return new Circle(this.fig,this.color,this.fill,this.thickness,this.center,this.radius);
}

/**
 * Overrides the shape accept method
 * @param shapeVisitor the shapeVisitor
 * @param o            the info transmitted by the caller
 * @return the info the shapeVisitor is returning
 */
@Override
public Object accept(ShapeVisitor shapeVisitor, Object o) {
	return shapeVisitor.visitCircle(this, o);
}
}
