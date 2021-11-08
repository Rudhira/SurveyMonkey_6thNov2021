import org.testng.annotations.Test;

public class TC002_PrioritiesConcept {

    @Test(priority = 1)
    public void login(){

        System.out.println("*****Login Test Case******");
        System.out.println("username entered");
        System.out.println("Password entered");
        System.out.println("Clicked on Login button");
    }

    @Test(priority = 2)
    public void bookTickets(){

        System.out.println("*****Booking Tickets Test Case******");
        System.out.println("Selecting the date");
        System.out.println("Selecting the flight");
        System.out.println("Credit card details are entered");
        System.out.println("Clicked on book button");
        System.out.println("Confirmation message is displayed");
    }

    @Test(priority = 3)

    public void logout(){

        System.out.println("*****Logout Test Case******");
        System.out.println("Clicked on logout button");
    }


}
