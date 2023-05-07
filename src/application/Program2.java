package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();

		System.out.println("======== TEST 1: department findById / Retornar departamento informando o ID ========");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"\n======== TEST 2: department findAll / Retornar todos os departamentos ordenados por nome ========");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n======== TEST 3: department insert / Inserindo novo departamento ========");
		Department newDepartment = new Department(null, "RH");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new ID = " + newDepartment.getId());

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n======== TEST 4: department update / Atualizando dados do departamento ========");
		department = departmentDao.findById(6);
		department.setName("TI");
		departmentDao.update(department);
		System.out.println("Update completed!");

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n======== TEST 6: department delet / Excluindo um departamento ========");
		System.out.print("Enter id for delete test: ");
		int deleteId = sc.nextInt();
		departmentDao.deleteById(deleteId);
		System.out.println("Delete completed!");

		sc.close();
	}

}
