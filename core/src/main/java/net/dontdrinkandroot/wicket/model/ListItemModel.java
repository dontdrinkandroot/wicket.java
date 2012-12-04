package net.dontdrinkandroot.wicket.model;

import java.util.List;

import org.apache.wicket.model.IModel;


public class ListItemModel<T> implements IModel<T> {

	private final IModel<List<T>> listModel;

	private final int idx;


	public ListItemModel(IModel<List<T>> model, int idx) {

		this.listModel = model;
		this.idx = idx;
	}


	@Override
	public void detach() {

		/* Noop, depends on parent */
	}


	@Override
	public T getObject() {

		return this.listModel.getObject().get(this.idx);
	}


	@Override
	public void setObject(T object) {

		List<T> list = this.listModel.getObject();
		list.set(this.idx, object);
	}

}
