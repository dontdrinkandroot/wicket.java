package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;


public class InputGroupNumberTextField<N extends Number & Comparable<N>> extends InputGroup<N, NumberTextField<N>>
{

	public InputGroupNumberTextField(String id, IModel<N> model)
	{
		super(id, model);
	}

	@Override
	protected NumberTextField<N> createFormComponent(String id)
	{
		NumberTextField<N> textField = new NumberTextField<N>(id, this.getModel()) {

			@Override
			protected void onComponentTag(ComponentTag tag)
			{
				tag.put("type", "number");
				super.onComponentTag(tag);
			}
		};
		textField.add(new HTML5Attributes());
		return textField;
	}
}
