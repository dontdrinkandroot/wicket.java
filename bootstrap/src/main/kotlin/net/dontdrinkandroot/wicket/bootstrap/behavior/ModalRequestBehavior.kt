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
import org.apache.wicket.model.IModel
import java.lang.reflect.InvocationTargetException

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

    private fun extractModal(modalRequest: ModalRequest): Modal<*> {
        if (modalRequest is OpenModalRequest) {
            return this.createModal(modalRequest)
        }
        if (modalRequest is CreateAndOpenModalRequest<*>) {
            return this.createModal(modalRequest)
        }
        throw WicketRuntimeException(
            String.format(
                "Unknown Modal Request: %s",
                modalRequest.javaClass.canonicalName
            )
        )
    }

    private fun createModal(openModalRequest: OpenModalRequest): Modal<*> {
        val modal = openModalRequest.modal
        if (targetId != modal.id) {
            throw WicketRuntimeException("Unexpected Modal ID")
        }
        return modal
    }

    private fun createModal(openModalRequest: CreateAndOpenModalRequest<*>): Modal<*> {
        val modalClass = openModalRequest.modalClass
        val model = openModalRequest.model
        return try {
            if (null == model) {
                modalClass.getConstructor(String::class.java).newInstance(targetId)
            } else {
                modalClass.getConstructor(String::class.java, IModel::class.java).newInstance(
                    targetId,
                    model
                )
            }
        } catch (e: InstantiationException) {
            throw WicketRuntimeException(e)
        } catch (e: IllegalAccessException) {
            throw WicketRuntimeException(e)
        } catch (e: IllegalArgumentException) {
            throw WicketRuntimeException(e)
        } catch (e: InvocationTargetException) {
            throw WicketRuntimeException(e)
        } catch (e: NoSuchMethodException) {
            throw WicketRuntimeException(e)
        } catch (e: SecurityException) {
            throw WicketRuntimeException(e)
        }
    }
}