package com.example.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.StudnetSignApplication;
import com.example.entity.Student;
@Service
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudnetSignApplication.class)    
@WebAppConfiguration  
public class StudentService {
//	@Autowired
//	StudentDAO studentDAO;
	private static Map<String,Student> students;
	//签到
//	@Test
	public static void Sign(String name) {
		initStudent();
//		String name = "小红";
		Student student =students.get(name);
		student.setState(true);
//		System.out.println(students);
	}
	//查询
//	@Test
	public static Map<String,Student>  selStudent(){
		initStudent();
		return students;
//		System.out.println(students);
		
	} 
	//初始化学生信息
//	@Test
	public static void initStudent(){
		if(students==null) {
			students= new HashMap<String,Student>();
			students.put("小明", new Student("小明",false));
			students.put("小华", new Student("小华",false));
			students.put("小红", new Student("小红",false));
		}
//		System.out.println(students);
	}
	//统计
	public static int count() {
		int i = 0;
		
		Collection<Student> stuList = students.values();
		Iterator<Student> iterator = stuList.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			i =  student.isSignState()? i+1:i;
		}
		return i;
	}
}
