package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class FormGroupStatic extends FormGroup<String>
{

	private Label content;


	public FormGroupStatic(String id, IModel<String> labelModel, IModel<String> contentModel)
	{
		super(id, labelModel, contentModel);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
	}

	@Override
	protected void createComponents()
	{
		super.createComponents();
		this.content = new Label("content", this.getModel());
	}

	@Override
	protected void addComponents()
	{
		super.addComponents();
		this.container.add(this.content);
	}
}
