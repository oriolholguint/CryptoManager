package cryptomanager;

import gui.Login;
import gui.MainWindow;
import apicontrol.*;

/**
 *
 * @author Oriol Holguin, Alex Guirao, Francesc Bagué
 */
public class CryptoManager 
{
    public static void main(String[] args) 
    {
        /*Ejemplo para obtener el precio del bitcoin respecto al euro desde la API.
        String bitcoinPrice=ApiControl.connectApi(ApiRequest.coinPrice("bitcoin", "eur"));
        System.out.println(bitcoinPrice);
        */
        
        //new Login();
        new MainWindow();
        
    }
}