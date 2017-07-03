package net.dontdrinkandroot.wicket.test;

import org.apache.wicket.Component;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputTestPage extends FormComponentTestPage
{
    private final String type;

    public InputTestPage(Component component, String type)
    {
        super(component);
        this.type = type;
    }

    @Override
    public String getFormComponentMarkup()
    {
        return String.format("<input wicket:id=\"%s\" type=\"%s\"/>", this.component.getId(), this.type);
    }
}
