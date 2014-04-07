/**
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
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

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.css.CssClass;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class AbstractLinkItem extends AbstractItem<String> {

	private IModel<CssClass> beforeIconModel;

	private IModel<CssClass> afterIconModel;


	public AbstractLinkItem(String id, IModel<String> labelModel) {

		super(id, labelModel);
	}


	public AbstractLinkItem(String id, String label) {

		super(id, Model.of(label));
	}


	public AbstractLinkItem setBeforeIcon(CssClass beforeIcon) {

		if (beforeIcon == null) {
			this.beforeIconModel = null;
		} else {
			this.beforeIconModel = Model.of(beforeIcon);
		}

		return this;
	}


	public AbstractLinkItem setAfterIcon(CssClass afterIcon) {

		if (afterIcon == null) {
			this.afterIconModel = null;
		} else {
			this.afterIconModel = Model.of(afterIcon);
		}

		return this;
	}


	public IModel<CssClass> getBeforeIconModel() {

		return this.beforeIconModel;
	}


	public IModel<CssClass> getAfterIconModel() {

		return this.afterIconModel;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Component link = this.createLink("link");
		link.add(new IconBehavior() {

			@Override
			public IModel<CssClass> getPrependIconModel() {

				return AbstractLinkItem.this.getBeforeIconModel();
			};


			@Override
			public IModel<CssClass> getAppendIconModel() {

				return AbstractLinkItem.this.getAfterIconModel();
			};
		});
		this.add(link);
	}


	protected abstract Component createLink(String id);
}
