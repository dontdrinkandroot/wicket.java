package net.dontdrinkandroot.wicket.bootstrap.component.form;

import java.util.List;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.WildcardListModel;


public class SelectFormGroup<T> extends AbstractFormGroup<T, DropDownChoice<T>> {

	private final WildcardListModel<T> choicesModel;

	private IChoiceRenderer<T> choiceRenderer = new ChoiceRenderer<T>();


	public SelectFormGroup(String id, IModel<T> model, String label, List<T> choices) {

		super(id, model, label);
		this.choicesModel = new WildcardListModel<T>(choices);
		this.createComponents();
	}


	public SelectFormGroup(String id, IModel<T> model, IModel<String> labelModel, List<T> choices) {

		super(id, model, labelModel);
		this.choicesModel = new WildcardListModel<T>(choices);
		this.createComponents();
	}


	public SelectFormGroup(String id, IModel<T> model, String label, List<T> choices, IChoiceRenderer<T> choiceRenderer) {

		super(id, model, label);
		this.choicesModel = new WildcardListModel<T>(choices);
		this.choiceRenderer = choiceRenderer;
		this.createComponents();
	}


	public SelectFormGroup(
			String id,
			IModel<T> model,
			IModel<String> labelModel,
			List<T> choices,
			IChoiceRenderer<T> choiceRenderer) {

		super(id, model, labelModel);
		this.choicesModel = new WildcardListModel<T>(choices);
		this.choiceRenderer = choiceRenderer;
		this.createComponents();
	}


	@Override
	protected DropDownChoice<T> createFormComponent(String id) {

		return new DropDownChoice<T>(id, this.getModel(), this.choicesModel, this.choiceRenderer);
	}

}
