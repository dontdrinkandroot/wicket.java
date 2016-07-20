package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class AjaxSubmitButton extends AjaxSubmitLink implements IButton
{

	private ButtonBehavior buttonBehavior = new ButtonBehavior();


	public AjaxSubmitButton(String id)
	{
		super(id);
	}

	public AjaxSubmitButton(String id, IModel<String> bodyModel)
	{
		super(id);
		this.setBody(bodyModel);
	}

	public AjaxSubmitButton(String id, Form<?> form)
	{
		super(id, form);
	}

	public AjaxSubmitButton(String id, Form<?> form, IModel<String> bodyModel)
	{
		super(id, form);
		this.setBody(bodyModel);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(this.buttonBehavior);
	}

	@Override
	public ButtonSize getButtonSize()
	{
		return this.buttonBehavior.getButtonSize();
	}

	@Override
	public AjaxSubmitButton setButtonSize(ButtonSize buttonSize)
	{
		this.buttonBehavior.setButtonSize(buttonSize);
		return this;
	}

	@Override
	public ButtonStyle getButtonStyle()
	{
		return this.buttonBehavior.getButtonStyle();
	}

	@Override
	public AjaxSubmitButton setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}

}
