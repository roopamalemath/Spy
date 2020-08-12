package com.in28minutes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTest {
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingMock() {
		List<String> todos=Arrays.asList("Learn Spring MVC",
	             "Learn Spring Boot",
	             "Learn To Sing");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_WithEmptyList() {
		List<String> todos=Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDDMock() {
		
		// Given - setup
		List<String> todos=Arrays.asList("Learn Spring MVC",
	             "Learn Spring Boot",
	             "Learn To Sing");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
				
		// When - call the method SUT
		
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		// Then - i would check whether all the changes that i am supposed 
		//to be making in the specific SUThave happened
		
		assertThat(filteredTodos.size(),is(2));
	}
	
	
}
