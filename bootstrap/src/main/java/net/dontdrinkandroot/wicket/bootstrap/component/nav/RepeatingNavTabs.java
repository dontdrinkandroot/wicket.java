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
package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavTabsBehavior;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingNavTabs<T> extends AbstractRepeatingNav<T>
{
    private NavTabsBehavior navTabsBehavior = new NavTabsBehavior();

    public RepeatingNavTabs(String id)
    {
        this(id, null);
    }

    public RepeatingNavTabs(String id, IModel<T> model)
    {
        super(id, model);
        this.add(this.navTabsBehavior);
    }

    public void setJustified(boolean justified)
    {
        this.navTabsBehavior.setJustified(justified);
    }
}
