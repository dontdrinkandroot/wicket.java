package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon;

import java.io.Serializable;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public class InputGroupLabel extends Label
{

	public InputGroupLabel(String id)
	{
		super(id);
	}

	public InputGroupLabel(String id, Serializable label)
	{
		super(id, label);
	}

	public InputGroupLabel(String id, IModel<?> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new CssClassAppender(BootstrapCssClass.INPUT_GROUP_ADDON));
	}

}
