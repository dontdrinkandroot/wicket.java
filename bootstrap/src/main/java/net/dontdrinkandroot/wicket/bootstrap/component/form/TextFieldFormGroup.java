package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;


public class TextFieldFormGroup<T> extends AbstractFormGroup<T, TextField<T>> {

	public TextFieldFormGroup(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	public TextFieldFormGroup(String id, IModel<T> model, IModel<String> labelModel, Class<T> type) {

		super(id, model, labelModel, type);
	}


	@Override
	protected TextField<T> createFormComponent(String id) {

		return new TextField<T>(id, this.getModel(), this.type);
	}

}
