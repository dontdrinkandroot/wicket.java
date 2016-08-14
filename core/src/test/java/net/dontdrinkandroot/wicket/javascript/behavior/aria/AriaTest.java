package net.dontdrinkandroot.wicket.javascript.behavior.aria;

import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.wicket.behavior.aria.Aria;


public class AriaTest
{

	@Test
	public void testNaming()
	{
		for (Aria aria : Aria.values()) {
			Assert.assertEquals("aria-" + aria.name().toLowerCase(), aria.getAttribute());
		}
	}
}
