package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;


public class PageHeightScalingBehavior extends Behavior {

	public PageHeightScalingBehavior() {

	}


	@Override
	public void renderHead(Component component, IHeaderResponse response) {

		super.renderHead(component, response);

		StringBuffer scalingFunctionBuffer = new StringBuffer();
		scalingFunctionBuffer.append(String.format("var offset = $('#%s').offset();", component.getMarkupId()));
		scalingFunctionBuffer.append(String.format(
				"$('#%s').height($(window).height() - offset.top);",
				component.getMarkupId()));

		response.render(OnDomReadyHeaderItem.forScript(scalingFunctionBuffer.toString()));
		response.render(OnDomReadyHeaderItem.forScript("$(window).resize(function() {"
				+ scalingFunctionBuffer.toString()
				+ "})"));
	}

}
