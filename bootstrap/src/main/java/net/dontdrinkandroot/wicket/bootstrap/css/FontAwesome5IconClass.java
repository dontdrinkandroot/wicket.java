package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;

public enum FontAwesome5IconClass implements CssClass
{
    EDIT("fas fa-edit");

    private final String classString;

    FontAwesome5IconClass(String classString)
    {
        this.classString = classString;
    }

    @Override
    public String getClassString()
    {
        return this.classString;
    }

    public FontAwesome5Icon createIcon()
    {
        return new FontAwesome5Icon(this);
    }
}
