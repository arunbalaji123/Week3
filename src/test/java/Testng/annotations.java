package Testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class annotations {
    @BeforeTest
    public void BT1() {
        System.out.println("BT 1");
    }

    @BeforeTest
    public void BT2() {
        System.out.println("BT 2" );
    }

    @BeforeClass
    public void BC1() {
        System.out.println("BC 1");
    }

    @BeforeClass
    public void BC2() {
        System.out.println("BC 2");
    }

    @BeforeMethod
    public void BM() {
        System.out.println("BM 1");
    }

    @BeforeMethod
    public void BM2() {
        System.out.println("BM 2");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @AfterMethod
    public void AM1() {
        System.out.println("AM 1");
    }

    @AfterMethod
    public void AM2() {
        System.out.println("AM 2");
    }

    @AfterClass
    public void AC1() {
        System.out.println("AC 1");
    }

    @AfterClass
    public void AC2() {
        System.out.println("AC 2");
    }

    @AfterTest
    public void AT1() {
        System.out.println("AT 1");
    }

    @AfterTest
    public void AT2() {
        System.out.println("AT 2");
    }
}


	


