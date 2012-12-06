package net.dontdrinkandroot.wicket.component.jqueryui;

import net.dontdrinkandroot.wicket.javascript.JQueryUiScript;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;


public abstract class JQueryUiButtonLink<T> extends Link<T> {

	private static final long serialVersionUID = 1L;


	public JQueryUiButtonLink(String id) {

		super(id);
		this.setOutputMarkupId(true);
	}


	public JQueryUiButtonLink(String id, IModel<T> model) {

		super(id, model);
		this.setOutputMarkupId(true);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);
		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).button().toString()));
	}

}
