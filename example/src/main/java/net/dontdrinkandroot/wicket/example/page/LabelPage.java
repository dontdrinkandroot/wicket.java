package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.behavior.LabelBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.LabelStyle;


public class LabelPage extends ComponentPage
{

	public LabelPage(PageParameters parameters)
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

		RepeatingView labelView = new RepeatingView("label");
		this.add(labelView);
		for (LabelStyle style : LabelStyle.values()) {
			Label label = new Label(labelView.newChildId(), Model.of(style.name().toLowerCase()));
			label.add(new LabelBehavior(Model.of(style)));
			labelView.add(label);
		}
	}
}
