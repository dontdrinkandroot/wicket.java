package net.dontdrinkandroot.wicket.component;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;


public class TypedWebMarkupContainer<T> extends WebMarkupContainer {

	private static final long serialVersionUID = 1L;


	public TypedWebMarkupContainer(String id) {

		super(id);
	}


	public TypedWebMarkupContainer(String id, IModel<T> model) {

		super(id, model);
	}


	@SuppressWarnings("unchecked")
	public IModel<T> getModel() {

		return (IModel<T>) this.getDefaultModel();
	}


	public void setModel(IModel<T> model) {

		this.setDefaultModel(model);
	}


	@SuppressWarnings("unchecked")
	public T getModelObject() {

		return (T) this.getDefaultModelObject();
	}


	public void setModelObject(T object) {

		this.setDefaultModelObject(object);
	}
}
