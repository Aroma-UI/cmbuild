/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.crossmobile.plugin.reg;

import org.apache.maven.project.MavenProject;
import org.crossmobile.Version;
import org.crossmobile.utils.PluginMetaData;

import java.io.File;

import static org.crossmobile.plugin.reg.PluginRegistryFile.RegistryType.*;
import static org.crossmobile.utils.PluginMetaData.CURRENT_PLUGIN_REGISTRY;

public final class PluginRegistryFile {

    public final RegistryType type;
    public final File file;

    public static PluginRegistryFile forPlugin(MavenProject project) {
        return new PluginRegistryFile(project.getGroupId().equals(Version.GROUPID) && project.getArtifactId().equals(Version.ARTIFACTID) ? core : user, project);
    }

    public static PluginRegistryFile forTheme(MavenProject project) {
        return new PluginRegistryFile(theme, project);
    }

    private PluginRegistryFile(RegistryType type, MavenProject project) {
        this.type = type;
        this.file = new File(project.getBuild().getOutputDirectory(), CURRENT_PLUGIN_REGISTRY);
    }

    public enum RegistryType {
        core, user, theme
    }
}
