package com.in28minutes.springboot.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.Student;
import com.in28minutes.springboot.jpa.StudentDaoImpl;
import com.in28minutes.springboot.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {	
	
	
	@Mock
	private StudentDaoImpl studentdaoimpl;
	
	@InjectMocks
	StudentService studentservice;
	
	@Test
	public void testgetStudentDetail()
	{	
	Student expected = new Student(1,"Sevanti",25,"A");
	when(studentdaoimpl.getStudentFromDb(1)).thenReturn(expected);
	
	Student result = studentservice.getStudentDetails(1);
	
	assertEquals(expected,result);
	}
	

}
