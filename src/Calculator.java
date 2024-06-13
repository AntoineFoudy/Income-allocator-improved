// netIncome - Money received after tax
// currentAccount - Money allocated to my current account
// investAmount - Money allocated to my investing
// saveAmount - Money allocated to my savings account
// spendAmount - Money allocated for me to spend, Max 100€ including amount carried on from spendAmountATM
// spendAmountATM - Money that I already have to spend, possibly because I had excess for the week prior

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    private double netIncome;
    private double currentAccount;
    private double investAmount;
    private double saveAmount;
    private double spendAmount;
    private double spendAmountATM;

    // Adding all the % allocations into
    private static final double precentageCurrentAccount = 0.25;
    private static final double precentageInvestAmount = 0.5;
    private static final double precentageSaveAmount = 0.15;
    private static final double precentageSpendAmount = 0.1;
    private static final double spendingLimit = 100;

    public void setVariables(double netIncome, double spendAmountATM) {
        this.netIncome = netIncome;
        this.spendAmountATM = spendAmountATM;

        calculate();
    }

    public void calculate() {
        // Inctial distribution of %
        currentAccount = netIncome * precentageCurrentAccount;
        investAmount = netIncome * precentageInvestAmount;
        saveAmount = netIncome * precentageSaveAmount;
        spendAmount = netIncome * precentageSpendAmount;

        // Checking if the spending amount is larger then 100€
        if (spendAmount + spendAmountATM > spendingLimit) {
            double excess = (spendAmount + spendAmountATM) - spendingLimit;
            // Gets rid of the extra money from the spending amount
            spendAmount = spendAmount - excess;
            // Check if the spending amount is a minus number and if it is set the spending amount to 0
            if (spendAmount < 0) {
                spendAmount = 0;
            }
            // divides the excess equally between the investment amount and the current account
            excess = excess / 2;
            investAmount = investAmount + excess;
            currentAccount = currentAccount + excess;

        }

        // Rounds down to 2 decimal points
        currentAccount = roundDown2DecimalPoints(currentAccount);
        investAmount = roundDown2DecimalPoints(investAmount);
        saveAmount = roundDown2DecimalPoints(saveAmount);
        spendAmount = roundDown2DecimalPoints(spendAmount);
    }
    // Method used to round down to 2 decimal points
    private double roundDown2DecimalPoints(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.DOWN);
        return bd.doubleValue();
    }

    public double getCurrentAccount() {
        return currentAccount;
    }

    public double getInvestAmount() {
        return investAmount;
    }

    public double getSaveAmount() {
        return saveAmount;
    }

    public double getSpendAmount() {
        return spendAmount;
    }
}
