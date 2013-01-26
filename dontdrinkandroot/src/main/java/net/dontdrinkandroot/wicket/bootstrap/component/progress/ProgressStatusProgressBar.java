package net.dontdrinkandroot.wicket.bootstrap.component.progress;

import net.dontdrinkandroot.utils.progressmonitor.ProgressStatus;
import net.dontdrinkandroot.wicket.bootstrap.css.ProgressBarClass;
import net.dontdrinkandroot.wicket.model.progress.ProgressStatusMessageModel;
import net.dontdrinkandroot.wicket.model.progress.ProgressStatusPercentModel;

import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;


public class ProgressStatusProgressBar extends GenericPanel<ProgressStatus> {

	private ProgressBar bar;

	private Label label;

	private AbstractAjaxTimerBehavior selfUpdatingBehavior;


	public ProgressStatusProgressBar(String id, IModel<ProgressStatus> model) {

		super(id, model);
		this.init();
	}


	private void init() {

		this.label = new Label("label", new ProgressStatusMessageModel(this.getModel()));
		this.label.setOutputMarkupId(true);
		this.label.setEscapeModelStrings(false);
		this.add(this.label);

		this.bar = new ProgressBar("progress", new ProgressStatusPercentModel(this.getModel()));
		this.add(this.bar);
	}


	public void update(AjaxRequestTarget target) {

		target.add(this.label);
		this.bar.update(target);
	}


	public ProgressBarClass getBarStyle() {

		return this.bar.getBarStyle();
	}


	public void setBarStyle(ProgressBarClass barStyle) {

		this.bar.setBarStyle(barStyle);
	}


	public boolean isBarActive() {

		return this.bar.isActive();
	}


	public void setBarActive(boolean active) {

		this.bar.setActive(active);
	}


	public void setSelfUpdating(Duration duration) {

		this.selfUpdatingBehavior = new AbstractAjaxTimerBehavior(duration) {

			@Override
			protected void onTimer(AjaxRequestTarget target) {

				ProgressStatusProgressBar.this.update(target);
			}
		};
		this.add(this.selfUpdatingBehavior);
	}


	public void stopSelfUpdating(AjaxRequestTarget target) {

		if (this.selfUpdatingBehavior != null) {
			this.selfUpdatingBehavior.stop(target);
			this.remove(this.selfUpdatingBehavior);
		}
	}


	public AbstractAjaxTimerBehavior getSelfUpdatingBehavior() {

		return this.selfUpdatingBehavior;
	}

}
