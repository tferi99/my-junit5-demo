package org.ftoth.testing.service;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService
{
	@Override
	public List<String> getTodos(String user)
	{
		return Arrays.asList("Learn Spring", "Learn Angular", "Practice Java", "Research Spring");
	}
}
