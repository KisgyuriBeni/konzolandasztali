import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filereader {
    
    public ArrayList<Buildings> readFile(String path) throws FileNotFoundException{
        ArrayList<Buildings> buildingList = new ArrayList<>();
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(",");

            Buildings buildings = new Buildings();

                buildings.id = Integer.parseInt(lineArray[0]);
                buildings.city = lineArray[1];
                buildings.address = lineArray[2];
                buildings.usage = lineArray[3];
                buildings.size = Integer.parseInt(lineArray[4]);
                buildings.price = Double.parseDouble(lineArray[5]);

                buildingList.add(buildings);
            System.out.println();
        }
        sc.close();
        return buildingList;
    }
}
