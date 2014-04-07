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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class BadgeBehavior extends Behavior {

	private IModel<BadgeStyle> badgeStyleModel = new Model<BadgeStyle>();


	public BadgeBehavior() {

	}


	public BadgeBehavior(BadgeStyle labelStyle) {

		this.badgeStyleModel = Model.of(labelStyle);
	}


	public BadgeBehavior(IModel<BadgeStyle> labelStyleModel) {

		this.badgeStyleModel = labelStyleModel;
	}


	public BadgeStyle getBadgeStyle() {

		return this.badgeStyleModel.getObject();
	}


	protected IModel<BadgeStyle> getBadgeStyleModel() {

		return this.badgeStyleModel;
	}


	@Override
	public void bind(Component component) {

		super.bind(component);

		component.add(new CssClassAppender(BootstrapCssClass.BADGE));
		component.add(new CssClassAppender(this.getBadgeStyleModel()));
	}
}
