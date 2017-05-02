package org.fla.app.hypervisor;

import org.onlab.osgi.DefaultServiceDirectory;
import org.onlab.osgi.ServiceDirectory;
import org.onosproject.net.LinkKey;
import org.onosproject.net.config.NetworkConfigService;
import org.onosproject.net.config.basics.BasicLinkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * A class containing a publisher for every physical link,
 * and being responsible for dispatching messages accordingly
 */
public class LinkFailureDispatcher {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private ServiceDirectory services = new DefaultServiceDirectory();
    private List<LinkEventPublisher> publishers;

    public void initialize(NetworkConfigService netCfgservice) {

//        NetworkConfigService netCfgservice = services.get(NetworkConfigService.class);
        if (netCfgservice == null) {
            log.error("NetworkConfigService is null!");
            return;
        }

        log.info("Getting network config...");
        Set<BasicLinkConfig> linkConfigs;
        linkConfigs = netCfgservice.getSubjects(BasicLinkConfig.class);

        if (linkConfigs.isEmpty()) {
            log.info(">> No LINK Config found");
        }
        for (BasicLinkConfig linkCfg : linkConfigs) {
            LinkKey key = linkCfg.subject();
            log.info("Found link key:" + key);
        }

    }
}
