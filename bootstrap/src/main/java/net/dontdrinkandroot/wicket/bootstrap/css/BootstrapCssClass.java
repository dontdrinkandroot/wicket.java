package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum BootstrapCssClass implements CssClass {

	ACTIVE("active"),
	ADD_ON("add-on"),
	ALERT("alert"),
	ALERT_BLOCK("alert-block"),
	ALERT_ERROR("alert-error"),
	ALERT_INFO("alert-info"),
	ALERT_HEADING("alert-heading"),
	ALERT_SUCCESS("alert-success"),
	BADGE("badge"),
	BADGE_SUCCESS("badge-success"),
	BADGE_WARNING("badge-warning"),
	BADGE_IMPORTANT("badge-important"),
	BADGE_INFO("badge-info"),
	BADGE_INVERSE("badge-inverse"),
	BRAND("brand"),
	BREADCRUMB("breadcrumb"),
	BTN("btn"),
	BTN_GROUP("btn-group"),
	BTN_NAVBAR("btn-navbar"),
	BTN_TOOLBAR("btn-toolbar"),
	CARET("caret"),
	CHECKBOX("checkbox"),
	CLOSE("close"),
	CONTAINER("container"),
	CONTAINER_FLUID("container-fluid"),
	CONTROLS("controls"),
	CONTROL_GROUP("control-group"),
	CONTROL_LABEL("control-label"),
	DISABLED("disabled"),
	DIVIDER("divider"),
	DIVIDER_VERTICAL("divider-vertial"),
	DROPDOWN("dropdown"),
	DROPDOWN_MENU("dropdown-menu"),
	DROPDOWN_SUBMENU("dropdown-submenu"),
	DROPDOWN_TOGGLE("dropdown-toggle"),
	DROPUP("dropup"),
	ERROR("error"),
	FADE("fade"),
	FORM_HORIZONTAL("form-horizontal"),
	FORM_INLINE("form-inline"),
	FORM_SEARCH("form-search"),
	FORM_VERTICAL("form-vertical"),
	HELP_INLINE("help-inline"),
	HELP_BLOCK("help-block"),
	HERO_UNIT("hero-unit"),
	ICON_WHITE("icon-white"),
	IMG_CIRCLE("img-circle"),
	IMG_POLAROID("img-polaroid"),
	IMG_ROUNDED("img-rounded"),
	INFO("info"),
	INITIALISM("initialism"),
	INLINE("inline"),
	INPUT_APPEND("input-append"),
	INPUT_MINI("input-mini"),
	INPUT_PREPEND("input-prepend"),
	INPUT_SMALL("input-small"),
	INPUT_MEDIUM("input-medium"),
	INPUT_LARGE("input-large"),
	INPUT_XLARGE("input-xlarge"),
	INPUT_XXLARGE("input-xxlarge"),
	LABEL("label"),
	LEAD("lead"),
	MUTED("muted"),
	NAV("nav"),
	NAV_COLLAPSE("nav-collapse"),
	NAV_HEADER("nav-header"),
	NAV_LIST("nav-list"),
	NAV_PILLS("nav-pills"),
	NAV_STACKED("nav-stacked"),
	NAV_TABS("nav-tabs"),
	NAVBAR("navbar"),
	NAVBAR_CONTAINER("navbar-container"),
	NAVBAR_FORM("navbar-form"),
	NAVBAR_INNER("navbar-inner"),
	NAVBAR_FIXED_BOTTOM("navbar-fixed-bottom"),
	NAVBAR_FIXED_TOP("navbar-fixed-top"),
	NAVBAR_SEARCH("navbar-search"),
	NAVBAR_TEXT("navbar-text"),
	NEXT("next"),
	OFFSET_1("offset1"),
	OFFSET_2("offset2"),
	OFFSET_3("offset3"),
	OFFSET_4("offset4"),
	OFFSET_5("offset5"),
	OFFSET_6("offset6"),
	OFFSET_7("offset7"),
	OFFSET_8("offset8"),
	OFFSET_9("offset9"),
	OFFSET_10("offset10"),
	OFFSET_11("offset11"),
	OFFSET_12("offset12"),
	PAGINATION("pagination"),
	PAGE_HEADER("page-header"),
	PAGER("pager"),
	PREVIOUS("previous"),
	PROGRESS("progress"),
	PULL_LEFT("pull-left"),
	PULL_RIGHT("pull-right"),
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
	TEXT_ERROR("text-error"),
	TEXT_INFO("text-info"),
	TEXT_SUCCESS("text-success"),
	TEXT_WARNING("text-warning"),
	THUMBNAIL("thumbnail"),
	THUMBNAILS("thumbnails"),
	UNEDITABLE_INPUT("uneditable-input"),
	UNSTYLED("unstyled"),
	WARNING("warning"),
	WELL("well"),
	BTN_BLOCK("btn-block");

	private String classString;


	private BootstrapCssClass(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}

}
