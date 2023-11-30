import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataManipulation {

    public static void main(String[] args) {
        String filePath = "random_data_.txt";

        IDBST idBST = new IDBST();
        NameSurnameBST nameSurnameBST = new NameSurnameBST();

        try {
            readDataFromFile(filePath, idBST, nameSurnameBST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example: Delete a student by Name-Surname
        nameSurnameBST.delete("Leah Anderson Cortez");

        // Example: Delete a student by ID
        idBST.delete(981883);

        // Example: Exact search by ID
        //...
        Student searchedStudentByID = idBST.exactSearch(885462);
        if (searchedStudentByID != null) {
            System.out.println("Found student by ID: " + searchedStudentByID.getName());
        } else {
            System.out.println("Student with the specified ID not found.");
        }

        // Example: Interval search by Name-Surname
        nameSurnameBST.intervalSearch("Joel Williams Robert", "louis");
    }

    private static void readDataFromFile(String filePath, IDBST idBST, NameSurnameBST nameSurnameBST)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // Skip the header line
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            // Split the line into components
            String[] components = line.split(",");

            // Extract data from components
            int ID = Integer.parseInt(components[0]);
            String nameSurname = components[1] + " " + components[2];
            int age = Integer.parseInt(components[3]);
            double GPA = Double.parseDouble(components[4]);

            // Create a Student object
            Student student = new Student(ID, components[1], components[2], age, GPA);

            // Insert the student into the ID and Name-Surname BSTs
            idBST.insert(ID, student);
            nameSurnameBST.insert(nameSurname, student);
        }

        reader.close();
    }
}
