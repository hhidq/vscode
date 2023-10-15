package domain;

public class ClassNo {
	
	private int id;
    private String cno;
    private String className;
    private String department;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "ClassNo [id=" + id + ", cno=" + cno + ", className=" + className + ", department=" + department + "]";
	}
    

}
