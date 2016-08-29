package net.dontdrinkandroot.wicket.javascript;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;


public class JQueryScriptTest
{

	@Test
	public void testShow()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.show();
		Assert.assertEquals("jQuery(this).show(0, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testHide()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.hide();
		Assert.assertEquals("jQuery(this).hide(0, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testToggle()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.toggle();
		Assert.assertEquals("jQuery(this).toggle(0, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testFadeIn()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.fadeIn();
		Assert.assertEquals("jQuery(this).fadeIn(400, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testFadeOut()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.fadeOut();
		Assert.assertEquals("jQuery(this).fadeOut(400, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testFadeToggle()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.fadeToggle();
		Assert.assertEquals("jQuery(this).fadeToggle(400, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testAnimate()
	{
		JQueryScript jQueryScript = new JQueryScript();

		Properties properties = new Properties();
		properties.setProperty("height", "100px");
		jQueryScript.animate(properties);
		Assert.assertEquals(
				"jQuery(this).animate({'height': '100px'}, 400, 'swing', function() {})",
				jQueryScript.toString());
	}

	@Test
	public void testSlideDown()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.slideDown();
		Assert.assertEquals("jQuery(this).slideDown(400, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testSlideUp()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.slideUp();
		Assert.assertEquals("jQuery(this).slideUp(400, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testSlideToggle()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.slideToggle();
		Assert.assertEquals("jQuery(this).slideToggle(400, 'swing', function() {})", jQueryScript.toString());
	}

	@Test
	public void testChildren()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.children(".test");
		Assert.assertEquals("jQuery(this).children('.test')", jQueryScript.toString());
	}

	@Test
	public void testSiblings()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.siblings(".test");
		Assert.assertEquals("jQuery(this).siblings('.test')", jQueryScript.toString());
	}

	@Test
	public void testAddClass()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.addClass(".test");
		Assert.assertEquals("jQuery(this).addClass('.test')", jQueryScript.toString());
	}

	@Test
	public void testRemoveClass()
	{
		JQueryScript jQueryScript = new JQueryScript();
		jQueryScript.removeClass(".test");
		Assert.assertEquals("jQuery(this).removeClass('.test')", jQueryScript.toString());
	}
}
