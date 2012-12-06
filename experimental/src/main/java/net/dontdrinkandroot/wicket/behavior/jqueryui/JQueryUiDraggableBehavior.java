package net.dontdrinkandroot.wicket.behavior.jqueryui;

import net.dontdrinkandroot.wicket.javascript.jqueryui.JQueryUiScript;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;


public class JQueryUiDraggableBehavior extends Behavior {

	@Override
	public void renderHead(Component component, IHeaderResponse response) {

		super.renderHead(component, response);
		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(component).append(".draggable()").toString()));
	}

}
