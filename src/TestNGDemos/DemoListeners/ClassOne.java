package TestNGDemos.DemoListeners;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassOne {


    @Test
    public void classOneTest1()
    {
        System.out.println("classOneTest1");
        Assert.assertEquals(true,false,"this test is failed");
    }

    @Test
    public void classOneTest2()
    {
        System.out.println("classOneTest2");
    }

    @Test
    public void classOneTest3()
    {
        System.out.println("classOneTest3");
    }
}
