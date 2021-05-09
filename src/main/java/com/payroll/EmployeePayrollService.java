package com.payroll;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class EmployeePayrollService {
    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }
    private List<EmployeePayrollData> employeePayrollList;


    // Creating constructor

    public EmployeePayrollService() {
    }

    // Parameterized constructor for initializing list

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    // Read from the console

    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Please enter employee name");
        String name = consoleInputReader.nextLine();
        System.out.println("Please enter employee ID");
        int id = consoleInputReader.nextInt();
        System.out.println("Please enter employee salary");
        double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    // Write into the console

    private void writeEmployeePayrollData() {
        System.out.println("\n Writing Employee Payroll Roster to Console\n" + employeePayrollList);
    }

    // Main method

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Employee Payroll service program!");
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();

        //UC2:-Check File Exists, Delete File and Check File Not Exist, Create Directory,
        //Create Empty File, List Files, Directories as well as Files with Extension.

        FileOperations fileOperations = new FileOperations();
        fileOperations.fileOperationDemonstrator();
    }
    // Count Entries
    public long countEntries(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO));
        return new EmployeePayrollFileIOService().countEntries();
    }
    // Prints entries
    public List<EmployeePayrollData> printEntries(IOService ioService){
        if(ioService.equals(IOService.FILE_IO));
        return new EmployeePayrollFileIOService().readData();
    }

    // Prints data into the file

    public void printData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO));
        new EmployeePayrollFileIOService().printData();
    }
}

