package net.dontdrinkandroot.wicket.bootstrap;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;


public class AbstractWicketTest
{

	protected WicketTester tester;


	@Before
	public void setUp()
	{
		this.tester = new WicketTester(new TestApplication());
	}
}
