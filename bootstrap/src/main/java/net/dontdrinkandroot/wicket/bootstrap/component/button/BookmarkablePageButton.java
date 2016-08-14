package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class BookmarkablePageButton<T> extends BookmarkablePageLink<T> implements IButton
{

	protected ButtonBehavior buttonBehavior = new ButtonBehavior();


	public <C extends Page> BookmarkablePageButton(String id, Class<C> pageClass)
	{
		super(id, pageClass);
	}

	public <C extends Page> BookmarkablePageButton(String id, Class<C> pageClass, PageParameters parameters)
	{
		super(id, pageClass, parameters);
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
	public BookmarkablePageButton<T> setButtonSize(ButtonSize buttonSize)
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
	public BookmarkablePageButton<T> setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}

	public BookmarkablePageButton<T> setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
	{
		this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
		return this;
	}

	public BookmarkablePageButton<T> setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
	{
		this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
		return this;
	}
}
