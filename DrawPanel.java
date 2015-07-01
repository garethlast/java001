import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

//Fig. 8.2: DrawPanel.java
//Created in Project Part 5

//Name: Gareth Last
//Email: garethlast@hotmail.com

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
   // declare all instant variables
   private MyShape shapes[];
   private int shapeCount;
   private int shapeType;
   private MyShape currentShape;
   private Color currentColor;
   private boolean filledShape;
   private JLabel statusLabel;

   // constructor with JLabel parameter
   public DrawPanel(JLabel status) {
      // Initialize Variables as requested
      shapes = new MyShape[100];
      shapeCount = 0;
      shapeType = 0;
      currentShape = null;
      currentColor = Color.BLACK;

      // set the background color of DrawPanel to white
      setBackground(Color.WHITE);
      statusLabel = status;

      // create and register listener for mouse and mouse motion events
      MouseHandler handler = new MouseHandler();
      addMouseListener(handler);
      addMouseMotionListener(handler);

   }

   // create single inner class to provide event handling
   class MouseHandler extends MouseAdapter implements MouseListener,
         MouseMotionListener {
      // MouseListener event handlers
      @Override
      public void mousePressed(MouseEvent e) {
         // assign currentShape a new shape specified by shapeType
         if (shapeType == 0) {
            currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(),
                  currentColor);
         } else if (shapeType == 1) {
            currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(),
                  currentColor, filledShape);
         } else if (shapeType == 2) {
            currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(),
                  e.getY(), currentColor, filledShape);
         }
      }// end method mousePressed

      // handle event when mouse released after dragging
      @Override
      public void mouseReleased(MouseEvent e) {
         // set second point of currentShape
         currentShape.setX2(e.getX());
         currentShape.setY2(e.getY());
         // finish current shape and put it into array
         shapes[shapeCount] = currentShape;
         shapeCount++;
         // set currentShape to null
         currentShape = null;
         // call method repaint to update drawing with new shape
         repaint();
      }// end method mouseReleased

      // handle event when user drags mouse with button pressed
      @Override
      public void mouseDragged(MouseEvent e) {
         // set the second point of the currentShape to the current
         // mouse position
         currentShape.setX2(e.getX());
         currentShape.setY2(e.getY());
         // set the text of the statusLabel so it displays mouse coordinates
         // when mouse dragged
         statusLabel.setText(String.format("(%d,%d)", e.getX(), e.getY()));
         // calls method repaint to allow user to see shape while dragging the
         // mouse
         repaint();
         ;
      }// end method mouseDragged

      // handler event when user moves mouse
      @Override
      public void mouseMoved(MouseEvent e) {
         // set the text of the statusLabel so it displays mouse coordinates
         // when mouse moved
         statusLabel.setText(String.format("(%d,  %d)", e.getX(), e.getY()));
      }// end method mouseMoved

   }// //end handling class

   // set method for currentColor
   public void setCurrentColor(Color color) {
      currentColor = color;
   }

   // set method for filledShape
   public void setFilledShape(boolean filled) {
      filledShape = filled;
   }

   // set method for currentShapeType
   public void setCurrentShapeType(int shape) {
      shapeType = shape;
   }

   // method clear last shape drawn, ensuring shapeCount is never less than zero
   public void clearLastShape() {
      if (shapeCount <= 0) {
         return;
      } else {
         currentShape = null;
         shapeCount--;
         repaint();
      }
   }// end method clearLastShape

   // method clearDrawing to remove all shapes by setting shapeCount to Zero &
   // repaint
   public void clearDrawing() {
      shapeCount = 0;
      repaint();
   }// end method clearDrawing

   // overridden method that draws the shape in the array
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      repaint();
      for (int i = 0; i < shapeCount; i++) {
         shapes[i].draw(g);
      }

      // only draws if currentShape is not null
      if (currentShape != null) {
         currentShape.draw(g);
      }

   }// end method paintComponent

}// end class DrawPanel

// PERSONAL NOTES PROJECT PART 5
//
// For each Test Project test each component variable and reverse the command, refer back to Test6Project5
// Shape must be visible while dragging
// Remove all the System.out.println()
// Test & Test again
// Check Indentation 
// Comment each request - check & check again
// Remove anything uncessary 
//Draw golf green & flag as per picture

