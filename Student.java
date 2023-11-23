public class Student {
    private int ID;
    private String Name;
    private String Surname;
    private int Age;
    private double GPA;

    // Constructor
    public Student(int ID, String Name, String Surname, int Age, double GPA) {
        this.ID = ID;
        this.Name = Name;
        this.Surname = Surname;
        this.Age = Age;
        this.GPA = GPA;
    }

    // Getters and setters (optional)
    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public int getAge() {
        return Age;
    }

    public double getGPA() {
        return GPA;
    }
}
