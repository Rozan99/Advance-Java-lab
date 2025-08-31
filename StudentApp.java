import java.sql.*;
import java.util.Scanner;

public class StudentApp {
    static final String BASE_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "studentdb";
    static final String URL = BASE_URL + DB_NAME;
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection tempConn = DriverManager.getConnection(BASE_URL, USER, PASSWORD);
            Statement tempStmt = tempConn.createStatement();
            tempStmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println("Database '" + DB_NAME + "' is ready.");

            tempConn.close();


            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();


            String createTableQuery = "CREATE TABLE IF NOT EXISTS student (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "roll INT," +
                    "semester INT," +
                    "dob DATE" +
                    ")";
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table 'student' is ready.");

            int choice;
            do {
                System.out.println("\n----- STUDENT CRUD MENU -----");
                System.out.println("1. Insert Student");
                System.out.println("2. Update Student Name");
                System.out.println("3. Delete Student");
                System.out.println("4. View All Students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Roll No: ");
                        int roll = sc.nextInt();
                        System.out.print("Enter Semester: ");
                        int semester = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter DOB (yyyy-mm-dd): ");
                        String dob = sc.nextLine();

                        String insertQuery = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(insertQuery);
                        pst.setInt(1, id);
                        pst.setString(2, name);
                        pst.setInt(3, roll);
                        pst.setInt(4, semester);
                        pst.setString(5, dob);
                        pst.executeUpdate();
                        System.out.println("✅ Student inserted successfully.");
                        break;

                    case 2:
                        System.out.print("Enter ID to Update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        String updateQuery = "UPDATE student SET name = ? WHERE id = ?";
                        pst = conn.prepareStatement(updateQuery);
                        pst.setString(1, newName);
                        pst.setInt(2, uid);
                        int updated = pst.executeUpdate();
                        if (updated > 0)
                            System.out.println("Student updated successfully.");
                        else
                            System.out.println("Student not found.");
                        break;

                    case 3:
                        System.out.print("Enter ID to Delete: ");
                        int did = sc.nextInt();
                        String deleteQuery = "DELETE FROM student WHERE id = ?";
                        pst = conn.prepareStatement(deleteQuery);
                        pst.setInt(1, did);
                        int deleted = pst.executeUpdate();
                        if (deleted > 0)
                            System.out.println("Student deleted successfully.");
                        else
                            System.out.println("Student not found.");
                        break;

                    case 4:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
                        System.out.println("\nID\tName\t\tRoll\tSemester\tDOB");
                        System.out.println("-------------------------------------------------------------");
                        while (rs.next()) {
                            System.out.printf("%d\t%-10s\t%d\t%d\t\t%s\n",
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getInt("roll"),
                                    rs.getInt("semester"),
                                    rs.getDate("dob"));
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
