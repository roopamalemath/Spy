package com.in28minutes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import java.util.List;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void letsMockListSizeMethod() {
		// given 
		List listMock=mock(List.class);
		given(listMock.size()).willReturn(2);
		
		// when and then 
	    assertThat(listMock.size(), is(2));
	}

	@Test
	public void letsMockListSize_ReturnMultipleVales() {
		//Given setup 
		List listMock=mock(List.class);
		given(listMock.size()).willReturn(2).willReturn(3);
	    
	    // When
		//listMock.size();
	    //Then
	    assertThat(listMock.size(),is(2));
	    assertThat(listMock.size(),is(3));
	}
	
	@Test
	public void letsMockGetMethod() {
		//given
		List<String> listMock=mock(List.class);
		given(listMock.get(0)).willReturn("Roopa");
		
		// when
		String firstElement=listMock.get(0);
		
		//then
	    assertThat(firstElement,is("Roopa"));
	   // not mock the get(1) nice mocks kick in it would return a value null
	    assertEquals(null,listMock.get(1));
	}
	
	/*@Test
	@Disabled
	public void letsMockGetMethod_ReturnsNull() {
		List<String> listMock=mock(List.class);
	    //when(listMock.get(0)).thenReturn("Roopa");
	    assertThat(listMock.get(0),null);
	   // not mock the get(1) nice mocks kick in it would return a value null
	    assertThat(listMock.get(1),null);
	}*/
	
	@Test
	public void letsMockGetMethod_Argumentmather() {
		List<String> listMock=mock(List.class);
		given(listMock.get(anyInt())).willReturn("in28minutes").willReturn("Malemath");
		
	    assertThat(listMock.get(0),is("in28minutes"));
	   // not mock the get(1) nice mocks kick in it would return a value null
	    assertThat(listMock.get(1),is("Malemath"));
	}
	
	@Test(expected=RuntimeException.class) // catching exception
	public void letsMockGetMethod_ExceptionHangling() {
		List listMock=mock(List.class);
		given(listMock.get(anyInt())).willThrow(new RuntimeException("Something"));
	    listMock.get(1);
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_mixingUp() {
		List listMock=mock(List.class);
		given(listMock.subList(anyInt(), 5)).willThrow(new RuntimeException("either generic or specific"));
	    listMock.subList(2,5);
	}
}
