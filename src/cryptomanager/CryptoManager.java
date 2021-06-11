package cryptomanager;

import gui.Login;
import gui.MainWindow;
import apicontrol.*;
import elements.Crypto;
import elements.User;
import java.util.ArrayList;
import localdata.LocalData;

/**
 *
 * @author Oriol Holguin, Alex Guirao, Francesc Bagué
 */
public class CryptoManager 
{
    public static void main(String[] args) 
    {
        /*Ejemplo para obtener el precio del bitcoin respecto al euro desde la API.
        Crypto crypto = ApiControl.parseToObject(ApiRequest.cryptoInfo("bitcoin"));
        System.out.println(crypto.toString());
        */
        LocalData.user=new User("Alex","secret","Alex@ssds");
        //new Login();
        new MainWindow();
        
    }
}