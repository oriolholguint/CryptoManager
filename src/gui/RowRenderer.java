package gui;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class RowRenderer extends DefaultTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean hasFocus, int row, int col)
    {
        super.getTableCellRendererComponent(table, value, selected, hasFocus, row, col);
        
        if (value instanceof JButton)
        {
            JButton btn = (JButton)value;
            return btn;
        }
        
        return this;
    }
}
