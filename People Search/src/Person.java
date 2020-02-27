
public class Person implements Comparable<Person>{
	private int age;
	private String name;
	
	public Person(int a, String n) {
		age = a;
		name = n;
	}
	
	public Person() {
		age = 0;
		name = "";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name + " is " + age + " year(s) old";
	}

	@Override
	public int compareTo(Person o) {
		return getName().toLowerCase().compareTo(o.getName().toLowerCase());
	}
	
	
}
