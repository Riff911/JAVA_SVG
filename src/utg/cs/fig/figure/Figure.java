/**
 * @file Figure.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.figure;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import utg.cs.fig.function.RVF;
import utg.cs.fig.shapes.*;
import utg.cs.fig.shapes.visitors.*;
import utg.cs.fig.utils.Point2D;

/**
 * The Figure class
 */
public class Figure implements FigDefaultValues {
  /**
   * the width of the canvas
   */
  public double width;
  /**
   * the height of the canvas
   */
  public double height;

/**
   * the resolution of the figure
   */
  public static double resolution;

  /**
   * the thickness of the pen
   */
  public static double thickness;

  /**
   * the color of the pen
   */
  public static String color;

  /**
   * the fill color of the shape
   */
  public static String fill;

  /**
   * the shapes contained in the figure
   */
  public Vector<Shape> shapes = new Vector<Shape>();

  /**
   * The constructor
   * @param width  the width of the canvas
   * @param height the height of the canvas
   */
  public Figure(double width, double height) {
    this.width = width;
    this.height = height;
    resolution = FigDefaultValues.RESOLUTION;
    color = FigDefaultValues.COLOR;
    fill = FigDefaultValues.FILL;
    thickness = FigDefaultValues.THICKNESS;
  }

  /**
   * sets the resolution of the figure
   *
   * @param r the resolution
   */
  public static void setResolution(double r) {
    resolution = r;
  }
  /**
   * sets the width of the figure
   *
   * @param width the width
   */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	   * sets the height of the figure
	   *
	   * @param height the height
	   */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	   * sets the thickness of the shapes in the figure
	   *
	   * @param thickness the thickness
	   */
	public static void setThickness(double thickness) {
		Figure.thickness = thickness;
	}
	/**
	   * sets the color of the shapes in the figure
	   *
	   * @param color the color
	   */
	public static void setColor(String color) {
		Figure.color = color;
	}
	/**
	   * sets the fill of the shapes in the figure
	   *
	   * @param fill the fill
	   */
	public static void setFill(String fill) {
		Figure.fill = fill;
	}
	/**
	   * gets the resolution of the figure
	   *
	   * @return resolution the resolution
	   */
	public static double getResolution() {
		return resolution;
	}

  /**
   * adds a line to the figure
   *
   * @param line the polyline to add
   */
  public void addLine(Line line) {
    shapes.add(line);
    
  }

  /**
   * adds a polyline to the figure
   *
   * @param polyline the polyline to add
   */
  public void addPolyline(Polyline polyline) {
    shapes.add(polyline);
  }

  /**
   * adds a text element to a figure
   *
   * @param text the text to add
   */
  public void addText(Text text) {
    shapes.add(text);
  }
  /**
   * adds a circle element to a figure
   *
   * @param circle the circle to add
   */
  public void addCircle(Circle circle) {
    shapes.add(circle);
  }
  /**
   * Adds an ellipse element to a figure
   *
   * @param ellipse the ellipse to add
   */
  public void addEllipse(Ellipse ellipse) {
    shapes.add(ellipse);
  }
  /**
   * Adds a tree element to a figure
   *
   * @param tree the tree to add
   */
  public void addBinaryTree(Tree tree) {
	  tree.traverseTree(tree.rootNode);
  }

  public void drawFunction(RVF rvf, double startX, double endX) {
  }

  /**
   * translates the figure using the vector (x,y)
   *
   * @param x the x translation factor
   * @param y the y translation factor
   */
  public void translate(double x, double y) {
	  Translate translator = new Translate(this,x,y);
	  for(int i=0;i<shapes.size();i++) {
		  Shape shape = shapes.get(i);
		  shape.accept(translator,shape);
	  }
  }


  /**
   * scales the figure using the vector (x,y)
   *
   * @param x the x scaling factor
   * @param y the y scaling factor
   */
  public void scale(double x, double y) {
	  Scale scaler = new Scale(this,x,y);
	  for(int i=0;i<shapes.size();i++) {
		  Shape shape = shapes.get(i);
		  shape.accept(scaler,shape);
	  }
  }
  /**
   * rotates the figure with center (x,y) and angle a
   *
   * @param x the x rotation center
   * @param y the y rotatioin center
   * @param a the rotation angle
   */
  public void rotate(double x, double y, double a) {
	  Rotate rotater = new Rotate(this,x,y,a);
	  for(int i=0;i<shapes.size();i++) {
		  Shape shape = shapes.get(i);
		  shape.accept(rotater,shape);
	  }
  }
  /**
   * clips the figure according to the clipping rectangle bl tr
   *
   * @param bl the bottom left point
   * @param tr the top right point
   */
  public  void clip(Point2D bl, Point2D tr) {
	  Clip clipper = new Clip(this,bl,tr);
	  for(int i=0;i<shapes.size();i++) {
		  Shape shape = shapes.get(i);
		  shape.accept(clipper,shape);
	  }
  }


