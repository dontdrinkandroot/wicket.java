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

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;


public class SubmitButtonLink<T> extends AbstractSubmitButtonLink<T> {

	public SubmitButtonLink(String id) {

		super(id);
	}


	public SubmitButtonLink(String id, Form<?> form) {

		super(id, form);
	}


	public SubmitButtonLink(String id, IModel<T> model) {

		super(id, model);
	}


	public SubmitButtonLink(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	public SubmitButtonLink(String id, IModel<T> model, Form<?> form) {

		super(id, model, form);
	}


	public SubmitButtonLink(String id, IModel<T> model, IModel<String> labelModel, Form<?> form) {

		super(id, model, labelModel, form);
	}


	/**
	 * This method is here as a means to fall back on normal link behavior when this link is not
	 * nested in a form. Not intended to be called by clients directly.
	 * 
	 * @see org.apache.wicket.markup.html.link.ILinkListener#onLinkClicked()
	 */
	public final void onLinkClicked() {

		this.onSubmit();
		this.onAfterSubmit();
	}


	/**
	 * @see org.apache.wicket.Component#onComponentTag(org.apache.wicket.markup.ComponentTag)
	 */
	@Override
	protected void onComponentTag(ComponentTag tag) {

		super.onComponentTag(tag);
		/* If we're disabled */
		if (!this.isLinkEnabled()) {
			this.disableLink(tag);
		} else {
			if (tag.getName().equalsIgnoreCase("a")) {
				tag.put("href", "#");
			}
			tag.put("onclick", this.getTriggerJavaScript());
		}
	}


	/**
	 * Controls whether or not clicking on this link will invoke form's javascript onsubmit handler.
	 * True by default.
	 * 
	 * @return true if form's javascript onsubmit handler should be invoked, false otherwise
	 */
	protected boolean shouldInvokeJavaScriptFormOnsubmit() {

		return true;
	}


	/**
	 * The JavaScript which triggers this link. Method is non-final so that subclasses can decorate
	 * the provided script by wrapping their own JS around a call to super.getTriggerJavaScript().
	 * 
	 * @return The JavaScript to be executed when the link is clicked.
	 */
	protected String getTriggerJavaScript() {

		if (this.getForm() != null) {
			// find the root form - the one we are really going to submit
			Form<?> root = this.getForm().getRootForm();
			StringBuilder sb = new StringBuilder(100);
			sb.append("var e=document.getElementById('");
			sb.append(root.getHiddenFieldId());
			sb.append("'); e.name=\'");
			sb.append(this.getInputName());
			sb.append("'; e.value='x';");
			sb.append("var f=document.getElementById('");
			sb.append(root.getMarkupId());
			sb.append("');");
			if (this.shouldInvokeJavaScriptFormOnsubmit()) {
				if (this.getForm() != root) {
					sb.append("var ff=document.getElementById('");
					sb.append(this.getForm().getMarkupId());
					sb.append("');");
				} else {
					sb.append("var ff=f;");
				}
				sb.append("if (ff.onsubmit != undefined) { if (ff.onsubmit()==false) return false; }");
			}
			sb.append("f.submit();e.value='';e.name='';return false;");
			return sb.toString();
		} else {
			return null;
		}
	}


	/**
	 * @see org.apache.wicket.markup.html.form.IFormSubmittingComponent#onError()
	 */
	@Override
	public void onError() {

	}


	/**
	 * Override this method to provide special submit handling in a multi-button form. This method
	 * will be called <em>after</em> the form's onSubmit method.
	 */
	@Override
	public void onAfterSubmit() {

	}


	/**
	 * Override this method to provide special submit handling in a multi-button form. This method
	 * will be called <em>before</em> the form's onSubmit method.
	 */
	@Override
	public void onSubmit() {

	}

}