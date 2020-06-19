/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.crossmobile.build.utils;

import java.io.File;

import static org.crossmobile.bridge.system.LauncherCommons.CROSSMOBILE_PROPERTIES;
import static org.crossmobile.bridge.system.MaterialsCommon.MATERIALS_TAG;

public class Config {

    //Xcode Build dirs
    public final static String XCODE_BASE = "xcode";
    public final static String XCODE_EXT_APP = "application";
    public final static String XCODE_EXT_MAT = MATERIALS_TAG;
    public final static String XCODE_EXT_INC = "plugins" + File.separator + "include";
    public final static String XCODE_EXT_LIB = "plugins" + File.separator + "lib";
    public final static String XCODE_EXT_PLIST = "plists";
    //General
    public final static String PROJECT_CACHES = "cache";
    public final static String CLASSES = "classes";
    public final static String GENERATED_CMSOURCES = "generated-sources" + File.separator + "main";
    public final static String APP = CLASSES + File.separator + "org" + File.separator + "crossmobile" + File.separator + MATERIALS_TAG + File.separator + "app";
    public final static String SYS = CLASSES + File.separator + "org" + File.separator + "crossmobile" + File.separator + MATERIALS_TAG + File.separator + "sys";
    public final static String PLUGIN_LAUNCHER = "org" + File.separator + "crossmobile" + File.separator + "sys" + File.separator + "PluginsLauncherList.java";
    public final static String IBOBJECTS = "org" + File.separator + "crossmobile" + File.separator + "sys" + File.separator + "IBObjects.java";
    //ANDROID APP
    public final static String ANDROID_APP = "app";
    public final static String ANDROID_MANIFEST = ANDROID_APP + File.separator + "AndroidManifest.xml";
    public final static String ANDROID_ASSET = ANDROID_APP + File.separator + "asset";
    public final static String ANDROID_RES = ANDROID_APP + File.separator + "res";
    public final static String ANDROID_PROP = ANDROID_ASSET + File.separator + CROSSMOBILE_PROPERTIES;
    public final static String ANDROID_PLIST = ANDROID_ASSET + File.separator + "Info.plist";
    public final static String ANDROID_FONTLIST = ANDROID_RES + File.separator + "xml" + File.separator + "fontlist.xml";
    public final static String ANDROID_BASEPATH = ANDROID_RES + File.separator + "xml" + File.separator + "base_path.xml";
    public final static String GRADLE = "build.gradle";
    public final static String GRADLE_PROPERTIES = "gradle.properties";

    public final static String CROSSMOBILE_GRADLE = ANDROID_APP + File.separator + "crossmobile.gradle";
    public final static String ANDROID_GENERATED_CMSOURCES = ANDROID_APP + File.separator + "gen" + File.separator + "main";
}
