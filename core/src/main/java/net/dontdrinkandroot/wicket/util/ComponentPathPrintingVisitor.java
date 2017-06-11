package net.dontdrinkandroot.wicket.util;

import org.apache.wicket.Component;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

/**
 * Prints all component paths and their classes.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ComponentPathPrintingVisitor implements IVisitor<Component, Void>
{
    @Override
    public void component(Component component, IVisit<Void> visit)
    {
        System.out.println(String.format("%s: %s", component.getPageRelativePath(), component.getClass()));
    }
}
