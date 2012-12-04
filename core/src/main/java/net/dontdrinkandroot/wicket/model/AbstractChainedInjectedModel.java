package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;


public abstract class AbstractChainedInjectedModel<P, T> extends AbstractInjectedModel<T> {

	private final IModel<? extends P> parent;


	public AbstractChainedInjectedModel(final IModel<? extends P> parent) {

		Injector.get().inject(this);
		this.parent = parent;
	}


	@Override
	public void detach() {

		/* Noop */
	}


	public IModel<? extends P> getParent() {

		return this.parent;
	}


	public P getParentObject() {

		return this.parent.getObject();
	}


	@Override
	public void setObject(final T object) {

		throw new RuntimeException("Chained Model, cannot set Object, must override method in order to do so");
	}
}
