package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class SubmitButtonLink extends SubmitLink implements IButton
{

	private ButtonBehavior buttonBehavior = new ButtonBehavior();


	public SubmitButtonLink(String id)
	{
		super(id);
	}

	public SubmitButtonLink(String id, IModel<?> model)
	{
		super(id, model);
	}

	public SubmitButtonLink(String id, Form<?> form)
	{
		super(id, form);
	}

	public SubmitButtonLink(String id, IModel<?> model, Form<?> form)
	{
		super(id, model, form);
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
	public SubmitButtonLink setButtonSize(ButtonSize buttonSize)
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
	public SubmitButtonLink setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}
}
