package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.UrlTextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupUrl;


public class FormGroupInputUrl extends FormGroupInputGroup<String, String, UrlTextField, InputGroupUrl>
{

	public FormGroupInputUrl(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroupUrl createInputGroup(String id)
	{
		return new InputGroupUrl(id, this.getModel()) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return FormGroupInputUrl.this.createInputGroupAddonBefore(id);
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return FormGroupInputUrl.this.createInputGroupAddonAfter(id);
			}
		};
	}
}
