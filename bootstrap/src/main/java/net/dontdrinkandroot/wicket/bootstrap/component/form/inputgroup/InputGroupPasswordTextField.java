package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.IModel;


public class InputGroupPasswordTextField extends InputGroup<String, String, PasswordTextField>
{

	public InputGroupPasswordTextField(String id, IModel<String> model)
	{
		super(id, model);
	}

	@Override
	protected PasswordTextField createFormComponent(String id)
	{
		PasswordTextField formComponent = new PasswordTextField(id, this.getModel()) {

			@Override
			protected void onComponentTag(ComponentTag tag)
			{
				tag.put("type", "password");
				super.onComponentTag(tag);
			}
		};
		formComponent.add(new HTML5Attributes());

		return formComponent;
	}
}
