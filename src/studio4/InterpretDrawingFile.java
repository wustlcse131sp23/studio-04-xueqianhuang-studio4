package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		String rectangle = "rectangle";
		String circle = "circlr";
		String ellipse = "ellipse";
		String triangle = "triangle";
		
		String type = in.next();
		int red = in.nextInt();
		int green = in.nextInt();
		int blue = in.nextInt();
		boolean isFilled = in.nextBoolean();
		StdDraw.setPenColor(red,green,blue);
		if(type.equals(rectangle)) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double halfWidth = in.nextDouble();
			double halfHeight = in.nextDouble();
			if(isFilled)
				StdDraw.filledRectangle(x,y,halfWidth,halfHeight);
			else 
				StdDraw.rectangle(x,y,halfWidth,halfHeight);
		}
		if(type.equals(circle)){
			double x = in.nextDouble();
			double y = in.nextDouble();
			double radius = in.nextDouble();
			if(isFilled)
				StdDraw.filledCircle(x, y, radius);
			else
				StdDraw.circle(x, y, radius);
		}
		if(type.equals(ellipse)) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double semiMajorAxis = in.nextDouble();
			double semiMinorAxis = in.nextDouble();
			if(isFilled)
				StdDraw.filledEllipse(x,y,semiMajorAxis,semiMinorAxis);
			else
				StdDraw.ellipse(x,y,semiMajorAxis,semiMinorAxis);
		}
		if(type.equals(triangle)){
			double[] x = new double[3];
			double[] y = new double[3];
			x[0] = in.nextDouble();
			y[0] = in.nextDouble();
			x[1] = in.nextDouble();
			y[1] = in.nextDouble();
			x[2] = in.nextDouble();
			y[2] = in.nextDouble();
			if(isFilled)
				StdDraw.filledPolygon(x, y);
			else
				StdDraw.polygon(x, y);
		}
	}
}
