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
package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;


public abstract class AjaxSubmitButtonLink<T> extends AbstractSubmitButtonLink<T> {

	public AjaxSubmitButtonLink(String id) {

		this(id, null, null, null);
	}


	public AjaxSubmitButtonLink(String id, Form<?> form) {

		this(id, null, null, form);
	}


	public AjaxSubmitButtonLink(String id, IModel<T> model) {

		this(id, model, null, null);
	}


	public AjaxSubmitButtonLink(String id, IModel<T> model, IModel<String> labelModel) {

		this(id, model, labelModel, null);

	}


	public AjaxSubmitButtonLink(String id, IModel<T> model, Form<?> form) {

		this(id, model, null, form);
	}


	public AjaxSubmitButtonLink(String id, IModel<T> model, IModel<String> labelModel, Form<?> form) {

		super(id, model, labelModel, form);

		this.add(new AjaxFormSubmitBehavior(form, "click") {

			private static final long serialVersionUID = 1L;


			@Override
			protected void onError(AjaxRequestTarget target) {

				AjaxSubmitButtonLink.this.onError(target, this.getForm());
			}


			@Override
			protected Form<?> findForm() {

				return AjaxSubmitButtonLink.this.getForm();
			}


			@Override
			protected void onComponentTag(ComponentTag tag) {

				/* write the onclick handler only if link is enabled */
				if (AjaxSubmitButtonLink.this.isLinkEnabled()) {
					super.onComponentTag(tag);
				}
			}


			@Override
			public boolean getDefaultProcessing() {

				return AjaxSubmitButtonLink.this.getDefaultFormProcessing();
			}


			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {

				super.updateAjaxAttributes(attributes);
				AjaxSubmitButtonLink.this.updateAjaxAttributes(attributes);
			}


			@Override
			protected void onSubmit(AjaxRequestTarget target) {

				AjaxSubmitButtonLink.this.onSubmit(target, this.getForm());
			}


			@Override
			protected void onAfterSubmit(AjaxRequestTarget target) {

				AjaxSubmitButtonLink.this.onAfterSubmit(target, this.getForm());
			}
		});
	}


	/**
	 * Override this method to provide special submit handling in a multi-button form. This method
	 * will be called <em>before</em> the form's onSubmit method.
	 */
	protected void onSubmit(AjaxRequestTarget target, Form<?> form) {

	}


	/**
	 * Override this method to provide special submit handling in a multi-button form. This method
	 * will be called <em>after</em> the form's onSubmit method.
	 */
	protected void onAfterSubmit(AjaxRequestTarget target, Form<?> form) {

	}


	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {

	}


	@Override
	protected void onComponentTag(ComponentTag tag) {

		super.onComponentTag(tag);

		if (this.isLinkEnabled()) {
			if (tag.getName().toLowerCase().equals("a")) {
				tag.put("href", "#");
			}
		} else {
			this.disableLink(tag);
		}
	}


	/**
	 * Final implementation of the Button's onError. AjaxSubmitLinks have their own onError which is
	 * called.
	 * 
	 * @see org.apache.wicket.markup.html.form.Button#onError()
	 */
	@Override
	public final void onError() {

	}


	/**
	 * Listener method invoked on form submit with errors. This method is called <em>before</em>
	 * {@link Form#onError()}.
	 * 
	 * @param target
	 * @param form
	 */
	protected void onError(AjaxRequestTarget target, Form<?> form) {

	}


	/**
	 * Use {@link #onSubmit(AjaxRequestTarget, Form)} instead.
	 */
	@Override
	public final void onSubmit() {

	}


	/**
	 * Use {@link #onAfterSubmit(AjaxRequestTarget, Form)} instead.
	 */
	@Override
	public final void onAfterSubmit() {

	}

}
