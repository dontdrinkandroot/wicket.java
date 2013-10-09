package net.dontdrinkandroot.wicket.bootstrap.component.list;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.basic.UnorderedList;

import org.apache.wicket.model.IModel;


public abstract class UnstyledUnorderedList<T> extends UnorderedList<T> {

	public UnstyledUnorderedList(String id, IModel<List<T>> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new CssClassAppender(BootstrapCssClass.LIST_UNSTYLED));
	}

}
