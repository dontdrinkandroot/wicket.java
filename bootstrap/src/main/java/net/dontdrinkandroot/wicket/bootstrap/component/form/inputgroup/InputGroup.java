package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
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

	private Component inputGroupAddonBefore =
			new WebMarkupContainer(InputGroup.INPUT_GROUP_ADDON_BEFORE_ID).setVisible(false);

	private Component inputGroupAddonAfter =
			new WebMarkupContainer(InputGroup.INPUT_GROUP_ADDON_AFTER_ID).setVisible(false);

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

	public InputGroup<T, F> setInputGroupAddonBefore(Component component)
	{
		if (!InputGroup.INPUT_GROUP_ADDON_BEFORE_ID.equals(component.getId())) {
			throw new WicketRuntimeException("Component must have id " + InputGroup.INPUT_GROUP_ADDON_BEFORE_ID);
		}
		this.inputGroupAddonBefore = component;

		return this;
	}

	public InputGroup<T, F> setInputGroupAddonAfter(Component component)
	{
		if (!InputGroup.INPUT_GROUP_ADDON_AFTER_ID.equals(component.getId())) {
			throw new WicketRuntimeException("Component must have id " + InputGroup.INPUT_GROUP_ADDON_AFTER_ID);
		}
		this.inputGroupAddonAfter = component;

		return this;
	}

	protected abstract F createFormComponent(String id);

}
