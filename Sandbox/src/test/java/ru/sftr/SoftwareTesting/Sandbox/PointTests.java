package ru.sftr.SoftwareTesting.Sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {
        Point p1 = new Point(1.1, 2.2);
        Point p2 = new Point(2.2, 1.1);

        Assert.assertEquals(p1.distance(p2), 1.5556349186104046);
    }

    @Test
    public void testDistance2() {
        Point p3 = new Point(-1, 0);
        Point p4 = new Point(0, -2.2);

        Assert.assertEquals(p3.distance(p4), 2.4166091947189146);
    }

    @Test
    public void testDistance3() {
        Point p6 = new Point(0, 0);
        Point p7 = new Point(-1, -1);

        Assert.assertEquals(p6.distance(p7), 1.4142135623730951);
    }
}
