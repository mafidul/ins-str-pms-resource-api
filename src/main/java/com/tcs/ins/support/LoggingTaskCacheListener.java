package com.tcs.ins.support;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tcs.ins.resource.repository.entity.ResourceDetail;

public class LoggingTaskCacheListener implements CacheEventListener<String, ResourceDetail> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingTaskCacheListener.class);

		@Override
		public void onEvent(CacheEvent<? extends String, ? extends ResourceDetail> cacheEvent) {
			LOGGER.info("Key: {} | EventType: {} | Old value: {} | New value: {}", cacheEvent.getKey(), cacheEvent.getType(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
		}
}
