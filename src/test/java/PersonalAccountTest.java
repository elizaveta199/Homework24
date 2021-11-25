import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class PersonalAccountTest {

    PersonalAccount personalAccount = new PersonalAccount();

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/testIncomeExpenses.csv")
    public void testIncome(int income, int expected) {

        personalAccount.addIncome(income);

        Assertions.assertEquals(expected, personalAccount.getIncome());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/testIncomeExpenses.csv")
    public void testExpenses(int expenses, int expected) {

        personalAccount.addExpenses(expenses);

        Assertions.assertEquals(expected, personalAccount.getExpenses());
    }

    @ParameterizedTest
    @CsvSource({"1000, 60", "0,0", "-1000,0"})
    public void testGetTax6p(int income, int expected) {

        personalAccount.addIncome(income);

        Assertions.assertEquals(expected, personalAccount.getTax6p());
    }

    @ParameterizedTest
    @CsvSource({"2000,1000, 150", "1000,2000,150", "0,0,0", "0,1000,150,", "5000,-1000,-1", "-2000,-1000,-1"})
    public void testGetTax15p(int income, int expenses, int expected) {

        Assertions.assertEquals(expected, personalAccount.getTax15p(income, expenses));
    }

}
