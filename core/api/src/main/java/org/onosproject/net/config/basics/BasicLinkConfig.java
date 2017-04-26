/*
 * Copyright 2015 Open Networking Laboratory
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
package org.onosproject.net.config.basics;

import com.fasterxml.jackson.databind.JsonNode;
import org.onosproject.net.Link;
import org.onosproject.net.LinkKey;
import org.onosproject.net.VnoId;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static org.onosproject.net.config.Config.FieldPresence.OPTIONAL;

/**
 * Basic configuration for network infrastructure link.
 */
public final class BasicLinkConfig extends AllowedEntityConfig<LinkKey> {

    public static final String TYPE = "type";
    public static final String METRIC = "metric";
    public static final String LATENCY = "latency";
    public static final String BANDWIDTH = "bandwidth";
    public static final String IS_DURABLE = "durable";
    public static final String VNO_IDS = "vno-ids";

    @Override
    public boolean isValid() {
        return hasOnlyFields(ALLOWED, TYPE, METRIC, LATENCY, BANDWIDTH, IS_DURABLE, VNO_IDS) &&
                isBoolean(ALLOWED, OPTIONAL) && isNumber(METRIC, OPTIONAL) &&
                isNumber(LATENCY, OPTIONAL) && isNumber(BANDWIDTH, OPTIONAL);
    }

    /**
     * Returns the link type.
     *
     * @return link type override
     */
    public Link.Type type() {
        return get(TYPE, Link.Type.DIRECT, Link.Type.class);
    }

    /**
     * Sets the link type.
     *
     * @param type link type override
     * @return self
     */
    public BasicLinkConfig type(Link.Type type) {
        return (BasicLinkConfig) setOrClear(TYPE, type);
    }

    /**
     * Mapper function for vnoId.
     */
    Function<String, VnoId> vnoIdMapper = (i)->VnoId.vnoId(Integer.parseInt(i));

    /**
     * Returns the ids of VNOs this link "belongs to".
     * @return list of VNO identifiers
     */
    public List<VnoId> vnoIds() {
        return getList(VNO_IDS, vnoIdMapper);
    }

    /**
     * Sets the VNO ids for link.
     * @param vnoIds list of vno ids
     * @return self
     */
    public BasicLinkConfig vnoIds(List<VnoId> vnoIds) {
        return (BasicLinkConfig)  setOrClear(VNO_IDS, vnoIds);
    }

    /**
     * Returns link metric value for use by
     * {@link org.onosproject.net.topology.MetricLinkWeight} function.
     *
     * @return link metric; -1 if not set
     */
    public double metric() {
        return get(METRIC, -1);
    }

    /**
     * Sets the link metric for use by
     * {@link org.onosproject.net.topology.MetricLinkWeight} function.
     *
     * @param metric new metric; null to clear
     * @return self
     */
    public BasicLinkConfig metric(Double metric) {
        return (BasicLinkConfig) setOrClear(METRIC, metric);
    }

    /**
     * Returns link latency in terms of nanos.
     *
     * @return link latency; -1 if not set
     */
    public Duration latency() {
        return Duration.ofNanos(get(LATENCY, -1));
    }

    /**
     * Sets the link latency.
     *
     * @param latency new latency; null to clear
     * @return self
     */
    public BasicLinkConfig latency(Duration latency) {
        Long nanos = latency == null ? null : latency.toNanos();
        return (BasicLinkConfig) setOrClear(LATENCY, nanos);
    }

    /**
     * Returns link bandwidth in terms of Mbps.
     *
     * @return link bandwidth; -1 if not set
     */
    public long bandwidth() {
        return get(BANDWIDTH, -1);
    }

    /**
     * Sets the link bandwidth.
     *
     * @param bandwidth new bandwidth; null to clear
     * @return self
     */
    public BasicLinkConfig bandwidth(Long bandwidth) {
        return (BasicLinkConfig) setOrClear(BANDWIDTH, bandwidth);
    }

    /**
     * Returns if link is durable in the network model or not.
     *
     * @return true for durable, false otherwise
     */
    public Boolean isDurable() {
        JsonNode res = object.path(IS_DURABLE);
        if (res.isMissingNode()) {
            return null;
        }
        return res.asBoolean();
    }

    /**
     * Sets durability for this link.
     *
     * @param isDurable true for durable, false otherwise
     * @return this BasicLinkConfig
     */
    public BasicLinkConfig isDurable(Boolean isDurable) {
        return (BasicLinkConfig) setOrClear(IS_DURABLE, isDurable);
    }
}
