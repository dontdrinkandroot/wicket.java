package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;


public class TextAreaControlGroup<T> extends AbstractControlGroup<T, TextArea<T>> {

	public TextAreaControlGroup(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	@Override
	protected TextArea<T> createFormComponent(String id) {

		return new TextArea<T>(id, this.getModel());
	}

}
