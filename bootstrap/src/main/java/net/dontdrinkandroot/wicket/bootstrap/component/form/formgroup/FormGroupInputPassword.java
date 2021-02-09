package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupPassword;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.IModel;

public class FormGroupInputPassword extends FormGroupInputGroup<String, String, PasswordTextField, InputGroupPassword>
{
    public FormGroupInputPassword(String id, IModel<String> labelModel, IModel<String> model) {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroup<String, String, PasswordTextField> createInputGroup(String id) {
        return new InputGroupPassword(id, this.getModel())
        {
            @Override
            protected Component createInputGroupPrepend(String id) {
                return FormGroupInputPassword.this.createInputGroupPrepend(id);
            }

            @Override
            protected Component createInputGroupAppend(String id) {
                return FormGroupInputPassword.this.createInputGroupAppend(id);
            }
        };
    }
}
