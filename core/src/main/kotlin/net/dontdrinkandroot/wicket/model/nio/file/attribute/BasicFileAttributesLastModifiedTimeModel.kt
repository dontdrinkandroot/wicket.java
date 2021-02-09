package net.dontdrinkandroot.wicket.model.nio.file.attribute

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import org.apache.wicket.model.IModel
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileTime

class BasicFileAttributesLastModifiedTimeModel(parent: IModel<BasicFileAttributes>) :
    AbstractChainedModel<BasicFileAttributes, FileTime>(parent) {

    override fun getValue(parentValue: BasicFileAttributes?) = parentValue?.lastModifiedTime()
}