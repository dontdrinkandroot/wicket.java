package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmittingComponent;
import org.apache.wicket.model.IModel;


public abstract class AbstractSubmitButtonLink<T> extends AbstractButtonLink<T> implements IFormSubmittingComponent {

	/**
	 * Target form or null if the form is parent of the link.
	 */
	private Form<?> form;

	/**
	 * If false, all standard processing like validating and model updating is skipped.
	 */
	private boolean defaultFormProcessing = true;


	public AbstractSubmitButtonLink(String id) {

		super(id);
	}


	public AbstractSubmitButtonLink(String id, Form<?> form) {

		super(id);
		this.form = form;
	}


	public AbstractSubmitButtonLink(String id, IModel<T> model) {

		super(id, model);
	}


	public AbstractSubmitButtonLink(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	public AbstractSubmitButtonLink(String id, IModel<T> model, Form<?> form) {

		super(id, model);
		this.form = form;
	}


	public AbstractSubmitButtonLink(String id, IModel<T> model, IModel<String> labelModel, Form<?> form) {

		super(id, model, labelModel);
		this.form = form;
	}


	/**
	 * Sets the defaultFormProcessing property. When false (default is true), all validation and
	 * form updating is bypassed and the onSubmit method of that button is called directly, and the
	 * onSubmit method of the parent form is not called. A common use for this is to create a cancel
	 * button.
	 * 
	 * TODO: This is a copy & paste from Button
	 * 
	 * @param defaultFormProcessing
	 *            defaultFormProcessing
	 * @return This
	 */
	@Override
	public final AbstractSubmitButtonLink<T> setDefaultFormProcessing(boolean defaultFormProcessing) {

		if (this.defaultFormProcessing != defaultFormProcessing) {
			this.addStateChange();
		}

		this.defaultFormProcessing = defaultFormProcessing;
		return this;
	}


	/**
	 * @see org.apache.wicket.markup.html.form.IFormSubmittingComponent#getDefaultFormProcessing()
	 */
	@Override
	public boolean getDefaultFormProcessing() {

		return this.defaultFormProcessing;
	}


	/**
	 * @see org.apache.wicket.markup.html.form.IFormSubmittingComponent#getForm()
	 */
	@Override
	public Form<?> getForm() {

		if (this.form != null) {
			return this.form;
		} else {
			return this.findParent(Form.class);
		}
	}


	/**
	 * @see org.apache.wicket.markup.html.form.IFormSubmittingComponent#getInputName()
	 */
	@Override
	public String getInputName() {

		return Form.getRootFormRelativeId(this);
	}

}
