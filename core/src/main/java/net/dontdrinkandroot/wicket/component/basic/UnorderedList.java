package net.dontdrinkandroot.wicket.component.basic;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.IModel;


public abstract class UnorderedList<T> extends AbstractList<T> {

	public UnorderedList(String id, IModel<List<T>> model) {

		super(id, model);
	}


	@Override
	protected void onComponentTag(ComponentTag tag) {

		tag.setName("ul");
		super.onComponentTag(tag);
	}

}
