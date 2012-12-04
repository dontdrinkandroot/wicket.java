package net.dontdrinkandroot.wicket.bootstrap.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class BootstrapPage<T> extends AbstractBootstrapPage<T> {

	public BootstrapPage() {

		super();
	}


	public BootstrapPage(PageParameters parameters) {

		super(parameters);
	}


	public BootstrapPage(IModel<T> model) {

		super(model);
	}

}
