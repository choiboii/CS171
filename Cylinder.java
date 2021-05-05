/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Andrew Choi
*/

//This class represents a cylinder; also a subclass of the Circle class
public class Cylinder extends Circle {

  //inherits three variables from Circle class: x, y, and radius
  protected double height; //height of the cylinder
  protected double z = 0.0; //z is always 0.0

  //default constructor without any parameters; sets it so center is (0.0,0.0,0.0) with a radius and height of 1.0 each.
  public Cylinder() {
    x = 0.0; //inherited variables in the Circle class
    y = 0.0;
    radius = 1.0;
    height = 1.0;
  }

  //overloading constructor with parameters which instantiate the object with the ex, why, r, and h values corresponding to x, y, radius, and height.
  public Cylinder(double ex, double why, double r, double h) {
    x = ex; //inherited variables in the Circle class
    y = why;
    radius = r;
    height = h;
  }

  //public getter method for the height of a cylinder.
  public double getHeight() {
    return height;
  }

  //public setter method which changes the height of a cylinder.
  public void setHeight(double h) {
    height = h;
  }

  //public overriding method from getArea() method in the Circle class
  //determines the overall surface area of the cylinder.
  @Override
  public double getArea() {
    return (super.getArea() * 2) + (super.getCircumference() * height); //returns the area of the two circular bases and the curved surface side
  } //most notably also use the getArea() and getCircumference() method from the Circle class.

  //public getter method which returns the volume of the cylinder;
  public double getVolume() {
    return super.getArea() * height; //uses the getArea() method from the Circle class and multiples with the height.
  }

  //Extra; for testing:
  /*
  @Override
  public String toString() {
    return "This cylinder is centered at (" + x + ", " + y + ", " + z + ") with radius " + radius + " and height " + height + ".";
  }
  */
}
