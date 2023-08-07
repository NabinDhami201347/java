import java.sql.*;
import java.util.Scanner;

public class InsertStudentData {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver (MySQL in this example)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection details
            String url = "jdbc:mysql://localhost:3306/ncitDb";
            String username = "root";
            String password = "admin";

            // Establish the database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prompt the user for name and roll
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter roll: ");
            int roll = scanner.nextInt();

            // Create the SQL INSERT query with placeholders (?)
            String insertQuery = "INSERT INTO students (name, roll) VALUES (?, ?)";

            // Create a PreparedStatement to prevent SQL injection
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the values for the placeholders (?)
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, roll);

            // Execute the INSERT command using executeUpdate
            // executeUpdate is used for SQL commands that modify the data (INSERT, UPDATE,
            // DELETE)
            // It returns the number of rows affected by the execution
            int rowsAffected = preparedStatement.executeUpdate();

            // Check the result of the INSERT operation
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }

            // Close the resources (no need to check for null, try-with-resources handles
            // it)
            preparedStatement.close();
            connection.close();
            scanner.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred during database connection or SQL execution.");
        }
    }
}
