package net.dontdrinkandroot.wicket.bootstrap.component.thumbnail;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ColumnSize;
import net.dontdrinkandroot.wicket.model.ListItemModel;

import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;


public abstract class ThumbnailsList<T> extends GenericPanel<List<T>> {

	private final RepeatingView itemView;

	private final ColumnSize spanClass;


	public ThumbnailsList(String id, IModel<List<T>> model, final ColumnSize spanClass) {

		super(id, model);

		this.add(new CssClassAppender(BootstrapCssClass.THUMBNAILS));

		this.spanClass = spanClass;

		this.itemView = new RepeatingView("item");
		this.add(this.itemView);
	}


	@Override
	protected void onBeforeRender() {

		this.itemView.removeAll();

		for (int idx = 0; idx < this.getModelObject().size(); idx++) {
			IModel<T> listItemModel = new ListItemModel<T>(this.getModel(), idx);
			Component item = this.createItem(this.itemView.newChildId(), listItemModel);
			item.add(new CssClassAppender(this.spanClass));
			this.itemView.add(item);
		}

		super.onBeforeRender();
	}


	@Override
	protected void onComponentTag(ComponentTag tag) {

		super.onComponentTag(tag);

		this.checkComponentTag(tag, "ul");
	}


	protected abstract Component createItem(String id, IModel<T> model);

}
