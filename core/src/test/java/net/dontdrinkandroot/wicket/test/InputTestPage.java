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
public class InputTestPage extends WebPage implements IMarkupResourceStreamProvider
{
    public static final String COMPONENT_ID = "id";

    private final String type;

    Form<Void> form;

    public InputTestPage(Component component, String type)
    {
        this.add(this.form = new Form<>("form"));
        this.form.add(component);
        this.type = type;
    }

    @Override
    public IResourceStream getMarkupResourceStream(MarkupContainer container, Class<?> containerClass)
    {
        String markup = String.format(
                "<html><body><form wicket:id=\"form\"><input wicket:id=\"id\" type=\"%s\"/></form></body></html>",
                this.type
        );
        return new StringResourceStream(markup);
    }
}