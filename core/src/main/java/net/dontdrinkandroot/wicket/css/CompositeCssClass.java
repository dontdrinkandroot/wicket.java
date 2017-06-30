package net.dontdrinkandroot.wicket.css;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A {@link CssClass} that is composed of multiple CssClasses.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CompositeCssClass implements CssClass
{
    private List<CssClass> cssClasses;

    public CompositeCssClass(CssClass... cssClasses)
    {
        this.cssClasses = Arrays.asList(cssClasses);
    }

    public CompositeCssClass(String... cssClassStrings)
    {
        this.cssClasses = new ArrayList<>(cssClassStrings.length);
        for (String cssClassString : cssClassStrings) {
            this.cssClasses.add(new StringCssClass(cssClassString));
        }
    }

    @Override
    public String getClassString()
    {
        return this.cssClasses.stream().map(CssClass::getClassString).collect(Collectors.joining(" "));
    }
}
