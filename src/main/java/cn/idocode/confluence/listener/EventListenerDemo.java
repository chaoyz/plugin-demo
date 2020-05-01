package cn.idocode.confluence.listener;

import com.atlassian.confluence.event.events.like.LikeCreatedEvent;
import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;

@Scanned
public class EventListenerDemo implements DisposableBean {

    @ComponentImport
    private EventPublisher eventPublisher;

    @Autowired
    public EventListenerDemo(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        this.eventPublisher.register(this);
    }

    @EventListener
    public void likeEvent(LikeCreatedEvent likeCreatedEvent) {
        // do something when a like event create
    }

    @Override
    public void destroy() throws Exception {
        this.eventPublisher.unregister(this);
    }
}
