package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

/**
 * A {@link Panel} that has no default components. You need to overwrite the corresponding create methods.
 *
 * @param <T> Type of the Model Object.
 */
public class PlainPanel<T> extends Panel<T>
{
    protected Component body;

    public PlainPanel(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.body = this.createBody(Panel.BODY_ID);
        this.body.add(new CssClassAppender(BootstrapCssClass.PANEL_BODY));
        this.add(this.body);
    }

    protected Component createBody(String id)
    {
        final WebMarkupContainer bodyContainer = new WebMarkupContainer(id);
        bodyContainer.setVisible(false);

        return bodyContainer;
    }
}
