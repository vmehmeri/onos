/*
 * Copyright 2016 Open Networking Laboratory
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

package org.onosproject.incubator.net.virtual;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import org.onosproject.incubator.net.tunnel.TunnelId;
import org.onosproject.net.ConnectPoint;
import org.onosproject.net.DeviceId;
import org.onosproject.net.PortNumber;

import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;

/**
 * Test of the default virtual link model entity.
 */
public class DefaultVirtualLinkTest {
    final String deviceIdValue1 = "DEVICE_ID1";
    final String deviceIdValue2 = "DEVICE_ID2";

    /**
     * Checks that the DefaultVirtualLink class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(DefaultVirtualLink.class);
    }

    @Test
    public void testEquality() {
        DefaultVirtualDevice device1 =
                new DefaultVirtualDevice(NetworkId.networkId(0), DeviceId.deviceId(deviceIdValue1));
        DefaultVirtualDevice device2 =
                new DefaultVirtualDevice(NetworkId.networkId(0), DeviceId.deviceId(deviceIdValue2));
        ConnectPoint src = new ConnectPoint(device1.id(), PortNumber.portNumber(1));
        ConnectPoint dst = new ConnectPoint(device2.id(), PortNumber.portNumber(2));

        DefaultVirtualLink link1 = new DefaultVirtualLink(NetworkId.networkId(0), src, dst, TunnelId.valueOf(0));
        DefaultVirtualLink link2 = new DefaultVirtualLink(NetworkId.networkId(0), src, dst, TunnelId.valueOf(0));
        DefaultVirtualLink link3 = new DefaultVirtualLink(NetworkId.networkId(0), src, dst, TunnelId.valueOf(1));
        DefaultVirtualLink link4 = new DefaultVirtualLink(NetworkId.networkId(1), src, dst, TunnelId.valueOf(0));

        new EqualsTester().addEqualityGroup(link1, link2).addEqualityGroup(link3)
                .addEqualityGroup(link4).testEquals();
    }
}
