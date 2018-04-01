import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cli {

	public Cli() {
		System.out.println("SchoolManagmentSystem CLI");
		
		BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		while (true) {
			System.out.print("> ");
			try {
				input = a.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			handleInput(input);
		}
	}
	
	private void handleInput(String input) {
		switch (input.split(" ")[0]) {
			case "info":
				System.out.println(Main.school.getName() + " - " + 
					Main.school.getStudents().size() + " Students - " +
					Main.school.getTeachers().size() + " Teachers - " + 
					"Balance: " + Main.school.getTotalMoney() + "€");
				break;
				
			case "balance":
				System.out.println("Balance: " + Main.school.getTotalMoney() + "€");
				break;
				
			case "add":
				String name;
				int grade;
				int salary;
				
				// Check whether a second parameter was given
				if (input.split(" ").length < 2) {
					System.out.println("Command not found!");
					break;
				}
				
				switch (input.split(" ")[1].trim()) {
					case "student":
						try {
							name = input.split(" ")[2];
							grade = Integer.parseInt(input.split(" ")[3]);
						} catch (ArrayIndexOutOfBoundsException exception) {
							System.out.println("Usage: add student NAME GRADE");
							break;
						}
						Main.school.addStudent(new Student(name, grade));
						break;
						
					case "teacher":
						try {
							name = input.split(" ")[2];
							salary = Integer.parseInt(input.split(" ")[3]);
						} catch (ArrayIndexOutOfBoundsException exception) {
							System.out.println("Usage: add teacher NAME SALARY");
							break;
						}
						Main.school.addTeacher(new Teacher(name, salary));
						break;
						
					case "expense":
						if (input.split(" ").length < 4) {
							System.out.println("Usage: add expense NAME AMOUNT");
							break;
						}
						name = input.split(" ")[2];
						float amount = Float.parseFloat(input.split(" ")[3].replaceAll(",", "."));
						
						Main.school.addExpense(new Expense(name, amount));
						break;
						
					default:
						System.out.println("Command not found!");
				}
				break;
				
			case "get":
				// Check whether a second parameter was given
				if (input.split(" ").length < 2) {
					System.out.println("Command not found!");
					break;
				}
				
				switch (input.split(" ")[1]) {
					case "student": 
						try {
							int id = Integer.parseInt(input.split(" ")[2]);
							boolean isStudentFound = false;
							for (int i = 0; i < Main.school.getStudents().size(); i++) {
								if (Main.school.getStudents().get(i).getId() == id) {
									isStudentFound = true;
									Student student = Main.school.getStudents().get(i);
									System.out.println("ID: " + student.getId() + "\n" +
											"Name: " +  student.getName() + "\n" +
											"Grade: " +  student.getGrade() + "\n" +
											"Fees Paid: " +  student.getFeesPaid() + "€\n" +
											"Remaining Fees: " +  student.getRemainingFees() + "€");
									break;
								}
							}
							if (!isStudentFound) {
								System.out.println("No student found!");
							}
							break;
						} catch (ArrayIndexOutOfBoundsException exception) {
							System.out.println("Usage: get student ID");
							break;
						}
						
					case "students":
						for (int i = 0; i < Main.school.getStudents().size(); i++) {
							System.out.println(Main.school.getStudents().get(i).getId() + " - " +
								Main.school.getStudents().get(i).getName() + " - " +
								"Grade " + Main.school.getStudents().get(i).getGrade());
						}
						break;
						
					case "teacher": 
						try {
							int id = Integer.parseInt(input.split(" ")[2]);
							boolean isTeacherFound = false;
							for (int i = 0; i < Main.school.getTeachers().size(); i++) {
								if (Main.school.getTeachers().get(i).getId() == id) {
									isTeacherFound = true;
									Teacher teacher = Main.school.getTeachers().get(i);
									System.out.println("ID: " + teacher.getId() + "\n" +
											"Name: " +  teacher.getName() + "\n" +
											"Salary: " +  teacher.getSalary() + "€\n" +
											"Total Paid: " +  teacher.getTotalPaidSalary() + "€");
									break;
								}
							}
							if (!isTeacherFound) {
								System.out.println("No teacher found!");
							}
							break;
						} catch (ArrayIndexOutOfBoundsException exception) {
							System.out.println("Usage: get teacher ID");
							break;
						}
						
					case "teachers":
						for (int i = 0; i < Main.school.getTeachers().size(); i++) {
							System.out.println(Main.school.getTeachers().get(i).getId() + " - " +
								Main.school.getTeachers().get(i).getName() + " - " +
								"Salary " + Main.school.getTeachers().get(i).getSalary() + "€");
						}
						break;
						
					case "expense":
						if (input.split(" ").length < 3) {
							System.out.println("Command not found!");
							break;
						}
						
						for (int k = 0; k < Main.school.getExpenses().size(); k++) {
							Expense expense = Main.school.getExpenses().get(k);
							if (expense.getId() == Integer.parseInt(input.split(" ")[2])) {
								System.out.println("ID: " + expense.getId() + "\n" +
										"Name: " + expense.getName() + "\n" +
										"Amount: " + expense.getAmount() + "€");
								break;
							}
							
						}
						break;
						
					case "expenses":
						for (int k = 0; k < Main.school.getExpenses().size(); k++) {
							Expense expense = Main.school.getExpenses().get(k);
							System.out.println(expense.getId() + " - " +
									expense.getName() + " - " +
									expense.getAmount() + "€");
						}
						break;
						
					default:
						System.out.println("Command not found!");
				}
				break;
				
			case "search":
				// Check whether a second parameter was given
				if (input.split(" ").length < 2) {
					System.out.println("Usage: search NAME");
					break;
				}
				String searchQuery = input.split(" ")[1];
				
				for (int i = 0; i < Main.school.getStudents().size(); i++) {
					if (Main.school.getStudents().get(i).getName().contains(searchQuery)) {
						System.out.println("STUDENT " +
								Main.school.getStudents().get(i).getId() + " - " +
								Main.school.getStudents().get(i).getName() + " - " +
								"Grade " + Main.school.getStudents().get(i).getGrade());
					}
				}
				
				for (int j = 0; j < Main.school.getTeachers().size(); j++) {
					if (Main.school.getTeachers().get(j).getName().contains(searchQuery)) {
						System.out.println("TEACHER " + 
								Main.school.getTeachers().get(j).getId() + " - " +
								Main.school.getTeachers().get(j).getName() + " - " +
								"Salary " + Main.school.getTeachers().get(j).getSalary() + "€");
					}
				}
				break;
				
			case "new_month":
				Main.school.newMonth();
				System.out.println("Started new month");
				break;
				
			case "pay":
				if (input.split(" ").length < 4) {
					System.out.println("Usage: pay student ID AMOUNT");
					break;
				}
					
				switch (input.split(" ")[1]) {
					case "student":
						for (int i = 0; i < Main.school.getStudents().size(); i++) {
							Student student = Main.school.getStudents().get(i);
							if (Integer.parseInt(input.split(" ")[2]) == student.getId()) {
								float amount = Float.parseFloat(input.split(" ")[3].replaceAll(",", "."));
								student.payFees(amount);
								System.out.println("Paid " + amount + "€ to " + student.getName() + " (" + student.getId() + ")");
								break;
							}
						}
						break;
				}
				break;
				
			case "help":
				System.out.println("SchoolManagmentSystem CLI\n" +
						"info - information about school\n" +
						"balance - current balance in EUR\n" +
						"add student NAME GRADE - add student" +
						"\nMore information about CLI: https://github.com/Lanseuo/SchoolManagmentSystem");
				break;
			
			default:
				System.out.println("Command not found!");
		}
	}

}
