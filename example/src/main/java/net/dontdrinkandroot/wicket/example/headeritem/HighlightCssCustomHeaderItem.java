package net.dontdrinkandroot.wicket.example.headeritem;

import org.apache.wicket.markup.head.CssContentHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;

import java.util.Collections;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class HighlightCssCustomHeaderItem extends CssContentHeaderItem
{
    public HighlightCssCustomHeaderItem()
    {
        super(".hljs {background: transparent; padding: 0;}", "highlight-custom", null);
    }

    @Override
    public List<HeaderItem> getDependencies()
    {
        return Collections.singletonList(new HightlightCssHeaderItem());
    }
}
