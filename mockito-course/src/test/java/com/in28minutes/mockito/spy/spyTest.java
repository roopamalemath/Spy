package com.in28minutes.mockito.spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class spyTest {

	@Test
	public void test() {
		List arrayListSpy=spy(ArrayList.class);
		assertEquals(0,arrayListSpy.size());
		arrayListSpy.add("Dummy");
		assertEquals(1, arrayListSpy.size());
		arrayListSpy.remove("Dummy");
		assertEquals(0, arrayListSpy.size());
	}
	
	@Test
	public void verifytest() {
		List arrayListSpy=spy(ArrayList.class);
		arrayListSpy.add("Dummy");
		verify(arrayListSpy).add("Dummy");
		verify(arrayListSpy, never()).clear();
	}

}
