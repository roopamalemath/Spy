package com.in28minutes.data.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	public List<String> retrieveTodos(String user) {
		// TODO Auto-generated method stub
		if(user=="Roopa") {
		return Arrays.asList("Learn Spring MVC",
				             "Learn Spring Boot",
				             "Learn To Sing");
		} else if(user=="Dummy1") {
			return Arrays.asList("Learn Spring MVC",
		                   "Learn To Sing");
		} else {
			return null;
		}
	}

}
