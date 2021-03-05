package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.button.ajaxButtonLink
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest
import net.dontdrinkandroot.wicket.example.component.SimpleAjaxFormModal
import net.dontdrinkandroot.wicket.example.component.SimpleFormModal
import net.dontdrinkandroot.wicket.example.component.SimpleModal
import org.apache.wicket.event.Broadcast
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class ModalPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = Model("Modals")

    override fun onInitialize() {
        super.onInitialize()

        this.add(
            ajaxButtonLink("openStandardModalButton", bodyModel = Model("Standard Modal"))
            { target ->
                target?.let {
                    send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleModal::class))
                }
            }
        )

        this.add(
            ajaxButtonLink("openFormModalButton", bodyModel = Model("Form Modal"))
            { target ->
                target?.let {
                    this.send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleFormModal::class))
                }
            }
        )

        this.add(ajaxButtonLink("openAjaxFormModalButton", bodyModel = Model("Ajax Form Modal"))
        { target ->
            target?.let {
                this.send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleAjaxFormModal::class))
            }
        }
        )
    }
}