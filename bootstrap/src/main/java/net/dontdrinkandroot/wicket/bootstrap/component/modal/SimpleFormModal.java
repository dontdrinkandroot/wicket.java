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

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public abstract class SimpleFormModal<T> extends GenericPanel<T>
{

	public SimpleFormModal(String id)
	{
		super(id);
	}

	public SimpleFormModal(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.MODAL));
		this.add(new CssClassAppender(BootstrapCssClass.FADE));

		Form<T> form = this.createForm("form");
		this.add(form);

		Label headingLabel = new Label("heading", this.createHeadingModel());
		headingLabel.add(new CssClassAppender(BootstrapCssClass.MODAL_TITLE));
		form.add(headingLabel);

		RepeatingView formGroupView = new RepeatingView("formGroup");
		this.populateFormGroups(formGroupView);
		form.add(formGroupView);

		RepeatingView formActionView = new RepeatingView("formAction");
		this.populateFormActions(formActionView);
		form.add(formActionView);
	}

	protected Form<T> createForm(String id)
	{
		return new Form<T>(id, this.getModel());
	}

	protected void populateFormActions(RepeatingView formActionView)
	{
	}

	protected void populateFormGroups(RepeatingView formGroupView)
	{
	}

	public CharSequence getHideScript()
	{
		return String.format("$('#%s').modal('hide');", this.getMarkupId());
	}

	public CharSequence getShowScript()
	{
		return String.format("$('#%s').modal({'show': true, 'backdrop':'static'});", this.getMarkupId());
	}

	public CharSequence getToggleScript()
	{
		return String.format("$('#%s').modal('toggle');", this.getMarkupId());
	}

	protected abstract IModel<?> createHeadingModel();

}
