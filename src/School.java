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
	public School(String name) {
		this.name = name;
		this.currentFeesPerMonth = 100;
	}
	
	public String getName() {
		return this.name;
	}

	// STUDENTS
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student student) {
		student.setId(this.students.size());
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
		teacher.setId(this.teachers.size());
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
		expense.setId(this.expenses.size());
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
