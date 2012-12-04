package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;


public abstract class AbstractInjectedLoadableDetachableModel<T> extends LoadableDetachableModel<T> {

	private static final long serialVersionUID = 1L;


	public AbstractInjectedLoadableDetachableModel() {

		super();
		Injector.get().inject(this);
	}


	public AbstractInjectedLoadableDetachableModel(final T object) {

		super(object);
		Injector.get().inject(this);
	}

}
