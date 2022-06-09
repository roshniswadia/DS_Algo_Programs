package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8Demo {

	public static void main(String[] args) {

		List<Book> listOfBooks = new ArrayList<>();
		listOfBooks.add(new Book("Effective Java", "Joshua Bloch", 32));
		listOfBooks.add(new Book("Java Puzzlers", "Joshua Bloch", 22));
		listOfBooks.add(new Book("Java Concurrency in Practice", "Brian Goetz", 42));
		listOfBooks.add(new Book("Java SE 8 for Really Impatient", "Cay S. Horstmann", 34));
		listOfBooks.add(new Book("Core Java", "Cay S. Horstmann", 31));
		listOfBooks.add(new Book("Core Java", "Cay S. Horstmann", 32));
		listOfBooks.add(new Book("Core Java", "Cay S. Horstmann", 33));
		listOfBooks.add(new Book("Core Java", "Cay S. Horstmann", 34));

		Comparator<Book> compareByTitle = Comparator.comparing(Book::getTitle);
		listOfBooks.sort(compareByTitle);

		// System.out.println(listOfBooks);

		// sort by title and price
		Comparator<Book> compareByTitleandPrice = Comparator.comparing(Book::getTitle).thenComparing(Book::getPrice);
		listOfBooks.sort(compareByTitleandPrice);

		// sorting in reverse order
		listOfBooks.sort(Comparator.comparing(Book::getTitle).reversed());
		// System.out.println(listOfBooks);

		List<Integer> listOfInt = new ArrayList<>();
		listOfInt.add(1);
		listOfInt.add(2);
		listOfInt.add(3);
		Collections.sort(listOfInt, Comparator.reverseOrder());
		// System.out.println(listOfInt);

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// number of male and female employees
		Map<String, Long> countofEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countofEmployees.toString());

		// name of all departments in the org
		List<String> dpmtNameList = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println(dpmtNameList);

		// avg age of male and female employees
		Map<String, Double> avgAgeofEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgAgeofEmployees.toString());

		// details of highest paid employee
		Employee highestPaidEmp = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.findFirst().get();
		System.out.println(highestPaidEmp.toString());
		highestPaidEmp = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
				.get();
		System.out.println(highestPaidEmp.toString());

		// Get the details of youngest male employee in the product development
		// department?
		Employee empWithMinAge = employeeList.stream()
				.filter(e -> e.getDepartment().equalsIgnoreCase("Product Development"))
				.collect(Collectors.minBy(Comparator.comparing(Employee::getAge))).get();
		System.out.println(empWithMinAge);

		// What is the average salary of male and female employees?
		Map<String, Double> avgSalofEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalofEmployees);

		// name of all employees in a department
		Map<String, List<Employee>> allEmpDepartmentWise = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		// What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics stats = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(stats.getAverage());

		// Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years.
		Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		Set<Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();

		for (Entry<Boolean, List<Employee>> entry : entrySet) {
			System.out.println("----------------------------");

			if (entry.getKey()) {
				System.out.println("Employees older than 25 years :");
			} else {
				System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}

		
		List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0);
		// Simplest groupingBy
		System.out.println("Simplest groupingBy");
		Map< String, List< Integer > > oddEvenNumbers = list.stream()
		        //grouped with EVEN or ODD
		        .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD"));
		System.out.println("Even Numbers are : " + oddEvenNumbers.get("EVEN"));
		System.out.println("ODD Numbers are : " + oddEvenNumbers.get("ODD"));
		
		// group again (nested grouping)
		System.out.println("Group again with some greater than 5");
		Map<String, Map<String, Set<Integer>>> oddEvenAndCompareTo5 = list.stream()
		        .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD",
		                Collectors.groupingBy(n -> n > 5 ? "GT5" : "LT5", toSet())
		        ));
		Map<String, Set<Integer>> evenNumbers = oddEvenAndCompareTo5.get("EVEN");
		Map<String, Set<Integer>> oddNumbers = oddEvenAndCompareTo5.get("ODD");
		System.out.println("Even numbers greater than 5: " + evenNumbers.get("GT5"));
		System.out.println("Odd numbers greater than 5: " + oddNumbers.get("GT5"));
		System.out.println("Even numbers Less than or equal to 5: " + evenNumbers.get("LT5"));
		System.out.println("Odd numbers Less than or equal to 5: " + oddNumbers.get("LT5"));
	}

}
