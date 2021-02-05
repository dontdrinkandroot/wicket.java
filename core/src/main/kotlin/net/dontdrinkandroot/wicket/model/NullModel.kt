package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class NullModel<T> : IModel<T?>
{

    override fun getObject(): T? = null
}
