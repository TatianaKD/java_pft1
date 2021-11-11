import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {
    private Point point;

    @Test
    void distanceTest() {
        Point p1 = new Point(2.1, 3.2);
        Point p2 = new Point(4.2, 3.4);
        double expected = 2.1095023109728985;
        assertEquals(point.distance(p1, p2), expected);
    }
}