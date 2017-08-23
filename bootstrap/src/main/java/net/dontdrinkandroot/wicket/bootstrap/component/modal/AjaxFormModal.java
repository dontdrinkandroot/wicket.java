package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class AjaxFormModal<T> extends FormModal<T>
{
    public AjaxFormModal(String id)
    {
        super(id);
    }

    public AjaxFormModal(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected Form<T> createForm(String id)
    {
        Form<T> form = new Form<T>(id);
        form.add(new AjaxFormSubmitBehavior(form, "submit")
        {
            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
                super.updateAjaxAttributes(attributes);
                attributes.setPreventDefault(true);
            }

            @Override
            protected void onError(AjaxRequestTarget target)
            {
                super.onError(target);
                AjaxFormModal.this.onError(target);
            }

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
                AjaxFormModal.this.onSubmit(target);
            }

            @Override
            protected void onAfterSubmit(AjaxRequestTarget target)
            {
                super.onAfterSubmit(target);
                AjaxFormModal.this.onAfterSubmit(target);
            }
        });

        return form;
    }

    /**
     * Hook for handling the submission with Ajax. Do not perform any setResponsePage Actions here, as they will lead
     * to a double subission. Use onAfterSubmit instead.
     *
     * @param target The current AjaxRequestTarget or null if not submitted via ajax
     * @see AjaxFormSubmitBehavior#onSubmit(AjaxRequestTarget)
     */
    protected void onSubmit(AjaxRequestTarget target)
    {
        /* Hook */
    }

    /**
     * @see AjaxFormSubmitBehavior#onAfterSubmit(AjaxRequestTarget)
     */
    protected void onAfterSubmit(AjaxRequestTarget target)
    {
        if (null != target) {
            target.appendJavaScript(this.getHideScript());
        }
    }

    /**
     * @see AjaxFormSubmitBehavior#onError(AjaxRequestTarget)
     */
    protected void onError(AjaxRequestTarget target)
    {
        if (null != target) {
            target.add(this.getForm());
        }
    }
}
