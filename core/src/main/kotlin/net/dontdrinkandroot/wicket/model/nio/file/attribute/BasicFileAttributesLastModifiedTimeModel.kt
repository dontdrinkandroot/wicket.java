package net.dontdrinkandroot.wicket.model.nio.file.attribute

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import net.dontdrinkandroot.wicket.model.KModel
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileTime

class BasicFileAttributesLastModifiedTimeModel(parent: KModel<BasicFileAttributes>) :
    AbstractChainedModel<BasicFileAttributes, FileTime>(parent) {

    override fun getValue(parentValue: BasicFileAttributes) = parentValue.lastModifiedTime()
}