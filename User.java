import java.util.ArrayList;

public class User {
    private String name;
    private double wallet;
    private ArrayList<Transaction> transactionHistory;
    private ArrayList<Crypto> portfolio;

    public User(String name, double initialFunds) {
        this.name = name;
        this.wallet = initialFunds;
        this.transactionHistory = new ArrayList<>();
        this.portfolio = new ArrayList<>();
    }

    public void buyCrypto(Crypto crypto, double quantity) {
        double cost = crypto.getPrice() * quantity;
        if (wallet >= cost) {
            wallet -= cost;
            portfolio.add(crypto);
            transactionHistory.add(new Transaction("BUY", crypto, quantity, crypto.getPrice()));
            System.out.println("Purchased " + quantity + " of " + crypto.getName());
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void sellCrypto(Crypto crypto, double quantity) {
        // Check if the user owns the cryptocurrency
        if (portfolio.contains(crypto)) {
            double earnings = crypto.getPrice() * quantity;
            wallet += earnings;
            transactionHistory.add(new Transaction("SELL", crypto, quantity, crypto.getPrice()));
            System.out.println("Sold " + quantity + " of " + crypto.getName());
        } else {
            System.out.println("You do not own this cryptocurrency!");
        }
    }

    public void viewPortfolio() {
        System.out.println("Portfolio:");
        for (Crypto c : portfolio) {
            System.out.println(c.getName() + " - Current Price: $" + c.getPrice());
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }

    public double getWallet() {
        return wallet;
    }
}
