package net.dontdrinkandroot.wicket.component.jquery;

import net.dontdrinkandroot.wicket.javascript.JQueryUiScript;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;


public class JQueryProgressBar extends WebMarkupContainer {

	private static final long serialVersionUID = 1L;


	public JQueryProgressBar(String id) {

		super(id);
		this.setOutputMarkupId(true);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);
		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).progressBar().toString()));
	}


	public CharSequence getUpdateScript(Integer value) {

		return String.format("$('#%s').progressbar('option', 'value', %d)", this.getMarkupId(), value);
	}

}