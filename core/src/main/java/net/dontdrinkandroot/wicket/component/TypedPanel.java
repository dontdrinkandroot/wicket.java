package net.dontdrinkandroot.wicket.component;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;


/**
 * @deprecated Use {@link GenericPanel} instead.
 */
@Deprecated
public class TypedPanel<T> extends Panel {

	private static final long serialVersionUID = 1L;


	public TypedPanel(final String id) {

		super(id);
	}


	public TypedPanel(final String id, final IModel<? extends T> model) {

		super(id, model);
	}


	@SuppressWarnings("unchecked")
	public IModel<T> getModel() {

		return (IModel<T>) this.getDefaultModel();
	}


	public void setModel(final IModel<T> model) {

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
