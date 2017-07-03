package net.dontdrinkandroot.wicket.test;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.IMarkupResourceStreamProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.StringResourceStream;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class FormComponentTestPage extends WebPage implements IMarkupResourceStreamProvider
{
    private Form<Void> form;

    protected Component component;

    public FormComponentTestPage(Component component)
    {
        this.add(this.form = new Form<>("form"));
        this.form.add(this.component = component);
    }

    @Override
    public IResourceStream getMarkupResourceStream(MarkupContainer container, Class<?> containerClass)
    {
        String markup =
                "<html><body><form wicket:id=\"form\">" + this.getFormComponentMarkup() + "</form></body></html>";
        return new StringResourceStream(markup);
    }

    public abstract String getFormComponentMarkup();
}
