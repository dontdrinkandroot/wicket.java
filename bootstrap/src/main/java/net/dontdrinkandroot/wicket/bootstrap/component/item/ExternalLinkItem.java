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
package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.UrlUtils;


public class ExternalLinkItem extends AbstractLinkItem {

	private final IModel<String> hrefModel;


	public ExternalLinkItem(String id, IModel<String> hrefModel, IModel<String> labelModel) {

		super(id, labelModel);
		this.hrefModel = hrefModel;
	}


	@Override
	protected Component createLink(String id) {

		ExternalLink link = new ExternalLink(id, this.hrefModel);

		link.add(new AttributeModifier("rel", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {

				if (UrlUtils.isRelative(ExternalLinkItem.this.hrefModel.getObject())) {
					return null;
				}
				return "external";
			}
		}));
		link.setBody(this.getModel());
		return link;
	}

}
