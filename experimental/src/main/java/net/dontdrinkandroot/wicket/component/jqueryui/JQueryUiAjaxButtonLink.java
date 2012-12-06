package net.dontdrinkandroot.wicket.component.jqueryui;

import net.dontdrinkandroot.wicket.javascript.jqueryui.JQueryUiScript;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;


public abstract class JQueryUiAjaxButtonLink<T> extends AjaxLink<T> {

	private static final long serialVersionUID = 1L;


	public JQueryUiAjaxButtonLink(String id) {

		super(id);
		this.setOutputMarkupId(true);
	}


	public JQueryUiAjaxButtonLink(String id, IModel<T> model) {

		super(id, model);
		this.setOutputMarkupId(true);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);
		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).button().toString()));
	}
}
