package utilities;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Uri
 */
public class WindowUtilities 
{
    public static void initSimpleWindow(JFrame window, String title)
    {
        window.setTitle(title);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    public static void initSimpleWindow(JDialog window, String title)
    {
        window.setTitle(title);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
}
