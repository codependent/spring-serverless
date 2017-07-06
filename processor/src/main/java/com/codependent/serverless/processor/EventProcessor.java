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
import java.util.function.Function;

public class EventProcessor implements Function<String, String> {

	public EventProcessor(){
		System.out.println("EventProcessor");
	}
	
	
	public String apply(String name) {
		return name + " processed at " + new Date().toString();
	}
}