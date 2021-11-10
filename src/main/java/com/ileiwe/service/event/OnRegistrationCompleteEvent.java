package com.ileiwe.service.event;

import com.ileiwe.data.model.LearningParty;
import lombok.Builder;
import lombok.Data;
import org.springframework.context.ApplicationEvent;
@Data
@Builder

public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private LearningParty appUser;

    public OnRegistrationCompleteEvent(LearningParty source) {
        super(source);
      appUser = source;
    }
}
