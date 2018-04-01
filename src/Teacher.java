import java.util.ArrayList;

public class Teacher {
	private int id;
	private String name;
	private int salary;
	private ArrayList<Integer> salaries = new ArrayList<>();
	
	/**
	 * Keeping track of teachers name, id and salary
	 * @param id: unique ID of teacher
	 * @param name: name of teacher
	 * @param salary: salary of teacher
	 */
	public Teacher(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void payTeacher() {
		this.salaries.add(salary);
	}
	
	/**
	 * Get the sum of all salaries that were paid to the teacher
	 */
	public int getTotalPaidSalary() {
		int result = 0;
		
		for (int i = 0; i < salaries.size(); i++) {
			result += salaries.get(i);
		}
		
		return result;
	}
}
