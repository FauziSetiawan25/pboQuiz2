package quiz2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

abstract class Employee {
    protected String name;
    protected String birthDate;
    protected String position;
    protected String department;
    protected String employeeID;

    public static String[] getDepartments() {
        return new String[]{"PROD", "HR"};
    }

    double calculateSalary() {
        return 0;
    }

    public String generateEmployeeID() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String formattedDate = dateFormat.format(new Date());
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        return String.format("000%s%s%03d", department, formattedDate, randomNumber);
    }

    public void setName(String name) {
        this.name = name;
    }
}