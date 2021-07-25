/**
 * @file Polyline.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes;

import java.util.Vector;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.visitors.ShapeVisitor;
import utg.cs.fig.utils.Point2D;

/**
 *The Polyline class
 */
public class Polyline extends Shape{
	/**
	   * the points of the polyline
	   */
	public Vector<Point2D> points = new Vector<Point2D>();
	/**
	 * The simple constructor
	 * @param fig the figure the polyline is belonging to
	 * @param x the points of the polyline as an array
	 */
	public Polyline(Figure fig,Point2D... x) {
		super(fig);
		this.color = fig.color;
		this.thickness = fig.thickness;
		this.fill = fig.fill;
		for(int i= 0; i<x.length;i++) {
			Point2D val = x[i];
			points.add(val);
		}
	}
	/**
	 * The complex constructor
	 * @param fig the figure the polyline is belonging to
	 * @param color the color of the polyline
	 * @param fill the fill of the polyline
	 * @param thickness the thickness of the polyline
	 * @param x the points of the polyline
	 */
	public Polyline(Figure fig,String color,String fill,double thickness,Point2D... x) {
		super(fig);
		this.color = color;
		this.thickness = thickness;
		this.fill = fill;
		for(int i= 0; i<x.length;i++) {
			Point2D val = x[i];
			points.add(val);
		}
		
	}
	/**
	   * Sets the color of the polyline
	   *
	   * @param c the color of the pen
	   */
	public void setColor(String c) {
		this.color = c;
	}
	/**
	   * Sets the fill of the polyline
	   *
	   * @param f the fill
	   */
	public void setFill(String f) {
		this.fill = f;
	}
	/**
	   * Sets the thickness of the polyline
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
		String result ="Polyline c " +  color +  " f "+ fill + " t "+ thickness + " points " ;
		for(int i=0; i<points.size();i++) {
		result = result + "(" + points.get(i) +") ";	
		}
		return result;
	}
	/**
	 * overrides the clone method
	 *
	 * @return a clone of the polyline 
	 */
	@Override
	public Object clone(){
		Point2D[] point = new Point2D[this.points.size()];
		for(int i=0;i<this.points.size();i++) {
			point[i]= this.points.get(i);
		}
		return new Polyline(this.fig,this.color,this.fill,this.thickness,point);
	}
	/**
	 * Overrides the shape accept method
	 * @param shapeVisitor the shapeVisitor
	 * @param o            the info transmitted by the caller
	 * @return the info the shapeVisitor is returning
	 */
	@Override
	public Object accept(ShapeVisitor shapeVisitor, Object o) {
		return shapeVisitor.visitPolyline(this, o);
	}
}
