public class Transaction {
    private String type; // "BUY" or "SELL"
    private Crypto crypto;
    private double quantity;
    private double price;

    public Transaction(String type, Crypto crypto, double quantity, double price) {
        this.type = type;
        this.crypto = crypto;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return type + " " + quantity + " of " + crypto.getName() + " at $" + price;
    }
}
