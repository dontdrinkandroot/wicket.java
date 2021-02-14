package net.dontdrinkandroot.wicket.bootstrap.component.modal

import net.dontdrinkandroot.wicket.bootstrap.behavior.ModalRequestBehavior
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest
import net.dontdrinkandroot.wicket.bootstrap.event.OpenModalRequest
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.event.Broadcast
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.WebPage

class ModalPage : WebPage() {

    override fun onInitialize() {
        super.onInitialize()
        val modalContainer = WebMarkupContainer("modal")
        modalContainer.outputMarkupId = true
        this.add(modalContainer)
        this.add(ModalRequestBehavior("modal"))
        val openModalLink: AjaxLink<Void> = object : AjaxLink<Void>("openModalLink") {
            override fun onClick(target: AjaxRequestTarget) {
                this.send(this.page, Broadcast.EXACT, OpenModalRequest(target, SimpleModal("modal")))
            }
        }
        this.add(openModalLink)
        val createAndOpenModalLink: AjaxLink<Void> = object : AjaxLink<Void>("createAndOpenModalLink") {
            override fun onClick(target: AjaxRequestTarget) {
                this.send(
                    this.page,
                    Broadcast.EXACT,
                    CreateAndOpenModalRequest(target, SimpleModal::class.java)
                )
            }
        }
        this.add(createAndOpenModalLink)
    }
}