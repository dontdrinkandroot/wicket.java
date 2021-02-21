package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxButton
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest
import net.dontdrinkandroot.wicket.example.component.SimpleAjaxFormModal
import net.dontdrinkandroot.wicket.example.component.SimpleFormModal
import net.dontdrinkandroot.wicket.example.component.SimpleModal
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.event.Broadcast
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class ModalPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Modals".model()

    override fun onInitialize() {
        super.onInitialize()

        this.add(
            AjaxButton<Void>(
                "openStandardModalButton",
                bodyModel = Model("Standard Modal"),
                onClickHandler = { target ->
                    target?.let {
                        send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleModal::class))
                    }
                })
        )

        this.add(
            AjaxButton<Void>(
                "openFormModalButton",
                bodyModel = Model("Form Modal"),
                onClickHandler = { target ->
                    target?.let {
                        this.send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleFormModal::class))
                    }
                })
        )

        this.add(AjaxButton<Void>(
            "openAjaxFormModalButton",
            bodyModel = Model("Ajax Form Modal"),
            onClickHandler = { target ->
                target?.let {
                    this.send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleAjaxFormModal::class))
                }
            }
        ))
    }
}