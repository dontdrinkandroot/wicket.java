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
package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.IAjaxLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.IModel;


public abstract class AjaxButtonLink<T> extends AbstractButtonLink<T> implements IAjaxLink {

	public AjaxButtonLink(String id) {

		super(id);
	}


	public AjaxButtonLink(String id, IModel<T> model) {

		super(id, model);
	}


	public AjaxButtonLink(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(this.newAjaxEventBehavior("onclick"));
	}


	/**
	 * @param event
	 *            the name of the default event on which this link will listen to
	 * @return the ajax behavior which will be executed when the user clicks the link
	 */
	protected AjaxEventBehavior newAjaxEventBehavior(String event) {

		return new AjaxEventBehavior(event) {

			private static final long serialVersionUID = 1L;


			@Override
			protected void onEvent(AjaxRequestTarget target) {

				AjaxButtonLink.this.onClick(target);
			}


			@Override
			protected void onComponentTag(ComponentTag tag) {

				// add the onclick handler only if link is enabled
				if (AjaxButtonLink.this.isLinkEnabled()) {
					super.onComponentTag(tag);
				}
			}


			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {

				super.updateAjaxAttributes(attributes);
				AjaxButtonLink.this.updateAjaxAttributes(attributes);
			}
		};
	}


	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {

	}


	/**
	 * @return the channel that manages how Ajax calls are executed
	 * @see AbstractDefaultAjaxBehavior#getChannel()
	 */
	@Deprecated
	protected AjaxChannel getChannel() {

		return null;
	}


	@Override
	protected void onComponentTag(ComponentTag tag) {

		super.onComponentTag(tag);

		if (this.isLinkEnabled()) {
			/* disable any href attr in markup */
			if (tag.getName().equalsIgnoreCase("a")
					|| tag.getName().equalsIgnoreCase("link")
					|| tag.getName().equalsIgnoreCase("area")) {
				tag.put("href", "#");
			}
		} else {
			this.disableLink(tag);
		}

	}


	/**
	 * Listener method invoked on the ajax request generated when the user clicks the link
	 * 
	 * @param target
	 */
	@Override
	public abstract void onClick(final AjaxRequestTarget target);

}
