import java.awt.Color;
import java.awt.Graphics;

//Fig. 8.25: MyRectangle.java
//Declaration of class MyRectangle brought forward from Project Part 1
// Modified Project Part 4

//Name: Gareth Last
//Email: garethlast@hotmail.com

//class MyRectangle
public class MyRectangle extends MyBoundedShape {

   // No Argument Constructor
   public MyRectangle() {
      super(); // Call constructor to set default
      setUnFilled(false);
   } // end MyRectangle no-argument constructor

   public MyRectangle(int x1, int y1, int x2, int y2, Color color,
         boolean notToFill) {
      super(x1, y1, x2, y2, color, notToFill);
   } // end MyRectangle constructor

   // Draw the rectangle in the specified color
   // & determines whether this shape is unfilled or filled
   public void draw(Graphics g) {
      g.setColor(getColor());

      if (filled()) {
         g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
      } else {

         g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
      }
      // end if else that determines whether this shape is filled
      // method references the coordinates by get methods instead of
      // directly

   } // end method draw
} // end class MyRectangle