package net.dontdrinkandroot.wicket.component

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import java.time.Duration

class SelfUpdatingGenericPanel<T> : GenericPanel<T>
{
    constructor(id: String, updateInterval: Duration) : super(id) {
        this.outputMarkupId = true
        this.add(AjaxSelfUpdatingTimerBehavior(updateInterval))
    }

    constructor(id: String?, model: IModel<T>?, updateInterval: Duration?) : super(id, model)
    {
        this.outputMarkupId = true
        this.add(AjaxSelfUpdatingTimerBehavior(updateInterval))
    }
}