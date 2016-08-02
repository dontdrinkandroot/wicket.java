package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;


public class InputGroupNumber<N extends Number & Comparable<N>> extends InputGroup<N, N, NumberTextField<N>>
{

	public InputGroupNumber(String id, IModel<N> model)
	{
		super(id, model);
	}

	@Override
	protected NumberTextField<N> createFormComponent(String id)
	{
		NumberTextField<N> formComponent = new NumberTextField<N>(id, this.getModel()) {

			@Override
			protected void onComponentTag(ComponentTag tag)
			{
				tag.put("type", "number");
				super.onComponentTag(tag);
			}
		};
		formComponent.add(new HTML5Attributes());

		return formComponent;
	}
}
