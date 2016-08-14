package net.dontdrinkandroot.wicket.bootstrap.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;


public class StandardBootstrapPageTest extends AbstractWicketTest
{

	@Test
	public void testDefaultMarkup()
	{
		this.tester.startPage(new StandardBootstrapPage<Void>() {

			@Override
			protected IModel<String> createPageHeadingModel()
			{
				return Model.of("Page Heading");
			}

			@Override
			protected IModel<String> createPageTitlePrefixModel()
			{
				return Model.of("Page Title Prefix");
			}
		});
		String pageResponse = this.tester.getLastResponseAsString();

		TagTester titleTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "pageTitle");
		Assert.assertEquals("Page Title Prefix - Page Heading", titleTester.getValue());

		TagTester headingTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "pageHeading");
		Assert.assertEquals("Page Heading", headingTester.getValue());
	}
}
