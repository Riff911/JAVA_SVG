/**
 * @file Rotate.java
* @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes.visitors;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.Circle;
import utg.cs.fig.shapes.Ellipse;
import utg.cs.fig.shapes.Line;
import utg.cs.fig.shapes.Node;
import utg.cs.fig.shapes.Polyline;
import utg.cs.fig.shapes.Text;
import utg.cs.fig.shapes.Tree;
import utg.cs.fig.utils.Point2D;

/**
 *The rotation visitor
 */
public class Rotate extends ShapeVisitor {
	/**
	   * the x coordinate of the rotation center
	   */
	double x;
	/**
	   * the y coordinate of the rotation center
	   */
	double y;
	/**
	   * the angle of rotation
	   */
	double alpha;
	/**
	 * The constructor
	   * @param fig  the current figure
	   * @param x the x coordinate of the rotation center
	   * @param y the y coordinate of the rotation center
	   * @param alpha the angle of rotation
	   */
	public Rotate(Figure fig,double x, double y, double alpha) {
		super(fig);
		this.x = x;
		this.y = y;
		this.alpha = alpha * (Math.PI/180);
	}
	/**
	 * the visit method for points
	 *
	 * @param line the line object
	 * @param o        the info got from the caller
	 * @return the info for the receiver
	 */
	@Override
	public Object visitLine(Line line, Object o) {
		double fxval = line.from.x;
		double fyval = line.from.y;
		double txval = line.to.x;
		double tyval = line.to.y;
		line.from.x = (((fxval - x)*Math.cos(alpha)) - ((fyval - y) * Math.sin(alpha))) + x;
		line.from.y = (((fxval - x)*Math.sin(alpha)) + ((fyval - y) * Math.cos(alpha))) + y;
		line.to.x = (((txval - x)*Math.cos(alpha)) - ((tyval - y) * Math.sin(alpha))) + x;
		line.to.y = (((txval - x)*Math.sin(alpha)) + ((tyval - y) * Math.cos(alpha))) + y;
			return null;
	}
	/**
	 * the visit method for points
	 *
	 * @param polyline the Polyline object
	 * @param o        the info got from the caller
	 * @return the info for the receiver
	 */
	@Override
	public Object visitPolyline(Polyline polyline, Object o) {
		for(int i=0; i< polyline.points.size();i++) {
			Point2D point = polyline.points.get(i);
			double xval = point.x;
			double yval = point.y;
			point.x = (((xval - x)*Math.cos(alpha)) - ((yval - y) * Math.sin(alpha))) + x;
			point.y = (((xval - x)*Math.sin(alpha)) + ((yval - y) * Math.cos(alpha))) + y;
			}
		return null;
	}
	/**
	 * the visit method for points
	 * 
	 * @param text the Text object
	 * @param o        the info got from the caller
	 * @return the info for the receiver
	 */
	@Override
	public Object visitText(Text text, Object o) {
		double xval = text.coord.x;
		double yval = text.coord.y;
		text.rotateangle = Math.toDegrees(alpha);
		text.coord.x = (((xval - x)*Math.cos(alpha)) - ((yval - y) * Math.sin(alpha))) + x;
		text.coord.y = (((xval - x)*Math.sin(alpha)) + ((yval - y) * Math.cos(alpha))) + y;
		return null;
	}
	/**
	 * the visit method for points
	 * 
	 * @param circle the Circle object
	 * @param o        the info got from the caller
	 * @return the info for the receiver
	 */
	
	@Override
	public Object visitCircle(Circle circle, Object o) {
		double cxval = circle.center.x;
		double cyval = circle.center.y;
		circle.center.x = (((cxval - x)*Math.cos(alpha)) - ((cyval - y) * Math.sin(alpha))) + x;
		circle.center.y = (((cxval - x)*Math.sin(alpha)) + ((cyval - y) * Math.cos(alpha))) + y;
		for(int i=0; i< circle.points.size();i++) {
			Point2D point = circle.points.get(i);
			double xval = point.x;
			double yval = point.y;
			point.x = (((xval - x)*Math.cos(alpha)) - ((yval - y) * Math.sin(alpha))) + x;
			point.y = (((xval - x)*Math.sin(alpha)) + ((yval - y) * Math.cos(alpha))) + y;
			}
		return null;
	}
	/**
	 * the visit method for points
	 * 
	 * @param ellipse the Ellipse object
	 * @param o        the info got from the caller
	 * @return the info for the receiver
	 */
	@Override
	public Object visitEllipse(Ellipse ellipse, Object o) {
		double cxval = ellipse.center.x;
		double cyval = ellipse.center.y;
		ellipse.center.x = (((cxval - x)*Math.cos(alpha)) - ((cyval - y) * Math.sin(alpha))) + x;
		ellipse.center.y = (((cxval - x)*Math.sin(alpha)) + ((cyval - y) * Math.cos(alpha))) + y;
		for(int i=0; i< ellipse.points.size();i++) {
			Point2D point = ellipse.points.get(i);
			double xval = point.x;
			double yval = point.y;
			point.x = (((xval - x)*Math.cos(alpha)) - ((yval - y) * Math.sin(alpha))) + x;
			point.y = (((xval - x)*Math.sin(alpha)) + ((yval - y) * Math.cos(alpha))) + y;
			}
		return null;
	}

}
