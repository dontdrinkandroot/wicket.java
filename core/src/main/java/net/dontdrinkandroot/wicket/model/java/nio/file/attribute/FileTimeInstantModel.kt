package net.dontdrinkandroot.wicket.model.java.nio.file.attribute

import net.dontdrinkandroot.wicket.model.AbstractChainedReadonlyModel
import org.apache.wicket.model.IModel
import java.nio.file.attribute.FileTime
import java.time.Instant

class FileTimeInstantModel(parent: IModel<out FileTime>) : AbstractChainedReadonlyModel<FileTime, Instant?>(parent) {

    override fun getObject(): Instant? = getParentModelObject()?.toInstant()
}