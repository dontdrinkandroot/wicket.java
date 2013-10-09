package net.dontdrinkandroot.wicket.bootstrap.component.list;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.basic.OrderedList;

import org.apache.wicket.model.IModel;


public abstract class UnstyledOrderedList<T> extends OrderedList<T> {

	public UnstyledOrderedList(String id, IModel<List<T>> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new CssClassAppender(BootstrapCssClass.LIST_UNSTYLED));
	}

}
