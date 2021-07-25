/**
 * @file Scale.java
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
 *The Scale visitor
 */
public class Scale extends ShapeVisitor {
	/**
	   * the x scale factor
	   */
	public double x;
	/**
	   * the y scale factor
	   */
	public double y;
	/**
	 * The constructor
	   * @param fig  the current figure
	   * @param x the x scale factor
	   * @param y the y scale factor
	   */
	public Scale(Figure fig,double x,double y) {
		super(fig);
		this.x = x;
		this.y = y;
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
		line.from.x *= x;
		line.from.y *= y;
		line.to.x *= x;
		line.to.y *= y;
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
			point.x *= x;
			point.y *= y;
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
		text.coord.x *= x;
		text.coord.y *= y;
		text.xscale =  x;
		text.yscale = y;
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
		circle.center.x *= x;
		circle.center.y *= y;
		for(int i=0; i< circle.points.size();i++) {
			Point2D point = circle.points.get(i);
			point.x *= x;
			point.y *= y;
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
		ellipse.center.x *= x;
		ellipse.center.y *= y;
		for(int i=0; i< ellipse.points.size();i++) {
			Point2D point = ellipse.points.get(i);
			point.x *= x;
			point.y *= y;
			}
		return null;
	}

}
