import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataManipulation {

    public static void main(String[] args) {
        // Specify the path to your data file
        String filePath = "C:/Users/muzca/Desktop/muzo-genel/COURSES/CS/cs201-2023-2024-FALL/lablar/genel-lab-2/input.txt";

        // Create instances of IDBST and NameSurnameBST
        IDBST idBST = new IDBST();
        NameSurnameBST nameSurnameBST = new NameSurnameBST();

        try {
            // Read data from the file and manipulate the BSTs
            readDataFromFile(filePath, idBST, nameSurnameBST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example: Delete a student by Name-Surname
        nameSurnameBST.delete("Mehmet Arda Eren");

        // Example: Delete a student by ID
        idBST.delete(123456);
    }

    private static void readDataFromFile(String filePath, IDBST idBST, NameSurnameBST nameSurnameBST)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            // Split the line into components
            String[] components = line.split(", ");

            // Extract data from components
            int ID = Integer.parseInt(components[1]);
            String nameSurname = components[2] + " " + components[3];
            int age = Integer.parseInt(components[4]);
            double GPA = Double.parseDouble(components[5]);

            // Create a Student object
            Student student = new Student(ID, components[2], components[3], age, GPA);

            // Insert the student into the ID and Name-Surname BSTs
            idBST.insert(ID);
            nameSurnameBST.insert(nameSurname);
        }

        reader.close();
    }
}
