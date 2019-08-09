package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("========== FIND BY ID ==============");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("========== FIND BY DEPARTMENT ==============");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		sellers.forEach(System.out::println);

		System.out.println("========== FIND ALL ==============");
		sellers = sellerDao.findAll();
		sellers.forEach(System.out::println);
		
		/*
		System.out.println("========== INSERT INTO ==============");
		Seller newSeller = new Seller(null, "Tayrone", "tayrone@yahoo.com.br", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Seller id = " + newSeller.getId());
		
		System.out.println("========== UPDATE ==============");
		seller = sellerDao.findById(1);
		seller.setName("Tião carreiro");
		sellerDao.update(seller);
		*/
		System.out.println("========== DELETE ==============");
		sellerDao.deleteById(10);

	}

}
