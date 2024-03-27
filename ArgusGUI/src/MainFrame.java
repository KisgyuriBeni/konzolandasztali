import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane;


    public MainFrame() throws SQLException{
        Load load = new Load();
        ArrayList<Buildings> buildingList = load.getBuildings();  

        // for (Buildings buildings : buildingList) {
        //     System.out.println(buildings.city);   Tesztelés, hogy tényleg jönnek e az adatok
        // }
        for (Buildings buildings : buildingList) {
            Vector<String> row = new Vector<>();
            row.add(buildings.id.toString());
            row.add(buildings.city);
            row.add(buildings.address);
            row.add(buildings.usage);
            row.add(buildings.size.toString());
            row.add(buildings.price.toString());
        }

        String[] mezoNevek = {"id", "Város", "cím", "Megnevezés", "Méret", "Ár"};
        Object[][]adat = {
            {1, "Szolnok", "Fasz utca", "iroda", 200, 12.2},
            {1, "Szolnok", "Fasz utca", "iroda", 200, 12.2}
        };

        this.table = new JTable(adat, mezoNevek);
        this.pane  = new JScrollPane(this.table);
        this.pane.setBounds(10, 10, 300, 200);

        this.add(pane);
        this.setLayout(null);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }

}
