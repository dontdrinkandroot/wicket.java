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
package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public abstract class AbstractModalPanel<T> extends AbstractBaseModalPanel<T> {

	public AbstractModalPanel(String id) {

		super(id);
	}


	public AbstractModalPanel(String id, IModel<T> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Label headingLabel = new Label("heading", this.createHeadingModel());
		headingLabel.add(new CssClassAppender(BootstrapCssClass.MODAL_TITLE));
		this.add(headingLabel);

		Component body = this.createBody("body");
		body.add(new CssClassAppender(BootstrapCssClass.MODAL_BODY));
		this.add(body);

		Component footer = this.createFooter("footer");
		footer.add(new CssClassAppender(BootstrapCssClass.MODAL_FOOTER));
		this.add(footer);
	}

}
