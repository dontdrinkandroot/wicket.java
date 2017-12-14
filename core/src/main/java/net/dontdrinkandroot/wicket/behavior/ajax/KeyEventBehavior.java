/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.behavior.ajax;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.util.string.StringValue;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class KeyEventBehavior extends AjaxEventBehavior
{
    public KeyEventBehavior()
    {
        super("keyup");
    }

    public KeyEventBehavior(String event)
    {
        super(event);
    }

    @Override
    protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
    {
        super.updateAjaxAttributes(attributes);

        StringBuffer keyEvtBuffer = new StringBuffer();
        keyEvtBuffer.append("return {");
        keyEvtBuffer.append("'keyEvent.altKey': attrs.event.altKey,");
        keyEvtBuffer.append("'keyEvent.charCode': attrs.event.charCode,");
        keyEvtBuffer.append("'keyEvent.ctrlKey': attrs.event.ctrlKey,");
        keyEvtBuffer.append("'keyEvent.keyCode': attrs.event.keyCode,");
        keyEvtBuffer.append("'keyEvent.metaKey': attrs.event.metaKey,");
        keyEvtBuffer.append("'keyEvent.shiftKey': attrs.event.shiftKey,");
        keyEvtBuffer.append("'keyEvent.which': attrs.event.which");
        keyEvtBuffer.append("}");

        attributes.getDynamicExtraParameters().add(keyEvtBuffer.toString());
    }

    @Override
    protected void onEvent(AjaxRequestTarget target)
    {
        final StringValue altKeyValue =
                this.getComponent().getRequest().getQueryParameters().getParameterValue("keyEvent.altKey");
        final boolean altKey = altKeyValue.toBoolean();

        final StringValue charCodeValue =
                this.getComponent().getRequest().getQueryParameters().getParameterValue("keyEvent.charCode");
        final int charCode = charCodeValue.toInt(-1);

        final StringValue ctrlKeyValue =
                this.getComponent().getRequest().getQueryParameters().getParameterValue("keyEvent.ctrlKey");
        final boolean ctrlKey = ctrlKeyValue.toBoolean();

        final StringValue keyCodeValue =
                this.getComponent().getRequest().getQueryParameters().getParameterValue("keyEvent.keyCode");
        final int keyCode = keyCodeValue.toInt(-1);

        final StringValue metaKeyValue =
                this.getComponent().getRequest().getQueryParameters().getParameterValue("keyEvent.metaKey");
        final boolean metaKey = metaKeyValue.toBoolean();

        final StringValue shiftKeyValue =
                this.getComponent().getRequest().getQueryParameters().getParameterValue("keyEvent.shiftKey");
        final boolean shiftKey = shiftKeyValue.toBoolean();

        final StringValue whichValue =
                this.getComponent().getRequest().getQueryParameters().getParameterValue("keyEvent.which");
        final int which = whichValue.toInt(-1);

        this.onEvent(target, new KeyEventResponse(which, keyCode, charCode, altKey, ctrlKey, metaKey, shiftKey));
    }

    protected abstract void onEvent(AjaxRequestTarget target, KeyEventResponse keyPressResponse);

    public class KeyEventResponse
    {
        private final int which;

        private final int keyCode;

        private final int charCode;

        private final boolean altKey;

        private final boolean ctrlKey;

        private final boolean metaKey;

        private final boolean shiftKey;

        public KeyEventResponse(
                int which,
                int keyCode,
                int charCode,
                boolean altKey,
                boolean ctrlKey,
                boolean metaKey,
                boolean shiftKey)
        {
            this.which = which;
            this.keyCode = keyCode;
            this.charCode = charCode;
            this.altKey = altKey;
            this.ctrlKey = ctrlKey;
            this.metaKey = metaKey;
            this.shiftKey = shiftKey;
        }

        public int getWhich()
        {
            return this.which;
        }

        public int getKeyCode()
        {
            return this.keyCode;
        }

        public int getCharCode()
        {
            return this.charCode;
        }

        public boolean isAltKey()
        {
            return this.altKey;
        }

        public boolean isCtrlKey()
        {
            return this.ctrlKey;
        }

        public boolean isMetaKey()
        {
            return this.metaKey;
        }

        public boolean isShiftKey()
        {
            return this.shiftKey;
        }
    }
}
