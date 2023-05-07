package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("======== TEST 1: seller findById / Retornar vendedor informando o ID ========");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"\n======== TEST 2: seller findByDepartment / Retornar vendedor informando o ID do Departamento ========");
		Department department = new Department(4, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"\n======== TEST 3: seller findAll / Retornar todos os vendedores ordenados por nome ========");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n======== TEST 4: seller insert / Inserindo novo vendedor ========");
		Seller newSeller = new Seller(null, "Ryan Black", "ryan@gmail.com", new Date(), 3200.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new ID = " + newSeller.getId());
		
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n======== TEST 5: seller update / Atualizando dados do vendedor ========");
		seller = sellerDao.findById(6);
		seller.setEmail("alexpink@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n======== TEST 6: seller delet / Excluindo um vendedor ========");
		System.out.print("Enter id for delete test: ");
		int deleteId = sc.nextInt();
		sellerDao.deleteById(deleteId);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
