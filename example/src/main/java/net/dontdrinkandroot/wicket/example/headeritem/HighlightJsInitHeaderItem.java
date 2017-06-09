package net.dontdrinkandroot.wicket.example.headeritem;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptContentHeaderItem;

import java.util.Arrays;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class HighlightJsInitHeaderItem extends JavaScriptContentHeaderItem
{
    public HighlightJsInitHeaderItem()
    {
        super("hljs.initHighlightingOnLoad();", "highlight-init", null);
    }

    @Override
    public List<HeaderItem> getDependencies()
    {
        return Arrays.asList(
                new HighlightCssCustomHeaderItem(),
                new HighlightJsHeaderItem()
        );
    }
}
