package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.Page;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import net.dontdrinkandroot.wicket.example.ExampleTestApplication;
import net.dontdrinkandroot.wicket.example.page.component.AlertPage;
import net.dontdrinkandroot.wicket.example.page.component.ButtonPage;
import net.dontdrinkandroot.wicket.example.page.component.DropDownPage;
import net.dontdrinkandroot.wicket.example.page.component.LabelPage;
import net.dontdrinkandroot.wicket.example.page.component.ModalPage;
import net.dontdrinkandroot.wicket.example.page.component.NavBarPage;
import net.dontdrinkandroot.wicket.example.page.component.ProgressBarPage;
import net.dontdrinkandroot.wicket.example.page.form.HorizontalFormPage;
import net.dontdrinkandroot.wicket.example.page.form.InlineFormPage;
import net.dontdrinkandroot.wicket.example.page.form.StandardFormPage;


public class SmokeTest
{

	private WicketTester tester;


	@Before
	public void setUp()
	{
		this.tester = new WicketTester(new ExampleTestApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		this.testPage(HomePage.class);
		this.testPage(GridPage.class);
		this.testPage(AlertPage.class);
		this.testPage(ButtonPage.class);
		this.testPage(DropDownPage.class);
		this.testPage(LabelPage.class);
		this.testPage(ModalPage.class);
		this.testPage(NavBarPage.class);
		this.testPage(ProgressBarPage.class);
		this.testPage(StandardFormPage.class);
		this.testPage(HorizontalFormPage.class);
		this.testPage(InlineFormPage.class);
	}

	protected <T extends Page> void testPage(Class<T> pageClass)
	{
		this.tester.startPage(pageClass);
		this.tester.assertRenderedPage(pageClass);
	}
}
