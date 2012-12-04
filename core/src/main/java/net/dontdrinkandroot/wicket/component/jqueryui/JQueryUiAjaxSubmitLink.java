package net.dontdrinkandroot.wicket.component.jqueryui;

import net.dontdrinkandroot.wicket.javascript.JQueryUiScript;

import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.form.Form;


public abstract class JQueryUiAjaxSubmitLink extends AjaxSubmitLink {

	public JQueryUiAjaxSubmitLink(String id) {

		this(id, null);
	}


	public JQueryUiAjaxSubmitLink(String id, final Form<?> form) {

		super(id, form);
		this.setOutputMarkupId(true);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);
		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).button().toString()));
	}

}
