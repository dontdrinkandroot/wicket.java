package net.dontdrinkandroot.wicket.bootstrap.test;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.IMarkupResourceStreamProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.StringResourceStream;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormTestPage extends WebPage implements IMarkupResourceStreamProvider
{
    public static final String COMPONENT_ID = "id";

    public FormTestPage(Form<?> form)
    {
        this.add(form);
    }

    @Override
    public IResourceStream getMarkupResourceStream(MarkupContainer container, Class<?> containerClass)
    {
        String markup = "<html><body><form wicket:id=\"id\"></form></body></html>";
        return new StringResourceStream(markup);
    }
}