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
package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public enum BootstrapCssClass implements CssClass
{
    /* Unchecked Classes */

    ADD_ON("add-on"),
    BRAND("brand"),
    CHECKBOX("checkbox"),
    CLOSE("close"),
    CONTROLS("controls"),
    ERROR("error"),
    FORM_SEARCH("form-search"),
    FORM_VERTICAL("form-vertical"),
    HELP_INLINE("help-inline"),
    HERO_UNIT("hero-unit"),
    HIDE("hide"),
    ICON_WHITE("icon-white"),
    IMG_CIRCLE("img-circle"),
    IMG_ROUNDED("img-rounded"),
    INFO("info"),
    INLINE("inline"),
    INPUT_APPEND("input-append"),
    INPUT_PREPEND("input-prepend"),
    MUTED("muted"),
    NAV("nav"),
    NAV_COLLAPSE("nav-collapse"),
    NAV_HEADER("nav-header"),
    NAV_LIST("nav-list"),
    NAV_STACKED("nav-stacked"),
    NAVBAR_CONTAINER("navbar-container"),
    NAVBAR_INNER("navbar-inner"),
    NAVBAR_SEARCH("navbar-search"),
    NEXT("next"),
    PAGE_HEADER("page-header"),
    PAGER("pager"),
    PREVIOUS("previous"),
    RADIO("radio"),
    ROW("row"),
    ROW_FLUID("row-fluid"),
    SEARCH_QUERY("search-query"),
    SUCCESS("success"),
    TAB_CONTENT("tab-content"),
    TAB_PANE("tab-pane"),
    TABABBLE("tababble"),
    TABLE("table"),
    TABS_BELOW("tabs-below"),
    TABS_LEFT("tabs-left"),
    TABS_RIGHT("tabs-right"),
    UNEDITABLE_INPUT("uneditable-input"),
    UNSTYLED("unstyled"),
    WARNING("warning"),
    WELL("well"),
    HAS_FEEDBACK("has-feedback"),
    INPUT_GROUP_ADDON("input-group-addon"),
    INPUT_GROUP_BTN("input-group-btn"),
    MODAL_BODY("modal-body"),
    IMG_RESPONSIVE("img-responsive"),
    IMG_THUMBNAIL("img-thumbnail"),

    /* Used classes */

    ACTIVE("active"),
    ALERT("alert"),
    BADGE("badge"),
    BLOCKQUOTE_REVERSE("blockquote-reverse"),
    BREADCRUMB("breadcrumb"),
    BREADCRUMB_ITEM("breadcrumb-item"),
    BTN("btn"),
    BTN_BLOCK("btn-block"),
    BTN_GROUP("btn-group"),
    BTN_TOOLBAR("btn-toolbar"),
    CARET("caret"),
    CLEARFIX("clearfix"),
    COLLAPSED("collapsed"),
    CONTROL_LABEL("control-label"),
    DISABLED("disabled"),
    DROPDOWN("dropdown"),
    DROPDOWN_DIVIDER("dropdown-divider"),
    DROPDOWN_HEADER("dropdown-header"),
    DROPDOWN_ITEM("dropdown-item"),
    DROPDOWN_MENU("dropdown-menu"),
    DROPDOWN_TOGGLE("dropdown-toggle"),
    DROPUP("dropup"),
    FADE("fade"),
    FORM_GROUP("form-group"),
    FORM_HORIZONTAL("form-horizontal"),
    FORM_INLINE("form-inline"),
    HELP_BLOCK("help-block"),
    INITIALISM("initialism"),
    INPUT_GROUP("input-group"),
    LIST_GROUP("list-group"),
    LIST_GROUP_ITEM("list-group-item"),
    LIST_INLINE("list-inline"),
    LIST_UNSTYLED("list-unstyled"),
    LEAD("lead"),
    MODAL("modal"),
    MODAL_FOOTER("modal-footer"),
    MODAL_TITLE("modal-title"),
    NAV_ITEM("nav-item"),
    NAV_LINK("nav-link"),
    NAVBAR("navbar"),
    NAVBAR_BTN("navbar-btn"),
    NAVBAR_FORM("navbar-form"),
    NAV_JUSTIFIED("nav-justified"),
    NAVBAR_NAV("navbar-nav"),
    NAVBAR_TEXT("navbar-text"),
    NAVBAR_TOGGLER("navbar-toggler"),
    NAVBAR_TOGGLER_ICON("navbar-toggler-icon"),
    PAGE_ITEM("page-item"),
    PAGE_LINK("page-link"),
    PAGINATION("pagination"),
    PANEL("panel"),
    PANEL_BODY("panel-body"),
    PANEL_FOOTER("panel-footer"),
    PANEL_HEADING("panel-heading"),
    PANEL_TITLE("panel-title"),
    PULL_RIGHT("pull-right"),
    PROGRESS("progress"),
    PROGRESS_BAR_ANIMATED("progress-bar-animated"),
    PROGRESS_BAR_STRIPED("progress-bar-striped"),
    PULL_LEFT("pull-left"),
    SR_ONLY("sr-only"),
    THUMBNAIL("thumbnail"),
    THUMBNAILS("thumbnails");

    private String classString;

    BootstrapCssClass(String classString)
    {
        this.classString = classString;
    }

    @Override
    public String getClassString()
    {
        return this.classString;
    }
}
