/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
