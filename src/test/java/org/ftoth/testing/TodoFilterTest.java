package org.ftoth.testing;

import org.ftoth.testing.service.TodoService;
import org.ftoth.testing.service.TodoServiceStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoFilterTest
{
	@Test
	@DisplayName("filter with Stub TodoService")
	void testFilter_withStub() {
		TodoServiceFilter filter = new TodoServiceFilter(new TodoServiceStub());
		List<String> learnTodos = filter.filter("Jozsi", "learn");
		assertEquals(2, learnTodos.size());
	}

	@Test
	@DisplayName("filter with Mock TodoService")
	void testFilter_withMock() {
		// Given
		List<String> ret = Arrays.asList("Learn Spring", "Learn Angular", "Practice Java", "Research Spring");
		TodoService service = mock(TodoService.class);
		when(service.getTodos(anyString())).thenReturn(ret);

		// When
		TodoServiceFilter filter = new TodoServiceFilter(service);
		List<String> learnTodos = filter.filter("Jozsi", "learn");

		// Then
		assertEquals(2, learnTodos.size());
	}

/*	@Test
	@DisplayName("filter with Mock BDD TodoService")
	void testFilter_withBddMock() {
		// Given
		List<String> ret = Arrays.asList("Learn Spring", "Learn Angular", "Practice Java", "Research Spring");
		TodoService service = mock(TodoService.class);
		given(service.getTodos(anyString())).willReturn(ret);
		TodoServiceFilter filter = new TodoServiceFilter(service);

		// When
		List<String> learnTodos = filter.filter("Jozsi", "learn");

		// Then
		assertThat(learnTodos.size(), Is(2));
	}*/
}
