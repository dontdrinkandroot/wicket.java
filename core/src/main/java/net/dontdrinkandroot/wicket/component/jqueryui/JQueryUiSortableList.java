package net.dontdrinkandroot.wicket.component.jqueryui;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.javascript.JQueryUiScript;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.StringValue;


// TODO: check if markup is list
public abstract class JQueryUiSortableList<T> extends GenericPanel<List<T>> {

	private final AbstractDefaultAjaxBehavior stopCallbackBehavior;

	private final ListView<T> itemView;


	public JQueryUiSortableList(String id, final IModel<List<T>> model) {

		super(id, model);

		this.setOutputMarkupId(true);

		this.itemView = new ListView<T>("item", this.getModel()) {

			@Override
			protected void populateItem(ListItem<T> item) {

				item.add(JQueryUiSortableList.this.createChild("child", item.getModel()));
				if (JQueryUiSortableList.this.appendItemClass() != null) {
					item.add(new CssClassAppender(JQueryUiSortableList.this.appendItemClass()));
				}
			}

		};
		this.add(this.itemView);

		this.stopCallbackBehavior = new AbstractDefaultAjaxBehavior() {

			@Override
			protected void respond(AjaxRequestTarget target) {

				final StringValue oldPositionValue =
						JQueryUiSortableList.this.getRequest().getQueryParameters().getParameterValue("oldPosition");
				final StringValue newPositionValue =
						JQueryUiSortableList.this.getRequest().getQueryParameters().getParameterValue("newPosition");
				final StringValue outValue =
						JQueryUiSortableList.this.getRequest().getQueryParameters().getParameterValue("out");
				final StringValue componentPathValue =
						JQueryUiSortableList.this.getRequest().getQueryParameters().getParameterValue("componentPath");

				int oldPosition = oldPositionValue.toInt();
				int newPosition = newPositionValue.toInt();
				boolean out = outValue.toBoolean();
				String droppedComponentPath = componentPathValue.toString("");
				String listPath = JQueryUiSortableList.this.getPageRelativePath();

				if (listPath.equals(droppedComponentPath)) {

					if (out) {
						JQueryUiSortableList.this.onRemove(target, oldPosition);
					} else {
						JQueryUiSortableList.this.onPositionChanged(target, oldPosition, newPosition);
					}

				} else {

					Component droppedComponent = JQueryUiSortableList.this.getPage().get(droppedComponentPath);
					Object droppedComponentModelObject = null;
					if (droppedComponent != null) {
						droppedComponentModelObject = droppedComponent.getDefaultModelObject();
					}
					JQueryUiSortableList.this.onInsert(target, droppedComponentModelObject, newPosition);
				}
			}
		};

		this.add(this.stopCallbackBehavior);

	}


	protected String getContainment() {

		return null;
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		StringBuffer sortableOptions = new StringBuffer();

		if (this.getContainment() != null) {
			sortableOptions.append("containment: '" + this.getContainment() + "', ");
		}
		sortableOptions.append("start : function(event, ui) {$(this).data('oldPosition', ui.item.index()); $(this).data('out', false);}, ");
		sortableOptions.append("items: 'li', ");
		sortableOptions.append("beforeStop : function(event, ui) {"
				+ "var componentPath = $(ui.helper).data('wicket.component.path'); "
				+ "console.log(componentPath); "
				+ this.beforeWicketCall()
				+ "wicketAjaxGet('"
				+ this.stopCallbackBehavior.getCallbackUrl()
				+ "&oldPosition=' + $(this).data('oldPosition') + '&newPosition=' + ui.item.index() + '&out=' + $(this).data('out') + '&componentPath=' + componentPath);"
				+ this.afterWicketCall()
				+ "}, ");
		sortableOptions.append("helper: function(event, ui) { "
				+ "ui.data('wicket.component.path', '"
				+ this.getPageRelativePath()
				+ "'); "
				+ "return ui; "
				+ "},");
		sortableOptions.append("out : function(event, ui) {$(this).data('out', true)}, ");
		sortableOptions.append("placeholder : '" + this.getPlaceHolderClass() + "',");
		sortableOptions.append("over : function(event, ui) {$(this).data('out', false)}");

		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).append(
				".sortable({" + sortableOptions + "})").toString()));
	}


	/**
	 * Javascript that should be performed after the "onstop" callback was called.
	 */
	protected String afterWicketCall() {

		return "";
	}


	/**
	 * Javascript that should be performed before the "onstop" callback is called.
	 */
	protected String beforeWicketCall() {

		return "";
	}


	protected String getPlaceHolderClass() {

		return "placeholder";
	}


	protected abstract Component createChild(String id, IModel<T> model);


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


	protected IModel<? extends CssClass> appendItemClass() {

		return null;
	}


	public void setReuseItems(boolean reuseItems) {

		this.itemView.setReuseItems(reuseItems);
	}

}
