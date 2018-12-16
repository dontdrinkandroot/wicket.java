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
package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.util.BehaviorUtils;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormRowBehavior extends Behavior
{
    @Override
    public void bind(final Component component)
    {
        super.bind(component);

        component.add(new CssClassAppender(() -> {
            FormStyleBehavior formStyleBehavior = BehaviorUtils.findClosestBehavior(component, FormStyleBehavior.class);
            if (null != formStyleBehavior) {
                if (formStyleBehavior.isHorizontal()) {
                    return BootstrapCssClass.ROW;
                }
            }

            return null;
        }));
    }
}