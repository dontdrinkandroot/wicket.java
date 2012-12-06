package net.dontdrinkandroot.wicket.component.jqueryui;

import java.util.List;

import net.dontdrinkandroot.wicket.javascript.jqueryui.JQueryUiScript;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.WildcardListModel;


public class JQueryUiAjaxRadioChoice<T> extends GenericPanel<T> {

	private static final long serialVersionUID = 1L;

	/** The list of objects. */
	private IModel<? extends List<? extends T>> choices;

	/** The renderer used to generate display/id values for the objects. */
	private IChoiceRenderer<? super T> renderer;


	public JQueryUiAjaxRadioChoice(String id, IModel<T> model, List<? extends T> choices) {

		this(id, model, new WildcardListModel<T>(choices), new ChoiceRenderer<T>());
	}


	public JQueryUiAjaxRadioChoice(
			final String id,
			IModel<T> model,
			final List<? extends T> choices,
			final IChoiceRenderer<? super T> renderer) {

		this(id, model, new WildcardListModel<T>(choices), renderer);
	}


	public JQueryUiAjaxRadioChoice(String id, IModel<T> model, IModel<? extends List<? extends T>> choices) {

		this(id, model, choices, new ChoiceRenderer<T>());
	}


	public JQueryUiAjaxRadioChoice(
			String id,
			IModel<T> model,
			IModel<? extends List<? extends T>> choices,
			IChoiceRenderer<? super T> renderer) {

		super(id, model);

		this.setOutputMarkupId(true);

		this.choices = choices;
		this.setChoiceRenderer(renderer);

		final RadioGroup<T> radioGroup = new RadioGroup<T>("radioGroup", model);
		this.add(radioGroup);

		ListView<T> radioItemView = new ListView<T>("radioItem", choices) {

			private static final long serialVersionUID = 1L;


			@Override
			protected void populateItem(final ListItem<T> item) {

				Radio<T> radio = new Radio<T>("input", item.getModel(), radioGroup);
				radio.setOutputMarkupId(true);
				radio.add(new AjaxEventBehavior("onclick") {

					private static final long serialVersionUID = 1L;


					@Override
					protected void onEvent(AjaxRequestTarget target) {

						JQueryUiAjaxRadioChoice.this.onSelectionChanged(item.getModelObject(), target);
					}
				});
				item.add(radio);

				Label label =
						new Label("label", JQueryUiAjaxRadioChoice.this.getChoiceRenderer().getDisplayValue(
								item.getModel().getObject()).toString());
				label.add(new AttributeAppender("for", new Model<String>(radio.getMarkupId())));
				item.add(label);

				item.setRenderBodyOnly(true);
			}

		};
		radioGroup.add(radioItemView);
	}


	public final JQueryUiAjaxRadioChoice<T> setChoiceRenderer(IChoiceRenderer<? super T> renderer) {

		if (renderer == null) {
			this.renderer = new ChoiceRenderer<T>();
		}
		this.renderer = renderer;

		return this;
	}


	public final IChoiceRenderer<? super T> getChoiceRenderer() {

		return this.renderer;
	}


	protected void onSelectionChanged(T newValue, AjaxRequestTarget target) {

		this.setModelObject(newValue);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).buttonset().toString()));
	}

}
