import javax.swing.JFrame;
//Fig 8.23: TestClass.java
//Created in Module part 5

//Name: Gareth Last
//Email: garethlast@hotmail.com

public class TestClass {
   public static void main(String[] args) {

      DrawFrame application = new DrawFrame();
      application.setVisible(true);// show the JFrame - being visible
      application.setSize(600, 600);// set the size of the JFrame 300x300 pixels
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }// end main
}//end class TestClass
