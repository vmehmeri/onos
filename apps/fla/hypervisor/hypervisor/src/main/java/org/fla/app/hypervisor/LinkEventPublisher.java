package org.fla.app.hypervisor;

import javax.jms.TextMessage;
import javax.jms.JMSException;

/**
 * Implementation of LinkEventPublisher
 */
public class LinkEventPublisher extends AbstractPublisher {

    public void sendLinkFailureEventMessage(String linkSrc, String linkDst) throws JMSException {
        String text = linkSrc + " " + linkDst;

        // create a JMS TextMessage
        TextMessage textMessage = session.createTextMessage(text);

        // send the message to the topic destination
        messageProducer.send(textMessage);
    }

}
