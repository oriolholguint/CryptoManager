package cryptomanager;

import gui.Login;
import gui.MainWindow;
import apicontrol.*;
import elements.Crypto;
import elements.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import localdata.LocalData;

/**
 *
 * @author Oriol Holguin, Alex Guirao, Francesc Bagué
 */
public class CryptoManager 
{
    public static void main(String[] args) 
    {
        //LocalData.user=new User("Alex","secret","Alex@ssds");
        new Login();
        //new MainWindow();
        
    }
}