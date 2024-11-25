import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class DataSaver {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> records = new ArrayList<>();
    String choice;

    do {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter ID number(6 digits): ");
        String idNumber = String.format("%06d", Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your year of birth(four digits): ");
        String yearOfBirth = scanner.nextLine();

        String record = String.join(" ", firstName, lastName, idNumber, email, yearOfBirth);
        records.add(record);

        System.out.println("Would you like to add another record(yes/no): ");
        choice = scanner.nextLine().toLowerCase();

    } while (choice.equals("yes"));

        System.out.print("Enter the file name to save records: ");
        String fileName = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName + ".csv")))
        {
        for (String record: records) {
            writer.println(record);
        }
        System.out.println("Records saved to " + fileName + ".csv");

    } catch (IOException e) {
        System.out.println("Error while saving records: " + e.getMessage());
    }
   }

}
