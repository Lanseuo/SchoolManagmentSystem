
public class Expense {
	private int id;
	private String name;
	private float amount;
	
	public Expense(int id, String name, float amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getAmount() {
		return this.amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
