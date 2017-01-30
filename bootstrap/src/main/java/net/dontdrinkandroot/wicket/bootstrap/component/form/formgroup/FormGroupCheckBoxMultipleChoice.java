package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.form.AbstractChoice;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import java.util.Collection;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupCheckBoxMultipleChoice<T> extends FormGroupFormComponent<Collection<T>, Collection<T>, CheckBoxMultipleChoice<T>>
{
    @SuppressWarnings("unchecked")
    public FormGroupCheckBoxMultipleChoice(String id, IModel<String> labelModel, IModel<? extends Collection<T>> model)
    {
        super(id, labelModel, (IModel<Collection<T>>) model);
    }

    public FormGroupCheckBoxMultipleChoice(
            String id,
            IModel<String> labelModel, IModel<? extends Collection<T>> model,
            List<T> choices,
            IChoiceRenderer<T> choiceRenderer
    )
    {
        this(id, labelModel, model);
        this.getFormComponent().setChoices(choices);
        this.getFormComponent().setChoiceRenderer(choiceRenderer);
    }

    @Override
    protected CheckBoxMultipleChoice<T> createFormComponent(String id)
    {
        CheckBoxMultipleChoice<T> formComponent = new CheckBoxMultipleChoice<>(id, this.getModel(), (List<T>) null);
        formComponent.setPrefix("<div class=\"checkbox\">");
        formComponent.setSuffix("</div>");
        formComponent.setLabelPosition(AbstractChoice.LabelPosition.WRAP_AFTER);

        return formComponent;
    }
}
