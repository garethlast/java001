import java.awt.Color;
import java.awt.Graphics;

// Fig. 8.24: MyOval.java
//Declaration of class MyOval brought forward from Project Part 1
// Modified Project Part 4

// Name: Gareth Last
//Email: garethlast@hotmail.com

//class MyOval
public class MyOval extends MyBoundedShape {

   // No Argument Constructor
   public MyOval() {
      super(); // Call constructor to set default
      setUnFilled(false);
   } // end MyOval no-argument constructor

   public MyOval(int x1, int y1, int x2, int y2, Color color, boolean notToFill) {
      super(x1, y1, x2, y2, color, notToFill);
   }// end MyOval constructor

   // Draw the oval in the specified color
   // & determines whether this shape is unfilled or filled
   public void draw(Graphics g) {
      g.setColor(getColor());

      if (filled()) {
         g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
      } else {

         g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
      }
      // end if else that determines whether this shape is filled
      // method references the coordinates by get methods instead of
      // directly

   } // end method draw
} // end class MyOval

