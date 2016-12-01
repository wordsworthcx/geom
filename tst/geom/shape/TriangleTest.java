package geom.shape;

import geom.point.Point2D;
import geom.shape.Triangle;
import geom.test.AbstractCaseTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

// from branch master
/**
 * @author xuch.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:spring-configuration/unit-testing-config.xml"})
public class TriangleTest extends AbstractCaseTest {
    @Mock
    private Triangle mockTriangle;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void helloTest() {
        doReturn(100.00).when(mockTriangle).getArea();
        mockTriangle.getArea();
        verify(mockTriangle, atLeastOnce()).getArea();
        verify(mockTriangle, atLeastOnce()).getPerimeter();
    }

    @Test
    public void happyCaseIsosceles() {
        final double area = 0.5;
        final double perimeter = 1 + 1 + Math.sqrt(2);
        Triangle triangle = new Triangle(Point2D.ZERO, new Point2D(0, 1), new Point2D(1, 0));
        Assert.assertEquals(area, triangle.getArea(), delta);
        Assert.assertEquals(perimeter, triangle.getPerimeter(), delta);
        Assert.assertFalse(triangle.isEquilateral());
        Assert.assertTrue(triangle.isIsosceles());
        Assert.assertFalse(triangle.isScalene());
    }

    @Test
    public void happyCaseEquilateral() {
        final double height = Math.sqrt(3) / 2.0;
        final double width = 1.0;
        final double perimeter = 3.0;
        final double area = getTriangleAreaByWidthAndHeight(width, height);
        Triangle triangle = new Triangle(new Point2D(-(width / 2.0), 0), new Point2D((width / 2.0), 0), new Point2D(0, height));
        Assert.assertEquals(area, triangle.getArea(), delta);
        Assert.assertEquals(perimeter, triangle.getPerimeter(), delta);
        Assert.assertTrue(triangle.isEquilateral());
        Assert.assertTrue(triangle.isIsosceles());
        Assert.assertFalse(triangle.isScalene());
    }

    @Test
    public void happyCaseScalene() {
        final double height = 1.0;
        final double width = 2.0;
        final double perimeter = getPerimeterOfRightTriangle(width, height);
        final double area = getTriangleAreaByWidthAndHeight(width, height);
        Triangle triangle = new Triangle(Point2D.ZERO, new Point2D(width, 0), new Point2D(0, height));
        Assert.assertEquals(area, triangle.getArea(), delta);
        Assert.assertEquals(perimeter, triangle.getPerimeter(), delta);
        Assert.assertFalse(triangle.isEquilateral());
        Assert.assertFalse(triangle.isIsosceles());
        Assert.assertTrue(triangle.isScalene());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nulPoints() {
        Triangle triangle = new Triangle(Point2D.ZERO, new Point2D(1, 0), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void duplicatePoints() {
        Triangle triangle = new Triangle(Point2D.ZERO, new Point2D(1, 0), new Point2D(1, 0));
    }

    /**
     * Points are at the same line
     */
    @Test(expected = IllegalArgumentException.class)
    public void invalidPoints() {
        Triangle triangle = new Triangle(Point2D.ZERO, new Point2D(1, 0), new Point2D(-1, 0));
    }

    // conflit merge from master
    private double getTriangleAreaByWidthAndHeight(double width, double height) {
        return width * height / 2.0;
    }

    private double getPerimeterOfRightTriangle(double width, double height) {
        return height + width + Math.sqrt(Math.pow(height, 2.0) + Math.pow(width, 2.0));
    }

    //from branch master
}

