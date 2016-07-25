package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;


public class InputGroupTextField<T> extends InputGroup<T, T, TextField<T>>
{

	public InputGroupTextField(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected TextField<T> createFormComponent(String id)
	{
		TextField<T> textField = new TextField<T>(id, this.getModel()) {

			@Override
			protected void onComponentTag(ComponentTag tag)
			{
				tag.put("type", "text");
				super.onComponentTag(tag);
			}
		};
		textField.add(new HTML5Attributes());
		return textField;
	}

}
