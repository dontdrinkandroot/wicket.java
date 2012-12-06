package net.dontdrinkandroot.wicket.component.jqueryui;

import net.dontdrinkandroot.utils.oldprogressmonitor.ProgressMonitor;
import net.dontdrinkandroot.wicket.component.TypedWebMarkupContainer;
import net.dontdrinkandroot.wicket.javascript.jqueryui.JQueryUiScript;
import net.dontdrinkandroot.wicket.model.progress.ProgressMonitorMessageModel;
import net.dontdrinkandroot.wicket.model.progress.ProgressMonitorPercentModel;

import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;


public class JQueryUiSelfUpdatingProgressBar extends GenericPanel<ProgressMonitor> {

	private static final long serialVersionUID = 1L;

	private final TypedWebMarkupContainer<Integer> progressBar;

	private final Label label;


	public JQueryUiSelfUpdatingProgressBar(String id, IModel<ProgressMonitor> model) {

		super(id, model);

		this.setOutputMarkupId(true);

		this.progressBar =
				new TypedWebMarkupContainer<Integer>("progressBar", new ProgressMonitorPercentModel(this.getModel()));
		this.progressBar.setOutputMarkupId(true);
		this.add(this.progressBar);

		this.label = new Label("label", new ProgressMonitorMessageModel(this.getModel()));
		this.label.setOutputMarkupId(true);
		this.label.setEscapeModelStrings(false);
		this.add(this.label);

		AbstractAjaxTimerBehavior updateBehavior = new AbstractAjaxTimerBehavior(Duration.ONE_SECOND) {

			@Override
			protected void onTimer(AjaxRequestTarget target) {

				target.appendJavaScript(JQueryUiSelfUpdatingProgressBar.this.getUpdateScript());
				target.add(JQueryUiSelfUpdatingProgressBar.this.label);

				if (JQueryUiSelfUpdatingProgressBar.this.getModelObject().isDone()) {
					this.stop(target);
				}

			}
		};
		this.add(updateBehavior);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this.progressBar).progressBar(
				this.progressBar.getModelObject()).toString()));
	}


	public CharSequence getUpdateScript() {

		return String.format(
				"$('#%s').progressbar('option', 'value', %d)",
				this.progressBar.getMarkupId(),
				this.progressBar.getModelObject());
	}


	public Label getLabel() {

		return this.label;
	}

}
