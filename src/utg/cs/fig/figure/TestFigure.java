package utg.cs.fig.figure;

import utg.cs.fig.shapes.Circle;
import utg.cs.fig.shapes.Ellipse;
import utg.cs.fig.shapes.Line;
import utg.cs.fig.shapes.Node;
import utg.cs.fig.shapes.Polyline;
import utg.cs.fig.shapes.Text;
import utg.cs.fig.shapes.Tree;
import utg.cs.fig.shapes.fractals.Fractals;
import utg.cs.fig.utils.Point2D;

public class TestFigure {
//
//  public static void main(String [] args) {
//    Figure fig = new Figure(500,500);
//    fig.setColor("red");
//    fig.setFill("#FF00FF");
//    fig.setThickness(1);

//    fig.addCircle(new Circle(fig,"green","blue",3,new Point2D(100,100),60));
//    fig.addEllipse(new Ellipse(fig,new Point2D(100,100),60,40));
//    fig.addPolyline(new Polyline(fig,new Point2D(50,50),new Point2D(50,150),new Point2D(150,150),new Point2D(150,50),new Point2D(50,50)));    

//    fig.addLine(new Line(fig,"blue",3,new Point2D(150,30),new Point2D(50,150)));
//    fig.addText(new Text(fig,new Point2D(130,70),"Sheriff"));
    //fig.translate(150, 150);
    //fig.scale(2, 2);
    //fig.rotate(200, 200, 180);
    //fig.clip(new Point2D(50,50), new Point2D(150,150));
//    Figure fig2 = fig.open("lined.fig");
//    System.out.println(fig);
//    fig2.exportSVG("sample.svg");
 // }
	 public static void main(String[] args) throws CloneNotSupportedException {
		    Figure fig = new Figure(1000.00, 1000.00);
		    fig.setFill("red");
		    Polyline p = new Polyline(fig,new Point2D(55.00,44.00), new Point2D(77.00, 22.00), new Point2D(99.00, 0.00));
		    fig.setColor("blue");
		    fig.setThickness(0.50);
		    fig.addPolyline(p);
		    Text text = new Text(fig,new Point2D(50.00, 47.00), "this_is_a_test");
		    fig.addText(text);
		    fig.exportSVG("test01.svg");
		    System.out.print(fig);
		    fig.translate(0.00, -3.00);
		    System.out.print(fig);
		    fig.scale(0.00, 2.00);
		    System.out.print(fig);
		    fig.rotate(51.00, 49.00, 45);
		    System.out.print(fig);
		    fig.rotate(51.00, 49.00, 60);
		    fig.addEllipse(new Ellipse(fig,new Point2D(0,0),20, 10));
		    fig.exportSVG("test02.svg");
		    System.out.print(fig);
		    fig.rotate(51.00, 49.00, -60);
		    System.out.print(fig);
		    fig = new Figure(100.00, 100.00);
		    p = new Polyline(fig,new Point2D(10.00, 50.00), new Point2D(50.00, 10.00), new Point2D(90.00, 50.00), new Point2D(50.00, 90.00),
		    		new Point2D(10.00, 50.00));
		    fig.addPolyline(p);
		    p = new Polyline(fig,new Point2D(0.00, 42.50), new Point2D(100.00, 42.50));
		    fig.addPolyline(p);
		    p = new Polyline(fig,new Point2D(0.00, 52.50), new Point2D(100.00, 52.50));
		    fig.addPolyline(p);
		    fig.addText(new Text(fig,new Point2D(50.0, 50.0), "the pqrst world"));
		    System.out.print(fig);
		    // clipping
		    fig.exportSVG("clip01.svg");
		    Point2D bl = new Point2D(10.00, 30.00);
		    Point2D tr = new Point2D(90.00, 70.00);
		    fig.clip(bl, tr);
		    fig.exportSVG("clip02.svg");
		    System.out.print(fig);
		    fig.save("clip02.jfig");
		    System.out.print(fig);
		    fig = Figure.open("clip02.jfig");
		    System.out.print(fig);
		    bl = new Point2D(0.00, 0.00);
		    tr = new Point2D(0.00, 100.00);
		    fig.clip(bl, tr);
		    System.out.print(fig);
		    fig.exportSVG("square.svg");
		    // koch snowflake
		    fig = new Figure(100.00, 100.00);
		    Fractals.addKockSnowflake(fig, new Point2D(50,50), 50, 0);
		    System.out.print(fig);
		    fig.exportSVG("koch0.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addKockSnowflake(fig, new Point2D(50,50), 50, 1);
		    System.out.print(fig);
		    fig.exportSVG("koch1.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addKockSnowflake(fig, new Point2D(50,50), 50, 2);
		    System.out.print(fig);
		    fig.exportSVG("koch2.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addKockAntiSnowflake(fig, new Point2D(50,50), 50, 0);
		    System.out.print(fig);
		    // koch anti-snowflake
		    fig = new Figure(100.00, 100.00);
		    Fractals.addKockAntiSnowflake(fig, new Point2D(50,50), 50, 0);
		    System.out.print(fig);
		    fig.exportSVG("akoch0.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addKockAntiSnowflake(fig, new Point2D(50,50), 50, 1);
		    System.out.print(fig);
		    fig.exportSVG("akoch1.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addKockAntiSnowflake(fig, new Point2D(50,50), 50, 2);
		    System.out.print(fig);
		    fig.exportSVG("akoch2.svg");
		 // Partial Square
		    fig = new Figure(100.00, 100.00);
		    Fractals.addPartialSquareKock(fig, new Point2D(50,50), 50, 0);
		    System.out.print(fig);
		    fig.exportSVG("partialsquare0.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addPartialSquareKock(fig, new Point2D(50,50), 50, 1);
		    System.out.print(fig);
		    fig.exportSVG("partialsquare1.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addPartialSquareKock(fig, new Point2D(50,50), 50, 2);
		    System.out.print(fig);
		    fig.exportSVG("partialsquare2.svg");
		 // Internal Square
		    fig = new Figure(100.00, 100.00);
		    Fractals.addInternalSquareKock(fig, new Point2D(50,50), 50, 0);
		    System.out.print(fig);
		    fig.exportSVG("internalsquare0.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addInternalSquareKock(fig, new Point2D(50,50), 50, 1);
		    System.out.print(fig);
		    fig.exportSVG("internalsquare1.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addInternalSquareKock(fig, new Point2D(50,50), 50, 2);
		    System.out.print(fig);
		    fig.exportSVG("internalsquare2.svg");
		 // Sierpinski triangle
		    fig = new Figure(100.00, 100.00);
		    Fractals.addSierpinskiTriangle(fig, new Point2D(50,50), 50, 0);
		    System.out.print(fig);
		    fig.exportSVG("sierpinski0.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addSierpinskiTriangle(fig, new Point2D(50,50), 50, 1);
		    System.out.print(fig);
		    fig.exportSVG("siepinski1.svg");
		    fig = new Figure(100.00, 100.00);
		    Fractals.addSierpinskiTriangle(fig, new Point2D(50,50), 50, 2);
		    System.out.print(fig);
		    fig.exportSVG("siepinski2.svg");
		    // Fractal Tree
		    fig = new Figure(300.00, 300.00);
		    Fractals.addFTree(fig, new Point2D(150,250), 50,3, 2);
		    System.out.print(fig);
		    fig.exportSVG("fractaltree0.svg");
		    fig = new Figure(300.00, 300.00);
		    Fractals.addFTree(fig, new Point2D(150,250),50,3, 4);
		    System.out.print(fig);
		    fig.exportSVG("fractaltree1.svg");
		    fig = new Figure(300.00, 300.00);
		    Fractals.addFTree(fig, new Point2D(150,250), 50,3, 6);
		    System.out.print(fig);
		    fig.exportSVG("fractaltree2.svg");
		 // Asymmetric Fractal Tree
		    fig = new Figure(300.00, 300.00);
		    Fractals.addAFTree(fig, new Point2D(150,250), 50,3, 2);
		    System.out.print(fig);
		    fig.exportSVG("asymfractaltree0.svg");
		    fig = new Figure(300.00, 300.00);
		    Fractals.addAFTree(fig, new Point2D(150,250), 50,3, 4);
		    System.out.print(fig);
		    fig.exportSVG("asymfractaltree1.svg");
		    fig = new Figure(300.00, 300.00);
		    Fractals.addAFTree(fig, new Point2D(150,250), 50,3, 6);
		    System.out.print(fig);
		    fig.exportSVG("asymfractaltree2.svg");
		    //	    
		    //Binary Tree
		    fig = new Figure(300.00, 300.00);
		    Node root = new Node("23",new Point2D(150,50));
		    Node rl = new Node("13",new Point2D(100,100));
		    Node rr = new Node("26",new Point2D(200,100));
		    Node rll = new Node("3",new Point2D(50,150));
		    Node rrr = new Node("16",new Point2D(250,150));
		    root.addLeft(rl);
		    root.addRight(rr);
		    rl.addLeft(rll);
		    rr.addRight(rrr);
		    fig.addBinaryTree(new Tree(fig,root));
		    System.out.print(fig);
		    fig.exportSVG("tree.svg");
		  }
}
