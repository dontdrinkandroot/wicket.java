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

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;


public class ButtonGroupChoice<T> extends GenericPanel<T> {

	public ButtonGroupChoice(String id, IModel<T> model, List<T> choices) {

		this(id, model, new ListModel<T>(choices));
	}


	public ButtonGroupChoice(String id, IModel<T> model, IModel<List<T>> choicesModel) {

		super(id, model);

		this.setOutputMarkupId(true);
		this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));

		final RepeatingView choicesView = new RepeatingView("choice");
		choicesView.setOutputMarkupId(true);
		this.add(choicesView);

		for (final T choice : choicesModel.getObject()) {

			AjaxLink<Void> choiceLink = new AjaxLink<Void>(choicesView.newChildId()) {

				@Override
				public void onClick(AjaxRequestTarget target) {

					ButtonGroupChoice.this.onSelectionChanged(choice, target);
				}
			};
			choiceLink.setBody(this.getDisplayModel(choice));
			choiceLink.add(new CssClassAppender(new Model<BootstrapCssClass>() {

				@Override
				public BootstrapCssClass getObject() {

					if (ButtonGroupChoice.this.getModelObject().equals(choice)) {
						super.getObject();
					}

					return null;
				}
			}));

			choicesView.add(choiceLink);
		}
	}


	protected void onSelectionChanged(T choice, AjaxRequestTarget target) {

		this.setModelObject(choice);
		target.add(ButtonGroupChoice.this);
	}


	protected IModel<String> getDisplayModel(T choice) {

		return new Model<String>(choice.toString());
	}

}
