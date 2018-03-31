import java.util.ArrayList;


public class School {
	private String name;
	private ArrayList<Teacher> teachers = new ArrayList<>();
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Expense> expenses = new ArrayList<>();
	private int currentFeesPerMonth;
	
	/**
	 * Keep track of one school and it's elements
	 * @param name
	 * @param teachers
	 * @param students
	 */
	public School(String name, ArrayList<Teacher> teachers, ArrayList<Student> students) {
		this.name = name;
		this.teachers = teachers;
		this.students = students;
		this.currentFeesPerMonth = 100;
	}
	
	public String getName() {
		return this.name;
	}

	// STUDENTS
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student student) throws Exception {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == student.getId()) {
				throw new Exception("StudentId " + student.getId() + " has to be unique.");
			}
		}
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
	}
	
	// TEACHERS
	
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}
	
	public void removeTeacher(Teacher teacher) {
		this.teachers.remove(teacher);
	}
	
	// EXPENSES
	
	public ArrayList<Expense> getExpenses() {
		return this.expenses;
	}
	
	public void addExpense(Expense expense) {
		this.expenses.add(expense);
	}
	
	// MONEY
	
	public int getTotalMoneyEarned() {
		int result = 0;
		
		for (int i = 0; i < students.size(); i++) {
			result += students.get(i).getFeesPaid();
		}
		
		return result;
	}

	/**
	 * Get the sum of all salaries and expenses
	 */
	public int getTotalMoneySpent() {
		int result = 0;
		
		// Add all salaries of teachers together
		for (int i = 0; i < teachers.size(); i++) {
			result += teachers.get(i).getSalary();
		}
		
		// Add all expenses together
		for (int j = 0; j < expenses.size(); j++) {
			result += expenses.get(j).getAmount();
		}
		
		return result;
	}
	
	public int getTotalMoney() {
		return this.getTotalMoneyEarned() - this.getTotalMoneySpent();
	}
	
	// OPERATIONS
	
	/**
	 * Start new month
	 * Give every teacher his salary
	 * Demand fees from every student
	 */
	public void newMonth() {
		for (int i = 0; i < this.teachers.size(); i++) {
			this.teachers.get(i).payTeacher();
		}
		
		for (int j = 0; j < this.students.size(); j++) {
			this.students.get(j).demandFees(this.currentFeesPerMonth);
		}
	}
}
