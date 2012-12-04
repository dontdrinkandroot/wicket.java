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
		scalingFunctionBuffer.append("var offset = $('#" + component.getMarkupId() + "').offset();");
		scalingFunctionBuffer.append("$('#" + component.getMarkupId() + "').height($(window).height() - offset.top);");

		response.render(OnDomReadyHeaderItem.forScript(scalingFunctionBuffer.toString()));
		response.render(OnDomReadyHeaderItem.forScript("$(window).resize(function() {"
				+ scalingFunctionBuffer.toString()
				+ "})"));
	}

}
