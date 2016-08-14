package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropDownToggleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropDownMenu;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


abstract public class SplitDropDownButton<T> extends GenericPanel<T> implements IButton
{

	private ButtonBehavior buttonBehavior = new ButtonBehavior();

	private WebMarkupContainer toggle;


	public SplitDropDownButton(String id)
	{
		super(id);
	}

	public SplitDropDownButton(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));

		Component action = this.createAction("button");
		action.add(this.buttonBehavior);
		this.add(action);

		this.toggle = new WebMarkupContainer("toggle");
		this.toggle.add(this.buttonBehavior);
		this.toggle.add(new DropDownToggleBehavior());
		this.toggle.add(new IconBehavior().setAppendIcon(this.getCaretClass()).setSeparator(null));
		this.add(this.toggle);

		this.add(this.createDropDownMenu("dropdownMenu"));
	}

	public WebMarkupContainer getToggle()
	{
		return this.toggle;
	}

	protected Component createDropDownMenu(String id)
	{
		DropDownMenu dropDownMenu = new DropDownMenu(id) {

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				SplitDropDownButton.this.populateItems(itemView);

			}
		};
		return dropDownMenu;
	};

	@Override
	public ButtonSize getButtonSize()
	{
		return this.buttonBehavior.getButtonSize();
	}

	@Override
	public SplitDropDownButton<T> setButtonSize(ButtonSize buttonSize)
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
	public SplitDropDownButton<T> setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}

	@Override
	public SplitDropDownButton<T> setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
	{
		this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
		return this;
	}

	@Override
	public SplitDropDownButton<T> setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
	{
		this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
		return this;
	}

	protected BootstrapCssClass getCaretClass()
	{
		return BootstrapCssClass.CARET;
	}

	protected abstract Component createAction(String id);

	protected abstract void populateItems(RepeatingView itemView);
}
