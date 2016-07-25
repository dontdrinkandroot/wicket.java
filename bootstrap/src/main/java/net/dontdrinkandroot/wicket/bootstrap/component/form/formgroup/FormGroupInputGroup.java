package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;


public abstract class FormGroupInputGroup<T, M, F extends FormComponent<M>, I extends InputGroup<T, M, F>>
		extends FormGroupValidatable<T, M, F>
{

	private InputGroup<T, M, F> inputGroup;


	public FormGroupInputGroup(String id, IModel<String> labelModel, IModel<T> model)
	{
		super(id, labelModel, model);
		this.inputGroup = this.createInputGroup("inputGroup");
		this.getFormComponent().setLabel(this.labelModel);
	}

	@Override
	protected void addComponents()
	{
		super.addComponents();

		this.container.add(this.inputGroup);
	}

	@Override
	public F getFormComponent()
	{
		return this.inputGroup.getFormComponent();
	}

	protected Component createInputGroupAddonBefore(String id)
	{
		return new WebMarkupContainer(id).setVisible(false);
	}

	protected Component createInputGroupAddonAfter(String id)
	{
		return new WebMarkupContainer(id).setVisible(false);
	}

	protected abstract InputGroup<T, M, F> createInputGroup(String id);

}
