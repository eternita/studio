/*
 * Copyright (c) 2013-2014, Neuro4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neuro4j.studio.core.buildpath;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.frameworkadmin.BundleInfo;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.service.resolver.VersionRange;
import org.neuro4j.studio.core.Neuro4jCore;
import org.neuro4j.studio.core.Neuro4jCorePlugin;
import org.osgi.framework.Version;

/**
 *
 *
 */
public class BuildPathSupport {
    public static final Neuro4jStudioCorePluginDescription NEURO4j_CORE_PLUGIN = new Neuro4jStudioCorePluginDescription(
            "org.neuro4j.studio.workflow", new VersionRange("[1.0.0,1.0.8)"), "neuro4j-workflow-core.jar", "neuro4j-workflow-core.jar", "org.neuro4j.workflow.source", "source-bundle/", "org.neuro4j.workflow.javadoclocation");

    public static final Neuro4jStudioCorePluginDescription NEURO4j_WORKFLOW_COMMON_PLUGIN = new Neuro4jStudioCorePluginDescription(
            "org.neuro4j.studio.workflow", new VersionRange("[1.0.0,1.0.8)"), "neuro4j-workflow-common.jar", "neuro4j-workflow-common.jar", "org.neuro4j.workflow.core.source", "source-bundle/", "org.neuro4j.workflow.common.javadoclocation");

    public static IClasspathEntry getNeuro4j1ClasspathEntry()
    {
        return JavaCore.newContainerEntry(Neuro4jCore.NEURO4J_CONTAINER_PATH);
    }

    public static IClasspathEntry getNeuro4jCoreLibraryEntry()
    {
        return NEURO4j_CORE_PLUGIN.getLibraryEntry("org.neuro4j.workflow");
    }

    public static IClasspathEntry getNeuro4jLogicLibraryEntry()
    {
        return NEURO4j_WORKFLOW_COMMON_PLUGIN.getLibraryEntry("org.neuro4j.workflow.common");
    }

    public static class Neuro4jStudioCorePluginDescription
    {
        private final String bundleId;
        private final VersionRange versionRange;
        private final String bundleRoot;
        private final String binaryImportedRoot;
        private final String sourceBundleId;
        private final String repositorySource;
        private final String javadocPreferenceKey;

        public Neuro4jStudioCorePluginDescription(String bundleId, VersionRange versionRange, String bundleRoot, String binaryImportedRoot, String sourceBundleId, String repositorySource, String javadocPreferenceKey)
        {
            this.bundleId = bundleId;
            this.versionRange = versionRange;
            this.bundleRoot = bundleRoot;
            this.binaryImportedRoot = binaryImportedRoot;
            this.sourceBundleId = sourceBundleId;
            this.repositorySource = repositorySource;
            this.javadocPreferenceKey = javadocPreferenceKey;
        }

        public IPath getBundleLocation() {
            return P2Utils.getBundleLocationPath(P2Utils.findBundle(this.bundleId, this.versionRange, false));
        }

        public IPath getSourceBundleLocation() {
            return getSourceLocation(P2Utils.findBundle(this.bundleId, this.versionRange, false));
        }

        public IClasspathEntry getLibraryEntry(String name) {
            BundleInfo bundleInfo = P2Utils.findBundle(this.bundleId, this.versionRange, false);
            IPath bundleLocation = P2Utils.getBundleLocationPath(bundleInfo);
            if (bundleLocation != null)
            {
                IPath bundleRootLocation = getLibraryLocation(bundleInfo, bundleLocation);
                IPath srcLocation = getSourceLocation(bundleInfo);

                IAccessRule[] accessRules = new IAccessRule[0];

                String javadocLocation = Platform.getPreferencesService().getString(name, this.javadocPreferenceKey, "", null);
                IClasspathAttribute[] attributes;
                if (javadocLocation.length() == 0)
                    attributes = new IClasspathAttribute[0];
                else {
                    attributes = new IClasspathAttribute[] { JavaCore.newClasspathAttribute("javadoc_location", javadocLocation) };
                }

                return JavaCore.newLibraryEntry(bundleRootLocation, srcLocation, null, accessRules, attributes, false);
            }
            return null;
        }

        private IPath getLibraryLocation(BundleInfo bundleInfo, IPath bundleLocation) {
            IPath bundleRootLocation = null;

            if (this.bundleRoot != null) {
                bundleRootLocation = getLocationIfExists(bundleInfo, this.bundleRoot);
            }
            if ((bundleRootLocation == null) && (this.binaryImportedRoot != null)) {
                bundleRootLocation = getLocationIfExists(bundleInfo, this.binaryImportedRoot);
            }
            if (bundleRootLocation == null)
                bundleRootLocation = bundleLocation;
            return bundleRootLocation;
        }

        private IPath getSourceLocation(BundleInfo bundleInfo) {
            IPath srcLocation = null;
            if (this.repositorySource != null)
            {
                srcLocation = getLocationIfExists(bundleInfo, this.repositorySource);
            }

            if (srcLocation == null)
            {
                BundleInfo sourceBundleInfo = P2Utils.findBundle(this.sourceBundleId, new Version(bundleInfo.getVersion()), true);
                if (sourceBundleInfo == null)
                {
                    sourceBundleInfo = P2Utils.findBundle(this.sourceBundleId, this.versionRange, true);
                }
                srcLocation = P2Utils.getBundleLocationPath(sourceBundleInfo);
            }
            return srcLocation;
        }

        private IPath getLocationIfExists(BundleInfo bundleInfo, String entryInBundle) {
            IPath srcLocation = null;
            IPath bundleLocationPath = P2Utils.getBundleLocationPath(bundleInfo);
            if (bundleLocationPath != null) {
                File bundleFile = bundleLocationPath.toFile();
                if (bundleFile.isDirectory()) {
                    File srcFile = null;
                    int starIdx = entryInBundle.indexOf('*');
                    if (starIdx != -1) {
                        File[] files = bundleFile.listFiles(new BuildPathSupportLocal(this, entryInBundle, starIdx));

                        if (files.length > 0) {
                            srcFile = files[0];
                        }
                    }
                    if (srcFile == null)
                        srcFile = new File(bundleFile, entryInBundle);
                    if (srcFile.exists()) {
                        srcLocation = new Path(srcFile.getPath());
                        if (srcFile.isDirectory()) {
                            srcLocation = srcLocation.addTrailingSeparator();
                        }
                    }
                }
            }
            return srcLocation;
        }
    }

}
