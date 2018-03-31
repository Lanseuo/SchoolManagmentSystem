
public class Student {

	private int id;
	private String name;
	private int grade;
	private int feesPaid;
	private int feesTotal;
	
	/**
	 * This class is responsible for keeping
	 * track of students fees, name, grade and
 	 * fees paid
	 * @param id: unique ID for the student
	 * @param name: name of the student
	 * @param grade: grade of the student
	 */
	public Student(int id, String name, int grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.feesPaid = 0;
		this.feesTotal = 0;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getFeesPaid() {
		return this.feesPaid;
	}
	
	public int getGrade() {
		return grade;
	}

	public int getFeesTotal() {
		return this.feesTotal;
	}

	/**
	 * Update students grade
	 * @param grade: new grade of the student
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	/**
	 * Keep adding the fees feesPaid
	 * Add the fees to the fees paid
	 * The school is going to receive the funds
	 * @param fees: fees that the student paid
	 */
	
	public void payFees(int fees) {
		this.feesPaid += fees;
		
	}
	
	public int getRemainingFees() {
		return this.feesTotal - this.feesPaid;
	}
	
	public void demandFees(int currentFees) {
		this.feesTotal += currentFees;
	}
}
