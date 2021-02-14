package net.dontdrinkandroot.wicket.bootstrap.event

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.model.IModel
import kotlin.reflect.KClass

/**
 * @param <T> Type of the modal model object.
 */
class CreateAndOpenModalRequest<T, C : Modal<T>>(
    target: AjaxRequestTarget,
    val modalClass: KClass<C>,
    val model: IModel<T>? = null
) : ModalRequest(target)