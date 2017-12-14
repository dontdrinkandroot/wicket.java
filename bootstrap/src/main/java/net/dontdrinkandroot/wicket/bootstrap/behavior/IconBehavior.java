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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.transformer.AbstractTransformerBehavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Prepends and/or appends an Icon to the body of the attached component.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class IconBehavior extends AbstractTransformerBehavior
{
    /**
     * Pattern that matches html tags and is able to extract the open tag, body and close tag.
     */
    private final static Pattern PATTERN = Pattern.compile("(<.*?>)(.*)(</.*?>)", Pattern.DOTALL);

    private IModel<CssClass> prependIconModel;

    private IModel<CssClass> appendIconModel;

    private String separator = "&nbsp;&nbsp;";

    /**
     * Create an IconBehavior that does not add any Icon initially.
     */
    public IconBehavior()
    {
        /* Noop */
    }

    /**
     * Creates an IconBehavior that prepends the given icon.
     */
    public IconBehavior(IModel<CssClass> prependIconModel)
    {
        this.prependIconModel = prependIconModel;
    }

    /**
     * Creates an IconBehavior that prepends the given icon.
     */
    public IconBehavior(CssClass prependIcon)
    {
        this.setPrependIcon(prependIcon);
    }

    /**
     * Creates an IconBehavior with prepended and appended icon.
     */
    public IconBehavior(IModel<CssClass> prependIconModel, IModel<CssClass> appendIconModel)
    {
        this.prependIconModel = prependIconModel;
        this.appendIconModel = appendIconModel;
    }

    /**
     * Creates an IconBehavior with prepended and appended icon.
     */
    public IconBehavior(CssClass prependIcon, CssClass appendIcon)
    {
        this.setPrependIcon(prependIcon);
        this.setAppendIcon(appendIcon);
    }

    @Override
    public CharSequence transform(Component component, CharSequence output)
    {
        boolean hasPrependIcon =
                (this.getPrependIconModel() != null) && (this.getPrependIconModel().getObject() != null);
        boolean hasAppendIcon = (this.getAppendIconModel() != null) && (this.getAppendIconModel().getObject() != null);

        /* Abort early if no icon is requested */
        if (!hasPrependIcon && !hasAppendIcon) {
            return output;
        }

        /*
         * Fail if there if the component does not have a body and therefore is a single tag (e.g. <input />)
         */
        Matcher matcher = IconBehavior.PATTERN.matcher(output);
        if (!matcher.matches()) {
            throw new WicketRuntimeException(
                    String.format("IconBehavior applied to a component that does not have a body: %s", output));
        }

        /* Extract the parts */
        String openTag = matcher.group(1);
        String body = matcher.group(2);
        String closeTag = matcher.group(3);
        boolean bodyIsEmpty = Strings.isEmpty(body);

        StringBuffer outputBuffer = new StringBuffer(openTag);

        /* Prepend icon if requested */
        if (hasPrependIcon) {
            outputBuffer.append(this.renderIcon(this.getPrependIconModel()));
            if (((null != this.separator) && !bodyIsEmpty) || hasAppendIcon) {
                outputBuffer.append(this.separator);
            }
        }

        outputBuffer.append(body);

        /* Append icon if requested */
        if (hasAppendIcon) {
            if ((null != this.separator) && !bodyIsEmpty) {
                outputBuffer.append(this.separator);
            }
            outputBuffer.append(this.renderIcon(this.getAppendIconModel()));
        }

        outputBuffer.append(closeTag);

        return outputBuffer;
    }

    /**
     * Get the iocn to prepend if set or null.
     */
    public CssClass getPrependIcon()
    {
        if (this.prependIconModel == null) {
            return null;
        }
        return this.getPrependIconModel().getObject();
    }

    /**
     * Get the icon to append if set or null.
     */
    public CssClass getAppendIcon()
    {
        if (this.appendIconModel == null) {
            return null;
        }
        return this.getAppendIconModel().getObject();
    }

    /**
     * Set the icon to prepend, if it is null no icon will be prepended.
     */
    public IconBehavior setPrependIcon(CssClass prependIcon)
    {
        if (prependIcon == null) {
            this.prependIconModel = null;
            return this;
        }

        if (this.prependIconModel == null) {
            this.prependIconModel = Model.of(prependIcon);
        } else {
            this.prependIconModel.setObject(prependIcon);
        }

        return this;
    }

    /**
     * Set the icon to append, if it is null no icon will be appended.
     */
    public IconBehavior setAppendIcon(CssClass appendIcon)
    {
        if (appendIcon == null) {
            this.appendIconModel = null;
            return this;
        }

        if (this.appendIconModel == null) {
            this.appendIconModel = Model.of(appendIcon);
        } else {
            this.appendIconModel.setObject(appendIcon);
        }

        return this;
    }

    /**
     * Set the model of the icon to prepend, if it or its object is null no icon will be prepended.
     */
    public IconBehavior setPrependIcon(IModel<CssClass> prependIconModel)
    {
        this.prependIconModel = prependIconModel;
        return this;
    }

    /**
     * Set the model of the icon to append, if it or its object is null no icon will be prepended.
     */
    public IconBehavior setAppendIcon(IModel<CssClass> appendIconModel)
    {
        this.appendIconModel = appendIconModel;
        return this;
    }

    /**
     * Get the model of the icon to prepend.
     */
    protected IModel<CssClass> getPrependIconModel()
    {
        return this.prependIconModel;
    }

    /**
     * Get the model of the icon to append.
     */
    protected IModel<CssClass> getAppendIconModel()
    {
        return this.appendIconModel;
    }

    /**
     * Sets the (HTML) String that is added between the icon and the body. By default this is some extra non breaking
     * spacing.
     */
    public IconBehavior setSeparator(String separator)
    {
        this.separator = separator;
        return this;
    }

    /**
     * Renders a span element with the given CssClass.
     */
    protected String renderIcon(IModel<CssClass> iconModel)
    {
        return String.format("<span class=\"%s\"></span>", iconModel.getObject().getClassString());
    }
}
