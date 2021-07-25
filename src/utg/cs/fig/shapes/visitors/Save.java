/**
 * @file Save.java
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
 * The save visitor
 */
public class Save extends ShapeVisitor {
	/**
	 * The constructor
	   * @param fig  the current figure
	   */
	public Save(Figure fig) {
		super(fig);
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
		String result = "2 " + line.thickness + " " + line.color + " " + line.fill + " 2 ";
		String pointer = line.from.x + " " + line.from.y + " " + line.to.x + " " + line.to.y + "\n";
		result = result + pointer;
		return result;
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
		String result = "2 " + polyline.thickness + " " + polyline.color + " " + polyline.fill +  " " + polyline.points.size() +" ";
		String pointer = "";
		for(int i=0; i< polyline.points.size();i++) {
			Point2D point = polyline.points.get(i);
			pointer = pointer + point.x + " " + point.y + " ";	
			}
		result = result + pointer + "\n";
		return result;
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
		return "4 " + text.thickness + " " + text.color + " " + text.fill + " " + text.coord.x + " " + text.coord.y + " " + text.message +" $$$$\n";
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
		String result = "1 3 " +  circle.thickness + " " + circle.color + " " + circle.fill + " " + circle.center.x + " " + circle.center.y + " "+
		circle.radius + " " + circle.radius+"\n";
		return result;
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
		String result = "1 3 " +  ellipse.thickness + " " + ellipse.color + " " + ellipse.fill + " " + ellipse.center.x + " " + ellipse.center.y + " "+
		ellipse.xradius + " " + ellipse.yradius+"\n";
		return result;
	}


}
