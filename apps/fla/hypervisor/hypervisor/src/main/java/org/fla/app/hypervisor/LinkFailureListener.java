/*
 * Copyright 2017 Open Networking Laboratory
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
package org.fla.app.hypervisor;

import org.onlab.osgi.DefaultServiceDirectory;
import org.onlab.osgi.ServiceDirectory;
import org.onosproject.net.Link;
import org.onosproject.net.LinkKey;
import org.onosproject.net.VnoId;
import org.onosproject.net.config.NetworkConfigService;
import org.onosproject.net.config.basics.BasicLinkConfig;
import org.onosproject.net.link.LinkEvent;
import org.onosproject.net.link.LinkListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkFailureListener implements LinkListener {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private ServiceDirectory services = new DefaultServiceDirectory();
    private LinkFailureDispatcher linkFailureDispatcher;

    public LinkFailureListener() {
        linkFailureDispatcher = new LinkFailureDispatcher();
    }

    /**
     * LinkEvent{time=2017-04-24T02:32:01.993, type=LINK_REMOVED,
     * subject=DefaultLink{
     * src=ConnectPoint{elementId=of:000000000000000b, portNumber=1},
     * dst=ConnectPoint{elementId=of:0000000000000001, portNumber=2},
     * type=DIRECT,
     * state=ACTIVE,
     * expected=false}}
     */

    public void event(LinkEvent e) {
        log.info(String.format("<-- Link Event (%s)",e.type().toString()));

        NetworkConfigService netCfgservice = services.get(NetworkConfigService.class);


        if (netCfgservice == null) {
            log.error("NetworkConfigService is null!");
            return;
        }

        if (e.type().equals(LinkEvent.Type.LINK_REMOVED) || e.type().equals(LinkEvent.Type.LINK_UPDATED) ) {
//            log.info("<-- LINK DOWN:");
            linkFailureDispatcher.initialize(netCfgservice);
            Link affectedLink = e.subject();
            log.info(affectedLink.toString());

            LinkKey linkKey = LinkKey.linkKey(affectedLink.src(), affectedLink.dst());
            LinkKey linkKeyRev = LinkKey.linkKey(affectedLink.dst(), affectedLink.src());
//            log.info("Link Key:");
//            log.info(linkKey.toString());
//            if (linkKey == null) {
//                log.info("Link Key was null");
//                return;
//            }
            BasicLinkConfig blc;

            blc = netCfgservice.getConfig(linkKey, BasicLinkConfig.class);

            if (blc == null) {
                blc = netCfgservice.getConfig(linkKeyRev, BasicLinkConfig.class);
                if (blc == null) {
                    log.info(String.format("No Link configuration for %s or %s", linkKey.toString(), linkKeyRev.toString()));
                    return;
                }
            }

            log.info("Getting link config...");
            if (blc.vnoIds() != null) {
                log.info("Event affected VNOs:");
                for (VnoId vno : blc.vnoIds()) {
                    log.info(String.format("Failure affects VNO #%d", vno.id()));
                }
            } else {
                log.info("No VNO affected");
            }

        }
    }

}

