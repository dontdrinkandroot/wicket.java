package net.dontdrinkandroot.wicket.bootstrap.component.button;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.model.AbstractChainedModel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;


public class DropDownChoiceButton<T> extends FormComponentPanel<T> {

	private final IModel<List<T>> choicesModel;

	private IChoiceRenderer<? super T> choiceRenderer;

	private Class<T> type;

	private HiddenField<T> valueInputField;


	public DropDownChoiceButton(String id, IModel<T> model, List<T> choices) {

		this(id, model, new ListModel<T>(choices), new ChoiceRenderer<T>());
	}


	public DropDownChoiceButton(String id, IModel<T> model, IModel<List<T>> choicesModel) {

		this(id, model, choicesModel, new ChoiceRenderer<T>());
	}


	public DropDownChoiceButton(
			String id,
			IModel<T> model,
			IModel<List<T>> choicesModel,
			IChoiceRenderer<? super T> choiceRenderer) {

		super(id, model);

		this.choicesModel = choicesModel;
		this.choiceRenderer = choiceRenderer;
	}


	public DropDownChoiceButton(String id, IModel<T> model, IModel<List<T>> choicesModel, Class<T> type) {

		this(id, model, choicesModel, new ChoiceRenderer<T>(), type);
	}


	public DropDownChoiceButton(
			String id,
			IModel<T> model,
			IModel<List<T>> choicesModel,
			IChoiceRenderer<? super T> choiceRenderer,
			Class<T> type) {

		super(id, model);

		this.choicesModel = choicesModel;
		this.choiceRenderer = choiceRenderer;
		this.type = type;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.setOutputMarkupId(true);
		this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));
		this.add(new CssClassAppender("dropdownchoice"));

		Label selectedLabel = new Label("selected", new ChoiceModel(this.getModel()));
		selectedLabel.add(new CssClassAppender("selection"));
		this.add(selectedLabel);

		ListView<T> choicesView = new ListView<T>("choiceItem", this.choicesModel) {

			@Override
			protected void populateItem(final ListItem<T> item) {

				AjaxLink<Void> choiceLink = new AjaxLink<Void>("choiceLink") {

					@Override
					public void onClick(AjaxRequestTarget target) {

						DropDownChoiceButton.this.onSelectionChanged(target, item.getModelObject());
					}

				};
				choiceLink.setBody(new ChoiceModel(item.getModel()));
				item.add(choiceLink);
			}

		};
		this.add(choicesView);

		this.valueInputField = new HiddenField<T>("valueInput", this.getModel(), this.type);
		this.add(this.valueInputField);
	}


	protected void onSelectionChanged(AjaxRequestTarget target, T selection) {

		this.setModelObject(selection);
		target.add(this);
		this.onSelectionChanged(target);
	}


	protected void onSelectionChanged(AjaxRequestTarget target) {

		/* Override to act on changes */
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


	@Override
	protected void convertInput() {

		this.setConvertedInput(this.valueInputField.getConvertedInput());
	}


	class ChoiceModel extends AbstractChainedModel<T, Object> {

		public ChoiceModel(IModel<? extends T> parent) {

			super(parent);
		}


		@Override
		public Object getObject() {

			return DropDownChoiceButton.this.choiceRenderer.getDisplayValue(this.getParentObject());
		}

	}

}
