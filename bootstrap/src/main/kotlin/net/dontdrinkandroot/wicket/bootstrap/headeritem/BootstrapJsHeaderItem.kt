package net.dontdrinkandroot.wicket.bootstrap.headeritem

import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem
import org.apache.wicket.markup.html.CrossOrigin

const val BOOTSTRAP_VERSION = "5.0.0-beta1"

class BootstrapJsHeaderItem : JavaScriptUrlReferenceHeaderItem(
    "https://cdn.jsdelivr.net/npm/bootstrap@$BOOTSTRAP_VERSION/dist/js/bootstrap.bundle.min.js",
    "bootstrap.js"
) {

    init {
        integrity = "sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossOrigin = CrossOrigin.ANONYMOUS
    }
}