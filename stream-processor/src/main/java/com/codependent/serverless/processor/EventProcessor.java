/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codependent.serverless.processor;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Flux;

public class EventProcessor implements Function<Flux<Map<String, Object>>, Flux<Map<String, Object>>> {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public Flux<Map<String, Object>> apply(Flux<Map<String, Object>> event) {
		return event.map( e -> {e.put("processingTime", new Date()); return e;})
				.doOnNext( val-> logger.info("*** {} ***", val));
	}
}
