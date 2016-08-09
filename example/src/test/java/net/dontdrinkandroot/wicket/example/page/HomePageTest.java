package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.Page;
import org.junit.Test;

import net.dontdrinkandroot.wicket.example.AbstractWicketTest;


public class HomePageTest extends AbstractWicketTest
{

	@Test
	public void testPageStateless()
	{
		this.tester.startPage(HomePage.class);
		this.tester.assertRenderedPage(HomePage.class);
		Page page = this.tester.getLastRenderedPage();
		this.assertStateless(page);
	}
}
