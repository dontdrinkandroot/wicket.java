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
package net.dontdrinkandroot.wicket.component.jqueryui;

import net.dontdrinkandroot.wicket.javascript.jqueryui.JQueryUiScript;

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
