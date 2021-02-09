package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxButton
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest
import net.dontdrinkandroot.wicket.example.component.SimpleAjaxFormModal
import net.dontdrinkandroot.wicket.example.component.SimpleFormModal
import net.dontdrinkandroot.wicket.example.component.SimpleModal
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.event.Broadcast
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class ModalPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Modals".model()

    override fun onInitialize() {
        super.onInitialize()
        this.add(object : AjaxButton<Void?>("openStandardModalButton")
        {
            override fun onClick(target: AjaxRequestTarget)
            {
                this.send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleModal::class.java))
            }
        }.setBody(Model.of("Standard Modal")))
        this.add(object : AjaxButton<Void?>("openFormModalButton")
        {
            override fun onClick(target: AjaxRequestTarget)
            {
                this.send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleFormModal::class.java))
            }
        }.setBody(Model.of("Form Modal")))
        this.add(object : AjaxButton<Void?>("openAjaxFormModalButton")
        {
            override fun onClick(target: AjaxRequestTarget)
            {
                this.send(this, Broadcast.BUBBLE, CreateAndOpenModalRequest(target, SimpleAjaxFormModal::class.java))
            }
        }.setBody(Model.of("Ajax Form Modal")))
    }
}