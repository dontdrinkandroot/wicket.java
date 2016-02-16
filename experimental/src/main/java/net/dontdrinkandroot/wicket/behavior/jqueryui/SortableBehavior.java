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
package net.dontdrinkandroot.wicket.behavior.jqueryui;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.CallbackParameter;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.util.string.StringValue;

import net.dontdrinkandroot.wicket.headeritem.ExternalJQueryUiJsHeaderItem;


public abstract class SortableBehavior extends AbstractDefaultAjaxBehavior
{

	private final String itemSelector;


	public SortableBehavior(String itemSelector)
	{
		this.itemSelector = itemSelector;
	}

	@Override
	protected void respond(AjaxRequestTarget target)
	{
		final StringValue oldPositionValue =
				this.getComponent().getRequest().getQueryParameters().getParameterValue("oldPosition");
		final StringValue newPositionValue =
				this.getComponent().getRequest().getQueryParameters().getParameterValue("newPosition");
		final StringValue outValue = this.getComponent().getRequest().getQueryParameters().getParameterValue("out");
		final StringValue componentPathValue =
				this.getComponent().getRequest().getQueryParameters().getParameterValue("componentPath");

		final int oldPosition = oldPositionValue.toInt();
		final int newPosition = newPositionValue.toInt();
		final boolean out = outValue.toBoolean();
		final String droppedComponentPath = componentPathValue.toString("");
		final String boundComponentPath = this.getComponent().getPageRelativePath();

		if (boundComponentPath.equals(droppedComponentPath)) {

			/* The dropped component is one of our list items */
			if (out) {
				/* Item was dragged outside of the list, remove it */
				this.onRemove(target, oldPosition);
			} else {
				/* Item was dragged within the list, update position */
				this.onPositionChanged(target, oldPosition, newPosition);
			}

		} else {

			/* Retrieve the dropped component by its path and insert its model into the list */
			final Component droppedComponent = this.getComponent().getPage().get(droppedComponentPath);
			Object droppedComponentModelObject = null;
			if (droppedComponent != null) {
				droppedComponentModelObject = droppedComponent.getDefaultModelObject();
			}
			this.onInsert(target, droppedComponentModelObject, newPosition);
		}
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response)
	{
		super.renderHead(component, response);

		final CharSequence callbackFunction = this.getCallbackFunction(
				CallbackParameter.explicit("oldPosition"),
				CallbackParameter.explicit("newPosition"),
				CallbackParameter.explicit("out"),
				CallbackParameter.explicit("componentPath"));

		String containment = "";
		final Component containmentComponent = this.getContainment();
		if (containmentComponent != null) {
			containment = "#" + containmentComponent.getMarkupId();
		}

		final PackageResourceReference sortableResourceReference =
				new PackageResourceReference(SortableBehavior.class, "sortable.js");

		final JavaScriptReferenceHeaderItem sortableHeaderItem = new JavaScriptReferenceHeaderItem(
				sortableResourceReference,
				null,
				"jqueryui.sortable",
				false,
				null,
				null) {

			@Override
			public List<HeaderItem> getDependencies()
			{
				return Collections.singletonList((HeaderItem) new ExternalJQueryUiJsHeaderItem(false));
			}
		};

		final OnDomReadyHeaderItem initHeaderItem = new OnDomReadyHeaderItem(
				String.format(
						"initSortable('%s', %s, '%s', '%s', '%s', '%s')",
						component.getMarkupId(),
						callbackFunction,
						component.getPageRelativePath(),
						this.itemSelector,
						this.getPlaceHolderClass(),
						containment)) {

			@Override
			public List<HeaderItem> getDependencies()
			{
				return Collections.singletonList((HeaderItem) sortableHeaderItem);
			}
		};

		response.render(initHeaderItem);
	}

	protected String getPlaceHolderClass()
	{
		return "placeholder";
	}

	protected Component getContainment()
	{
		return this.getComponent();
	}

	protected abstract void onPositionChanged(AjaxRequestTarget target, int oldPosition, int newPosition);

	protected abstract void onRemove(AjaxRequestTarget target, int position);

	protected abstract void onInsert(AjaxRequestTarget target, Object droppedModelObject, int position);
}