package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavbarText extends Label
{
    private IModel<NavbarAlignment> alignmentModel = Model.of(NavbarAlignment.LEFT);

    public NavbarText(String id)
    {
        super(id);
    }

    public NavbarText(String id, Serializable label)
    {
        super(id, label);
    }

    public NavbarText(String id, IModel<?> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR_TEXT));
        this.add(new CssClassAppender(this.alignmentModel));
    }

    public NavbarText setAlignment(NavbarAlignment alignment)
    {
        this.alignmentModel.setObject(alignment);
        return this;
    }
}
