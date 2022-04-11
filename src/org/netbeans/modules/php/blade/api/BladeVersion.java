package org.netbeans.modules.php.blade.api;

import java.time.LocalDate;
import org.openide.util.NbBundle;

/**
 * Illuminate/View versioning
 *
 * @author bhaidu
 */
@NbBundle.Messages({
    "BladeVersion.IVIEW_4=4.1/4.2",
    "BladeVersion.IVIEW_5=5.1/5.8",
    "BladeVersion.IVIEW_9=9.*",})
public enum BladeVersion {
    /**
     * ILLUMINATE / VIEW 4.1/4.2
     */
    IVIEW_4(Bundle.BladeVersion_IVIEW_4()),
    IVIEW_5(Bundle.BladeVersion_IVIEW_5()),
    IVIEW_9(Bundle.BladeVersion_IVIEW_9());

    private final String displayName;

    private BladeVersion(String displayName) {
        assert displayName != null;
        this.displayName = displayName;
    }

    /**
     * Always return the latest PHP version.
     *
     * @return the latest PHP version
     */
    public static BladeVersion getDefault() {
        BladeVersion[] phpVersions = BladeVersion.values();
        return phpVersions[phpVersions.length - 1];
    }

    /**
     * Return legacy PHP version, the one before the latest one.
     * <p>
     * This usually means the oldest yet supported PHP version.
     *
     * @return the legacy PHP version
     * @since 2.41
     */
    public static BladeVersion getLegacy() {
        BladeVersion[] phpVersions = BladeVersion.values();
        for (BladeVersion phpVersion : phpVersions) {
            if (phpVersion.isSupportedVersion()) {
                return phpVersion;
            }
        }
        return phpVersions[phpVersions.length - 2];
    }

    /**
     * Get display name of this version.
     *
     * @return display name of this version
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * ADAPT BLADE VERSION TO DIFFERENT CHANGES
     */
    public boolean hasPropertyTypes() {
        return this.compareTo(BladeVersion.IVIEW_9) >= 0;
    }

    /**
     * Check whether this is supported version yet by PHP official.
     *
     * @return {@code true} if this is supported version, {@code false}
     * otherwise
     * @since 2.72
     */
    public boolean isSupportedVersion() {
        return Period.valueOf(name()).isSupportedVersion();
    }

    @Override
    public String toString() {
        return getDisplayName();
    }

    /**
     * not sure if necessary https://github.com/illuminate/view/branches/all
     */
    private enum Period {
        IVIEW_4(LocalDate.of(2013, 10, 16), LocalDate.of(2015, 1, 6), LocalDate.of(2015, 1, 6)),
        IVIEW_5(LocalDate.of(2015, 6, 30), LocalDate.of(2019, 8, 14), LocalDate.of(2019, 8, 14)),;

        private final LocalDate initialRelease;
        private final LocalDate activeSupport;
        private final LocalDate securitySupport;

        private Period(LocalDate initialRelease, LocalDate activeSupport, LocalDate securitySupport) {
            this.initialRelease = initialRelease;
            this.activeSupport = activeSupport;
            this.securitySupport = securitySupport;
        }

        public LocalDate getInitialRelease() {
            return initialRelease;
        }

        public LocalDate getActiveSupport() {
            return activeSupport;
        }

        public LocalDate getSecuritySupport() {
            return securitySupport;
        }

        public boolean isSupportedVersion() {
            return LocalDate.now().isBefore(securitySupport);
        }

    }
}
