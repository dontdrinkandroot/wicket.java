package net.dontdrinkandroot.wicket.component.jqueryui;

import net.dontdrinkandroot.utils.progressmonitor.ProgressStatus;
import net.dontdrinkandroot.wicket.component.TypedPanel;
import net.dontdrinkandroot.wicket.component.TypedWebMarkupContainer;
import net.dontdrinkandroot.wicket.javascript.JQueryUiScript;
import net.dontdrinkandroot.wicket.model.jqueryui.ProgressStatusMessageModel;
import net.dontdrinkandroot.wicket.model.jqueryui.ProgressStatusPercentModel;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class JQueryUiProgressStatusProgressBar extends TypedPanel<ProgressStatus> {

	private static final long serialVersionUID = 1L;

	private final TypedWebMarkupContainer<Integer> progressBar;

	private final Label label;


	public JQueryUiProgressStatusProgressBar(String id, IModel<ProgressStatus> model) {

		super(id, model);

		this.setOutputMarkupId(true);

		this.progressBar =
				new TypedWebMarkupContainer<Integer>("progressBar", new ProgressStatusPercentModel(this.getModel()));
		this.progressBar.setOutputMarkupId(true);
		this.add(this.progressBar);

		this.label = new Label("label", new ProgressStatusMessageModel(this.getModel()));
		this.label.setOutputMarkupId(true);
		this.label.setEscapeModelStrings(false);
		this.add(this.label);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this.progressBar).progressBar(
				this.progressBar.getModelObject()).toString()));
	}


	public CharSequence getUpdateScript() {

		StringBuffer sb = new StringBuffer();
		sb.append(String.format(
				"$('#%s .ui-progressbar-value').animate({width: %d + '%%'});",
				this.progressBar.getMarkupId(),
				this.progressBar.getModelObject()));
		sb.append(String.format(
				"$('#%s .ui-progressbar-value').css('display','block');",
				this.progressBar.getMarkupId()));
		sb.append(String.format(
				"$('#%s').attr('aria-valuenow', %d);",
				this.progressBar.getMarkupId(),
				this.progressBar.getModelObject()));

		return sb.toString();
	}


	public Label getLabel() {

		return this.label;
	}

}
