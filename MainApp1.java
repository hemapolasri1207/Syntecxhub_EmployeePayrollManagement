import java.util.Scanner;

public class MainApp1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Payroll System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Generate Payslip");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: PayrollCRUD.addEmployee(); break;
                case 2: PayrollCRUD.viewEmployees(); break;
                case 3: PayrollCRUD.updateSalary(); break;
                case 4: PayrollCRUD.generatePayslip(); break;
                case 5: PayrollCRUD.deleteEmployee(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}