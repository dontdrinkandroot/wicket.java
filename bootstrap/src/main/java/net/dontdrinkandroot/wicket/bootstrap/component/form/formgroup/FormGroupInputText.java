package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

public class FormGroupInputText extends FormGroupInputGroup<String, String, TextField<String>, InputGroupText>
{
    public FormGroupInputText(String id, IModel<String> labelModel, IModel<String> model) {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroupText createInputGroup(String id)
    {
        return new InputGroupText(id, this.getModel())
        {
            @Override
            protected Component createInputGroupPrepend(String id)
            {
                return FormGroupInputText.this.createInputGroupPrepend(id);
            }

            @Override
            protected Component createInputGroupAppend(String id)
            {
                return FormGroupInputText.this.createInputGroupAppend(id);
            }
        };
    }
}
