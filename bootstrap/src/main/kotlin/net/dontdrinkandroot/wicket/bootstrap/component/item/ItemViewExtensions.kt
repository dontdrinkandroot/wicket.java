package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.kmodel.kModel
import net.dontdrinkandroot.wicket.kmodel.model
import org.apache.wicket.Page
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

fun ItemView.ajaxLink(
    label: String,
    vararg linkBehaviors: Behavior,
    onClickHandler: AjaxLinkItem<Void>.(target: AjaxRequestTarget?) -> Any?
) {
    add(object : AjaxLinkItem<Void>(newChildId(), null, model(label), linkBehaviors = linkBehaviors) {
        override fun onClick(target: AjaxRequestTarget?) {
            onClickHandler(target)
        }
    })
}

fun ItemView.divider() {
    this.add(DropdownDividerItem(newChildId()))
}

fun ItemView.dropdown(label: String, vararg linkBehaviors: Behavior, populateItemsHandler: ItemView.() -> Any?) {
    this.add(object : RepeatingDropdownItem<Void>(this.newChildId(), null, model(label), *linkBehaviors) {
        override fun populateItems(itemView: ItemView) {
            populateItemsHandler(itemView)
        }
    })
}

fun ItemView.header(label: String) {
    add(DropdownHeaderItem(newChildId(), kModel(label)))
}

fun <T> ItemView.link(
    label: IModel<String>,
    model: IModel<T>,
    vararg linkBehaviors: Behavior,
    onClickHandler: LinkItem<T>.() -> Any?
) {
    add(createLinkItem(newChildId(), model, label, linkBehaviors = linkBehaviors, onClickHandler))
}

inline fun <T> ItemView.link(
    label: String,
    model: IModel<T>,
    vararg linkBehaviors: Behavior,
    crossinline onClickHandler: LinkItem<T>.() -> Any?
) {
    add(createLinkItem(newChildId(), model, Model(label), linkBehaviors = linkBehaviors, onClickHandler))
}

fun ItemView.link(label: String, vararg linkBehaviors: Behavior, onClickHandler: LinkItem<Void>.() -> Any?) {
    add(createLinkItem(newChildId(), null, model(label), linkBehaviors = linkBehaviors, onClickHandler))
}

fun ItemView.pageLink(label: String, pageClass: Class<out Page>) {
    add(BookmarkablePageLinkItem<Void>(newChildId(), label = model(label), pageClass = pageClass))
}

fun ItemView.pageLink(
    label: String,
    pageClass: Class<out Page>,
    pageParameters: PageParameters?,
    vararg linkBehaviors: Behavior
) {
    add(
        BookmarkablePageLinkItem<Void>(
            newChildId(),
            label = model(label),
            pageClass = pageClass,
            pageParameters = pageParameters,
            linkBehaviors = *linkBehaviors
        )
    )
}

fun ItemView.pageLink(label: IModel<String>, pageClass: Class<out Page>) {
    add(BookmarkablePageLinkItem<Void>(newChildId(), label = label, pageClass = pageClass))
}
