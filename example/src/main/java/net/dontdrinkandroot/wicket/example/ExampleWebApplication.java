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
package net.dontdrinkandroot.wicket.example;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import net.dontdrinkandroot.wicket.example.page.CssPage;
import net.dontdrinkandroot.wicket.example.page.GettingStartedPage;
import net.dontdrinkandroot.wicket.example.page.GridPage;
import net.dontdrinkandroot.wicket.example.page.HomePage;
import net.dontdrinkandroot.wicket.example.page.component.*;
import net.dontdrinkandroot.wicket.example.page.form.AjaxFormPage;
import net.dontdrinkandroot.wicket.example.page.form.FormGroupPage;
import net.dontdrinkandroot.wicket.example.page.form.InputGroupPage;
import net.dontdrinkandroot.wicket.example.page.form.ValidationPage;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Component
public class ExampleWebApplication extends WicketBootStandardWebApplication
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Properties buildProperties;

    @Override
    public Class<? extends Page> getHomePage()
    {
        return HomePage.class;
    }

    public static ExampleWebApplication get()
    {
        return (ExampleWebApplication) WebApplication.get();
    }

    @Override
    protected void init()
    {
        super.init();

        this.getJavaScriptLibrarySettings()
                .setJQueryReference(new UrlResourceReference(Url.parse("https://code.jquery.com/jquery-2.2.4.min.js")));

        try {
            this.buildProperties = new Properties();
            this.buildProperties.load(this.getClass().getClassLoader().getResourceAsStream("build.properties"));
        } catch (Exception e) {
            this.logger.warn("Could not load build properties: {}", e.getMessage());
        }

        this.mountPage("css", CssPage.class);
        this.mountPage("grid", GridPage.class);
        this.mountPage("gettingstarted", GettingStartedPage.class);
        this.mountPage("forms/formgroups", FormGroupPage.class);
        this.mountPage("forms/validations", ValidationPage.class);
        this.mountPage("forms/ajax", AjaxFormPage.class);
        this.mountPage("forms/inputgroups", InputGroupPage.class);
        this.mountPage("components/navbars", NavbarPage.class);
        this.mountPage("components/navs", NavPage.class);
        this.mountPage("components/panels", PanelPage.class);
        this.mountPage("components/alerts", AlertPage.class);
        this.mountPage("components/buttons", ButtonPage.class);
        this.mountPage("components/dropdowns", DropdownPage.class);
        this.mountPage("components/labels", BadgePage.class);
        this.mountPage("components/modals", ModalPage.class);
        this.mountPage("components/pagination", PaginationPage.class);
        this.mountPage("components/progressbars", ProgressBarPage.class);
        this.mountPage("components/breadcrumbs", BreadcrumbPage.class);
    }

    public Properties getBuildProperties()
    {
        return this.buildProperties;
    }

    @Override
    public Session newSession(Request request, Response response)
    {
        return new ExampleWebSession(request);
    }
}
