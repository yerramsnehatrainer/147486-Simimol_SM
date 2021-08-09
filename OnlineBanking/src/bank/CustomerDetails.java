package bank;

public class CustomerDetails {
	private int customerId;
	private String name;
	private int age;
	public int getCustomerId() {
		return customerId;
	}
	public CustomerDetails(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
