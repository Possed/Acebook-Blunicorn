package com.makersacademy.unit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import com.makersacademy.acebook.Post;
import org.junit.Test;


public class PostTest {

	private Post post = new Post("hello");
	private Long id = new Long(1);

	@Test
	public void postHasContent() {
		assertThat(post.getContent(), containsString("hello"));
	}

    @Test
    public void postHasId() {
        post.setId(id);
        assertEquals(post.getId(), id);
    }

}

