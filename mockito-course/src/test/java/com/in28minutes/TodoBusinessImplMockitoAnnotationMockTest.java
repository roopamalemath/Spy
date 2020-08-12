package com.in28minutes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockitoAnnotationMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingMock() {
		TodoService todoServiceMock=mock(TodoService.class);
		List<String> todos=Arrays.asList("Learn Spring MVC",
	             "Learn Spring Boot",
	             "Learn To Sing");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_WithEmptyList() {
		TodoService todoServiceMock=mock(TodoService.class);
		List<String> todos=Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDDMock() {
		
		// Given - setup
		TodoService todoServiceMock=mock(TodoService.class);
		List<String> todos=Arrays.asList("Learn Spring MVC",
	             "Learn Spring Boot",
	             "Learn To Sing");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceMock);
		
		// When - call the method SUT
		
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		// Then - i would check whether all the changes that i am supposed 
		//to be making in the specific SUThave happened
		
		assertThat(filteredTodos.size(),is(2));
	}
	
	
}
