import java.awt.Color;
import java.awt.Graphics;

//Fig. 8.26: MyShape.java
//Declaration of class MyShape created in Project Part 3
// Abstract Class and extended by MyLine, MyBoundedShape

//Name: Gareth Last
//Email: garethlast@hotmail.com

//abstract class MyShape
public abstract class MyShape {

   private int x1; // the x coordinate
   private int y1; // the y coordinate
   private int x2; // the width of the oval
   private int y2; // the height of the oval
   private Color myColor; // Color of the oval

   public MyShape(int x1, int y1, int x2, int y2, Color color) {
      this.x1 = x1; // set the x coordinate
      this.y1 = y1; // set the y coordinate
      this.x2 = x2; // set the width of the oval
      this.y2 = y2; // set the height of the oval
      myColor = color; // set the color
   } // end MyShape constructor

   // No Argument Constructor
   public MyShape() {
      this(0, 0, 0, 0, Color.BLACK); // Call constructor to set default
   } // end no-argument constructor

   // SET METHODS
   // validate & setX1
   public void setX1(int x1) {
      if (x1 >= 0) {
         this.x1 = x1;// verify argument is greater or equal to zero
      } else {
         this.x1 = 0; // else set to zero
      }
   }// end method setX1

   // validate & setY1
   public void setY1(int y1) {
      if (y1 >= 0) {
         this.y1 = y1;// verify argument is greater or equal to zero
      } else {
         this.y1 = 0;// else set to zero
      }
   } // end method setY1

   // validate & setX2
   public void setX2(int x2) {
      if (x2 >= 0) {
         this.x2 = x2;// verify argument is greater or equal to zero
      } else {
         this.x2 = 0;// else set to zero
      }
   }// end method setX1

   // validate & setY2
   public void setY2(int y2) {
      if (y2 >= 0) {
         this.y2 = y2;// verify argument is greater or equal to zero
      } else {
         this.y2 = 0;// else set to zero
      }
   }// end method setY2

   // GET METHODS
   // getX1 value
   public int getX1() {
      return x1;
   }// end method getX1

   // getY1 value
   public int getY1() {
      return y1;
   }// end method getY1

   // getX2 value
   public int getX2() {
      return x2;
   }// end method getX2

   // getY2 value
   public int getY2() {
      return y2;
   }// end method getY2

   // Validate & set the color
   public void setColor(Color color) {
      myColor = color;
   } // end method setColor

   // get Color
   public Color getColor() {
      return myColor;
   } // end method getColor

   // abstract draw method
   public abstract void draw(Graphics g);
}// end class MyShape
