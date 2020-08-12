package com.in28minutes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingAStub() {
		TodoService todoServiceStub=new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	//what we can the two items in the arraylist 
  //this test case returns only one value or its not returning anything back 
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingAStub1() {
		TodoService todoServiceStub=new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy1");
		assertEquals(1, filteredTodos.size());
	}
}
