package dataProvider;

import org.testng.annotations.DataProvider;

public class Register {
    @DataProvider(name = "Registration")
    public static Object[][] incorrectLoginData() {
        return new Object[][]{
                {"nastiasitnik@gmail.com", "rrbevyr984"}, {"nastyasitnik24@gmail.com", "0675692829Nastya"}, {"nastiasitnik@gmail.com", "fpdof3409"}

        };
    }

    @DataProvider(name = "Incorrect email")
    public static Object[] incorrectEmailCriteria() {
        return new Object[]{
                "@nastiasitnik@gmail.com", "nastiasitnik.gmail.com", "nastiasitnik@gmailcom"
        };
    }

    @DataProvider(name = "Boundary values")
    public static Object[] incorrectBoundaryValuesEmail() {
        return new Object[]{
                "nastyasitnik24242424242424242424242424242424242424242424242424@gmail.com",
                "nastyasitnik242424242424242424242424242424242424242424242424242@gmail.com"
        };

    }
}