package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class AjaxSubmitButtonLink extends AjaxSubmitLink implements IButton
{

	private ButtonBehavior buttonBehavior = new ButtonBehavior();


	public AjaxSubmitButtonLink(String id)
	{
		super(id);
	}

	public AjaxSubmitButtonLink(String id, Form<?> form)
	{
		super(id, form);
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
	public AjaxSubmitButtonLink setButtonSize(ButtonSize buttonSize)
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
	public AjaxSubmitButtonLink setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}

}
