import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/Student_mgt";
        String username = "root";
        String password = "abc";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver error: " + e.getMessage());
        }

        try (Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
                Scanner sc = new Scanner(System.in)) {

            System.out.println("✅ Connection established successfully.");

            while (true) {
                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Add Course");
                System.out.println("4. View All Courses");
                System.out.println("5. Enroll Student in Course");
                System.out.println("6. View Student Enrollments");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String sname = sc.nextLine();
                        System.out.print("Enter student email: ");
                        String semail = sc.nextLine();
                        String insertStudent = "INSERT INTO Students (name, email) VALUES ('" + sname + "', '" + semail
                                + "')";
                        stmt.executeUpdate(insertStudent);
                        System.out.println("✅ Student added.");
                        break;

                    case 2:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
                        System.out.println("STUDENT LIST:");
                        while (rs.next()) {
                            System.out.println(rs.getInt("student_id") + " | " + rs.getString("name") + " | "
                                    + rs.getString("email"));
                        }
                        break;

                    case 3:
                        System.out.print("Enter course name: ");
                        String courseN = sc.nextLine();
                        System.out.print("Enter course credits: ");
                        int creditN = sc.nextInt();
                        String insertCourse = "INSERT INTO Courses (course_name, credits) VALUES ('" + courseN + "', "
                                + creditN + ")";
                        stmt.executeUpdate(insertCourse);
                        System.out.println("✅ Course added.");
                        break;

                    case 4:
                        ResultSet rs1 = stmt.executeQuery("SELECT * FROM Courses");
                        System.out.println("COURSES LIST:");
                        while (rs1.next()) {
                            System.out.println(rs1.getInt("course_id") + " | " + rs1.getString("course_name")
                                    + " | Credits: " + rs1.getInt("credits"));
                        }
                        break;

                    case 5:
                        System.out.print("Enter student ID: ");
                        int sid = sc.nextInt();
                        System.out.print("Enter course ID: ");
                        int cid = sc.nextInt();
                        String enrollSQL = "INSERT INTO Enrollments (student_id, course_id, enrollment_date) VALUES ("
                                + sid + ", " + cid + ", CURDATE())";
                        stmt.executeUpdate(enrollSQL);
                        System.out.println("✅ Enrollment done.");
                        break;

                    case 6:
                        String viewSQL = "SELECT s.name AS student, c.course_name, e.enrollment_date FROM Enrollments e "
                                +
                                "JOIN Students s ON e.student_id = s.student_id " +
                                "JOIN Courses c ON e.course_id = c.course_id";
                        ResultSet rs3 = stmt.executeQuery(viewSQL);
                        System.out.println("ENROLLMENTS:");
                        while (rs3.next()) {
                            System.out.println(rs3.getString("student") + " | " +
                                    rs3.getString("course_name") + " | " +
                                    rs3.getDate("enrollment_date"));
                        }
                        break;

                    case 0:
                        System.out.println("👋 Exiting...");
                        return;

                    default:
                        System.out.println("❌ Invalid choice!");
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ SQL error: " + e.getMessage());
        }
    }
}
