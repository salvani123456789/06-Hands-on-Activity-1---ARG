class Person {
    protected String name;
    protected String contactNum;

    public Person(String name, String contactNum) {
        this.name = name;
        this.contactNum = contactNum;
    }

    public String getPersonInfo() {
        return "Name: " + name + "\nContact Number: " + contactNum;
    }
}

class Employee extends Person {
    protected double salary;
    protected String department;

    public Employee(String name, String contactNum, double salary, String department) {
        super(name, contactNum);
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String getPersonInfo() {
        return super.getPersonInfo() + "\nSalary: " + salary + "\nDepartment: " + department;
    }
}

class Faculty extends Employee {
    private boolean isRegular;

    public Faculty(String name, String contactNum, double salary, String department, boolean isRegular) {
        super(name, contactNum, salary, department);
        this.isRegular = isRegular;
    }

    @Override
    public String getPersonInfo() {
        return super.getPersonInfo() + "\nStatus: " + (isRegular ? "Regular" : "Contractual");
    }
}

class Student extends Person {
    private String program;
    private String yearLevel;

    public Student(String name, String contactNum, String program, String yearLevel) {
        super(name, contactNum);
        this.program = program;
        this.yearLevel = yearLevel;
    }
    
    @Override
    public String getPersonInfo() {
        return super.getPersonInfo() + "\nProgram: " + program + "\nYear Level: " + yearLevel;
    }
}
public class CollegeList {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Press E for Employee, F for Faculty, or S for Student:");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "E":
                System.out.println("Enter employee's name:");
                String empName = scanner.nextLine();
                System.out.println("Enter contact number:");
                String empContact = scanner.nextLine();
                System.out.println("Enter salary:");
                double empSalary = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter department:");
                String empDept = scanner.nextLine();
                Employee employee = new Employee(empName, empContact, empSalary, empDept);
                System.out.println(employee.getPersonInfo());
                break;
            
            case "F":
                System.out.println("Enter faculty's name:");
                String facName = scanner.nextLine();
                System.out.println("Enter contact number:");
                String facContact = scanner.nextLine();
                System.out.println("Enter salary:");
                double facSalary = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter department:");
                String facDept = scanner.nextLine();
                System.out.println("Is the faculty regular? (yes/no):");
                boolean isRegular = scanner.nextLine().equalsIgnoreCase("yes");
                Faculty faculty = new Faculty(facName, facContact, facSalary, facDept, isRegular);
                System.out.println(faculty.getPersonInfo());
                break;

            case "S":
                System.out.println("Enter student's name:");
                String stuName = scanner.nextLine();
                System.out.println("Enter contact number:");
                String stuContact = scanner.nextLine();
                System.out.println("Enter program:");
                String stuProgram = scanner.nextLine();
                System.out.println("Enter year level:");
                String stuYear = scanner.nextLine();
                Student student = new Student(stuName, stuContact, stuProgram, stuYear);
                System.out.println(student.getPersonInfo());
                break;

            default:
                System.out.println("Invalid input. Please enter E, F, or S.");
                break;
        }

        scanner.close();
    }
}