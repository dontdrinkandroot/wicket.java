package net.dontdrinkandroot.wicket.model.java.nio.file.attribute;

import net.dontdrinkandroot.wicket.model.AbstractChainedReadonlyModel;
import org.apache.wicket.model.IModel;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BasicFileAttributesLastModifiedTimeModel extends AbstractChainedReadonlyModel<BasicFileAttributes, FileTime>
{
    public BasicFileAttributesLastModifiedTimeModel(IModel<? extends BasicFileAttributes> parent)
    {
        super(parent);
    }

    @Override
    public FileTime getObject()
    {
        return this.getParentObject().lastModifiedTime();
    }
}
