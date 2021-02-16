package net.dontdrinkandroot.wicket.example.headeritem

import org.apache.wicket.markup.head.CssContentHeaderItem
import org.apache.wicket.markup.head.HeaderItem

class HighlightCssCustomHeaderItem :
    CssContentHeaderItem(".hljs {background: transparent; padding: 0;}", "highlight-custom")
{
    override fun getDependencies(): List<HeaderItem>
    {
        return listOf(HightlightCssHeaderItem())
    }
}