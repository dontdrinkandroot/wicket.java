package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;


public abstract class AbstractChainedInjectedLoadableDetachableModel<P, T> extends LoadableDetachableModel<T>
{

	private IModel<? extends P> parentModel;


	public AbstractChainedInjectedLoadableDetachableModel(IModel<? extends P> parentModel)
	{
		this.parentModel = parentModel;
		Injector.get().inject(this);
	}

	public IModel<? extends P> getParent()
	{
		return this.parentModel;
	}

	public P getParentObject()
	{
		return this.parentModel.getObject();
	}

	@Override
	public void detach()
	{
		super.detach();
		this.parentModel.detach();
	}

	@Override
	public void setObject(final T object)
	{
		throw new RuntimeException("Chained Model, cannot set Object, must override method in order to do so");
	}

}
