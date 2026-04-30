import java.sql.*;
import java.util.Scanner;

public class PayrollCRUD {

    static Scanner sc = new Scanner(System.in);

    // ADD EMPLOYEE + CALCULATE SALARY
    public static void addEmployee() {
        try {
            Connection con = DBConnection1.getConnection();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Basic Salary: ");
            double basic = sc.nextDouble();

            System.out.print("HRA: ");
            double hra = sc.nextDouble();

            System.out.print("DA: ");
            double da = sc.nextDouble();

            System.out.print("Deductions: ");
            double deductions = sc.nextDouble();
            sc.nextLine();

            double net = basic + hra + da - deductions;

            String sql = "INSERT INTO employees(name,basic_salary,hra,da,deductions,net_salary) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDouble(2, basic);
            ps.setDouble(3, hra);
            ps.setDouble(4, da);
            ps.setDouble(5, deductions);
            ps.setDouble(6, net);

            ps.executeUpdate();

            System.out.println("Employee Added! Net Salary = " + net);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // VIEW EMPLOYEES
    public static void viewEmployees() {
        try {
            Connection con = DBConnection1.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | Net: " +
                    rs.getDouble("net_salary")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE SALARY
    public static void updateSalary() {
        try {
            Connection con = DBConnection1.getConnection();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("New Basic Salary: ");
            double basic = sc.nextDouble();

            System.out.print("New HRA: ");
            double hra = sc.nextDouble();

            System.out.print("New DA: ");
            double da = sc.nextDouble();

            System.out.print("New Deductions: ");
            double deductions = sc.nextDouble();
            sc.nextLine();

            double net = basic + hra + da - deductions;

            String sql = "UPDATE employees SET basic_salary=?, hra=?, da=?, deductions=?, net_salary=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, basic);
            ps.setDouble(2, hra);
            ps.setDouble(3, da);
            ps.setDouble(4, deductions);
            ps.setDouble(5, net);
            ps.setInt(6, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Salary Updated! New Net = " + net);
            else
                System.out.println(" ID not found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // GENERATE PAYSLIP
    public static void generatePayslip() {
        try {
            Connection con = DBConnection1.getConnection();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            String sql = "SELECT * FROM employees WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n===== PAYSLIP =====");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Basic: " + rs.getDouble("basic_salary"));
                System.out.println("HRA: " + rs.getDouble("hra"));
                System.out.println("DA: " + rs.getDouble("da"));
                System.out.println("Deductions: " + rs.getDouble("deductions"));
                System.out.println("-----------------------");
                System.out.println("Net Salary: " + rs.getDouble("net_salary"));
            } else {
                System.out.println(" Employee not found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE
    public static void deleteEmployee() {
        try {
            Connection con = DBConnection1.getConnection();

            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println(" Employee Deleted");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}