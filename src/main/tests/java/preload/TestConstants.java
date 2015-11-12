package main.tests.java.preload;

import org.junit.Assert;
import org.junit.Test;

import main.java.preload.Constants;

public class TestConstants {

	@Test
	public void testLoad() {
		Assert.assertFalse(Constants.isLoaded());
		Constants.load();
		Assert.assertTrue(Constants.isLoaded());
	}
	
	@Test
	public void testCommentExists() {
		Assert.assertEquals("Siddharth Ramesh", Constants.get("test_author"));
	}
	
	@Test
	public void testCommentDoesNotExist() {
		Assert.assertEquals(null, Constants.get("test_should_not_exist"));
	}
	
	@Test
	public void testIgnoresComments() {
		Assert.assertEquals(null, Constants.get("#"));
	}

}
