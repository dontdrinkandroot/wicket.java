package net.dontdrinkandroot.wicket.component.jqueryui;

import net.dontdrinkandroot.wicket.component.TypedWebMarkupContainer;
import net.dontdrinkandroot.wicket.javascript.jqueryui.JQueryUiScript;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;


public class JqueryUiProgressBar extends TypedWebMarkupContainer<Integer> {

	private static final long serialVersionUID = 1L;


	public JqueryUiProgressBar(String id, IModel<Integer> model) {

		super(id, model);
		this.setOutputMarkupId(true);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).progressBar(this.getModelObject()).toString()));
	}


	public CharSequence getUpdateScript() {

		return String.format("$('#%s').progressbar('option', 'value', %d)", this.getMarkupId(), this.getModelObject());
	}

}
