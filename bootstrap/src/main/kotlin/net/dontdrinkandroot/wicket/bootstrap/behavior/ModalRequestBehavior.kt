package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest
import net.dontdrinkandroot.wicket.bootstrap.event.ModalRequest
import net.dontdrinkandroot.wicket.bootstrap.event.OpenModalRequest
import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.WicketRuntimeException
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.event.IEvent
import kotlin.reflect.full.primaryConstructor

/**
 * Handles [net.dontdrinkandroot.wicket.bootstrap.event.ModalRequest] Events.
 */
class ModalRequestBehavior(private val targetId: String) : Behavior() {

    override fun bind(component: Component) {
        super.bind(component)
        if (component !is MarkupContainer) {
            throw WicketRuntimeException("Can only bind to a markup container")
        }
    }

    override fun onEvent(component: Component, event: IEvent<*>) {
        super.onEvent(component, event)
        if (event.payload is ModalRequest) {
            val modalRequest = event.payload as ModalRequest
            val modal = extractModal(modalRequest)
            val target = modalRequest.target
            (component as MarkupContainer).replace(modal)
            target.add(modal)
            target.appendJavaScript(modal.showScript)
        }
    }

    private fun extractModal(modalRequest: ModalRequest): Modal<*> = when (modalRequest) {
        is OpenModalRequest -> this.createModal(modalRequest)
        is CreateAndOpenModalRequest<*, *> -> this.createModal(modalRequest)
        else -> throw WicketRuntimeException(
            String.format(
                "Unknown Modal Request: %s",
                modalRequest.javaClass.canonicalName
            )
        )
    }

    private fun createModal(openModalRequest: OpenModalRequest): Modal<*> {
        val modal = openModalRequest.modal
        if (targetId != modal.id) throw WicketRuntimeException("Unexpected Modal ID")
        return modal
    }

    private fun createModal(openModalRequest: CreateAndOpenModalRequest<*, *>): Modal<*> {
        val modalClass = openModalRequest.modalClass
        val model = openModalRequest.model
        try {
            val primaryConstructor = modalClass.primaryConstructor
            return when (primaryConstructor!!.parameters.size) {
                1 -> primaryConstructor.call(targetId)
                2 -> primaryConstructor.call(targetId, model)
                else -> throw Exception("No idea how to construct modal")
            }
        } catch (e: Exception) {
            throw WicketRuntimeException(e)
        }
    }
}