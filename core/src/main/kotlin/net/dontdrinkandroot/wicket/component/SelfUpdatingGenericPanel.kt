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
package net.dontdrinkandroot.wicket.component

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import java.time.Duration

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class SelfUpdatingGenericPanel<T> : GenericPanel<T>
{
    constructor(id: String?, updateInterval: Duration?) : super(id)
    {
        this.outputMarkupId = true
        this.add(AjaxSelfUpdatingTimerBehavior(updateInterval))
    }

    constructor(id: String?, model: IModel<T>?, updateInterval: Duration?) : super(id, model)
    {
        this.outputMarkupId = true
        this.add(AjaxSelfUpdatingTimerBehavior(updateInterval))
    }
}