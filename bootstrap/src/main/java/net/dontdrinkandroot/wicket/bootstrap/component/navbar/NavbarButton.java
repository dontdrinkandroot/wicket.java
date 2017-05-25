package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.button.Button;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class NavbarButton<T> extends Button<T>
{
    IModel<NavbarAlignment> alignmentModel = Model.of(NavbarAlignment.LEFT);

    public NavbarButton(String id)
    {
        super(id);
    }

    public NavbarButton(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR_BTN));
        this.add(new CssClassAppender(this.alignmentModel));
    }

    public NavbarButton<T> setAlignment(NavbarAlignment alignment)
    {
        this.alignmentModel.setObject(alignment);
        return this;
    }
}
