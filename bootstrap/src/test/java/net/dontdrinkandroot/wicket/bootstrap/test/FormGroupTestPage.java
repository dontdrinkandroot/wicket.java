package net.dontdrinkandroot.wicket.bootstrap.test;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroup;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class FormGroupTestPage<T extends FormGroup<?>> extends WebPage
{
    private T formGroup;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form form = new Form("form");
        this.add(form);

        this.formGroup = this.createFormGroup("formGroup");
        form.add(this.formGroup);
    }

    protected abstract T createFormGroup(String id);

    public T getFormGroup()
    {
        return this.formGroup;
    }
}
