import java.util.ArrayList;

public class Main {

	public static ArrayList<School> schools = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Teacher teacher1 = new Teacher(1, "Teaher 1", 500);
		Teacher teacher2 = new Teacher(2, "Teacher 2", 600);
		
		ArrayList<Teacher> teachers = new ArrayList<>();
		teachers.add(teacher1);
		teachers.add(teacher2);
		
		Student student1 = new Student(1, "Student 1", 4);
		Student student2 = new Student(2, "Student 2", 5);
		Student student3 = new Student(3, "Student 3", 4);
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		School mySchool = new School("My School", teachers, students);
		schools.add(mySchool);
		
		System.out.println(mySchool.getTotalMoney());
		
		mySchool.newMonth();
		
		System.out.println(mySchool.getTotalMoney());
		
		student2.payFees(30);
		System.out.println(student2.getRemainingFees());
		
		mySchool.addExpense(new Expense(1, "new books", 200));
		
		System.out.println(mySchool.getTotalMoney());
		
		mySchool.addStudent(new Student(4, "Student 4", 9));
	}

}
