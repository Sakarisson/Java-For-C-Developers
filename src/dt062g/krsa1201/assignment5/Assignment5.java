package dt062g.krsa1201.assignment5;

/**
* <h1>Assignment 5</h1>
* This application creates a <code>Drawing</code> with a name,
* author and different shapes in it. It then saves the drawing
* to XML, clear the drawing and then loads a drawing from XML. 
*
* @author  Kristian Sakarisson (krsa1201)
* @version 1.0
* @since   20-11-2017
*/
public class Assignment5 {

	public static void main(String[] args) {
		testDrawing();
	}

	private static void testDrawing() {
		// Create a drawing with a name and author.
        System.out.println("Create a drawing...\n");
		Drawing d1 = new Drawing("Magnum Opus", "Kristian Sakarisson");
			
        // Create at least 5 shapes with end points
        Shape s1 = new Circle(6, 10, "blue");
        s1.addPoint(new Point(7.1, 4));
        
        Shape s2 = new Rectangle(7.3, 19, "ff0000");
        s2.addPoint(11, 0);

        Shape s3 = new Rectangle(1, 0, "red");
        s3.addPoint(10, 9.12);

        Shape s4 = new Circle(8.2, 17.9, "cyan");
        s4.addPoint(new Point(6.1, 9));

        Shape s5 = new Circle(22, 5.74, "blue");
        s5.addPoint(12, 7);

        d1.addShape(s1);
        d1.addShape(s2);
        d1.addShape(s3);
        d1.addShape(s4);
        d1.addShape(s5);

		// Add shapes to the drawing
		
		// Print the drawing
		d1.draw();
		
		// Save the drawing to XML
		final String fileName = "MyDrawing.xml";
		System.out.println("\nSave the drawing to " + fileName + "...");
        FileHandler.saveToXML(d1, fileName);
		
		// Clear and print
		System.out.println("\nClearing the drawing and then draw it....");
		d1.clear();
		d1.draw();
		
		// Load drawing from XML
		System.out.println("\nLoad drawing from " + fileName + "...\n");
		d1 = FileHandler.loadFromXML(fileName);
		
		// Print the drawing
		d1.draw();
	}
}