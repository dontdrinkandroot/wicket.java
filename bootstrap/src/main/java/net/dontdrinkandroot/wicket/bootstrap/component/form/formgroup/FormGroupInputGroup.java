package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;


public abstract class FormGroupInputGroup<T, F extends FormComponent<T>, I extends InputGroup<T, F>>
		extends FormGroupValidatable<T, F>
{

	private InputGroup<T, F> inputGroup;


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

	public FormGroupInputGroup<T, F, I> setInputGroupAddonBefore(Component component)
	{
		this.inputGroup.setInputGroupAddonBefore(component);
		return this;
	}

	public FormGroupInputGroup<T, F, I> setInputGroupAddonAfter(Component component)
	{
		this.inputGroup.setInputGroupAddonAfter(component);
		return this;
	}

	protected abstract InputGroup<T, F> createInputGroup(String id);

}
