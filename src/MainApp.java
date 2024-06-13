import javax.swing.JOptionPane;

public class MainApp {
    public static void main(String[] args) {

        // Getting required info from user
        String netIncomeString = JOptionPane.showInputDialog("Enter net income");
        String spendAmountATMString = JOptionPane.showInputDialog("Enter the amount already to spend");

        double netIncome = Double.parseDouble(netIncomeString);
        double spendAmountATM = Double.parseDouble(spendAmountATMString);

        Calculator calculator = new Calculator();
        // Adding users input to the object
        calculator.setVariables(netIncome, spendAmountATM);

        // Gets all the values from the calculations
        double currentAccount = calculator.getCurrentAccount();
        double investAmount = calculator.getInvestAmount();
        double saveAmount = calculator.getSaveAmount();
        double spendAmount = calculator.getSpendAmount();

        // Sting to return the final calculattions to the user
        String finalResult = ("Your current account money is " +currentAccount + "\n"
        + "Your investment amount is " + investAmount + "\n"
        + "Your save amount is " + saveAmount + "\n"
        + "Your spend amount is " + spendAmount + "\n");

        JOptionPane.showMessageDialog(null, finalResult);

    }

}