package net.dontdrinkandroot.wicket.bootstrap.css;

import org.junit.Assert;
import org.junit.Test;


public class FontAwesomeIconClassTest
{

	@Test
	public void testGetClassString()
	{
		for (FontAwesomeIconClass fontAwesomeIconClass : FontAwesomeIconClass.values()) {
			if (!(fontAwesomeIconClass.equals(FontAwesomeIconClass.FIVEHUNDRED_PX))) {
				Assert.assertEquals(
						"fa-" + fontAwesomeIconClass.name().toLowerCase().replace("_", "-"),
						fontAwesomeIconClass.getClassString());
			}
		}
	}
}
