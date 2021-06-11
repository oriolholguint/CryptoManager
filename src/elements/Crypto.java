package elements;
/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class Crypto 
{
    private String id;
    private String symbol;

    public Crypto(String id, String symbol) 
    {
        this.id = id;
        this.symbol = symbol;
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
}
