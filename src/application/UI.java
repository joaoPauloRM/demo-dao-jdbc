package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class UI {
	private static SellerDao sellerDao = DaoFactory.createSellerDao();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void printTableAll() {
		List<Seller> sellers = sellerDao.findAll();
		sellers.forEach(System.out::println);

	}

	public static void printTableById(Scanner sc) {
		try {
			System.out.print("Enter the Id: ");
			int id = sc.nextInt();
			Seller seller = sellerDao.findById(id);
			System.out.println(seller);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Invalid value");
		}

	}

	public static void printTableByDepartment(Scanner sc) {
		try {
			List<Seller> sellers = sellerDao.findAll();
			System.out.print("Enter the department: ");
			int idDepartment = sc.nextInt();
			Department department = new Department(idDepartment, null);
			sellers = sellerDao.findByDepartment(department);
			sellers.forEach(System.out::println);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Invalid value");
		}

	}

	public static void insertInto(Scanner sc) {
		try {
			System.out.println("Enter Name");
			String name = sc.next();
			System.out.println("Enter Email");
			String email = sc.next();
			System.out.println("Enter Data");
			Date date = sdf.parse(sc.next());
			System.out.println("Enter Salary");
			double salary = sc.nextDouble();
			System.out.println("Enter Department Id");
			int departmentId = sc.nextInt();
			Department department = new Department(departmentId, null);
			Seller seller = new Seller(null, name, email, date, salary, department);
			sellerDao.insert(seller);
			System.out.println("Inserted!!");

		} catch (RuntimeException e) {
			throw new InputMismatchException("Invalisd value");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void deleteSeller(Scanner sc) {
		try {
			System.out.print("Enter the Id to delete: ");
			int id = sc.nextInt();
			sellerDao.deleteById(id);
			System.out.println("Deleted!!");
		} catch (RuntimeException e) {
			throw new InputMismatchException("Invalisd value");
		}
	}

}
