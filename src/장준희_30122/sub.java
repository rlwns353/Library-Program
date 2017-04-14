package 장준희_30122;

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
		System.out.println("제목 : " + name);
		System.out.println("저자 : " + human);
		System.out.println("출판사 : " + company);
		System.out.println("가격 : " + cost);
		return getName() + "," + getHuman() + "," + getCompany() + "," + getCost();

	}

}
