package net.dontdrinkandroot.wicket.example.page.component;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.behavior.AlertBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle;


public class AlertPage extends ComponentPage
{

	public AlertPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		RepeatingView alertView = new RepeatingView("alert");
		this.add(alertView);
		for (AlertStyle style : AlertStyle.values()) {
			Label label = new Label(alertView.newChildId(), Model.of(style.name().toLowerCase()));
			label.add(new AlertBehavior(Model.of(style)));
			alertView.add(label);
		}
	}

	@Override
	protected void onBeforeRender()
	{
		super.onBeforeRender();

		this.info("Info Message");
		this.debug("Debug message");
		this.success("Success Message");
		this.warn("Warn Message");
		this.error("Error Message");
		this.fatal("Fatal Message");
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Alerts and Feedback");
	}
}
