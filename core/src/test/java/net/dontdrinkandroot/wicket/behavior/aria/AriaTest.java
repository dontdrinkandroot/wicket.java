package net.dontdrinkandroot.wicket.behavior.aria;

import org.junit.Assert;
import org.junit.Test;


public class AriaTest
{

	@Test
	public void testNaming()
	{
		Aria[] ariaValues = Aria.values();
		Assert.assertEquals(35, ariaValues.length);
		for (Aria aria : ariaValues) {
			Assert.assertEquals("aria-" + aria.name().toLowerCase(), aria.getAttribute());
		}
	}
}
