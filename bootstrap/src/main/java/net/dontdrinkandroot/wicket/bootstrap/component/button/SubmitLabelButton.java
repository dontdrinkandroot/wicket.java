package net.dontdrinkandroot.wicket.bootstrap.component.button;

import java.io.Serializable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class SubmitLabelButton extends Label implements IButton
{

	protected ButtonBehavior buttonBehavior = new ButtonBehavior(Model.of(ButtonStyle.PRIMARY));


	public SubmitLabelButton(String id)
	{
		super(id);
	}

	public SubmitLabelButton(String id, Serializable label)
	{
		super(id, label);
	}

	public SubmitLabelButton(String id, IModel<?> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(this.buttonBehavior);
	}

	@Override
	public SubmitLabelButton setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}

	@Override
	public SubmitLabelButton setButtonSize(ButtonSize buttonSize)
	{
		this.buttonBehavior.setButtonSize(buttonSize);
		return this;
	}

	@Override
	public ButtonSize getButtonSize()
	{
		return this.buttonBehavior.getButtonSize();
	}

	@Override
	public ButtonStyle getButtonStyle()
	{
		return this.buttonBehavior.getButtonStyle();
	}

	@Override
	protected void onComponentTag(ComponentTag tag)
	{
		tag.setName("button");
		tag.put("type", "submit");
		super.onComponentTag(tag);
	}
}
