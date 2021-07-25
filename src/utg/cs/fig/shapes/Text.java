/**
 * @file Text.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.visitors.ShapeVisitor;
import utg.cs.fig.utils.Point2D;

/**
 * The Text class
 */
public class Text extends Shape{
	/**
	   * the coordinate of the base point of the line
	   */
	public Point2D coord;
	/**
	   * the message string
	   */
	public String message;
	/**
	   * the scale factor along the x axis
	   */
	public double xscale;
	/**
	   * the scale factor along the y axis
	   */
	public double yscale;
	/**
	   * the width of the clipping window
	   */
	public double clipwidth;
	/**
	   * the height of the clipping window
	   */
	public double clipheight;
	/**
	   * the rotation angle of the text
	   */
	public double rotateangle;
	/**
	   * the coordinate of the top left corner of the clipping window
	   */
	public Point2D ctlc;
	
	/**
	 * The simple constructor
	 * @param fig the figure the text is belonging to
	 * @param p the coordinate of the base point of the text
	 * @param mess the message string
	 */
	public Text(Figure fig,Point2D p,String mess) {
		super(fig);
		this.color = fig.color;
		this.thickness = fig.thickness;
		this.fill = fig.fill;
		coord = p;
		message = mess;
		xscale = 1;
		yscale = 1;
		rotateangle = 0;
		clipheight = fig.height;
		clipwidth = fig.width;
		ctlc = new Point2D(0,0);
	}
	/**
	 * The complex constructor
	 * @param fig the figure the text is belonging to
	 * @param color the color of the text
	 * @param thickness the thickness of the text
	 * @param p the coordinate of the base point of the text
	 * @param mess the message string
	 */
	public Text(Figure fig,String color,double thickness,Point2D p,String mess) {
		super(fig);
		this.color = color;
		this.thickness = thickness;
		this.fill = fig.fill;
		coord = p;
		message = mess;
		xscale = 1;
		yscale = 1;
		rotateangle = 0;
		clipheight = fig.height;
		clipwidth = fig.width;
		ctlc = new Point2D(0,0);
	}
	/**
	   * Sets the color of the text
	   *
	   * @param c the color of the pen
	   */
	public void setColor(String c) {
		this.color = c;
	}
	/**
	   * Sets the fill of the text
	   *
	   * @param f the fill
	   */
	public void setFill(String f) {
		this.fill = f;
	}
	/**
	   * Sets the thickness of the text
	   *
	   * @param t the thickness of the pen
	   */
	public void setThickness(double t) {
		this.thickness = t;
	}
	/**
	 * overrides the clone method
	 *
	 * @return a clone of the text
	 */
	@Override
	public Object clone(){
		return new Text(this.fig,this.color,this.thickness,this.coord,this.message);
	}
	/**
	   * overrides the tostring method
	   *
	   * @return result the string representation of the ellipse
	   */
	@Override
	public String toString() {
		String result = "Text c "+ color +" f " + fill + " t " + thickness + " basepoint  " + coord + " Message  " + message + " Cliprect " + ctlc;
		return result;
	}
	/**
	 * Overrides the shape accept method
	 * @param shapeVisitor the shapeVisitor
	 * @param o            the info transmitted by the caller
	 * @return the info the shapeVisitor is returning
	 */
	@Override
	public Object accept(ShapeVisitor shapeVisitor, Object o) {
		return shapeVisitor.visitText(this, o);
	}
}
