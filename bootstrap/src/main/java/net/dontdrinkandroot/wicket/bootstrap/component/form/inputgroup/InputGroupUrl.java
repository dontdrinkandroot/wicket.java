package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.UrlTextField;
import org.apache.wicket.model.IModel;


public class InputGroupUrl extends InputGroup<String, String, UrlTextField>
{

	public InputGroupUrl(String id, IModel<String> model)
	{
		super(id, model);
	}

	@Override
	protected UrlTextField createFormComponent(String id)
	{
		UrlTextField formComponent = new UrlTextField(id, this.getModel()) {

			@Override
			protected void onComponentTag(ComponentTag tag)
			{
				tag.put("type", "url");
				super.onComponentTag(tag);
			}
		};
		formComponent.add(new HTML5Attributes());

		return formComponent;
	}
}
