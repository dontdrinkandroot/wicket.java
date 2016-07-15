package net.dontdrinkandroot.wicket.example;

public class ExampleTestApplication extends ExampleApplication
{

	@Override
	protected void init()
	{
		super.init();
		this.getMarkupSettings().setStripWicketTags(false);
	}
}
