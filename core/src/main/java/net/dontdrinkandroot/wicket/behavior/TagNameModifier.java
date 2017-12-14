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
package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

/**
 * Changes the component tag name. Note that as this is a behavior this is done after the
 * {@link Component#onComponentTag(ComponentTag)} execution.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class TagNameModifier extends Behavior
{
    private String tagName;

    public TagNameModifier(String tagName)
    {
        this.tagName = tagName;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag)
    {
        tag.setName(this.tagName);
        super.onComponentTag(component, tag);
    }
}
