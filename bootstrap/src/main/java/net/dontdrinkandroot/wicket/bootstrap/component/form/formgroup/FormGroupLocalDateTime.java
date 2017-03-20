package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLocalDateTime;
import net.dontdrinkandroot.wicket.component.form.LocalDateTimeTextField;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import java.time.LocalDateTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalDateTime extends FormGroupInputGroup<LocalDateTime, LocalDateTime, LocalDateTimeTextField, InputGroupLocalDateTime>
{
    public FormGroupLocalDateTime(String id, IModel<String> labelModel, IModel<LocalDateTime> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroup<LocalDateTime, LocalDateTime, LocalDateTimeTextField> createInputGroup(String id)
    {
        return new InputGroupLocalDateTime(id, this.getModel())
        {
            @Override
            protected Component createInputGroupAddonBefore(String id)
            {
                return FormGroupLocalDateTime.this.createInputGroupAddonBefore(id);
            }

            @Override
            protected Component createInputGroupAddonAfter(String id)
            {
                return FormGroupLocalDateTime.this.createInputGroupAddonAfter(id);
            }
        };
    }
}
