package elements;
/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class Crypto 
{
    private String id;
    private String symbol;
    private float currentPrice;

    public Crypto(String id, String symbol, float currentPrice) {
        this.id = id;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }
    
    
}
