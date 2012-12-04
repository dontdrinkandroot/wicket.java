package net.dontdrinkandroot.wicket.component.basic;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.IModel;


public abstract class OrderedList<T> extends AbstractList<T> {

	public OrderedList(String id, IModel<List<T>> model) {

		super(id, model);
	}


	@Override
	protected void onComponentTag(ComponentTag tag) {

		tag.setName("ol");
		super.onComponentTag(tag);
	}

}
