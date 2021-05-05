/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Andrew Choi
*/

public class ShapeTester {

  // This method compares two objects' (a Circle first, then a Rectangle) areas,
  // and it returns true if the area of the circle is bigger than (or equal to)
  //the area of the rectangle, false otherwise.
  public static boolean isLarger(Circle cir, Rectangle rect){
    return cir.getArea() >= rect.area();
  }

  // This method compares two objects (a Circle first, then a Rectangle).
  // It compares the perimeters of the objects and returns the longer of the two.
  public static double longerPerim(Circle cir, Rectangle rect){
    if(cir.getCircumference() > rect.perimeter()){ return cir.getCircumference(); }
    else{ return rect.perimeter(); }
  }

  // This method is an overloading method of the longerPerim():
  // This method compares two objects (a Rectangle first, then a Circle).
  // It compares the perimeters of the objects and returns the longer of the two.
  public static double longerPerim(Rectangle rect, Circle cir){
    if(cir.getCircumference() > rect.perimeter()){ return cir.getCircumference(); }
    else{ return rect.perimeter(); }
  }

  // This method compares two objects (a Circle first, then a Rectangle).
  // It compares the areas of the objects and returns the larger of the two.
  public static double largerArea(Circle cir, Rectangle rect){
    if(cir.getArea() > rect.area()){ return cir.getArea(); }
    else{ return rect.area(); }
  }

  // This method is an overloading method of the largerArea():
  // This method compares two objects (a Rectangle first, then a Circle).
  // It compares the areas of the objects and returns the larger of the two.
  public static double largerArea(Rectangle rect, Circle cir){
    if(cir.getArea() > rect.area()){ return cir.getArea(); }
    else{ return rect.area(); }
  }

  // This method takes two Circle objects as parameters, and is used to determine if the
  // center of the second circle is within the area of the first circle.
  // This returns true if the first circle contains the center of the second circle,
  // false otherwise.
  public static boolean containsCenter(Circle circleA, Circle circleB){
    double[] centerB = circleB.getCenter(); //obtain the x and y coordinates of the center of the second circle
    return circleA.containsPoint(centerB[0],centerB[1]); //use the method containsPoint with the center coordinates.
  }

}
