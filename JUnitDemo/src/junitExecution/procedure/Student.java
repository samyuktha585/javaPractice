package junitExecution.procedure;

public class Student {
	int roll_no;
	String name;
	float percentage;
	String Grade;
	public Student(int rn,String nm,float p)
	{
		this.roll_no=rn;
		name=nm;
		percentage=p;
	}
	public String cal_Grade()
	{
		if(percentage<35)
		{
			Grade="Fail";
		}
		else if(percentage<50)
		{
			Grade="Pass class";
		}
		else if(percentage<60)
		{
			Grade="Second class";
		}
		else if(percentage<70)
		{
			Grade="First Class";
		}
		else
		{
			Grade="Distintion";
		}
		return Grade;
	}
	public void Display()
	{
		System.out.println("Roll Number:"+roll_no);
		System.out.println("Name:"+name);
		System.out.println("Percentage:"+percentage);
		System.out.println("Grade:"+Grade);
	}
}