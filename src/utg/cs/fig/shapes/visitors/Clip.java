/**
 * @file Clip.java
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
 * The Clip visitor
 */
public class Clip extends ShapeVisitor {
	public Point2D bl;
	public Point2D tr;

	/**
	 * The constructor
	 * @param fig  the current figure
	 * @param bl the bottom left corner of the clipping window
	 * @param tr the top right corner of the clipping window
	 */
	public Clip(Figure fig,Point2D bl, Point2D tr) {
		super(fig);
		this.bl = bl;
		this.tr = tr;
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
		double xMin,xMax,yMin,yMax;
		xMin = bl.x;
		xMax = tr.x;
		yMin = bl.y;
		yMax = tr.y;
		double u1 = 0, u2 = 1;
		double x0 = line.from.x, y0 = line.from.y, x1 = line.to.x, y1 = line.to.y;
		double dx = x1 - x0, dy = y1 - y0;
		double p[] = {-dx, dx, -dy, dy};
		double q[] = {x0 - xMin, xMax - x0, y0 - yMin, yMax - y0};
		boolean done = true;
		for (int i = 0; i < 4; i++) {
		if (p[i] == 0) {
			if (q[i] < 0) {
				done = false;
				line.from.x = 0;
				line.from.y = 0;
				line.to.x = 0;
				line.to.y = 0;
			}
		}
		else {
		double u = (double) q[i] / p[i];
			if (p[i] < 0) {
			u1 = Math.max(u, u1);
			} else {
			u2 = Math.min(u, u2);
			}
		}
		}
		if (u1 > u2) {
			done = false;
			line.from.x = 0;
			line.from.y = 0;
			line.to.x = 0;
			line.to.y = 0;
		}
		if(done) {
		int nx0, ny0, nx1, ny1;
		nx0 = (int) (x0 + u1 * dx);
		ny0 = (int) (y0 + u1 * dy);
		nx1 = (int) (x0 + u2 * dx);
		ny1 = (int) (y0 + u2 * dy);
		line.from.x = nx0;
		line.from.y = ny0;
		line.to.x = nx1;
		line.to.y = ny1;
		}
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
		
		for(int j=0; j < polyline.points.size()-1;j++) {
			int first = j;
			double xMin,xMax,yMin,yMax;
			xMin = bl.x;
			xMax = tr.x;
			yMin = bl.y;
			yMax = tr.y;
			double u1 = 0, u2 = 1;
			double  x0 = polyline.points.get(first).x, y0 = polyline.points.get(first).y,
					x1 = polyline.points.get(first+1).x, y1 = polyline.points.get(first+1).y;
			double dx = x1 - x0, dy = y1 - y0;
			double p[] = {-dx, dx, -dy, dy};
			double q[] = {x0 - xMin, xMax - x0, y0 - yMin, yMax - y0};
			for (int i = 0; i < 4; i++) {
				if (p[i] == 0) {
					if (q[i] < 0) {
						continue;
					}
				} 
				else {
				double u = (double) q[i] / p[i];
					if (p[i] < 0) {
					u1 = Math.max(u, u1);
					} 
					else {
					u2 = Math.min(u, u2);
					}
				}
				}
				if (u1 > u2) {
					continue;
				}
				int nx0, ny0, nx1, ny1;
				nx0 = (int) (x0 + u1 * dx);
				ny0 = (int) (y0 + u1 * dy);
				nx1 = (int) (x0 + u2 * dx);
				ny1 = (int) (y0 + u2 * dy);
				fig.addLine(new Line(fig,polyline.color,polyline.thickness,new Point2D(nx0,ny0),new Point2D(nx1,ny1)));
			}
			polyline.points.removeAllElements();
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
		text.ctlc.x = bl.x;
		text.ctlc.y = bl.y;
		text.clipwidth = tr.x-bl.x;
		text.clipheight = tr.y-bl.y;
		return text;
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
		double xMin,xMax,yMin,yMax;
		xMin = bl.x;
		xMax = tr.x;
		yMin = bl.y;
		yMax = tr.y;
		for(int j=0; j < circle.points.size()-1;j++) {
			double u1 = 0, u2 = 1;
			int first = j;
			double  x0 = circle.points.get(first).x, y0 = circle.points.get(first).y,
					x1 = circle.points.get(first+1).x, y1 = circle.points.get(first+1).y;
			double dx = x1 - x0, dy = y1 - y0;
			double p[] = {-dx, dx, -dy, dy};
			double q[] = {x0 - xMin, xMax - x0, y0 - yMin, yMax - y0};
			for (int i = 0; i < 4; i++) {
			if (p[i] == 0) {
				if (q[i] < 0) {
					continue;
				}
			} 
			else {
			double u = (double) q[i] / p[i];
				if (p[i] < 0) {
				u1 = Math.max(u, u1);
				} 
				else {
				u2 = Math.min(u, u2);
				}
			}
			}
			if (u1 > u2) {
				continue;
			}
			int nx0, ny0, nx1, ny1;
			nx0 = (int) (x0 + u1 * dx);
			ny0 = (int) (y0 + u1 * dy);
			nx1 = (int) (x0 + u2 * dx);
			ny1 = (int) (y0 + u2 * dy);
			fig.addPolyline(new Polyline(fig,circle.color,circle.fill,circle.thickness,new Point2D(nx0,ny0),new Point2D(nx1,ny1)));
		}
		circle.points.removeAllElements();
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
		double xMin,xMax,yMin,yMax;
		xMin = bl.x;
		xMax = tr.x;
		yMin = bl.y;
		yMax = tr.y;
		for(int j=0; j < ellipse.points.size()-1;j++) {
			double u1 = 0, u2 = 1;
			int first = j;
			double  x0 = ellipse.points.get(first).x, y0 = ellipse.points.get(first).y,
					x1 = ellipse.points.get(first+1).x, y1 = ellipse.points.get(first+1).y;
			double dx = x1 - x0, dy = y1 - y0;
			double p[] = {-dx, dx, -dy, dy};
			double q[] = {x0 - xMin, xMax - x0, y0 - yMin, yMax - y0};
			for (int i = 0; i < 4; i++) {
			if (p[i] == 0) {
			if (q[i] < 0) {
				continue;
			}
			} else {
			double u = (double) q[i] / p[i];
			if (p[i] < 0) {
			u1 = Math.max(u, u1);
			} else {
			u2 = Math.min(u, u2);
			}
			}
			}
			if (u1 > u2) {
				continue;
			}
			int nx0, ny0, nx1, ny1;
			nx0 = (int) (x0 + u1 * dx);
			ny0 = (int) (y0 + u1 * dy);
			nx1 = (int) (x0 + u2 * dx);
			ny1 = (int) (y0 + u2 * dy);
			fig.addPolyline(new Polyline(fig,ellipse.color,ellipse.fill,ellipse.thickness,new Point2D(nx0,ny0),new Point2D(nx1,ny1)));
		}
		ellipse.points.removeAllElements();
		return null;
	}

	
}
