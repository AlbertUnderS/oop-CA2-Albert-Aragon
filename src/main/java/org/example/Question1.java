package org.example;

/**
 *  Your Name:
 *  Class Group:
 */
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        System.out.println("Question 1");

        ContainerManager manager = new ContainerManager();

        // Create and add containers
        Box box = new Box(2.0, 3.0, 4.0, 5.0);
        Cylinder cylinder = new Cylinder(5.0, 2.0, 3.5);
        Pyramid pyramid = new Pyramid(3.0, 2.5, 4.5);

        manager.add(box);
        manager.add(cylinder);
        manager.add(pyramid);

        // Call methods and display results
        System.out.println("Total weight: " + manager.totalWeight());
        System.out.println("Total rectangular volume: " + manager.totalRectangularVolume());

        // Get and display all containers
        List<IMeasurableContainer> allContainers = manager.getAllContainers();
        for (IMeasurableContainer container : allContainers) {
            if (container instanceof Box) {
                Box b = (Box) container;
                System.out.println("Box - Length: " + b.getLength() + ", Width: " + b.getWidth() +
                        ", Depth: " + b.getDepth() + ", Weight: " + b.getWeight());
            } else if (container instanceof Cylinder) {
                Cylinder c = (Cylinder) container;
                System.out.println("Cylinder - Height: " + c.getHeight() + ", Diameter: " + c.getDiameter() +
                        ", Weight: " + c.getWeight());
            } else if (container instanceof Pyramid) {
                Pyramid p = (Pyramid) container;
                System.out.println("Pyramid - Length: " + p.getLength() + ", SideLength: " + p.getSideLength() +
                        ", Weight: " + p.getWeight());
            }
        }
    }
}
