package com.tcs.ins.resource.messaging;

import com.tcs.ins.resource.service.model.ProjectDetailModel;

public interface BatchProcessTriggeredEventProducer {

	void sendMessage(ProjectDetailModel event);
}