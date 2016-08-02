package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupNumber;


public class FormGroupInputNumber<N extends Number & Comparable<N>>
		extends FormGroupInputGroup<N, N, NumberTextField<N>, InputGroupNumber<N>>
{

	public FormGroupInputNumber(String id, IModel<String> labelModel, IModel<N> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroupNumber<N> createInputGroup(String id)
	{
		return new InputGroupNumber<N>(id, this.getModel()) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return FormGroupInputNumber.this.createInputGroupAddonBefore(id);
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return FormGroupInputNumber.this.createInputGroupAddonAfter(id);
			}
		};
	}
}
