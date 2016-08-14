package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class SubmitButton extends SubmitLink implements IButton
{

	protected ButtonBehavior buttonBehavior = new ButtonBehavior();


	public SubmitButton(String id)
	{
		super(id);
	}

	public SubmitButton(String id, IModel<?> model)
	{
		super(id, model);
	}

	public SubmitButton(String id, Form<?> form)
	{
		super(id, form);
	}

	public SubmitButton(String id, IModel<?> model, Form<?> form)
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
	public SubmitButton setButtonSize(ButtonSize buttonSize)
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
	public SubmitButton setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}

	@Override
	public SubmitButton setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
	{
		this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
		return this;
	}

	@Override
	public SubmitButton setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
	{
		this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
		return this;
	}
}
