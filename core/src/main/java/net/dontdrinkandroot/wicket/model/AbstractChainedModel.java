package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;


public abstract class AbstractChainedModel<P, T> implements IModel<T> {

	private final IModel<? extends P> parent;


	public AbstractChainedModel(final IModel<? extends P> parent) {

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

		if (this.parent == null) {
			return null;
		}

		return this.parent.getObject();
	}


	@Override
	public void setObject(final T object) {

		throw new RuntimeException("Chained Model, cannot set Object, must override method in order to do so");
	}

}
