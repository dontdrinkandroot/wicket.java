package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.model.IModel;


public class InputGroupEmailTextField extends InputGroup<String, String, EmailTextField>
{

	public InputGroupEmailTextField(String id, IModel<String> model)
	{
		super(id, model);
	}

	@Override
	protected EmailTextField createFormComponent(String id)
	{
		EmailTextField formComponent = new EmailTextField(id, this.getModel()) {

			@Override
			protected void onComponentTag(ComponentTag tag)
			{
				tag.put("type", "email");
				super.onComponentTag(tag);
			}
		};
		formComponent.add(new HTML5Attributes());

		return formComponent;
	}
}
