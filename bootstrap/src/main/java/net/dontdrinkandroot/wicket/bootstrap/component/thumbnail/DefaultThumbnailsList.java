package net.dontdrinkandroot.wicket.bootstrap.component.thumbnail;

import java.util.List;

import net.dontdrinkandroot.wicket.bootstrap.css.SpanClass;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.model.IModel;


public abstract class DefaultThumbnailsList<T> extends ThumbnailsList<T> {

	public DefaultThumbnailsList(String id, IModel<List<T>> model, SpanClass spanClass) {

		super(id, model, spanClass);
	}


	@Override
	protected Component createItem(String id, IModel<T> model) {

		return new DefaultThumbnail<T>(id, model) {

			@Override
			protected MarkupContainer createLink(String id, IModel<T> model) {

				return DefaultThumbnailsList.this.createLink(id, model);
			}


			@Override
			protected Component createImage(String id, IModel<T> model) {

				return DefaultThumbnailsList.this.createImage(id, model);
			}
		};
	}


	protected abstract MarkupContainer createLink(String id, IModel<T> model);


	protected abstract Component createImage(String id, IModel<T> model);
}
