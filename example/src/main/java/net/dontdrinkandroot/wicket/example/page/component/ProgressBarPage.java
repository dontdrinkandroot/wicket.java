package net.dontdrinkandroot.wicket.example.page.component;

import java.util.Iterator;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.progress.ProgressBar;
import net.dontdrinkandroot.wicket.bootstrap.css.ProgressBarStyle;


public class ProgressBarPage extends ComponentPage
{

	public ProgressBarPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Progress Bars");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		final IModel<Integer> valueModel = new Model<Integer>(33);
		final RepeatingView progressBarView = new RepeatingView("progressBarStyle");
		this.add(progressBarView);
		for (ProgressBarStyle style : ProgressBarStyle.values()) {
			progressBarView.add(new ProgressBar(progressBarView.newChildId(), valueModel, style));
		}

		AjaxLink<Void> updateButton = new AjaxLink<Void>("updateButton") {

			@Override
			public void onClick(AjaxRequestTarget target)
			{
				valueModel.setObject((int) Math.round(Math.random() * 100));
				Iterator<Component> childIterator = progressBarView.iterator();
				for (; childIterator.hasNext();) {
					Component child = childIterator.next();
					((ProgressBar) child).update(target);
				}
			}
		};
		updateButton.setBody(Model.of("update"));
		updateButton.add(new ButtonBehavior());
		this.add(updateButton);

		ProgressBar stripedBar = new ProgressBar("stripedBar", valueModel, ProgressBarStyle.DEFAULT, true, false);
		this.add(stripedBar);

		ProgressBar activeBar = new ProgressBar("activeBar", valueModel, ProgressBarStyle.DEFAULT, true, true);
		this.add(activeBar);
	}
}
