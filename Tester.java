
public class Tester{
  public static void main(String args[]){
    Circle circleA = new Circle(50, 50, 50);
    Circle circleB = new Circle(60, 50, 50);
    System.out.println(circleA.toString());
    System.out.println(circleA.getCircumference());
    System.out.println(circleA.isBiggerThan(circleB));
    System.out.println(circleA.containsPoint(50,30));
    System.out.println(circleB.containsPoint(200,200));
    circleA.setRadius(100);
    System.out.println(circleA.toString());
    circleB.setCenter(0,0);
    System.out.println(circleB.toString());

    circleB.setRadius(100);
    System.out.println(circleA.equals(circleB));

    Cylinder cylinderA = new Cylinder(0.0,0.0,100.0,50.0);
    System.out.println(cylinderA.toString());
    System.out.println(cylinderA.getArea());
    Cylinder cylinderB = new Cylinder();
    System.out.println(cylinderB.toString());
  }
}
