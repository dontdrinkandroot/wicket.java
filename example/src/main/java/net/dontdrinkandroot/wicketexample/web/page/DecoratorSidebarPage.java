package net.dontdrinkandroot.wicketexample.web.page;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class DecoratorSidebarPage<T> extends DecoratorPage<T> {

	public DecoratorSidebarPage(PageParameters parameters) {

		super(parameters);
	}


	public DecoratorSidebarPage(IModel<T> model) {

		super(model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		RepeatingView sideBarNavItemView = new RepeatingView("sidebarNavItem");
		this.createNavItems(sideBarNavItemView);
		this.add(sideBarNavItemView);
	}


	protected abstract void createNavItems(RepeatingView navItemView);

}
