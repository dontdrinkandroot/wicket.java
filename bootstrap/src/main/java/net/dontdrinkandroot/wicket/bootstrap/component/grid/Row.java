package net.dontdrinkandroot.wicket.bootstrap.component.grid;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public abstract class Row extends Panel
{

	public Row(String id)
	{
		super(id);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new CssClassAppender(BootstrapCssClass.ROW));
		RepeatingView columnView = new RepeatingView("column");
		this.populateColumns(columnView);
		this.add(columnView);
	}

	protected abstract void populateColumns(RepeatingView columnView);

}
