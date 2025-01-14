/**
 * Copyright (C) 2004-2011 Jive Software. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.resource;

import org.jivesoftware.spark.PluginRes;
import org.jivesoftware.spark.util.log.Log;
import org.jivesoftware.sparkimpl.plugin.manager.Enterprise;

import javax.swing.ImageIcon;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import static org.jivesoftware.sparkimpl.plugin.manager.Enterprise.PLUGINS_BLACKLIST_NODE;

public class Default {
    private static final Properties prb;

    private static final Map<String,Object> customMap = new HashMap<>();

    private static final Map<String,ImageIcon> cache = new HashMap<>();

    public static final String MAIN_IMAGE = "MAIN_IMAGE";
    public static final String APPLICATION_NAME = "APPLICATION_NAME";
    public static final String APPLICATION_INFO1 = "APPLICATION_INFO1";
    public static final String APPLICATION_INFO2 = "APPLICATION_INFO2";
    public static final String APPLICATION_INFO3 = "APPLICATION_INFO3";
    public static final String APPLICATION_LICENSE_LINK = "APPLICATION_LICENSE_LINK";
    public static final String APPLICATION_LICENSE_LINK_TXT = "APPLICATION_LICENSE_LINK_TXT";
    public static final String APPLICATION_INFO4 = "APPLICATION_INFO4";
    public static final String APPLICATION_LINK = "APPLICATION_LINK";
    public static final String APPLICATION_LINK_TXT = "APPLICATION_LINK_TXT";
    public static final String DISPLAY_DEV_INFO = "DISPLAY_DEV_INFO";
    public static final String JAVA_VERSION = "JAVA_VERSION";
    public static final String SHORT_NAME = "SHORT_NAME";
    public static final String LOGIN_DIALOG_BACKGROUND_IMAGE = "LOGIN_DIALOG_BACKGROUND_IMAGE";
    public static final String HOST_NAME = "HOST_NAME";
    public static final String HOST_NAME_CHANGE_DISABLED = "HOST_NAME_CHANGE_DISABLED";
    public static final String SHOW_POWERED_BY = "SHOW_POWERED_BY";
    public static final String TOP_BOTTOM_BACKGROUND_IMAGE = "TOP_BOTTOM_BACKGROUND_IMAGE";
    public static final String BRANDED_IMAGE = "BRANDED_IMAGE";
    public static final String DISABLE_UPDATES = "DISABLE_UPDATES";
    public static final String SECONDARY_BACKGROUND_IMAGE = "SECONDARY_BACKGROUND_IMAGE";
    public static final String HOVER_TEXT_COLOR = "HOVER_TEXT_COLOR";
    public static final String TEXT_COLOR = "TEXT_COLOR";
    public static final String TAB_START_COLOR = "TAB_START_COLOR";
    public static final String TAB_END_COLOR = "TAB_END_COLOR";
    public static final String CONTACT_GROUP_START_COLOR = "CONTACT_GROUP_START_COLOR";
    public static final String CONTACT_GROUP_END_COLOR = "CONTACT_GROUP_END_COLOR";
    public static final String PROXY_HOST = "PROXY_HOST";
    public static final String PROXY_PORT = "PROXY_PORT";
    public static final String ACCOUNT_DISABLED = "ACCOUNT_DISABLED";
    public static final String PASSWORD_RESET_ENABLED = "PASSWORD_RESET_ENABLED";
    public static final String PASSWORD_RESET_URL = "PASSWORD_RESET_URL";
    public static final String ADD_CONTACT_DISABLED = "ADD_CONTACT_DISABLED";
    public static final String CHANGE_PASSWORD_DISABLED = "CHANGE_PASSWORD_DISABLED";
    public static final String TRAY_IMAGE = "TRAY_IMAGE";
    public static final String FRAME_IMAGE = "FRAME_IMAGE";
    public static final String LOOK_AND_FEEL_DISABLED = "LOOK_AND_FEEL_DISABLED";
    public static final String DEFAULT_LOOK_AND_FEEL = "DEFAULT_LOOK_AND_FEEL";
    public static final String DEFAULT_LOOK_AND_FEEL_MAC = "DEFAULT_LOOK_AND_FEEL_MAC";
    public static final String INSTALL_PLUGINS_DISABLED = "INSTALL_PLUGINS_DISABLED";
    public static final String UNINSTALL_PLUGINS_DISABLED = "UNINSTALL_PLUGINS_DISABLED";
    public static final String ADVANCED_DISABLED = "ADVANCED_DISABLED";
    public static final String SSO_DISABLED = "SSO_DISABLED";
    public static final String PROXY_DISABLED = "PROXY_DISABLED";
    public static final String PKI_DISABLED = "PKI_DISABLED";
    public static final String CERTIFICATES_MANAGER_DISABLED = "CERTIFICATES_MANAGER_DISABLED";
    public static final String MUTUAL_AUTH_DISABLED = "MUTUAL_AUTH_DISABLED";
    public static final String HELP_USER_GUIDE = "HELP_USER_GUIDE";
    public static final String BROADCAST_IN_CHAT_WINDOW = "BROADCAST_IN_CHAT_WINDOW";
    public static final String FILE_TRANSFER_WARNING_SIZE = "FILE_TRANSFER_WARNING_SIZE";
    public static final String FILE_TRANSFER_MAXIMUM_SIZE = "FILE_TRANSFER_MAXIMUM_SIZE";
    public static final String TABS_PLACEMENT_TOP = "TABS_PLACEMENT_TOP";
    public static final String HIDE_PERSON_SEARCH_FIELD = "HIDE_PERSON_SEARCH_FIELD";
    public static final String USER_DIRECTORY_WINDOWS = "USER_DIRECTORY_WINDOWS";
    public static final String USER_DIRECTORY_LINUX = "USER_DIRECTORY_LINUX";
    public static final String USER_DIRECTORY_MAC = "USER_DIRECTORY_MAC";
    public static final String HISTORY_DISABLED = "HISTORY_DISABLED";
    public static final String HIDE_HISTORY_SETTINGS = "HIDE_HISTORY_SETTINGS";
    public static final String HIDE_SAVE_PASSWORD_AND_AUTO_LOGIN = "HIDE_SAVE_PASSWORD_AND_AUTO_LOGIN";
    public static final String HIDE_LOGIN_AS_INVISIBLE = "HIDE_LOGIN_AS_INVISIBLE";
    public static final String HIDE_LOGIN_ANONYMOUSLY = "HIDE_LOGIN_ANONYMOUSLY";
    public static final String MAINTENANCE_FILE_PATH = "MAINTENANCE_FILE_PATH";
    public static final String HIDE_START_A_CHAT = "HIDE_START_A_CHAT";  
    public static final String ACCEPT_EXPIRED = "ACCEPT_EXPIRED";
    public static final String ACCEPT_NOT_VALID_YET = "ACCEPT_NOT_VALID_YET";
    public static final String ACCEPT_SELF_SIGNED = "ACCEPT_SELF_SIGNED";
    public static final String ACCEPT_REVOKED = "ACCEPT_REVOKED";
    public static final String CHECK_CRL = "CHECK_CRL"; 
    public static final String CHECK_OCSP = "CHECK_OCSP";
    public static final String ALLOW_SOFT_FAIL = "ALLOW_SOFT_FAIL";
    public static final String ALLOW_CLIENT_SIDE_AUTH = "ALLOW_CLIENT_SIDE_AUTH";
    public static final String DISABLE_HOSTNAME_VERIFICATION = "DISABLE_HOSTNAME_VERIFICATION";
    public static final String SECURITY_MODE = "SECURITY_MODE";
    public static final String HOST_AND_PORT_CONFIGURED = "HOST_AND_PORT_CONFIGURED";
    public static final String XMPP_PORT = "XMPP_PORT";
    public static final String USE_HOSTNAME_AS_RESOURCE = "USE_HOSTNAME_AS_RESOURCE";
    public static final String USE_VERSION_AS_RESOURCE = "USE_VERSION_AS_RESOURCE";
    public static final String TIME_OUT = "TIME_OUT";
    public static final String COMPRESSION_ENABLED = "COMPRESSION_ENABLED";
    public static final String DEBUGGER_ENABLED = "DEBUGGER_ENABLED";
    public static final String USE_SSO = "USE_SSO";
    public static final String USE_SASL_GSS_API_SMACK_3_COMPATIBLE = "USE_SASL_GSS_API_SMACK_3_COMPATIBLE";
    public static final String SSO_METHOD = "SSO_METHOD";
    public static final String PROXY_ENABLED = "PROXY_ENABLED";
    public static final String OLD_SSL_ENABLED = "OLD_SSL_ENABLED";
    public static final String FILE_TRANSFER_IBB_ONLY = "FILE_TRANSFER_IBB_ONLY";
    public static final String FILE_TRANSFER_AUTO_ACCEPT_PRESENCE = "FILE_TRANSFER_AUTO_ACCEPT_PRESENCE";
    public static final String CHANGE_COLORS_DISABLED = "CHANGE_COLORS_DISABLED";
    public static final String ADD_CONTACT_GROUP_DISABLED = "ADD_CONTACT_GROUP_DISABLED";
    public static final String DISABLE_AVATAR_TAB = "DISABLE_AVATAR_TAB";
    public static final String DISABLE_BROADCAST_MENU_ITEM = "DISABLE_BROADCAST_MENU_ITEM";
    public static final String DISABLE_EDIT_PROFILE = "DISABLE_EDIT_PROFILE";
    public static final String DISABLE_EXIT = "DISABLE_EXIT";
    public static final String DISABLE_FILE_TRANSFER = "DISABLE_FILE_TRANSFER";
    public static final String DISABLE_MOVE_AND_COPY = "DISABLE_MOVE_AND_COPY";
    public static final String DISABLE_PLUGINS_MENU_ITEM = "DISABLE_PLUGINS_MENU_ITEM";
    public static final String DISABLE_PREFERENCES_MENU_ITEM = "DISABLE_PREFERENCES_MENU_ITEM";
    public static final String DISABLE_PRESENCE_STATUS_CHANGE = "DISABLE_PRESENCE_STATUS_CHANGE";
    public static final String DISABLE_REMOVALS = "DISABLE_REMOVALS";
    public static final String DISABLE_RENAMES = "DISABLE_RENAMES";
    public static final String DISABLE_VIEW_NOTES = "DISABLE_VIEW_NOTES";
    public static final String DISABLE_VIEW_TASK_LIST = "DISABLE_VIEW_TASK_LIST";
    public static final String HELP_FORUM = "HELP_FORUM";
    public static final String HELP_FORUM_DISABLED = "HELP_FORUM_DISABLED";
    public static final String HELP_FORUM_TEXT = "HELP_FORUM_TEXT";
    public static final String HELP_USER_GUIDE_DISABLED = "HELP_USER_GUIDE_DISABLED";
    public static final String PLUGIN_BLACKLIST = "PLUGIN_BLACKLIST";
    public static final String PLUGIN_BLACKLIST_CLASS = "PLUGIN_BLACKLIST_CLASS";
    public static final String PLUGIN_REPOSITORY = "PLUGIN_REPOSITORY";
    public static final String PLUGIN_REPOSITORY_USE_PROXY = "PLUGIN_REPOSITORY_USE_PROXY";
    public static final String PROXY_PROTOCOL = "PROXY_PROTOCOL";
    public static final String IDLE_LOCK = "IDLE_LOCK";
    public static final String IDLE_TIME = "IDLE_TIME";
    public static final String UNFILEDGROUP_DISABLED = "UNFILEDGROUP_DISABLED";
    public static final String ALLOW_NICKNAME_CHANGE_DISABLED = "ALLOW_NICKNAME_CHANGE_DISABLED";
    public static final String CONFERENCE_BUTTON_SETTINGS_DISABLED = "CONFERENCE_BUTTON_SETTINGS_DISABLED";
    public static final String CONFERENCE_BUTTON_REGISTER_DISABLED = "CONFERENCE_BUTTON_REGISTER_DISABLED";
    public static final String SHOW_FULL_JID_ADDRESS = "SHOW_FULL_JID_ADDRESS";
    public static final String EDIT_AVATAR_ONLY = "EDIT_AVATAR_ONLY";
    public static final String DISABLE_LOOKUP_PROFILE = "DISABLE_LOOKUP_PROFILE";

    private static final ClassLoader cl = SparkRes.class.getClassLoader();

    static {
        prb = new Properties();
        try
        {
            InputStream resourceAsStream = cl.getResourceAsStream( "default.properties" );
            prb.load( resourceAsStream );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    public static void putCustomValue(String value, Object object) {
        customMap.put(value, object);
    }

    public static void removeCustomValue(String value) {
        customMap.remove(value);
    }

    public static void clearCustomValues() {
        customMap.clear();
    }

    public static String getString(String propertyName) {
        String pluginString = PluginRes.getDefaultRes(propertyName);
        return pluginString != null ? pluginString : prb.getProperty(propertyName);
    }

    public static boolean getBoolean(String propertyName) {
	return getString(propertyName).replace(" ","").equals("true");
    }

    public static ImageIcon getImageIcon(String imageName) {
        // Check custom map
        Object o = customMap.get(imageName);
        if (o instanceof ImageIcon) {
            return (ImageIcon)o;
        }

        // Otherwise check cache
        o = cache.get(imageName);
        if (o != null) {
            return (ImageIcon)o;
        }

        // Otherwise, load and add to cache.
        try {
            final URL imageURL = getURL(imageName);

            final ImageIcon icon = new ImageIcon(imageURL);
            cache.put(imageName, icon);
            return icon;
        }
        catch (Exception ex) {
            Log.debug(imageName + " not found.");
        }
        return null;
    }

    public static URL getURL(String propertyName) {
    	URL pluginUrl = PluginRes.getDefaultURL(propertyName);
        return pluginUrl != null ? pluginUrl : cl.getResource(getString(propertyName));
    }


    public static URL getURLWithoutException(String propertyName) {
        // Otherwise, load and add to cache.
        try {
            return getURL(propertyName);
        }
        catch (Exception ex) {
            Log.debug(propertyName + " not found.");
        }
        return null;
    }

    /**
     * Returns a Collection of Plugins on the Blacklist<br>
     * Containing the Name and also if specified the entrypoint-class
     * @return Collection
     */
    public static Collection<String> getPluginBlacklist() {
        ArrayList<String> list = new ArrayList<>();

        // Load the blacklist from the (local) configuration.
        String pluginlist = getString(Default.PLUGIN_BLACKLIST).replace(" ", "").toLowerCase();
        StringTokenizer tokenizer = new StringTokenizer(pluginlist, ",");

        while (tokenizer.hasMoreTokens()) {
            final String pluginName = tokenizer.nextToken();
            Log.debug("Local config plugin blacklist: " + pluginName);
            list.add(pluginName);
        }

        StringTokenizer clazztokenz = new StringTokenizer(
            getString(Default.PLUGIN_BLACKLIST_CLASS).replace(" ", ""), ",");

        while (clazztokenz.hasMoreTokens()) {
            final String pluginClass = clazztokenz.nextToken();
            Log.debug("Local config plugin blacklist: " + pluginClass);
            list.add(pluginClass);
        }

        // Load the blacklist from Openfire's clientControl plugin
        for( final String entry : Enterprise.getItemsForNode(PLUGINS_BLACKLIST_NODE) ) {
            final String normalized = entry.toLowerCase();
            Log.debug("Server-dictated plugin blacklist: " + normalized);
            if (!list.contains(normalized)) {
                list.add(normalized);
            }
        }

        return list;
    }

    /**
     * Returns all Keys stored in the default.properties file
     * @return {@link Enumeration}<{@link String}>
     */
    public static Enumeration<String> getAllKeys()
    {
        return (Enumeration<String>) prb.propertyNames();
    }

}
