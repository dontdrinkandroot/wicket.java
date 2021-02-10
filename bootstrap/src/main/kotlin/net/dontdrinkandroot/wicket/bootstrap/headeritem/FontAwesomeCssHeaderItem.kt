package net.dontdrinkandroot.wicket.bootstrap.headeritem

import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem
import org.apache.wicket.markup.html.CrossOrigin

const val FONTAWESOME_VERSION = "4.7.0"

class FontAwesomeCssHeaderItem : CssUrlReferenceHeaderItem(
    "https://cdn.jsdelivr.net/npm/font-awesome@$FONTAWESOME_VERSION/css/font-awesome.min.css",
    null,
    "screen"
) {

    init {
        integrity = "sha256-eZrrJcwDc/3uDhsdt61sL2oOBY362qM3lon1gyExkL0="
        crossOrigin = CrossOrigin.ANONYMOUS
    }
}