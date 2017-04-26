package org.onosproject.net;

import java.util.Objects;

/**
 * Created by optical on 2/28/17.
 */
public final class VnoId extends ElementId {

    /**
     * Represents either no VNO, or an unspecified VNO.
     */
    public static final VnoId NONE = new VnoId(-1);

    private final int id;

    // Public construction is prohibited
    private VnoId(int id) {
        this.id = id;
    }

    // Default constructor for serialization
    private VnoId() {
        this.id = -1;
    }

    /**
     * Returns the VNO ID.
     *
     * @return VNO ID
     */
    public long id() {
        return id;
    }

    /**
     * Creates a vno id.
     *
     * @param id    the vno id
     * @return vno identifier
     */
    public static VnoId vnoId(int id) {
        return new VnoId(id);
    }

    public String toString() {
        return Integer.toString(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VnoId) {
            final VnoId other = (VnoId) obj;
            return Objects.equals(this.id, other.id);
        }
        return false;
    }
}
