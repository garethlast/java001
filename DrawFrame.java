import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Fig. 8.29: DrawFrame.java
//Created in Project Part 5

//Name: Gareth Last
//Email: garethlast@hotmail.com

@SuppressWarnings("serial")
public class DrawFrame extends JFrame {
   // Declare Instant variables
   private JPanel componentPanel;
   private JPanel statusBar;
   private JButton undoButton;
   private JButton clearButton;
   private JComboBox shapeComboBox;
   private JComboBox colorComboBox;
   private JCheckBox filledCheckBox;
   private DrawPanel mousePanel;
   private JLabel statusLabel;

   // Colors 13 predefined for the JComboBox
   private String colorNames[] = { "Black", "Blue", "Cyan", "Dark Gray",
         "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red",
         "White", "Yellow" };
   private Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN,
         Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
         Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
         Color.YELLOW };

   // Shapes for the JComboBox
   private String[] shapeChoice = { "Line", "Oval", "Rectangle" };
   private int shapeNum[] = { 0, 1, 2 };

   // Constructor DrawFrame
   public DrawFrame() {
      // TitleBar Text
      super("Java Drawings");

      // Initialize Instant Variables
      componentPanel = new JPanel();
      statusBar = new JPanel();
      statusLabel = new JLabel("Mouse Outside Panel");
      undoButton = new JButton("Undo");
      clearButton = new JButton("Clear");
      colorComboBox = new JComboBox(colorNames);
      shapeComboBox = new JComboBox(shapeChoice);
      filledCheckBox = new JCheckBox("Filled");// Create CheckBox

      // add componentPanel in the north region
      add(componentPanel, BorderLayout.NORTH);

      // add the statusBar to the south region
      add(statusBar, BorderLayout.SOUTH);
      statusBar.add(statusLabel);

      mousePanel = new DrawPanel(statusLabel);
      // add the main drawing panel to the center region
      add(mousePanel, BorderLayout.CENTER);

      // /// A button to undo last shape drawn /////
      componentPanel.add(undoButton);
      undoButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            mousePanel.clearLastShape();
         }
      });

      // /// A button to clear all shapes from drawing /////
      componentPanel.add(clearButton);
      clearButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            mousePanel.clearDrawing();
         }
      });

      // /// A combo box for selecting from 13 predefined colors /////
      componentPanel.add(colorComboBox, BorderLayout.NORTH);
      colorComboBox.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED)
               ;
            mousePanel.setCurrentColor(colors[colorComboBox.getSelectedIndex()]);
         }
      });

      // /// A combo box for selecting the shape to draw /////
      componentPanel.add(shapeComboBox);
      shapeComboBox.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED)
               ;
            mousePanel.setCurrentShapeType(shapeNum[shapeComboBox
                  .getSelectedIndex()]);
         }
      });

      // ///A check box that specifies whether the shape should be filled?/////
      componentPanel.add(filledCheckBox);// add bold CheckBoc to JFrame
      filledCheckBox.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            mousePanel.setFilledShape(filledCheckBox.isSelected());
         }
      });
   }// end constructor DrawFrame
}// end class DrawFrame
