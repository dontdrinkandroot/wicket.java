package net.dontdrinkandroot.wicket.example.headeritem

import org.apache.wicket.markup.head.HeaderItem
import org.apache.wicket.markup.head.JavaScriptContentHeaderItem
import java.util.*

class HighlightJsInitHeaderItem : JavaScriptContentHeaderItem("hljs.initHighlightingOnLoad();", "highlight-init")
{
    override fun getDependencies(): List<HeaderItem>
    {
        return Arrays.asList(
            HighlightCssCustomHeaderItem(),
            HighlightJsHeaderItem()
        )
    }
}