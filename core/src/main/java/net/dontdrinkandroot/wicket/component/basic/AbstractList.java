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

		this.itemView = new RepeatingView("item");
		this.add(this.itemView);
	}


	@Override
	protected void onBeforeRender() {

		super.onBeforeRender();

		this.itemView.removeAll();
		if (this.getModel() != null && this.getModelObject() != null) {
			for (int idx = 0; idx < this.getModelObject().size(); idx++) {
				IModel<T> itemModel = new ListItemModel<T>(this.getModel(), idx);
				this.itemView.add(this.createComponent(this.itemView.newChildId(), itemModel));
			}
		}
	}


	protected abstract Component createComponent(String id, IModel<T> model);

}
