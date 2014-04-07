/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
