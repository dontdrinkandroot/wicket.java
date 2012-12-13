package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class DropDownItem extends AbstractLinkItem {

	public DropDownItem(String id, IModel<String> labelModel) {

		super(id, labelModel);
	}


	public DropDownItem(String id, String label) {

		super(id, Model.of(label));
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN));
		RepeatingView dropDownItemView = new RepeatingView("dropDownItem");
		this.createDropDownItems(dropDownItemView);
		this.add(dropDownItemView);
	}


	@Override
	protected Component createLink(String id) {

		Label label = new Label(id, this.getModel()) {

			@Override
			public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {

				this.replaceComponentTagBody(markupStream, openTag, this.getDefaultModelObjectAsString()
						+ " <span class=\"caret\"></span>");
			}
		};
		label.add(new CssClassAppender(BootstrapCssClass.DROPDOWN_TOGGLE));
		label.add(new AttributeModifier("data-toggle", Model.of("dropdown")));

		return label;
	}


	protected abstract void createDropDownItems(RepeatingView itemView);
}
