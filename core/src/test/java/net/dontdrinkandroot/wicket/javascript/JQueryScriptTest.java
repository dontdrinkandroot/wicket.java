package net.dontdrinkandroot.wicket.javascript;

import org.junit.Assert;
import org.junit.Test;


public class JQueryScriptTest
{

	@Test
	public void testShow()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.show();
		Assert.assertEquals("$(this).show(0, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testHide()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.hide();
		Assert.assertEquals("$(this).hide(0, 'swing', function() {})", jQueryScript.toString());
	}
}
