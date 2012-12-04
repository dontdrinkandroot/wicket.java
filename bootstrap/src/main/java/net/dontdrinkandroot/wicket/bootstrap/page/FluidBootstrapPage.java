package net.dontdrinkandroot.wicket.bootstrap.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class FluidBootstrapPage<T> extends AbstractBootstrapPage<T> {

	public FluidBootstrapPage() {

		super();
	}


	public FluidBootstrapPage(PageParameters parameters) {

		super(parameters);
	}


	public FluidBootstrapPage(IModel<T> model) {

		super(model);
	}

}
