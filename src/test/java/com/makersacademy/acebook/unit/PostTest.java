package com.makersacademy.acebook.unit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import com.makersacademy.acebook.Post;
import org.junit.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostTest {


	private Post post = new Post("hello");
	private Long id = new Long(1);
	String str = "2000-12-12 12:00";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

	@Test
	public void postHasContent() {
		assertThat(post.getContent(), containsString("hello"));
	}

    @Test
    public void postHasId() {
        post.setId(id);
        assertEquals(post.getId(), id);
    }

    @Test
	public void postHasTimeStamp() {
		post.setCreatedAt(dateTime);
		String TimeString = String.join(" ",post.getCreatedAt().toString().split("T"));
		assertEquals(str, TimeString);
	}

}

