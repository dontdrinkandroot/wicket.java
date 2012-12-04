package net.dontdrinkandroot.wicket.component.form;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;


public class AjaxDropDownChoice<T> extends DropDownChoice<T> {

	public AjaxDropDownChoice(String id) {

		super(id);
	}


	public AjaxDropDownChoice(final String id, final List<? extends T> choices) {

		super(id, choices);
	}


	public AjaxDropDownChoice(
			final String id,
			final List<? extends T> choices,
			final IChoiceRenderer<? super T> renderer) {

		super(id, choices, renderer);
	}


	public AjaxDropDownChoice(final String id, IModel<T> model, final List<? extends T> choices) {

		super(id, model, choices);
	}


	public AjaxDropDownChoice(
			final String id,
			IModel<T> model,
			final List<? extends T> choices,
			final IChoiceRenderer<? super T> renderer) {

		super(id, model, choices, renderer);
	}


	public AjaxDropDownChoice(String id, IModel<? extends List<? extends T>> choices) {

		super(id, choices);
	}


	public AjaxDropDownChoice(String id, IModel<T> model, IModel<? extends List<? extends T>> choices) {

		super(id, model, choices);
	}


	public AjaxDropDownChoice(
			String id,
			IModel<? extends List<? extends T>> choices,
			IChoiceRenderer<? super T> renderer) {

		super(id, choices, renderer);
	}


	public AjaxDropDownChoice(
			String id,
			IModel<T> model,
			IModel<? extends List<? extends T>> choices,
			IChoiceRenderer<? super T> renderer) {

		super(id, model, choices, renderer);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.setOutputMarkupId(true);
		this.add(new AjaxFormComponentUpdatingBehavior("onchange") {

			@Override
			protected void onUpdate(final AjaxRequestTarget target) {

				AjaxDropDownChoice.this.onSelectionChanged(target);
			}
		});
	}


	protected void onSelectionChanged(AjaxRequestTarget target) {

	}

}
