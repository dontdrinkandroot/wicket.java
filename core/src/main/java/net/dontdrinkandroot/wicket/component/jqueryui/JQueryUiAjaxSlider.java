package net.dontdrinkandroot.wicket.component.jqueryui;

import net.dontdrinkandroot.wicket.component.TypedWebMarkupContainer;

import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.StringValue;


public class JQueryUiAjaxSlider extends TypedWebMarkupContainer<Integer> implements IHeaderContributor {

	private final AbstractDefaultAjaxBehavior valueChangedBehaviour;

	private final int step;

	private final IModel<Integer> maxModel;

	private final IModel<Integer> minModel;


	public JQueryUiAjaxSlider(final String id, final IModel<Integer> model, final int min, final int max, final int step) {

		this(id, model, new Model<Integer>(min), new Model<Integer>(max), step);

	}


	public JQueryUiAjaxSlider(
			final String id,
			final IModel<Integer> model,
			IModel<Integer> minModel,
			final IModel<Integer> maxModel,
			final int step) {

		super(id, model);

		this.setOutputMarkupId(true);

		this.minModel = minModel;
		this.maxModel = maxModel;
		this.step = step;

		this.valueChangedBehaviour = new AbstractDefaultAjaxBehavior() {

			private static final long serialVersionUID = 1L;


			@Override
			protected void respond(final AjaxRequestTarget target) {

				final StringValue value =
						JQueryUiAjaxSlider.this.getRequest().getQueryParameters().getParameterValue("value");
				JQueryUiAjaxSlider.this.setModelObject(value.toInteger());
				JQueryUiAjaxSlider.this.onValueChanged(target);
			}

		};
		this.add(this.valueChangedBehaviour);
	}


	@Override
	public void renderHead(final IHeaderResponse response) {

		super.renderHead(response);

		response.render(OnDomReadyHeaderItem.forScript(String.format(
				"$('#%s').slider({value: %d, min: %d, max: %d, step: %d, change: function(event, ui) {wicketAjaxGet('%s&value=' + ui.value)}"
						+ "})",
				this.getMarkupId(),
				this.getModelObject(),
				this.minModel.getObject(),
				this.maxModel.getObject(),
				this.step,
				this.valueChangedBehaviour.getCallbackUrl())));
	}


	public void onValueChanged(final AjaxRequestTarget target) {

		target.appendJavaScript(String.format(
				"$('#%s').slider({ 'option', 'max', %d})",
				this.getMarkupId(),
				this.maxModel.getObject()));
		target.appendJavaScript(String.format(
				"$('#%s').slider({ 'option', 'min', %d})",
				this.getMarkupId(),
				this.minModel.getObject()));
		target.appendJavaScript(String.format(
				"$('#%s').slider({ 'option', 'value', %d})",
				this.getMarkupId(),
				this.getModelObject()));
	}
}
