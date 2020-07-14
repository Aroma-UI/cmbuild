/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.crossmobile.plugin;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.settings.Settings;
import org.crossmobile.build.utils.DependencyDigger;
import org.crossmobile.plugin.actions.PluginAssembler;
import org.crossmobile.plugin.reg.Registry;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.SystemDependent;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;

import static org.crossmobile.utils.FileUtils.toURL;

@Mojo(name = "package", defaultPhase = LifecyclePhase.PACKAGE)
public class PackageMojo extends GenericPluginMojo {

    @Override
    public void exec(Registry reg) {
        skipIos |= !SystemDependent.canMakeIos();
        skipUwp |= !SystemDependent.canMakeUwp();
        if (skipDesktop && skipIos && skipAndroid && skipUwp) {
            Log.info("Skipping all targets");
            return;
        }
        // Append classpaths - maybe should be done otherwise?
        DependencyItem root = getRootDependency(true);
        getPluginDescriptor().getClassRealm().addURL(FileUtils.toURL(new File(getProject().getBuild().getOutputDirectory())));
        for (DependencyItem dep : root.getCompiletimeDependencies(true))
            getPluginDescriptor().getClassRealm().addURL(toURL(dep.getFile()));

        PluginAssembler.packageFiles(reg, new File(getProject().getBuild().getDirectory()), new File(getProject().getBuild().getSourceDirectory()),
                !skipDesktop, !skipIos, !skipAndroid, !skipUwp, !skipRvm
        );
    }
}
