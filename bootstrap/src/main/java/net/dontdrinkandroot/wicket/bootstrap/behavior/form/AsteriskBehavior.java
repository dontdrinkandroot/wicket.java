package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.Response;

/**
 * Appends an asterisk to the HTML of the component.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AsteriskBehavior extends Behavior
{
    private IModel<Boolean> enabledBehavior;

    public AsteriskBehavior(IModel<Boolean> enabledBehavior)
    {
        this.enabledBehavior = enabledBehavior;
    }

    @Override
    public void afterRender(Component component)
    {
        Response response = component.getResponse();
        StringBuffer labelHtml = new StringBuffer(200);

        if (this.enabledBehavior.getObject()) {
            labelHtml.append("<b class=\"text-warning\"> <sup>*</sup></b>");
        }
        response.write(labelHtml);
    }
}
