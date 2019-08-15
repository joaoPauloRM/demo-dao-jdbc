package application;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja acessar a tabela? (yes/no)");
		String keepConnection = sc.next();
		while (keepConnection.equals("yes")) {
			System.out.println("1 - Find All \n2 - Find By Id\n3 - Find by Department\n4 - Insert\n5 - Delete");
			int selectedOption = sc.nextInt();
			switch (selectedOption) {
			case 1:
				UI.printTableAll();
				break;
			case 2:
				UI.printTableById(sc);
				break;
			case 3:
				UI.printTableByDepartment(sc);
				break;
			case 4:
				UI.insertInto(sc);
				break;
			case 5:
				UI.deleteSeller(sc);
				break;
			}

			System.out.println("Deseja manter acesso à tabela? (yes/no)");
			keepConnection = sc.next();

		}
		sc.close();
	}
}