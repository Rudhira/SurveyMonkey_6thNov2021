import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC003_HardAssertions {

    String fruit1= "apple" , fruit2= "apple";
    int no1=10, no2=10;
    boolean status1 = true , status2 = true;

    @Test

    public void verifyValues(){

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(fruit2,fruit1);
        sa.assertEquals(no2,no1);
        sa.assertEquals(status1,status2);
        sa.assertTrue(true);
        System.out.println("End of the program");
        sa.assertAll();

       /* Assert.assertEquals(fruit1, fruit2);
        Assert.assertEquals(no1,no2);
        Assert.assertEquals(status1,status2);
        Assert.assertTrue(true,"Link status is not matching");
        System.out.println("End of the program");

        if(fruit1.equalsIgnoreCase(fruit2)){

            System.out.println("Both the fruits are same");
            System.out.println("Statement after condition is passed");

        }else{

            System.out.println("Both the fruits are not same");
            System.out.println("Statement after condition is failed");
        }

        System.out.println("End of the program");*/
    }
}
