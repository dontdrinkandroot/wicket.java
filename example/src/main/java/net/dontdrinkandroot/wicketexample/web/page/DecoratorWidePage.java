package net.dontdrinkandroot.wicketexample.web.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class DecoratorWidePage<T> extends DecoratorPage<T> {

	public DecoratorWidePage(PageParameters parameters) {

		super(parameters);
	}


	public DecoratorWidePage(IModel<T> model) {

		super(model);
	}

}
