package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;


public class TextFieldControlGroup<T> extends AbstractControlGroup<T, TextField<T>> {

	private Class<T> type = null;


	public TextFieldControlGroup(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	public TextFieldControlGroup(String id, IModel<T> model, IModel<String> labelModel, Class<T> type) {

		super(id, model, labelModel);
		this.type = type;
	}


	@Override
	protected TextField<T> createFormComponent(String id) {

		return new TextField<T>(id, this.getModel(), this.type);
	}

}
