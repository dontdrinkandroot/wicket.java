package net.dontdrinkandroot.wicket.bootstrap;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;


public class TestFormPanel extends Panel
{

	private Form<Void> form;


	public TestFormPanel(String id)
	{
		super(id);
		this.form = new Form<Void>("form");
		this.add(this.form);
	}

	public Form<Void> getForm()
	{
		return this.form;
	}
}
