package cryptomanager;

import gui.Login;
import gui.MainWindow;
import apicontrol.*;
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
        //Ejemplo para obtener el precio del bitcoin respecto al euro desde la API.
        String bitcoinPrice=ApiControl.connectApi(ApiRequest.coinListURL);
        ArrayList<String> coinList=ApiControl.parseCryptoList(bitcoinPrice);
        
        for (String s:coinList)
        {
            System.out.println(s);
        }
        
        
        LocalData.user=new User("Alex","secret","Alex@ssds");
        //new Login();
        new MainWindow();
        
    }
}