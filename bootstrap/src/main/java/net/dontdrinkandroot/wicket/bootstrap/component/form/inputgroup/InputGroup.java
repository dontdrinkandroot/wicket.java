package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public abstract class InputGroup<T, F extends FormComponent<T>> extends GenericPanel<T>
{

	private Component inputGroupAddonBefore;

	private Component inputGroupAddonAfter;

	private F formComponent;


	public InputGroup(String id)
	{
		this(id, null);
	}

	public InputGroup(String id, IModel<T> model)
	{
		super(id, model);
		this.formComponent = this.createFormComponent("formComponent");
		this.formComponent.setOutputMarkupId(true);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.INPUT_GROUP));

		this.inputGroupAddonBefore = this.createInputGroupAddonBefore("inputGroupAddonBefore");
		this.inputGroupAddonAfter = this.createInputGroupAddonAfter("inputGroupAddonAfter");

		this.add(this.formComponent);
		this.add(this.inputGroupAddonBefore);
		this.add(this.inputGroupAddonAfter);
	}

	@Override
	protected void onConfigure()
	{
		super.onConfigure();

		boolean hasAddon = this.inputGroupAddonBefore.isVisible() || this.inputGroupAddonAfter.isVisible();
		this.setRenderBodyOnly(!hasAddon);
	}

	@Override
	protected void onBeforeRender()
	{
		super.onBeforeRender();
	}

	public F getFormComponent()
	{
		return this.formComponent;
	}

	protected Component createInputGroupAddonBefore(String id)
	{
		WebMarkupContainer inputGroupAddon = new WebMarkupContainer(id);
		inputGroupAddon.setVisible(false);
		return inputGroupAddon;
	}

	protected Component createInputGroupAddonAfter(String id)
	{
		WebMarkupContainer inputGroupAddon = new WebMarkupContainer(id);
		inputGroupAddon.setVisible(false);
		return inputGroupAddon;
	}

	protected abstract F createFormComponent(String id);

}
