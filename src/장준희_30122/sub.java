package ������_30122;

public class sub {
	private String name;
	private String cost;
	private String company;
	private String human;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getHuman() {
		return human;
	}

	public void setHuman(String human) {
		this.human = human;
	}

	public String toString() {
		System.out.println("���� : " + name);
		System.out.println("���� : " + human);
		System.out.println("���ǻ� : " + company);
		System.out.println("���� : " + cost);
		return getName() + "," + getHuman() + "," + getCompany() + "," + getCost();

	}

}
