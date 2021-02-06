package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.breadcrumb.RepeatingBreadcrumb
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.example.page.HomePage
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class BreadcrumbPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel(): IModel<String> {
        return Model.of("Breadcrumbs")
    }

    override fun onInitialize() {
        super.onInitialize()
        val breadcrumb: RepeatingBreadcrumb<Void> = object : RepeatingBreadcrumb<Void>("breadcrumb")
        {
            override fun populateItems(itemView: RepeatingView)
            {
                itemView.add(
                    BookmarkablePageLinkItem<Void, HomePage>(
                        itemView.newChildId(), Model.of("Examples"),
                        HomePage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, BreadcrumbPage>(
                        itemView.newChildId(),
                        Model.of("Breadcrumbs"),
                        BreadcrumbPage::class.java
                    )
                )
            }
        }
        this.add(breadcrumb)
    }
}