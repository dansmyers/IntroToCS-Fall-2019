# Practice Writing Classes

## Guitar

Write a Java class named `Guitar` with the following `private` data members:

- `String maker`
- `String model`
- `boolean isPointy`
- `int year`
- `int volume`

Write a constructor that initializes all five values and `get` methods for all five values. Write a `set` method for the `volume` attribute that allows the user to set the volume to an `int` between 0 and 11, including both.

Give your class a `toString` method that prints a `String` representation of the object's data.

<img src="http://4.bp.blogspot.com/-JUSnyfGjK6E/Ty1JBvrGqWI/AAAAAAAAKdQ/Mlx4X8TuJ80/s1600/h1.jpg" width="30%" />

*Such points. Much shred.*

## Rectangle

Fill in the class below representing a 2-D rectangle.

```
/**
 * Rectangle
 *
 * @author CMS_167
 */

public class Rectangle {

    private double width;
    private double height;
    
    /**
     * Construct a new Rectangle
     */
    public Rectangle(double newWidth, double newHeight) {
    
    }
    
    /**
     * Calculate and return the area
     */
    public dobule area() {
    
    }


    /**
     * Fill in get methods
     */
     
     
     
     
    /**
     * Add a toString method
     */
     
     
     
    /**
     * Use main to test a class
     */
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3.5, 2.0);
        System.out.println(r);
        System.out.println(r.area());
    }

}
```
