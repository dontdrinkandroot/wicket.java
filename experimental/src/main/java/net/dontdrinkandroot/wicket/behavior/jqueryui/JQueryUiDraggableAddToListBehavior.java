package net.dontdrinkandroot.wicket.behavior.jqueryui;

import net.dontdrinkandroot.wicket.component.jqueryui.JQueryUiSortableList;
import net.dontdrinkandroot.wicket.javascript.JQueryUiScript;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;


public class JQueryUiDraggableAddToListBehavior extends Behavior {

	private JQueryUiSortableList<?> sortableList;

	private String listComponentId;


	public JQueryUiDraggableAddToListBehavior(JQueryUiSortableList<?> sortableList) {

		this.sortableList = sortableList;
	}


	public JQueryUiDraggableAddToListBehavior(String listComponentId) {

		this.listComponentId = listComponentId;
	}


	@Override
	public void renderHead(Component component, IHeaderResponse response) {

		super.renderHead(component, response);

		String listId = this.listComponentId;
		if (this.sortableList != null) {
			listId = this.sortableList.getMarkupId();
		}

		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(component).append(
				String.format(
						".draggable({helper: function() {%s}, connectToSortable: '#%s'})",
						this.getCreateHelperScript(component),
						listId)).toString()));

	}


	protected String getCreateHelperScript(Component component) {

		return String.format(
				"var cloned = $(this).clone(); cloned.data('wicket.component.path', '%s'); return cloned;",
				component.getPageRelativePath());
	}
}
