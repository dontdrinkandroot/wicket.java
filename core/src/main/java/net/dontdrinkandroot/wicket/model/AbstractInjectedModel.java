package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;


public abstract class AbstractInjectedModel<T> implements IModel<T> {

	private static final long serialVersionUID = 1L;


	public AbstractInjectedModel() {

		super();
		Injector.get().inject(this);
	}

}
