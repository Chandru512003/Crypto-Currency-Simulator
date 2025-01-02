import java.util.*;

public class CryptoTradingSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize market and user
        Market market = new Market();
        User user = new User("John Doe", 100000); // Initial wallet with $100,000

        while (true) {
            System.out.println("\n--- Crypto Trading Simulator ---");
            System.out.println("1. View Current Virtual Funds");
            System.out.println("2. View Portfolio");
            System.out.println("3. View Transaction History");
            System.out.println("4. View Market Prices");
            System.out.println("5. Buy Cryptocurrency");
            System.out.println("6. Sell Cryptocurrency");
            System.out.println("7. Simulate Market");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Virtual Funds: $" + user.getWallet());
                    break;
                case 2:
                    user.viewPortfolio();
                    break;
                case 3:
                    user.viewTransactionHistory();
                    break;
                case 4:
                    market.displayMarketPrices();
                    break;
                case 5:
                    System.out.println("Available Cryptocurrencies:");
                    ArrayList<Crypto> cryptos = market.getCryptoList();
                    for (int i = 0; i < cryptos.size(); i++) {
                        System.out.println((i + 1) + ". " + cryptos.get(i).getName());
                    }
                    System.out.print("Enter the cryptocurrency number to buy: ");
                    int buyChoice = scanner.nextInt() - 1;
                    System.out.print("Enter quantity to buy: ");
                    double buyQuantity = scanner.nextDouble();
                    user.buyCrypto(cryptos.get(buyChoice), buyQuantity);
                    break;
                case 6:
                    System.out.println("Enter cryptocurrency name to sell: ");
                    scanner.nextLine(); // Consume newline
                    String sellName = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    double sellQuantity = scanner.nextDouble();
                    for (Crypto c : market.getCryptoList()) {
                        if (c.getName().equalsIgnoreCase(sellName)) {
                            user.sellCrypto(c, sellQuantity);
                        }
                    }
                    break;
                case 7:
                    market.simulateMarket();
                    System.out.println("Market updated!");
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
