package net.dontdrinkandroot.wicket.component.repeater;

import java.util.Iterator;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;


public abstract class AppendingDataView<T> extends DataView<T> {

	private final String itemTagName;


	protected AppendingDataView(String id, IDataProvider<T> dataProvider, String itemTagName, long itemsPerPage) {

		super(id, dataProvider, itemsPerPage);
		this.itemTagName = itemTagName;
	}


	public void appendNewItems(AjaxRequestTarget target, Component parent) {

		Iterator<IModel<T>> models = this.getItemModels();
		Iterator<Item<T>> items = this.getItemReuseStrategy().getItems(this.newItemFactory(), models, this.getItems());

		int index = 0;
		while (items.hasNext()) {

			Item<T> item = items.next();
			item.setOutputMarkupId(true);
			item.setIndex(index);
			this.add(item);
			++index;

			target.prependJavaScript(String.format(
					"var item = document.createElement('%s'); item.id = '%s'; Wicket.$('%s').appendChild(item);",
					this.itemTagName,
					item.getMarkupId(),
					parent.getMarkupId()));
			target.add(item);
		}
	}


	@Override
	protected void onConfigure() {

		super.onConfigure();

		/*
		 * Reset current page before rendering so that on a page reload or re-adding of the view we
		 * start scrolling from the top again
		 */
		this.setCurrentPage(0);
	}

}
