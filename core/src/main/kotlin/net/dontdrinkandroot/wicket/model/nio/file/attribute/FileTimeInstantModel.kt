package net.dontdrinkandroot.wicket.model.nio.file.attribute

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import org.apache.wicket.model.IModel
import java.nio.file.attribute.FileTime
import java.time.Instant

class FileTimeInstantModel(parent: IModel<FileTime>) : AbstractChainedModel<FileTime, Instant>(parent) {

    override fun getValue(parentValue: FileTime?) = parentValue?.toInstant()
}