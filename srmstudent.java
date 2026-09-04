class SrmStudent {

    String name;

    static String collegeName;
    static String academicYear;

    // Static block runs only once when the class is loaded
    static {
        collegeName = "SRM";
        academicYear = "2026-2027";
        System.out.println("College info loaded");
    }

    SrmStudent(String name) {
        this.name = name;
    }

    void printConfirmation() {
        System.out.println("Student record created: " + name);
    }
}

public class Main {
    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        // Create all students using a loop
        for (String name : names) {
            SrmStudent student = new SrmStudent(name);
            student.printConfirmation();
        }
    }
}
