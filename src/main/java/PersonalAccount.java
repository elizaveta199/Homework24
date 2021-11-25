public class PersonalAccount {

    private int income;
    private int expenses;

    public void addIncome(int income) {
        if (income > 0) this.income += income;
    }

    public void addExpenses(int expenses) {
        if (expenses > 0) this.expenses += expenses;
    }

    public int getIncome() {
        return income;
    }

    public int getExpenses() {
        return expenses;
    }

    public int getTax6p() {
        return income * 6 / 100;
    }

    public int getTax15p(int income, int expenses) {
        if (income >= 0 & expenses >= 0) {
            this.income = income;
            this.expenses = expenses;
            return Math.abs(income - expenses) * 15 / 100;
        }
        return -1;
    }
}
