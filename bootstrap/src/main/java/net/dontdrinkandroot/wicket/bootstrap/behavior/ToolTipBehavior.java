/*
 * Copyright (C) 2012-2016 Philip Washington Sorst <philip@sorst.net>
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
import net.dontdrinkandroot.wicket.model.EnumLowerCaseNameModel;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class ToolTipBehavior extends Behavior {

	private final IModel<String> textModel;

	private final IModel<Position> positionModel = new Model<Position>();

	private final IModel<Integer> delayModel = new Model<Integer>();


	public ToolTipBehavior(IModel<String> textModel) {

		this.textModel = textModel;
	}


	@Override
	public void bind(Component component) {

		super.bind(component);

		component.add(new AttributeModifier("title", this.textModel));
		component.add(new CssClassAppender("has-tooltip"));
		component.add(new AttributeModifier("data-placement", new EnumLowerCaseNameModel(this.getPositionModel())));
		component.add(new AttributeModifier("data-delay", this.getDelayModel()));
	}


	@Override
	public void renderHead(Component component, IHeaderResponse response) {

		super.renderHead(component, response);

		response.render(OnDomReadyHeaderItem.forScript("$('.has-tooltip').tooltip();"));
	}


	public Integer getDelay() {

		return this.delayModel.getObject();
	}


	public ToolTipBehavior setDelay(Integer delay) {

		this.delayModel.setObject(delay);
		return this;
	}


	public Position getPosition() {

		return this.positionModel.getObject();
	}


	public ToolTipBehavior setPosition(Position position) {

		this.positionModel.setObject(position);
		return this;
	}


	protected IModel<Position> getPositionModel() {

		return this.positionModel;
	}


	protected IModel<Integer> getDelayModel() {

		return this.delayModel;
	}


	public enum Position {
		TOP,
		BOTTOM,
		LEFT,
		RIGHT;
	}

}
