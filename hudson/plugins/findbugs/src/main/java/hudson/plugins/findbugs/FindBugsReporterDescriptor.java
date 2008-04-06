package hudson.plugins.findbugs;

import hudson.maven.MavenReporter;
import hudson.maven.MavenReporterDescriptor;

import org.kohsuke.stapler.StaplerRequest;

/**
 * Descriptor for the class {@link FindBugsReporter}. Used as a singleton. The
 * class is marked as public so that it can be accessed from views.
 *
 * @author Ulli Hafner
 */
public class FindBugsReporterDescriptor extends MavenReporterDescriptor {
    /**
     * Creates a new instance of <code>FindBugsReporterDescriptor</code>.
     */
    public FindBugsReporterDescriptor() {
        super(FindBugsReporter.class);
    }

    /** {@inheritDoc} */
    @Override
    public String getDisplayName() {
        return Messages.FindBugs_Publisher_Name();
    }

    /** {@inheritDoc} */
    @Override
    public String getConfigPage() {
        return getViewPage(FindBugsPublisher.class, "config.jelly");
    }

    /** {@inheritDoc} */
    @Override
    public String getHelpFile() {
        return "/plugin/" + FindBugsDescriptor.PLUGIN_NAME + "/help.html";
    }

    /** {@inheritDoc} */
    @Override
    public MavenReporter newInstance(final StaplerRequest request) throws FormException {
        return request.bindParameters(FindBugsReporter.class, FindBugsDescriptor.PLUGIN_NAME + "_");
    }
}
