package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.bootstrap.component.pagination.AbstractPageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesome4Icon
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesome4IconClass
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesome5IconClass
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class FirstPageLinkItem(id: String?, pageable: IPageable?) : AbstractPageLinkItem(id, pageable) {

    override fun createLabel(): IModel<String> = Model("")

    override fun onLinkCreated(link: AbstractLink) {
        super.onLinkCreated(link)
        link.add(IconBehavior(FontAwesome5IconClass.ANGLE_DOUBLE_LEFT.createIcon()))
    }

    override fun isEnabled(): Boolean = pageable.currentPage != 0L

    override fun setPaginablePage() {
        pageable.currentPage = 0
    }

    override fun getPaginablePageModel(): IModel<Long> = Model.of(0L)
}