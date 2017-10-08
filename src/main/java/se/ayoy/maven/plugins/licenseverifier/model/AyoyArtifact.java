package se.ayoy.maven.plugins.licenseverifier.model;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.License;

import java.util.ArrayList;
import java.util.List;

public class AyoyArtifact {

    private final Artifact artifact;

    private final ArrayList<License> licenses;

    public AyoyArtifact(Artifact artifact) {
        this.artifact = artifact;
        this.licenses = new ArrayList<License>();
    }

    public void addLicenses(List<License> licenses) {
        if (licenses == null) {
            return;
        }

        this.licenses.addAll(licenses);
    }

    public List<License> getLicenses() {
        return new ArrayList<License>(this.licenses);
    }

    public Artifact getArtifact() {
        return this.artifact;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();

        toReturn.append("artifact " );
        toReturn.append(this.artifact);
        toReturn.append(" with licenses: ");

        boolean firstLic = true;
        for (License license : this.licenses) {
            if (!firstLic) {
                toReturn.append(", ");
            }

            firstLic = false;
            toReturn.append(license);
        }

        return toReturn.toString();
    }
}
