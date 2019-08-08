package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		Department d = new Department(1, "Books");
		System.out.println(d);
		Seller s = new Seller(1, "J�o", "jao@gmail.com", new Date(), 1150.0, d);
		System.out.println(s);

		SellerDao sellerDao = DaoFactory.createSellerDao();
	}

}
