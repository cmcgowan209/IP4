
package components;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleTableDemo extends JPanel {
    private boolean DEBUG = false;

    public SimpleTableDemo() {
        super(new GridLayout(1,0));

        String[] columnNames = {"Surname",
                                "Forename",
                                "Sex",
                                "Address",
                                "Appointment Type",
                                "Treatment",
                                "User Type"};

        Object[][] data = {
	    {"McGowan", "Conor",
	     "M", "1 Place Street", "Check Up", "Ongoing", "Student"},
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        
        JScrollPane scrollPane = new JScrollPane(table);

        
        add(scrollPane);
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    
    private static void createAndShowGUI() {
        
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        SimpleTableDemo newContentPane = new SimpleTableDemo();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);

    
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
   
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
