import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTest {
    @Test
    //у уравнения нет решений
    public void test0() {
        Equation e = new Equation(1, 1, 1);
        Assert.assertEquals(e.rootNumber(), 0);
    }

    @Test
    // у уравнения есть одно решение
    public void test1() {
        Equation e = new Equation(1, 2, 1);
        Assert.assertEquals(e.rootNumber(), 1);
    }

    @Test
    //у  уравнения есть 2 решения
    public void test2() {
        Equation e = new Equation(1, 5, 6);
        Assert.assertEquals(e.rootNumber(), 2);
    }
    @Test
    //уравнение становится линейным
    public void testLinear() {
        Equation e = new Equation(0, 1, 1);
        Assert.assertEquals(e.rootNumber(), 1);
    }
    @Test
    //уравнение, которое вырождается в константу
    public void testConstant() {
        Equation e = new Equation(0, 0, 1);
        Assert.assertEquals(e.rootNumber(), 0);
    }
    @Test
    //уравнение, где все равно нулю, а решений бесконечное множество
    public void testZero() {
        Equation e = new Equation(0, 0, 0);
        Assert.assertEquals(e.rootNumber(), -1);
    }
}
