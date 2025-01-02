import java.util.ArrayList;

public class Market {
    private ArrayList<Crypto> cryptoList;

    public Market() {
        cryptoList = new ArrayList<>();
        // Add some cryptocurrencies
        cryptoList.add(new Crypto("Bitcoin", "BTC", 30000));
        cryptoList.add(new Crypto("Ethereum", "ETH", 2000));
        cryptoList.add(new Crypto("Dogecoin", "DOGE", 0.3));
    }

    public ArrayList<Crypto> getCryptoList() {
        return cryptoList;
    }

    public void simulateMarket() {
        for (Crypto c : cryptoList) {
            c.updatePrice();
        }
    }

    public void displayMarketPrices() {
        System.out.println("Current Market Prices:");
        for (Crypto c : cryptoList) {
            System.out.println(c.getName() + " (" + c.getSymbol() + "): $" + c.getPrice());
        }
    }
}
