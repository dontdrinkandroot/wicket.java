package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import java.util.List;

import org.apache.wicket.markup.html.form.AbstractChoice.LabelPosition;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.IModel;


public class FormGroupRadioChoice<T> extends FormGroupFormComponent<T, RadioChoice<T>>
{

	public FormGroupRadioChoice(
			String id,
			IModel<String> labelModel,
			IModel<T> model,
			IModel<? extends List<? extends T>> choices)
	{
		super(id, labelModel, model);
		this.getFormComponent().setChoices(choices);
	}

	public FormGroupRadioChoice(String id, IModel<String> labelModel, IModel<T> model, List<? extends T> choices)
	{
		super(id, labelModel, model);
		this.getFormComponent().setChoices(choices);
	}

	@Override
	protected RadioChoice<T> createFormComponent(String id)
	{
		RadioChoice<T> radioChoice = new RadioChoice<T>(id, this.getModel(), (List<T>) null);
		radioChoice.setPrefix("<div class=\"radio\">");
		radioChoice.setSuffix("</div>");
		radioChoice.setLabelPosition(LabelPosition.WRAP_AFTER);

		return radioChoice;
	}
}
