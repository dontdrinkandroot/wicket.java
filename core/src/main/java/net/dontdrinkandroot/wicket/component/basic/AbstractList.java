package net.dontdrinkandroot.wicket.component.basic;

import java.util.List;

import net.dontdrinkandroot.wicket.model.ListItemModel;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;


public abstract class AbstractList<T> extends GenericPanel<List<T>> {

	private RepeatingView itemView;


	public AbstractList(String id, IModel<List<T>> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.itemView = new RepeatingView("item") {

			@Override
			protected void onPopulate() {

				this.removeAll();

				IModel<List<T>> model = AbstractList.this.getModel();

				if (model != null && model.getObject() != null) {
					for (int idx = 0; idx < model.getObject().size(); idx++) {
						IModel<T> itemModel = new ListItemModel<T>(model, idx);
						this.add(AbstractList.this.createComponent(this.newChildId(), itemModel));
					}
				}
			}
		};
		this.add(this.itemView);
	}


	protected abstract Component createComponent(String id, IModel<T> model);

}
