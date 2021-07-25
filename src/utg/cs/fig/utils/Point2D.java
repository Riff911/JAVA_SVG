/**
 * @file Point2D.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.utils;

import utg.cs.fig.shapes.visitors.ShapeVisitor;

/**
 * Point is a wrapper for points (x,y) in the canevas
 */
public class Point2D {
	/**
	 * the x coordinate of the point
	 */
  public double x;
  /**
	 * the y coordinate of the point
	 */
  public double y;
  /**
	 * The constructor
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }
  /**
   * overrides the clone method
   *
   * @return a clone of the point
   */
  @Override
  public Object clone(){
  	return new Point2D(this.x,this.y);
  }
  /**
	 * Overrides the tostring method
	 * @return string representation for the point
	 */
  public String toString(){
    return x + "," + y;
  }
}
