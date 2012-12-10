package net.dontdrinkandroot.wicket.component.jqueryui;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.jqueryui.SortableBehavior;
import net.dontdrinkandroot.wicket.component.basic.AbstractList;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;


public abstract class JQueryUiSortableList<T> extends AbstractList<T> {

	public JQueryUiSortableList(String id, final IModel<List<T>> model) {

		super(id, model);

		this.setOutputMarkupId(true);

		this.add(new SortableBehavior("li") {

			@Override
			protected void onPositionChanged(AjaxRequestTarget target, int oldPosition, int newPosition) {

				JQueryUiSortableList.this.onPositionChanged(target, oldPosition, newPosition);
			}


			@Override
			protected void onRemove(AjaxRequestTarget target, int position) {

				JQueryUiSortableList.this.onRemove(target, position);
			}


			@Override
			protected void onInsert(AjaxRequestTarget target, Object droppedModelObject, int position) {

				JQueryUiSortableList.this.onInsert(target, droppedModelObject, position);
			}
		});

	}


	protected void onPositionChanged(AjaxRequestTarget target, int oldPosition, int newPosition) {

		T t = this.getModelObject().get(oldPosition);
		this.getModelObject().remove(oldPosition);
		this.getModelObject().add(newPosition, t);

		target.add(this);
	}


	protected void onRemove(AjaxRequestTarget target, int position) {

		this.getModelObject().remove(position);
		target.add(this);
	}


	protected void onInsert(AjaxRequestTarget target, Object droppedModelObject, int position) {

		if (droppedModelObject != null) {
			/*
			 * Evil hack as we don't know the Type of the list and cannot check directly against it
			 * (generics are erased at runtime), subclasses SHOULD override this method
			 */
			if (this.getModelObject().isEmpty()
					|| this.getModelObject().iterator().next().getClass().isAssignableFrom(
							droppedModelObject.getClass())) {
				this.getModelObject().add(position, (T) droppedModelObject);
			}
		}
		target.add(this);
	}

}
