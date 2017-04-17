package net.dontdrinkandroot.wicket.example.page.form;

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingAjaxForm;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxFormPage extends FormPage
{
    private int submitCount = 0;

    public AjaxFormPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Ajax Form");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        RepeatingAjaxForm<Void> simpleAjaxForm = new RepeatingAjaxForm<Void>("simpleAjaxForm")
        {
            @Override
            protected void populateFormGroups(RepeatingView formGroupView)
            {
                super.populateFormGroups(formGroupView);
                formGroupView.add(new FormGroupInputText(
                        formGroupView.newChildId(),
                        Model.of("TextField"),
                        new Model<>()
                ));
            }

            @Override
            protected void populateActions(RepeatingView buttonView)
            {
                super.populateActions(buttonView);
                buttonView.add(new SubmitLabelButton(buttonView.newChildId(), Model.of("Submit")));
            }

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
                AjaxFormPage.this.submitCount++;
                this.info(String.format("Submitted %d times", AjaxFormPage.this.submitCount));
                target.add(this.getFeedbackPanel());
            }
        };
        this.add(simpleAjaxForm);
    }
}
