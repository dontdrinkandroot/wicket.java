package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesome5IconClass
import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class PrevPageLinkItem(id: String, pageable: IPageable) : AbstractPageLinkItem(id, pageable) {

    override fun createLabel(): IModel<String> = Model("")

    override fun onLinkCreated(link: AbstractLink) {
        super.onLinkCreated(link)
        link.add(AttributeAppender("rel", "prev"))
        link.add(IconBehavior(FontAwesome5IconClass.ANGLE_LEFT.createIcon()))
    }

    override fun isEnabled(): Boolean = pageable.currentPage != 0L

    override fun setPaginablePage() {
        pageable.currentPage = Math.max(0, pageable.currentPage - 1)
    }

    override val paginablePageModel: IModel<Long>
        get() = IModel { pageable.currentPage - 1 }
}