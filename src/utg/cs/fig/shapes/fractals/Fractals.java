/**
 * @file Fractals.java
 * @author sheriff
 * @date 10 July 2020
 */
package utg.cs.fig.shapes.fractals;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import utg.cs.fig.figure.Figure;
import utg.cs.fig.shapes.Polyline;
import utg.cs.fig.utils.Point2D;
/**
 * The Fractals class
 */
public class Fractals {
	/**
	 * Calculates the points of the triangle
	 * @param c the center of the triangle
	 * @param r the length of the side
	 * @param pOne the first point on the triangle
	 * @param pTwo the second point on the triangle
	 * @param pThree the third point on the triangle
	 */	
	public static void triangle(Point2D c,int r,Point2D pOne, Point2D pTwo, Point2D pThree) {
		pOne.x = c.x - (double) r/2;
		pOne.y = c.y + Math.sqrt(3) * r/2;
		pTwo.x = c.x + r;
		pTwo.y = c.y;
		pThree.x = c.x - (double) r/2;
		pThree.y = c.y - Math.sqrt(3) * r/2;
	}
	/**
	 * Calculates the points on each side of the Sierpinski triangle
	 * @param fig the current figure
	 * @param lev the number of iterations
	 * @param pOne the first point on the triangle
	 * @param pTwo the second point on the triangle
	 * @param pThree the third point on the triangle
	 */
	private static void addSierpinski(Figure fig,int lev, Point2D pOne, Point2D pTwo, Point2D pThree){
		if (lev > 0){
		Point2D pA = new Point2D(pOne.x + (pTwo.x-pOne.x) /2,pOne.y + (pTwo.y-pOne.y)/2);
		Point2D pB = new Point2D(pOne.x + (pThree.x-pOne.x) /2,pOne.y + (pThree.y-pOne.y)/2);
		Point2D pC = new Point2D(pTwo.x + (pThree.x-pTwo.x) /2,pTwo.y + (pThree.y-pTwo.y)/2);
		
		addSierpinski(fig, lev - 1, pOne, pA, pB);
		addSierpinski(fig, lev - 1, pB, pC, pThree);	
		addSierpinski(fig, lev - 1, pA, pTwo, pC);
		}
		else{
			fig.addPolyline(new Polyline(fig,pOne,pTwo,pThree,pOne));
		}
	}
	/**
	 * Passes the points of the triangle to draw the Sierinski Triangle
	 * @param fig the current figure
	 * @param center the center of the triangle
	 * @param length the length of the sides of the triangle
	 * @param iterations the number of iterations
	 */
	public static void addSierpinskiTriangle(Figure fig,Point2D center,int length,int iterations) {
		Point2D pOne = new Point2D(0,0);
		Point2D pTwo = new Point2D(0,0);
		Point2D pThree = new Point2D(0,0);
		
		triangle(center,length,pOne,pTwo,pThree);
		
		addSierpinski(fig, iterations, pOne, pTwo, pThree);
	}
	/**
	 * Calculates the points of the Koch line
	 * @param fig the current figure
	 * @param lev the number of iterations
	 * @param pOne the beginning point of the line
	 * @param pTwo the end point of the line
	 */
	private static void addKochLine(Figure fig,int lev, Point2D pOne, Point2D pTwo){
		if (lev > 0){
			Point2D pA = new Point2D(pOne.x + (pTwo.x-pOne.x) /3,pOne.y + (pTwo.y-pOne.y)/3);
			double sin60 = 0.866025403784438646763723170752936183471402626905190;
			Point2D pTip = new Point2D(pA.x + (int)((pTwo.x-pOne.x)/3* 0.5 + (pTwo.y-pOne.y)/3*sin60),pA.y + (int)((pTwo.y-pOne.y)/3* 0.5 - (pTwo.x-pOne.x)/3*sin60));
			Point2D pB = new Point2D(pOne.x + 2 * (pTwo.x - pOne.x)/3,pOne.y + 2 * (pTwo.y - pOne.y)/3);
			
		 addKochLine(fig, lev - 1, pOne, pA);
         addKochLine(fig, lev - 1, pA, pTip);
         addKochLine(fig, lev - 1, pTip, pB);	
         addKochLine(fig, lev - 1, pB, pTwo);	
		}
		else{
			fig.addPolyline(new Polyline(fig,pOne,pTwo));
		}
	}
	/**
	 * Passes the points of the triangle to draw the Koch snowflake
	 * @param fig the current figure
	 * @param center the center of the triangle
	 * @param length the length of the sides of the triangle
	 * @param iterations the number of iterations
	 */
	public static void addKockSnowflake(Figure fig,Point2D center,int length,int iterations) {
		Point2D pOne = new Point2D(0,0);
		Point2D pTwo = new Point2D(0,0);
		Point2D pThree = new Point2D(0,0);
		
		triangle(center,length,pOne,pTwo,pThree);
		
		addKochLine(fig, iterations, pOne, pThree);
		addKochLine(fig, iterations, pThree, pTwo);
		addKochLine(fig, iterations, pTwo,pOne);
		
	}
	/**
	 * Passes the points of the triangle to draw the Koch Anti-snowflake
	 * @param fig the current figure
	 * @param center the center of the triangle
	 * @param length the length of the sides of the triangle
	 * @param iterations the number of iterations
	 */
	public static void addKockAntiSnowflake(Figure fig,Point2D center,int length,int iterations) {
		Point2D pOne = new Point2D(0,0);
		Point2D pTwo = new Point2D(0,0);
		Point2D pThree = new Point2D(0,0);
		
		triangle(center,length,pOne,pTwo,pThree);
		
		addKochLine(fig, iterations, pOne, pTwo);
		addKochLine(fig, iterations, pTwo, pThree);
		addKochLine(fig, iterations, pThree,pOne);
		
	}
	/**
	 * Calculates the points of the square
	 * @param c the center of the square
	 * @param r the length of the side
	 * @param pOne the first point on the square
	 * @param pTwo the second point on the square
	 * @param pThree the third point on the square
	 * @param pFour the fourth point on the square
	 */	
	public static void square(Point2D c,int r,Point2D pOne, Point2D pTwo, Point2D pThree, Point2D pFour) {
		pOne.x = c.x - (double) r/2;
		pOne.y = c.y + (double) r/2;
		pTwo.x = c.x + (double) r/2;
		pTwo.y = c.y + (double) r/2;
		pThree.x = c.x + (double) r/2;
		pThree.y = c.y - (double) r/2;
		pFour.x = c.x - (double) r/2;
		pFour.y = c.y - (double) r/2;	
	}
	/**
	 * Calculates the points of the Square Koch line
	 * @param fig the current figure
	 * @param lev the number of iterations
	 * @param pOne the beginning point of the line
	 * @param pTwo the end point of the line
	 */
	private static void addSquareKochLine(Figure fig,int lev, Point2D pOne, Point2D pTwo){
		if (lev > 0){
			Point2D pA = new Point2D(pOne.x + (pTwo.x-pOne.x) /3,pOne.y + (pTwo.y-pOne.y)/3);
			Point2D pD = new Point2D(pOne.x + 2 * (pTwo.x - pOne.x)/3,pOne.y + 2 * (pTwo.y - pOne.y)/3);
			double sin60 = -0.866025403784438646763723170752936183471402626905190;
			Point2D pB = new Point2D(pOne.x + ((pTwo.x-pOne.x)/3 + (pTwo.y-pOne.y)/3*sin60),pOne.y + ((pTwo.y-pOne.y)/3 - (pTwo.x-pOne.x)/3*sin60));
			Point2D pC = new Point2D(pA.x + ((pTwo.x-pOne.x)/3 + (pTwo.y-pOne.y)/3*sin60),pA.y + ((pTwo.y-pOne.y)/3 - (pTwo.x-pOne.x)/3*sin60));
		 addSquareKochLine(fig, lev - 1, pOne, pA);
         addSquareKochLine(fig, lev - 1, pA, pB);
         addSquareKochLine(fig, lev - 1, pB, pC);	
         addSquareKochLine(fig, lev - 1, pC, pD);
         addSquareKochLine(fig, lev - 1, pD, pTwo);
		}
		else{
			fig.addPolyline(new Polyline(fig,pOne,pTwo));
		}
	}
	/**
	 * Calculates the points of the Inverse Square Koch line
	 * @param fig the current figure
	 * @param lev the number of iterations
	 * @param pOne the first point on the square
	 * @param pTwo the second point on the square
	 * @param pThree the third point on the square
	 * @param pFour the fourth point on the square
	 */
	private static void InverseKochLine(Figure fig,int lev, Point2D pOne, Point2D pTwo, Point2D pThree, Point2D pFour){
		if (lev > 0){
			Point2D pA = new Point2D(pOne.x + (pTwo.x-pOne.x) /2,pOne.y + (pTwo.y-pOne.y)/2);
			Point2D pB = new Point2D(pTwo.x + (pThree.x-pTwo.x) /2,pTwo.y + (pThree.y-pTwo.y)/2);
			Point2D pC = new Point2D(pThree.x + (pFour.x-pThree.x) /2,pThree.y + (pFour.y-pThree.y)/2);
			Point2D pD = new Point2D(pFour.x + (pOne.x-pFour.x) /2,pFour.y + (pOne.y-pFour.y)/2);
			
			fig.addPolyline(new Polyline(fig,pOne,pTwo,pThree,pFour,pOne));
			
			InverseKochLine(fig, lev - 1, pA, pB,pC,pD);
		}
		else{
			fig.addPolyline(new Polyline(fig,pOne,pTwo,pThree,pFour,pOne));
		}
	}
	/**
	 * Passes the points of the square to draw the partial square Koch
	 * @param fig the current figure
	 * @param center the center of the square
	 * @param length the length of the sides of the square
	 * @param iterations the number of iterations
	 */
	public static void addPartialSquareKock(Figure fig,Point2D center,int length,int iterations) {
		Point2D pOne = new Point2D(0,0);
		Point2D pTwo = new Point2D(0,0);
		Point2D pThree = new Point2D(0,0);
		Point2D pFour = new Point2D(0,0);
		
		square(center,length,pOne,pTwo,pThree,pFour);
		
		addSquareKochLine(fig, iterations, pOne, pTwo);
		addSquareKochLine(fig, iterations, pTwo, pThree);
		addSquareKochLine(fig, iterations, pThree,pFour);
		addSquareKochLine(fig, iterations, pFour,pOne);
		
	}
	/**
	 * Passes the points of the square to draw the Internal square Koch
	 * @param fig the current figure
	 * @param center the center of the square
	 * @param length the length of the sides of the square
	 * @param iterations the number of iterations
	 */
	public static void addInternalSquareKock(Figure fig,Point2D center,int length,int iterations) {
		Point2D pOne = new Point2D(0,0);
		Point2D pTwo = new Point2D(0,0);
		Point2D pThree = new Point2D(0,0);
		Point2D pFour = new Point2D(0,0);
		
		square(center,length,pOne,pTwo,pThree,pFour);
		
		InverseKochLine(fig, iterations, pOne, pTwo, pThree,pFour);
		
	}
	/**
	 * Calculates the points and draws the branches of the fractal tree line
	 * @param fig the current figure
	 * @param lev the number of iterations
	 * @param angle the angle of the branch line
	 * @param length the length of the sides of the square
	 * @param thickness the thickness of the branch line
	 * @param pTwo the ending point of a branch
	 */	
	private static void addFBranch(Figure fig,int lev,double angle,int length,double thickness,  Point2D pTwo){
		if (lev == 0) return;
		else {
			if(thickness<0.5) {
			thickness=0.5;
			}
			fig.setThickness(thickness);
		 Point2D pThree = new Point2D(0,0);
		 pThree.x = pTwo.x + (int) (Math.cos(Math.toRadians(angle)) * lev * 7.0);
		 pThree.y = pTwo.y - length + (int) (Math.sin(Math.toRadians(angle)) * lev * 7.0);
		 
	        fig.addPolyline(new Polyline(fig,pTwo, pThree));
	        
	        addFBranch(fig, lev - 1, angle - 35,length/2, thickness-0.5, pThree);
	        
	        addFBranch(fig, lev - 1, angle + 35,length/2,thickness-0.5, pThree);
		}
	}
	/**
	 * Calculates the points and draws the branches of the Asymmetric fractal tree line
	 * @param fig the current figure
	 * @param lev the number of iterations
	 * @param angle the angle of the branch line
	 * @param length the length of the sides of the square
	 * @param thickness the thickness of the branch line
	 * @param pTwo the ending point of a branch
	 */
	private static void addAFBranch(Figure fig,int lev,double angle,int length,double thickness,  Point2D pTwo){
		if (lev == 0) return;
		else {
			if(thickness<0.5) {
				thickness=0.5;
			}
			fig.setThickness(thickness);
		Point2D pThree = new Point2D(0,0);
		 pThree.x = pTwo.x + (int) (Math.cos(Math.toRadians(angle)) * lev * 7.0);
		 pThree.y = pTwo.y - length+ (int) (Math.sin(Math.toRadians(angle)) * lev * 7.0);
		 
	        fig.addPolyline(new Polyline(fig,pTwo, pThree));
	        
	        addFBranch(fig, lev - 1, angle - 50,length/2,thickness-0.5, pThree);
	        
	        addFBranch(fig, lev - 1, angle + 15,length/2,thickness-0.5, pThree);
		}
	}
	/**
	 * Passes the point of the tree trunk to draw the Fractal tree
	 * @param fig the current figure
	 * @param c the center of the fractal tree
	 * @param length the length of the tree trunk
	 * @param thickness the thickness of the tree trunk
	 * @param iterations the number of iterations
	 */	
	public static void addFTree(Figure fig,Point2D c,int length, double thickness, int iterations) {
		Point2D pTwo = new Point2D(0,0);
		pTwo.x = c.x;
		pTwo.y = c.y+length;
		
		addFBranch(fig,iterations,-90,length,thickness,pTwo);
		
	}
	/**
	 * Passes the point of the tree trunk to draw the Asymmetric Fractal tree
	 * @param fig the current figure
	 * @param c the center of the fractal tree
	 * @param length the length of the tree trunk
	 * @param thickness the thickness of the tree trunk
	 * @param iterations the number of iterations
	 */	
	public static void addAFTree(Figure fig,Point2D c,int length, double thickness, int iterations) {
	Point2D pTwo = new Point2D(0,0);
	pTwo.x = c.x;
	pTwo.y = c.y+length;
	
	addAFBranch(fig,iterations,-90,length,thickness,pTwo);
	}
}
