package junitExecution.procedure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDemo {
	Student s1,s2,s3,s4;
	@Before
	public void setUp()  {
		System.out.println("-----------------------------------");
		System.out.println("In Before method");
		s1=new Student(1,"samyuktha",35);
		s2=new Student(2,"rajil",50);
		s3=new Student(3,"priyanka",60);
		s4=new Student(4,"surya",70);
	}
	@Test
	public void testPass() {
		System.out.println("In testpass test method");
		s1.cal_Grade();
		assertEquals("Pass class",s1.Grade);
		s1.Display();
	}
	@Test
	public void testSecond() {
		System.out.println("In testsecond test method");
		s2.cal_Grade();
		assertEquals("Second class",s2.Grade);
		s2.Display();
	}
	@Test
	public void testFirst() {
		System.out.println("In testFirst test method");
		s3.cal_Grade();
		assertEquals("First Class",s3.Grade);
		s3.Display();
	}
	@Test
	public void testDist() {
		System.out.println("In testFirst test method");
		s4.cal_Grade();
		assertEquals("Distintion",s4.Grade);
		s4.Display();
	}
}