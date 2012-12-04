package net.dontdrinkandroot.wicketexample.web.page.auth;

import net.dontdrinkandroot.wicketexample.web.page.DecoratorWidePage;

import org.apache.wicket.request.mapper.parameter.PageParameters;


public class AbstractAuthPage<T> extends DecoratorWidePage<T> {

	public AbstractAuthPage(PageParameters parameters) {

		super(parameters);
	}

}
