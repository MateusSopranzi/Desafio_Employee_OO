package application;

import entities.Address;
import entities.Department;
import entities.Employee;


import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do departamento: ");
        String departmentName = sc.nextLine();
        System.out.println("Dia do pagamento: ");
        Integer payDay = sc.nextInt();
        sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Telefone: ");
        String phone = sc.nextLine();
        Address address = new Address(email, phone);
        Department department = new Department(departmentName, payDay, address);
        System.out.println("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do funcionário #" + i);
            System.out.println("Nome: ");
            String name = sc.nextLine();
            System.out.println("Salário: ");
            Double salary = sc.nextDouble();
            sc.nextLine();
            Employee employee = new Employee(name, salary);
            department.addEmployee(employee);
        }

        showReport(department);
        sc.close();
    }

    private static void showReport(Department department) {
        System.out.println("FOLHA DE PAGAMENTO\n");
        Double sum = 0.0;
        for (Employee emp : department.getEmployees())
            sum += department.payroll(emp);
        System.out.printf("Departamento Vendas = R$ %.2f\n", sum);
        System.out.println("Pagamento realizado no dia " + department.getPayDay());
        System.out.println("Funcionários: \n");
        for (Employee emp : department.getEmployees())
            System.out.println(emp.getName());
        System.out.println("Para dúvidas favor entrar em contato: " + department.getAddress().getEmail());
    }


}
