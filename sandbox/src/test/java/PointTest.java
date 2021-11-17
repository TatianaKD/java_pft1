import org.testng.annotations.Test;
import org.testng.Assert;

public class PointTest {
    private Point point;

    @Test
    public void distanceTest() {
        Point p1 = new Point(2.1, 3.2);
        Point p2 = new Point(4.2, 3.4);
        double expected = 2.1095023109728985;
        Assert.assertEquals(point.distance(p1, p2), expected);
    }
}