package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Taxpayers;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Taxpayers> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company(i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else if(ch == 'c') {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				list.add(new Company(name, anualIncome, employees));
			}
		}
		
		double sum = 0;
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		for (Taxpayers taxpayers : list) {
			System.out.println(taxpayers.getName() + ": $" + String.format("%.2f", taxpayers.taxes()));
			sum += taxpayers.taxes();
		}
		
		System.out.println("TOTAL TAXES: " + sum);
		sc.close();
	}
}