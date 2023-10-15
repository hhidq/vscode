package domain;

public class Course {

	private int id;
	private String courseno;
	private String coursename;
	private String type;
	private int period;
	private double credit;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseno() {
		return courseno;
	}
	public void setCourseno(String courseno) {
		this.courseno = courseno;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return "Cource [id=" + id + ", courseno=" + courseno + ", coursename=" + coursename + ", type=" + type
				+ ", period=" + period + ", credit=" + credit + "]";
	}
	
	
}
