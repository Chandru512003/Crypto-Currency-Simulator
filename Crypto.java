public class Crypto {
    private String name;
    private String symbol;
    private double price;

    public Crypto(String name, String symbol, double price) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    public void updatePrice() {
        double change = (Math.random() - 0.5) * 10; // +/- 5% change
        price = Math.max(price + change, 0); // Ensure price doesn't go negative
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}
