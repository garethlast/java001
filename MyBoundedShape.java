import java.awt.Color;

//Fig. 8.27: MyBoundedShape.java
//Declaration of class MyShape created in Project Part 4
//Abstract Class & extended by MyRectangle, MyOval

//Name: Gareth Last
//Email: garethlast@hotmail.com

public abstract class MyBoundedShape extends MyShape {
   private boolean unFilled; // whether this shape is filled

   // No Argument Constructor
   public MyBoundedShape() {
      super(); // Call constructor to set default
      setUnFilled(false);
   } // end MyBoundedShape no-argument constructor

   // Call superclass passing parameters
   public MyBoundedShape(int x1, int y1, int x2, int y2, Color color,
         boolean filled) {
      super(x1, y1, x2, y2, color);
      unFilled = filled; // set the boolean
   }// end MyBoundedShape constructor

   // Validate whether filled or unfilled
   public boolean filled() {
      return unFilled;
   } // end method set unfilled

   // sets whether this shape is filled
   public void setUnFilled(boolean filled) {
      unFilled = filled;
   } // end method setunFilled

   // get upper left x coordinate
   public int getUpperLeftX() {
      // UpperLeftX coordinate is the smaller of the 2 x-coordinates
      return Math.min(getX1(), getX2());
   } // end method getUpperLeftX

   // get upper left y coordinate
   public int getUpperLeftY() {
      // UpperLeftX coordinate is the smaller of the 2 y-coordinates
      return Math.min(getY1(), getY2());
   } // end method getUpperLeftY

   // get shape width
   public int getWidth() {
      // Width is the absolute value of the difference between two x values
      return Math.abs(getX2() - getX1());
   } // end method getWidth

   // get shape height
   public int getHeight() {
      // Height is the absolute value of the difference between two y values
      return Math.abs(getY2() - getY1());
   } // end method getHeight

} // end class MyBoundedShape
