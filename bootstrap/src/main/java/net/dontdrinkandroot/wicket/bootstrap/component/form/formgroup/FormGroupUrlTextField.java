package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.UrlTextField;
import org.apache.wicket.model.IModel;


public class FormGroupUrlTextField extends AbstractFormGroupTextField<String, UrlTextField>
{

	public FormGroupUrlTextField(String id, IModel<String> model, String label)
	{
		super(id, model, label);
	}

	public FormGroupUrlTextField(String id, IModel<String> model, IModel<String> labelModel)
	{
		super(id, model, labelModel);
	}

	@Override
	protected UrlTextField createFormComponent(String id)
	{
		UrlTextField urlTextField = new UrlTextField(id, this.getModel());
		urlTextField.add(new HTML5Attributes());
		urlTextField.add(new AttributeModifier("type", "url"));

		return urlTextField;
	}

}
