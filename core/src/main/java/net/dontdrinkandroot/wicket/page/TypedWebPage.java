package net.dontdrinkandroot.wicket.page;

import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


/**
 * @deprecated Use {@link GenericWebPage} instead.
 */
@Deprecated
public class TypedWebPage<T> extends WebPage {

	private static final long serialVersionUID = 1L;


	public TypedWebPage(final IModel<T> model) {

		super(model);
	}


	public TypedWebPage(final PageParameters parameters) {

		super(parameters);
	}


	public TypedWebPage() {

		super();
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


	public void setModelObject(final T object) {

		this.setDefaultModelObject(object);
	}

}
