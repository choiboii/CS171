/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Andrew Choi
*/

// This class represents a circle shape
public class Circle {

    // Instance variables (data members) of class Circle
    protected double radius; // the radius of the circle
    protected double x; // the x coordinate of the circle's center
    protected double y; // the y coordinate fo the circle's center

    // The default constructor with no argument
    public Circle(){
      // Initializing the values of the instance variables
      radius = 1.0;
      x = 0.0;
      y = 0.0;
    }

    // Second constructor with given radius, but origin default
    public Circle(double r) {
      radius = r;
      x = 0.0;
      y = 0.0;
    }

    //Third constructor with three parameters r, ex, and why
    // Parameter r should be the radius length
    // Parameter ex should be the x coordinate
    // Parameter why should be the y coordinate
    public Circle(double r, double ex, double why) {
    	radius = r;
      x = ex;
      y = why;
    }

    // A public getter method for retrieving the radius
    public double getRadius() {
     return radius;
    }

    // A public getter method for retrieving the center coordinates
    public double[] getCenter() {
     double[] c = {this.x, this.y};
     return c;
    }

    // A public getter method for computing and returning
    // the area of the circle
    public double getArea() {
      return radius * radius * Math.PI;
    }

    // A public method which returns the circumference of the circle object
    public double getCircumference() {
    	return 2.0 * radius * Math.PI; //circumference of a circle is 2*pi*r.
    }

    // A public method which compares two circles' areas; one circle as the
    // current object, and the circle passed as a parameter.
    // Example: circleA.isBiggerThan(circleB) should return true if circleA
    // has a larger area than circleB, false otherwise.
    public boolean isBiggerThan(Circle other) {
      return this.getArea() >  other.getArea();
    }

    // A public method that takes as input an x coordinate (as a double)
    // and a y coordinate (a double), and returns true if the (x, y) coordinate
    // is inside the current circle, false otherwise.
    public boolean containsPoint(double ex, double why) {
      double distance = Math.sqrt(Math.pow((ex - x),2) + Math.pow((why - y),2)); //distance formula
      return distance < radius; //if the distance away from the center is less than the radius, then it is within the circle.
    }

    // A public setter method which sets the radius of the circle to a new value double r given in the parameter
    public void setRadius(double r){
      radius = r;
    }

    // A public setter method which sets the center of the circle to a new set of coordinates represented by the two parameters
    // ex as the x-coordinate and why as the y-coordinate of the center.
    public void setCenter(double ex, double why){
      x = ex;
      y = why;
    }

    // An overriding method which prints out a statement describing the Circle object:
    // "This circle is centered at point (center coordinates in (x, y) format)
    // with radius (radius of the circle)."
    @Override
    public String toString() {
        return "This circle is centered at point (" + x + ", " + y + ") with radius " + radius + ".";
    }

    // An overriding method of the equals() method in the Object class
    // Compares two circle objects and returns true if the
		// two circles have equal areas, false otherwise.
    @Override
    public boolean equals(Object other){
      Circle temp = (Circle) other; //need to cast the object to a (Circle) to logically compare two objects.
      return this.getArea() == temp.getArea();
    }
}
