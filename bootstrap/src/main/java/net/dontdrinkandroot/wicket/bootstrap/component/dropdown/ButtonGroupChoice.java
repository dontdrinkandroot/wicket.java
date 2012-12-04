package net.dontdrinkandroot.wicket.bootstrap.component.dropdown;

import java.util.List;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.TypedPanel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;


public class ButtonGroupChoice<T> extends TypedPanel<T> {

	public ButtonGroupChoice(String id, IModel<? extends T> model, List<T> choices) {

		this(id, model, new ListModel<T>(choices));
	}


	public ButtonGroupChoice(String id, IModel<? extends T> model, IModel<List<T>> choicesModel) {

		super(id, model);

		this.setOutputMarkupId(true);
		this.add(new CssClassAppender("btn-group"));

		final RepeatingView choicesView = new RepeatingView("choice");
		choicesView.setOutputMarkupId(true);
		this.add(choicesView);

		for (final T choice : choicesModel.getObject()) {

			AjaxLink<Void> periodLink = new AjaxLink<Void>(choicesView.newChildId()) {

				@Override
				public void onClick(AjaxRequestTarget target) {

					ButtonGroupChoice.this.onSelectionChanged(choice, target);
				}
			};
			periodLink.setBody(this.getDisplayModel(choice));
			periodLink.add(new CssClassAppender(new Model<BootstrapCssClass>() {

				@Override
				public BootstrapCssClass getObject() {

					if (ButtonGroupChoice.this.getModelObject().equals(choice)) {
						super.getObject();
					}

					return null;
				}
			}));

			choicesView.add(periodLink);
		}
	}


	protected void onSelectionChanged(T choice, AjaxRequestTarget target) {

		this.setModelObject(choice);
		target.add(ButtonGroupChoice.this);
	}


	protected IModel<String> getDisplayModel(T choice) {

		return new Model<String>(choice.toString());
	}

}
