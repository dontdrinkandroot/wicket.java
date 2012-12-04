package net.dontdrinkandroot.wicket.bootstrap.component.button;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;


public class DropDownChoiceButton<T> extends GenericPanel<T> {

	public DropDownChoiceButton(String id, IModel<T> model, List<T> choices) {

		super(id, model);

		this.setOutputMarkupId(true);
		this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));
		this.add(new CssClassAppender("dropdownchoice"));

		Label selectedLabel = new Label("selected", DropDownChoiceButton.this.createChoiceLabelModel(this.getModel()));
		selectedLabel.add(new CssClassAppender("selection"));
		this.add(selectedLabel);

		ListView<T> choicesView = new ListView<T>("choiceItem", choices) {

			@Override
			protected void populateItem(final ListItem<T> item) {

				AjaxLink<Void> choiceLink = new AjaxLink<Void>("choiceLink") {

					@Override
					public void onClick(AjaxRequestTarget target) {

						DropDownChoiceButton.this.onSelectionChanged(target, item.getModelObject());
					}

				};
				choiceLink.setBody(DropDownChoiceButton.this.createChoiceLabelModel(item.getModel()));
				item.add(choiceLink);
			}

		};
		this.add(choicesView);
	}


	protected IModel<String> createChoiceLabelModel(final IModel<T> choiceModel) {

		return new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {

				return DropDownChoiceButton.this.renderChoice(choiceModel.getObject());
			}

		};
	}


	protected String renderChoice(T choice) {

		return choice.toString();
	}


	protected void onSelectionChanged(AjaxRequestTarget target, T selection) {

		this.setModelObject(selection);
		target.add(this);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);
		//
		// response.render(JavaScriptHeaderItem.forReference(new PackageResourceReference(
		// DropDownChoiceButton.class,
		// "dropdownchoicescale.js"), "dropdownchoicescale"));
		// response.render(OnLoadHeaderItem.forScript("scaleDropDownChoices()"));
	}
}
