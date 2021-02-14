package net.dontdrinkandroot.wicket.bootstrap.event

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal
import org.apache.wicket.ajax.AjaxRequestTarget

class OpenModalRequest(target: AjaxRequestTarget, val modal: Modal<*>) : ModalRequest(target)