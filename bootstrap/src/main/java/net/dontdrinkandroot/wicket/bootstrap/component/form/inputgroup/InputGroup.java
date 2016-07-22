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

	public static final String INPUT_GROUP_ADDON_BEFORE_ID = "inputGroupAddonBefore";

	public static final String INPUT_GROUP_ADDON_AFTER_ID = "inputGroupAddonAfter";

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

		this.add(this.formComponent);

		this.inputGroupAddonBefore = this.createInputGroupAddonBefore(InputGroup.INPUT_GROUP_ADDON_BEFORE_ID);
		this.add(this.inputGroupAddonBefore);

		this.inputGroupAddonAfter = this.createInputGroupAddonAfter(InputGroup.INPUT_GROUP_ADDON_AFTER_ID);
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
		return new WebMarkupContainer(id).setVisible(false);
	}

	protected Component createInputGroupAddonAfter(String id)
	{
		return new WebMarkupContainer(id).setVisible(false);
	}

	protected abstract F createFormComponent(String id);

}
