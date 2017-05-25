package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ContainerStyle;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarPosition;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle;
import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class Navbar extends Panel
{
    private IModel<NavbarPosition> positionModel = Model.of(NavbarPosition.INLINE);

    private IModel<NavbarStyle> styleModel = Model.of(NavbarStyle.DEFAULT);

    private IModel<ContainerStyle> containerStyleModel = Model.of(ContainerStyle.DEFAULT);

    public Navbar(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR));
        this.add(new CssClassAppender(this.styleModel));
        this.add(new CssClassAppender(this.positionModel));

        WebMarkupContainer container = new WebMarkupContainer("container");
        container.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>()
        {
            @Override
            public CssClass getObject()
            {
                if (NavbarPosition.INLINE.equals(Navbar.this.positionModel.getObject())) {
                    return ContainerStyle.FLUID;
                }

                return Navbar.this.containerStyleModel.getObject();
            }
        }));
        this.add(container);

        container.add(this.createBrand("navbarBrand"));

        WebMarkupContainer navbarCollapse = new WebMarkupContainer("navbarCollapse");
        navbarCollapse.setOutputMarkupId(true);
        container.add(navbarCollapse);

        Component navbarToggle = this.createNavbarToggle("navbarToggle");
        navbarToggle.add(new AttributeModifier("data-target", new AbstractReadOnlyModel<String>()
        {
            @Override
            public String getObject()
            {
                return String.format("#%s", navbarCollapse.getMarkupId());
            }
        }));
        container.add(navbarToggle);

        RepeatingView collapseItemView = new RepeatingView("navbarCollapseItem");
        this.populateCollapseItems(collapseItemView);
        navbarCollapse.add(collapseItemView);
    }

    protected Component createNavbarToggle(String id)
    {
        return new NavbarToggle(id);
    }

    protected Component createBrand(String id)
    {
        WebMarkupContainer brandLink = new WebMarkupContainer(id);
        brandLink.setVisible(false);

        return brandLink;
    }

    protected void populateCollapseItems(RepeatingView collapseItemView)
    {
        /* Hook */
    }

    public Navbar setPosition(NavbarPosition position)
    {
        this.positionModel.setObject(position);
        return this;
    }

    public Navbar setStyle(NavbarStyle style)
    {
        this.styleModel.setObject(style);
        return this;
    }

    public Navbar setContainerStyle(ContainerStyle containerStyle)
    {
        this.containerStyleModel.setObject(containerStyle);
        return this;
    }
}
