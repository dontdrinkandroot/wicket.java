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
package net.dontdrinkandroot.wicket.component.image;

import java.net.URL;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class ExternalImage extends WebComponent {

	public ExternalImage(String id, String urlString) {

		super(id, new Model<String>(urlString));
		this.setEscapeModelStrings(false);
	}


	public ExternalImage(final String id, final IModel<URL> urlModel) {

		super(id, urlModel);
		this.setEscapeModelStrings(false);
	}


	@Override
	protected void onComponentTag(final ComponentTag tag) {

		super.onComponentTag(tag);

		this.checkComponentTag(tag, "img");
		tag.put("src", this.getDefaultModelObjectAsString());
	}
}
