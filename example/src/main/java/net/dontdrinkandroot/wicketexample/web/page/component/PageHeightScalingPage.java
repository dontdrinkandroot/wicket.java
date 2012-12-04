package net.dontdrinkandroot.wicketexample.web.page.component;

import net.dontdrinkandroot.wicket.behavior.PageHeightScalingBehavior;
import net.dontdrinkandroot.wicketexample.web.page.DecoratorWidePage;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class PageHeightScalingPage extends DecoratorWidePage<Void> {

	public PageHeightScalingPage(PageParameters parameters) {

		super(parameters);

		WebMarkupContainer scaling = new WebMarkupContainer("scaling");
		scaling.add(new PageHeightScalingBehavior());
		scaling.setOutputMarkupId(true);
		this.add(scaling);
	}

}
