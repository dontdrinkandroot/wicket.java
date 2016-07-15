package net.dontdrinkandroot.wicket.example.page.component;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class ButtonPage extends ComponentPage
{

	public ButtonPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Labels");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		RepeatingView styleView = new RepeatingView("buttonStyle");
		this.add(styleView);
		for (ButtonStyle style : ButtonStyle.values()) {
			Label button = new Label(styleView.newChildId(), Model.of(style.name().toLowerCase()));
			button.add(new ButtonBehavior(Model.of(style)));
			styleView.add(button);
		}

		RepeatingView sizeView = new RepeatingView("buttonSize");
		this.add(sizeView);
		for (ButtonSize size : ButtonSize.values()) {
			Label button = new Label(sizeView.newChildId(), Model.of(size.name().toLowerCase()));
			button.add(new ButtonBehavior().setButtonSize(size));
			sizeView.add(button);
		}
	}
}
