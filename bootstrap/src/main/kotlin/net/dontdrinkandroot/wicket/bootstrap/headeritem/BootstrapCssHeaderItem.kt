package net.dontdrinkandroot.wicket.bootstrap.headeritem

import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem
import org.apache.wicket.markup.html.CrossOrigin

class BootstrapCssHeaderItem : CssUrlReferenceHeaderItem(
    "https://cdn.jsdelivr.net/npm/bootstrap@5$BOOTSTRAP_VERSION/dist/css/bootstrap.min.css",
    null,
    "stylesheet"
) {

    init {
        integrity = "sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
        crossOrigin = CrossOrigin.ANONYMOUS
    }

    override fun getDependencies() = mutableListOf(BootstrapJsHeaderItem())
}