  /**
   * exports the figure to SVG
   *
   * @param name the file name
   */
  public void exportSVG(String name) {
    try {
      PrintWriter writer = new PrintWriter(name);
      ExportSVG sv = new ExportSVG(this);
      String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
      header += String.format(
        "<svg width=\"%.2f\" height=\"%.2f\" "
          + "xmlns=\"http://www.w3.org/2000/svg\">\n",
        width, height);
      writer.write(header);
      for (Shape shape : shapes) {
        writer.write((String) shape.accept(sv, null));
      }
      writer.write("</svg>\n");
      writer.flush();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  /**
   * saves the figure in internal format
   *
   * @param name the file name
   */
  public  void save(String name) {
	  try {
	      PrintWriter writer = new PrintWriter(name);
	      Save sv = new Save(this);
	      String header = "JFIG 0.1\n";
	      header += String.format(width + " " + height + " " + resolution + "\n");
	      writer.write(header);
	      for (Shape shape : shapes) {
	        writer.write((String) shape.accept(sv, null));
	      }
	      writer.flush();
	      writer.close();
	    }
	  catch (Exception e) {
	      e.printStackTrace();
	    }
  }

  /**
   * builds the figure in internal format
   *
   * @param name the file name
   * @return fig the figure
   */
public  static Figure open(String name) {
	  Figure fig = null;
	  try {
		  File file = new File(name);
		  Scanner in = new Scanner(file);
		  in.next();
		  in.next();
		  double width = in.nextDouble();
		  double height = in.nextDouble();
		  double resolution = in.nextDouble();
		  fig.setResolution(resolution);
		  fig = new Figure(width,height);
		  while(in.hasNext()) {
		  int shape = in.nextInt();
		  double thickness;
		  String color;
		  String fill;
		  if(shape == 2) {
		  thickness = in.nextDouble();
		  color = in.next();
		  fill = in.next();
		  int number_of_points = in.nextInt();
		  Point2D[] points = new Point2D[number_of_points];
		  for(int i = 0; i < number_of_points; i++) {
			  double xcoord = in.nextDouble();
			  double ycoord = in.nextDouble();
			  points[i] = new Point2D(xcoord,ycoord);
		  }
		  fig.addPolyline(new Polyline(fig,color,fill,thickness,points));
		  }
		  else if(shape == 1) {
			in.next();
			thickness = in.nextDouble();
			color = in.next();
			fill = in.next();
			double xcoord = in.nextDouble();
			double ycoord = in.nextDouble();
			double xradius = in.nextDouble();
			double yradius = in.nextDouble();
			fig.addEllipse(new Ellipse(fig,color,fill,thickness,new Point2D(xcoord,ycoord),xradius,yradius));
		  }
		  else {
		  thickness = in.nextDouble();
		  color = in.next();
		  fill = in.next();
		  fig.setColor(color);
		  fig.setThickness(thickness);
		  fig.setFill(fill);
		  double xcoord = in.nextDouble();
		  double ycoord = in.nextDouble();
		  Point2D basepoint = new Point2D(xcoord,ycoord);
		  StringBuilder build = new StringBuilder();
		  while(in.hasNext()) {
		  String data = in.next();
		  if (data.compareTo("$$$$")!=0)
		  build.append(data + " ");
		  else
		  break;
		  } 
		  fig.addText(new Text(fig, basepoint, build.toString().trim()));
		  }
		  }
		  in.close();
	  }
	  catch (Exception e) {
	      e.printStackTrace();
	    }
	return fig;
	  
  }
  /**
   * overrides the tostring method
   *
   * @return result the string representation of the figure
   */
  @Override
  public String toString() {
    String result = String.format("figure w %.2f h %.2f r %.2f\n", width,
      height, resolution);
    for (Shape shape : shapes) {
      result += "  " + shape + "\n";
    }
    return result;
  }
}
