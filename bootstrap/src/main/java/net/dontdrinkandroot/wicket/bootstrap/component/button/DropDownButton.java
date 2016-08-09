package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.markup.html.basic.Label;
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
import net.dontdrinkandroot.wicket.bootstrap.css.DropDownAlignment;
import net.dontdrinkandroot.wicket.css.CssClass;


public abstract class DropDownButton<T> extends GenericPanel<T> implements IButton
{

	protected ButtonBehavior buttonBehavior = new ButtonBehavior();

	private IModel<String> labelModel;

	private Label toggle;

	private DropDownMenu menu;


	public DropDownButton(String id)
	{
		super(id);
		this.createComponents();
	}

	public DropDownButton(String id, IModel<T> model)
	{
		super(id, model);
		this.createComponents();
	}

	public DropDownButton(String id, IModel<T> model, IModel<String> labelModel)
	{
		super(id, model);
		this.labelModel = labelModel;
		this.createComponents();
	}

	protected void createComponents()
	{
		this.toggle = new Label("toggle", this.labelModel);
		this.toggle.add(new DropDownToggleBehavior());
		this.menu = new DropDownMenu("menu") {

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				DropDownButton.this.populateItems(itemView);
			}
		};
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));
		this.toggle.add(this.buttonBehavior);
		this.toggle.add(new IconBehavior().setAppendIcon(this.getCaretClass()));
		this.add(this.toggle);
		this.add(this.menu);
	}

	@Override
	public ButtonSize getButtonSize()
	{
		return this.buttonBehavior.getButtonSize();
	}

	@Override
	public DropDownButton<T> setButtonSize(ButtonSize buttonSize)
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
	public DropDownButton<T> setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}

	public Label getToggle()
	{
		return this.toggle;
	}

	public DropDownMenu getMenu()
	{
		return this.menu;
	}

	public DropDownButton<T> setDropDownAlignment(DropDownAlignment alignment)
	{
		this.menu.setAlignment(alignment);
		return this;
	}

	private CssClass getCaretClass()
	{
		return BootstrapCssClass.CARET;
	}

	protected abstract void populateItems(RepeatingView itemView);
}
