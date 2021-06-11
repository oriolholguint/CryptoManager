package apicontrol;

/**
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class ApiRequest 
{
    public static String coinListURL="https://api.coingecko.com/api/v3/coins/list"; //GET lista de monedas

    /**
     * URL para llamar a la API y obtener el precio actual de una criptomoneda.
     * @param coinName criptomoneda a conocer su precio.
     * @param vsCurrency moneda contra la que se compara el precio.
     * @return URL para hacer la llamada a la API.
     */
    public static String coinPrice(String coinName, String vsCurrency)
    {
        return "https://api.coingecko.com/api/v3/simple/price?ids="+coinName+"&vs_currencies="+vsCurrency+
                "&include_market_cap=false&include_24hr_vol=false&include_24hr_change=false&include_last_updated_at=false";
    }
    
    public static String cryptoInfo(String coinName)
    {
        return "https://api.coingecko.com/api/v3/coins/"+coinName+"?tickers=false&market_data=false&community_data=false&developer_data=false&sparkline=false";
    }
}
