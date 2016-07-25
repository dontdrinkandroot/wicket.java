package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupNumberTextField;


public class FormGroupNumberTextField<N extends Number & Comparable<N>>
		extends FormGroupInputGroup<N, N, NumberTextField<N>, InputGroupNumberTextField<N>>
{

	public FormGroupNumberTextField(String id, IModel<String> labelModel, IModel<N> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroupNumberTextField<N> createInputGroup(String id)
	{
		return new InputGroupNumberTextField<N>(id, this.getModel()) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return FormGroupNumberTextField.this.createInputGroupAddonBefore(id);
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return FormGroupNumberTextField.this.createInputGroupAddonAfter(id);
			}
		};
	}
}
