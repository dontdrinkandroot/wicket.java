package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLocalTime;
import net.dontdrinkandroot.wicket.component.form.LocalTimeTextField;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import java.time.LocalTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalTime extends FormGroupInputGroup<LocalTime, LocalTime, LocalTimeTextField, InputGroupLocalTime>
{
    public FormGroupLocalTime(String id, IModel<String> labelModel, IModel<LocalTime> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroup<LocalTime, LocalTime, LocalTimeTextField> createInputGroup(String id)
    {
        return new InputGroupLocalTime(id, this.getModel())
        {
            @Override
            protected Component createInputGroupAddonBefore(String id)
            {
                return FormGroupLocalTime.this.createInputGroupAddonBefore(id);
            }

            @Override
            protected Component createInputGroupAddonAfter(String id)
            {
                return FormGroupLocalTime.this.createInputGroupAddonAfter(id);
            }
        };
    }
}
