/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
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


public enum BootstrapCssClass implements CssClass
{

	/* Unchecked Classes */

	ADD_ON("add-on"),
	BADGE("badge"),
	BRAND("brand"),
	BREADCRUMB("breadcrumb"),
	BTN_TOOLBAR("btn-toolbar"),
	CARET("caret"),
	CHECKBOX("checkbox"),
	CLOSE("close"),
	CONTAINER("container"),
	CONTAINER_FLUID("container-fluid"),
	CONTROLS("controls"),
	DROPDOWN_SUBMENU("dropdown-submenu"),
	DROPUP("dropup"),
	ERROR("error"),
	FORM_SEARCH("form-search"),
	FORM_VERTICAL("form-vertical"),
	HELP_INLINE("help-inline"),
	HELP_BLOCK("help-block"),
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
	NAV_PILLS("nav-pills"),
	NAV_STACKED("nav-stacked"),
	NAV_TABS("nav-tabs"),
	NAVBAR_CONTAINER("navbar-container"),
	NAVBAR_INNER("navbar-inner"),
	NAVBAR_FIXED_BOTTOM("navbar-fixed-bottom"),
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
	TABLE_BORDERED("table-bordered"),
	TABLE_CONDENSED("table-condensed"),
	TABLE_STRIPED("table-striped"),
	TABS_BELOW("tabs-below"),
	TABS_LEFT("tabs-left"),
	TABS_RIGHT("tabs-right"),
	UNEDITABLE_INPUT("uneditable-input"),
	UNSTYLED("unstyled"),
	WARNING("warning"),
	WELL("well"),
	CLEARFIX("clearfix"),
	HAS_FEEDBACK("has-feedback"),
	INPUT_GROUP_ADDON("input-group-addon"),
	INPUT_GROUP_BTN("input-group-btn"),
	MODAL_BODY("modal-body"),
	MODAL_FOOTER("modal-footer"),
	IMG_RESPONSIVE("img-responsive"),
	IMG_THUMBNAIL("img-thumbnail"),

	/* Used classes */

	ACTIVE("active"),
	ALERT("alert"),
	BLOCKQUOTE_REVERSE("blockquote-reverse"),
	BTN("btn"),
	BTN_BLOCK("btn-block"),
	BTN_GROUP("btn-group"),
	CONTROL_LABEL("control-label"),
	DISABLED("disabled"),
	DIVIDER("divider"),
	DROPDOWN("dropdown"),
	DROPDOWN_HEADER("dropdown-header"),
	DROPDOWN_MENU("dropdown-menu"),
	DROPDOWN_TOGGLE("dropdown-toggle"),
	FADE("fade"),
	FORM_GROUP("form-group"),
	FORM_HORIZONTAL("form-horizontal"),
	FORM_INLINE("form-inline"),
	INITIALISM("initialism"),
	INPUT_GROUP("input-group"),
	LABEL("label"),
	LIST_GROUP("list-group"),
	LIST_GROUP_ITEM("list-group-item"),
	LIST_INLINE("list-inline"),
	LIST_UNSTYLED("list-unstyled"),
	LEAD("lead"),
	MODAL("modal"),
	MODAL_TITLE("modal-title"),
	NAVBAR("navbar"),
	NAVBAR_BTN("navbar-btn"),
	NAVBAR_FORM("navbar-form"),
	NAVBAR_LEFT("navbar-left"),
	NAVBAR_FIXED_TOP("navbar-fixed-top"),
	NAVBAR_RIGHT("navbar-right"),
	NAVBAR_TEXT("navbar-text"),
	PAGINATION("pagination"),
	PANEL("panel"),
	PANEL_BODY("panel-body"),
	PANEL_FOOTER("panel-footer"),
	PANEL_HEADING("panel-heading"),
	PANEL_TITLE("panel-title"),
	PULL_RIGHT("pull-right"),
	PROGRESS("progress"),
	PROGRESS_STRIPED("progress-striped"),
	PULL_LEFT("pull-left"),
	SR_ONLY("sr-only"),
	THUMBNAIL("thumbnail"),
	THUMBNAILS("thumbnails");

	private String classString;


	private BootstrapCssClass(String classString)
	{
		this.classString = classString;
	}

	@Override
	public String getClassString()
	{
		return this.classString;
	}

}
