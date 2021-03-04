package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.breadcrumb.RepeatingBreadcrumb
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.request.mapper.parameter.PageParameters

class BreadcrumbPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Breadcrumbs".model()

    override fun onInitialize() {
        super.onInitialize()
        val breadcrumb: RepeatingBreadcrumb<Void> = object : RepeatingBreadcrumb<Void>("breadcrumb") {
            override fun populateItems(itemView: RepeatingView) {
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Examples".model(),
                        pageClass = HomePage::class
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Breadcrumbs".model(),
                        pageClass = BreadcrumbPage::class
                    )
                )
            }
        }
        this.add(breadcrumb)
    }
}