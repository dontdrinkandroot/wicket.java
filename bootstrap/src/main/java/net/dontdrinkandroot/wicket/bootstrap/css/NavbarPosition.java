package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public enum NavbarPosition implements CssClass
{
    INLINE(""),
    FIXED_TOP("navbar-fixed-top"),
    FIXED_BOTTOM("navbar-fixed-bottom"),
    STATIC_TOP("navbar-static-top");

    private String classString;

    NavbarPosition(String classString)
    {
        this.classString = classString;
    }

    @Override
    public String getClassString()
    {
        return this.classString;
    }
}
