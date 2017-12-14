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
import org.apache.wicket.model.IModel;

/**
 * Sets the component to invisible if its model or the modelobject is null or it is an empty string.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class EmptyModelInvisibleBehavior extends Behavior
{
    @Override
    public void onConfigure(Component component)
    {
        super.onConfigure(component);

        IModel<?> model = component.getDefaultModel();

        boolean visible = null != model;
        visible = visible && null != model.getObject();
        visible =
                visible && (!(model.getObject() instanceof String) || !("".equals(((String) model.getObject()).trim())));

        component.setVisible(visible);
    }
}
