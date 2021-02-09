package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLocalDate;
import net.dontdrinkandroot.wicket.component.form.LocalDateTextField;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalDate extends FormGroupInputGroup<LocalDate, LocalDate, LocalDateTextField, InputGroupLocalDate>
{
    public FormGroupLocalDate(String id, IModel<String> labelModel, IModel<LocalDate> model) {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroup<LocalDate, LocalDate, LocalDateTextField> createInputGroup(String id)
    {
        return new InputGroupLocalDate(id, this.getModel())
        {
            @Override
            protected Component createInputGroupPrepend(String id)
            {
                return FormGroupLocalDate.this.createInputGroupPrepend(id);
            }

            @Override
            protected Component createInputGroupAppend(String id)
            {
                return FormGroupLocalDate.this.createInputGroupAppend(id);
            }
        };
    }
}
