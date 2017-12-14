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
package net.dontdrinkandroot.wicket.behavior.aria;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public enum Aria
{
    ACTIVEDESCENDANT("aria-activedescendant", false),
    ATOMIC("aria-atomic", false),
    AUTOCOMPLETE("aria-autocomplete", false),
    BUSY("aria-busy", true),
    CHECKED("aria-checked", true),
    CONTROLS("aria-controls", false),
    DESCRIBEDBY("aria-describedby", false),
    DISABLED("aria-disabled", true),
    DROPEFFECT("aria-dropeffect", false),
    EXPANDED("aria-expanded", true),
    FLOWTO("aria-flowto", false),
    GRABBED("aria-grabbed", true),
    HASPOPUP("aria-haspopup", false),
    HIDDEN("aria-hidden", true),
    INVALID("aria-invalid", true),
    LABEL("aria-label", false),
    LABELLEDBY("aria-labelledby", false),
    LEVEL("aria-level", false),
    LIVE("aria-live", false),
    MULTILINE("aria-multiline", false),
    MULTISELECTABLE("aria-multiselectable", false),
    ORIENTATION("aria-orientation", false),
    OWNS("aria-owns", false),
    POSINSET("aria-posinset", false),
    PRESSED("aria-pressed", true),
    READONLY("aria-readonly", false),
    RELEVANT("aria-relevant", false),
    REQUIRED("aria-required", false),
    SELECTED("aria-selected", true),
    SETSIZE("aria-setsize", false),
    SORT("aria-sort", false),
    VALUEMAX("aria-valuemax", false),
    VALUEMIN("aria-valuemin", false),
    VALUENOW("aria-valuenow", false),
    VALUETEXT("aria-valuetext", false);

    private String attribute;

    private boolean withState;

    Aria(String attribute, boolean withState)
    {
        this.attribute = attribute;
        this.withState = withState;
    }

    public String getAttribute()
    {
        return this.attribute;
    }

    public boolean isWithState()
    {
        return this.withState;
    }

}
