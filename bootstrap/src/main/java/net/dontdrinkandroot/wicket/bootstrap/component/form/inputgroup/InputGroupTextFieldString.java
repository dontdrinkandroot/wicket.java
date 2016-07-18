package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;


public class InputGroupTextFieldString extends InputGroup<String, TextField<String>>
{

	public InputGroupTextFieldString(String id, IModel<String> model)
	{
		super(id, model);
	}

	@Override
	protected TextField<String> createFormComponent(String id)
	{
		TextField<String> textField = new TextField<String>(id, this.getModel(), String.class) {

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
