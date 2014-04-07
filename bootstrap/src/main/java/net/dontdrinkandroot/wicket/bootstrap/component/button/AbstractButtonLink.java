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

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.component.TypedWebMarkupContainer;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class AbstractButtonLink<T> extends TypedWebMarkupContainer<T> {

	private IModel<String> labelModel;

	private final IModel<ButtonStyle> buttonStyleModel = Model.of(ButtonStyle.DEFAULT);

	private final IModel<ButtonSize> buttonSizeModel = new Model<ButtonSize>();


	public AbstractButtonLink(String id) {

		super(id);
	}


	public AbstractButtonLink(String id, IModel<T> model) {

		super(id, model);
	}


	public AbstractButtonLink(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model);

		this.labelModel = labelModel;
	}


	@Override
	public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {

		super.onComponentTagBody(markupStream, openTag);

		/* Set body to label if a */
		if (this.labelModel != null
				&& (openTag.getName().equalsIgnoreCase("a") || openTag.getName().equalsIgnoreCase("button"))) {
			this.replaceComponentTagBody(markupStream, openTag, this.labelModel.getObject());
		}
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new ButtonBehavior(this.getButtonStyleModel(), this.getButtonSizeModel()));
		this.add(new DisabledCssBehavior());
	}


	@Override
	protected void onComponentTag(ComponentTag tag) {

		super.onComponentTag(tag);

		/* Set value to label if input */
		if (tag.getName().equalsIgnoreCase("input") && this.labelModel != null) {
			tag.put("value", this.labelModel.getObject());
		}
	}


	public AbstractButtonLink<T> setButtonStyle(ButtonStyle buttonStyle) {

		this.buttonStyleModel.setObject(buttonStyle);
		return this;
	}


	public AbstractButtonLink<T> setButtonSize(ButtonSize buttonSize) {

		this.buttonSizeModel.setObject(buttonSize);
		return this;
	}


	protected IModel<ButtonStyle> getButtonStyleModel() {

		return this.buttonStyleModel;
	}


	protected IModel<ButtonSize> getButtonSizeModel() {

		return this.buttonSizeModel;
	}


	/**
	 * Helper methods that both checks whether the link is enabled and whether the action ENABLE is
	 * allowed.
	 * 
	 * @return whether the link should be rendered as enabled
	 */
	protected boolean isLinkEnabled() {

		return this.isEnabledInHierarchy();
	}


	protected void disableLink(final ComponentTag tag) {

		/* if the tag is an anchor proper */
		if (tag.getName().equalsIgnoreCase("a")
				|| tag.getName().equalsIgnoreCase("link")
				|| tag.getName().equalsIgnoreCase("area")) {

			/* Remove any href from the old link */
			tag.remove("href");

			/* Remove onclick from the old link */
			tag.remove("onclick");
		}

		/* if the tag is a button or input */
		else if ("button".equalsIgnoreCase(tag.getName()) || "input".equalsIgnoreCase(tag.getName())) {
			tag.put("disabled", "disabled");
		}
	}


	public void setLabelModel(IModel<String> labelModel) {

		this.labelModel = labelModel;
	}

}
