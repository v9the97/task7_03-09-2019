
public class Threading_class  extends Thread{
private int employeeno, basisalary;
private String employeename;


	public int getEmployeeno() {
	return employeeno;
}

public void setEmployeeno(int employeeno) {
	this.employeeno = employeeno;
}

public int getBasisalary() {
	return basisalary;
}

public void setBasisalary(int basisalary) {
	this.basisalary = basisalary;
}

public String getEmployeename() {
	return employeename;
}

public void setEmployeename(String employeename) {
	this.employeename = employeename;
}

public void run()
{
	System.out.println(" hr of employee "+Thread.currentThread().getName()+" "+(basisalary/100));
	System.out.println(" DA of employee "+Thread.currentThread().getName()+" "+((basisalary*25)/100));
	System.out.println(" CA of employee "+Thread.currentThread().getName()+" "+(basisalary/100));
}
	

	public Threading_class(int employeeno,  String employeename,int basisalary) {
		super();
		this.employeeno = employeeno;
		this.basisalary = basisalary;
		this.employeename = employeename;
	}

	public static void main(String[] args) {
		Threading_class  obj1=new Threading_class (1,"vinod",200);
		Threading_class  obj2=new Threading_class (2,"ravi",200);
		Threading_class  obj3=new Threading_class (3,"rahul",200);
		Threading_class  obj4=new Threading_class (4,"tanish",200);
		Threading_class  obj5=new Threading_class (5,"vijay",200);
		obj1.setName("AAAAA");
		obj2.setName("BBBBB");
		obj3.setName("CCCCC");
		obj4.setName("DDDDD");
		obj5.setName("EEEEE");
		obj1.start();
		obj2.start();
		obj3.start();
		obj4.start();
		obj5.start();
		}
}
