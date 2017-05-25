package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public enum NavbarAlignment implements CssClass
{
    LEFT("navbar-left"),
    RIGHT("navbar-right");

    private String classString;

    NavbarAlignment(String classString)
    {
        this.classString = classString;
    }

    @Override
    public String getClassString()
    {
        return this.classString;
    }
}
