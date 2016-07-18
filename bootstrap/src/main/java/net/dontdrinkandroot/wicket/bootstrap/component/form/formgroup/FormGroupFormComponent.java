package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;


public abstract class FormGroupFormComponent<T, F extends FormComponent<T>> extends FormGroupValidatable<T, F>
{

	protected F formComponent;

	protected Class<T> type = null;


	public FormGroupFormComponent(String id, IModel<String> labelModel, IModel<T> model)
	{
		this(id, labelModel, model, null);
	}

	public FormGroupFormComponent(String id, IModel<String> labelModel, IModel<T> model, Class<T> type)
	{
		super(id, labelModel, model);
		this.setOutputMarkupId(true);

		this.type = type;

		/* Initialize form component early, so it is available before onInitialize takes place */
		this.formComponent = this.createFormComponent("formComponent");
		this.formComponent.setOutputMarkupId(true);
		this.formComponent.setLabel(this.labelModel);
	}

	@Override
	protected void createComponents()
	{
		super.createComponents();
	}

	@Override
	protected void addComponents()
	{
		super.addComponents();
		this.container.add(this.formComponent);
		this.container.add(this.helpBlock);
	}

	@Override
	public F getFormComponent()
	{
		return this.formComponent;
	}

	protected abstract F createFormComponent(String id);

}
