package net.dontdrinkandroot.wicket.example;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.util.tester.WicketTester;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;
import org.apache.wicket.util.visit.Visits;
import org.junit.Assert;
import org.junit.Before;


public class AbstractWicketTest
{

	protected WicketTester tester;


	@Before
	public void setUp()
	{
		this.tester = new WicketTester(new ExampleTestApplication());
	}

	protected void assertStateless(MarkupContainer component)
	{
		Visits.visitChildren(component, new IVisitor<Component, Void>() {

			@Override
			public void component(Component component, IVisit<Void> visit)
			{
				if (!component.isStateless()) {
					Assert.assertTrue(
							String.format(
									"Component '%s' is not stateless. Type: %s, Path: %s",
									component.getMarkupId(),
									component.getClass().getCanonicalName(),
									component.getPath()),
							component.isStateless());
				}
			}
		});
	}
}
