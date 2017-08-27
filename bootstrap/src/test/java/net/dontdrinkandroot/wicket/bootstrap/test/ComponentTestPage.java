package net.dontdrinkandroot.wicket.bootstrap.test;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.IMarkupResourceStreamProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.StringResourceStream;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ComponentTestPage extends WebPage implements IMarkupResourceStreamProvider
{
    public static final String COMPONENT_ID = "id";

    public ComponentTestPage(Component component)
    {
        this.add(component);
    }

    @Override
    public IResourceStream getMarkupResourceStream(MarkupContainer container, Class<?> containerClass)
    {
        String markup = "<html><body><div wicket:id=\"id\"></div></body></html>";
        return new StringResourceStream(markup);
    }
}