package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.behavior.aria.Aria;
import net.dontdrinkandroot.wicket.behavior.aria.AriaAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavbarToggle extends Panel
{
    public NavbarToggle(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR_TOGGLE));
        this.add(new CssClassAppender(BootstrapCssClass.COLLAPSED));
        this.add(new AttributeAppender("data-toggle", "collapse"));
        this.add(new AriaAppender(Aria.EXPANDED, "false"));

        Label label = new Label("label", new ResourceModel("navbar.toggle", "Toggle navigation"));
        label.add(new CssClassAppender(BootstrapCssClass.SR_ONLY));
        this.add(label);
    }
}
