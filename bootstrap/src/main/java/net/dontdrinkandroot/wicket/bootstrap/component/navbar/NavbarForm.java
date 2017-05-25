package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavbarForm<T> extends Form<T>
{
    private IModel<NavbarAlignment> alignmentModel = Model.of(NavbarAlignment.LEFT);

    public NavbarForm(String id)
    {
        super(id);
    }

    public NavbarForm(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR_FORM));
        this.add(new CssClassAppender(this.alignmentModel));
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        tag.setName("form");
        super.onComponentTag(tag);
    }

    public NavbarForm<T> setAlignment(NavbarAlignment alignment)
    {
        this.alignmentModel.setObject(alignment);
        return this;
    }
}
