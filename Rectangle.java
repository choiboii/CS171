/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Andrew Choi
*/

// This class represents a rectangle shape
public class Rectangle {

		private double L; // the length of the rectangle
		private double H; // the height of the rectangle
		private double x; // the x coordinate of the  bottom left corner of the rectangle
		private double y; // the y coordinate of the bottom left corner of the rectangle

		// A basic constructor which sets the variables L, H, x, and y to the defaults of:
		// L and H is 1.0 and the x and y coordinates are located at (0.0,0.0).
		public Rectangle(){
			L = 1.0;
			H = 1.0;
			x = 0.0;
			y = 0.0;
		}

		// A second constructor which sets the variables L, H, x, and y variables to parameters Ell, Eich, Ex, Why, respectively.
		public Rectangle(double Ell, double Eich, double Ex, double Why){
			L = Ell;
			H = Eich;
			x = Ex;
			y = Why;
		}

		// A public getter method which returns the length of the rectangle.
		public double getLength(){
			return L;
		}

		// A public getter method which returns the height of the rectangle.
		public double getHeight(){
			return H;
		}

		// A public setter method which sets the length of the rectangle to the parameter double Ell.
		public void setLength(double Ell){
			L = Ell;
		}

		// A public setter method which sets the height of the rectangle to the parameter double Eich.
		public void setHeight(double Eich){
			H = Eich;
		}

		// A public method which returns the perimeter of the rectangle.
		public double perimeter(){
			return 2 * (L + H); //all 4 sides added up together
		}

		// A public method which returns the area of the rectangle.
		public double area(){
			return L * H; //base x height returns the area of a rectangle
		}

		// An overriding method of the equals() method in the Object class
    // Compares two Rectangle objects and returns true if the
		// two rectangles have equal areas, false otherwise.
		@Override
		public boolean equals(Object other){
			Rectangle temp = (Rectangle) other; //need to cast the object to a (Rectangle) to logically compare two objects.
			return this.area() == temp.area();
		}

}
