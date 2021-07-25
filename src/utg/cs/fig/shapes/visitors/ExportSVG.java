/**
 * @file ExportSVG.java
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
 *The SVG export visitor
 */
public class ExportSVG extends ShapeVisitor {
	/**
	 * The constructor
	   * @param fig  the current figure
	   */
  public ExportSVG(Figure fig) {
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
	  
	  return "  <polyline points=\"" + line.from + " " + line.to + "\" " +
			  "stroke=\""+ line.color + "\" stroke-width=\"" + line.thickness + "\" fill=\"" + line.fill + "\" />\n";
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
	  String result ="";
		for(int i=0; i< polyline.points.size();i++) {
		Point2D point = polyline.points.get(i);
		result = result + point +" ";	
		}
	  return "  <polyline points=\"" + result + "\" " +
	  		 "stroke=\""+ polyline.color + "\" stroke-width=\"" + polyline.thickness + "\" fill=\"" + polyline.fill + "\" />\n";
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
	  return "  <text x=\"" + text.coord.x + "\" y=\"" + text.coord.y + "\" " + "textLength = \"" + ((text.message.length()+40)*text.xscale) +
			  "\" lengthAdjust=\"spacingAndGlyphs\" font-size=\"" + (25*text.yscale) +"\" text-anchor=\"start\"" + " transform=\"rotate(" +
			  text.rotateangle + " " +  text.coord + ")\"  stroke=\""+ text.color + "\"  stroke-width=\"" + text.thickness + "\" fill=\"" + 
			  text.fill + "\" clip-path=\"url(#clip1)\">"+text.message+ "</text>\n"+
			  " <clipPath id=\"clip1\">\n <rect x=\""+ text.ctlc.x +"\" y=\""+ text.ctlc.y +"\" width=\""+text.clipwidth+"\" height=\""+text.clipheight+"\"/>\n</clipPath>\n";
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
	 String result ="";
		for(int i=0; i < circle.points.size();i++) {
		Point2D point = circle.points.get(i);
		result = result + point + " ";	
		}
		return "  <polyline points=\"" + result + "\" " +"stroke=\""+ circle.color +
			"\" stroke-width=\"" + circle.thickness + "\" fill=\"" + circle.fill + "\" />\n";
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
	String result ="";
	for(int i=0; i < ellipse.points.size();i++) {
		Point2D point = ellipse.points.get(i);
		result = result + point + " ";	
		}
		return "  <polyline points=\"" + result + "\" " +"stroke=\""+ ellipse.color + "\" stroke-width=\"" +
				ellipse.thickness + "\" fill=\"" + ellipse.fill + "\" />\n";
}


}
