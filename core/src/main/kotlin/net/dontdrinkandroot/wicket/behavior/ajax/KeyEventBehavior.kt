package net.dontdrinkandroot.wicket.behavior.ajax

import org.apache.wicket.ajax.AjaxEventBehavior
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes

abstract class KeyEventBehavior(event: String = "keyup") : AjaxEventBehavior("keyup") {

    override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
        super.updateAjaxAttributes(attributes)
        val keyEvtBuffer = StringBuffer()
        keyEvtBuffer.append("return {")
        keyEvtBuffer.append("'keyEvent.altKey': attrs.event.altKey,")
        keyEvtBuffer.append("'keyEvent.charCode': attrs.event.charCode,")
        keyEvtBuffer.append("'keyEvent.ctrlKey': attrs.event.ctrlKey,")
        keyEvtBuffer.append("'keyEvent.keyCode': attrs.event.keyCode,")
        keyEvtBuffer.append("'keyEvent.metaKey': attrs.event.metaKey,")
        keyEvtBuffer.append("'keyEvent.shiftKey': attrs.event.shiftKey,")
        keyEvtBuffer.append("'keyEvent.which': attrs.event.which")
        keyEvtBuffer.append("}")
        attributes.dynamicExtraParameters.add(keyEvtBuffer.toString())
    }

    override fun onEvent(target: AjaxRequestTarget) {
        val altKeyValue = component.request.queryParameters.getParameterValue("keyEvent.altKey")
        val altKey = altKeyValue.toBoolean()
        val charCodeValue = component.request.queryParameters.getParameterValue("keyEvent.charCode")
        val charCode = charCodeValue.toInt(-1)
        val ctrlKeyValue = component.request.queryParameters.getParameterValue("keyEvent.ctrlKey")
        val ctrlKey = ctrlKeyValue.toBoolean()
        val keyCodeValue = component.request.queryParameters.getParameterValue("keyEvent.keyCode")
        val keyCode = keyCodeValue.toInt(-1)
        val metaKeyValue = component.request.queryParameters.getParameterValue("keyEvent.metaKey")
        val metaKey = metaKeyValue.toBoolean()
        val shiftKeyValue = component.request.queryParameters.getParameterValue("keyEvent.shiftKey")
        val shiftKey = shiftKeyValue.toBoolean()
        val whichValue = component.request.queryParameters.getParameterValue("keyEvent.which")
        val which = whichValue.toInt(-1)
        this.onEvent(target, KeyEventResponse(which, keyCode, charCode, altKey, ctrlKey, metaKey, shiftKey))
    }

    protected abstract fun onEvent(target: AjaxRequestTarget, keyPressResponse: KeyEventResponse)

    inner class KeyEventResponse(
        val which: Int,
        val keyCode: Int,
        val charCode: Int,
        val isAltKey: Boolean,
        val isCtrlKey: Boolean,
        val isMetaKey: Boolean,
        val isShiftKey: Boolean
    )
}