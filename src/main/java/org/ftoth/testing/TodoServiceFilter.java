package org.ftoth.testing;

import org.ftoth.testing.service.TodoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoServiceFilter
{
	TodoService todoService;

	public TodoServiceFilter(TodoService todoService) {
		this.todoService = todoService;
	}

	List<String> filter(String user, String txt) {
		if (txt == null) {
			return new ArrayList<String>();
		}
		String txtLo = txt.toLowerCase();
		return todoService.getTodos(user).stream()
			.filter(item -> item.toLowerCase().contains(txtLo))
			.collect(Collectors.toList());
	}
}
