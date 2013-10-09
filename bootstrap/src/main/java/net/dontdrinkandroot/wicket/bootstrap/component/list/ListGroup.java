package net.dontdrinkandroot.wicket.bootstrap.component.list;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.basic.UnorderedList;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;


public abstract class ListGroup<T> extends UnorderedList<T> {

	public ListGroup(String id, IModel<List<T>> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new CssClassAppender(BootstrapCssClass.LIST_GROUP));
	}


	@Override
	protected void processListComponent(Component listComponent) {

		super.processListComponent(listComponent);
		listComponent.add(new CssClassAppender(BootstrapCssClass.LIST_GROUP_ITEM));
	}

}
