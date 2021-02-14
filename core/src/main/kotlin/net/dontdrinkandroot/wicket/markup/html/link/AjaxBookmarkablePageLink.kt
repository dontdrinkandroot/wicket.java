package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.Page
import org.apache.wicket.ajax.AjaxEventBehavior
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.request.mapper.parameter.PageParameters

open class AjaxBookmarkablePageLink<T>(id: String, pageClass: Class<Page>, parameters: PageParameters? = null) :
    BookmarkablePageLink<T>(id, pageClass, parameters) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(object : AjaxEventBehavior("click") {
            override fun onEvent(target: AjaxRequestTarget) {
                this@AjaxBookmarkablePageLink.onClick(target)
            }

            override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
                super.updateAjaxAttributes(attributes)
                attributes.isPreventDefault = true
                this@AjaxBookmarkablePageLink.updateAjaxAttributes(attributes)
            }
        })
    }

    protected fun updateAjaxAttributes(attributes: AjaxRequestAttributes?) {
        /* Hook */
    }

    protected open fun onClick(target: AjaxRequestTarget?) {
        /* Hook */
    }
}