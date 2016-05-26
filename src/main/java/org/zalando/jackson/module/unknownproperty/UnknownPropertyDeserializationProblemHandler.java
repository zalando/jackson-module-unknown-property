package org.zalando.jackson.module.unknownproperty;

/*
 * ⁣​
 * Jackson-module-Unknown-Property
 * ⁣⁣
 * Copyright (C) 2015 - 2016 Zalando SE
 * ⁣⁣
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
 * ​⁣
 */

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import org.slf4j.Logger;

final class UnknownPropertyDeserializationProblemHandler extends DeserializationProblemHandler {
    
    private final Logger logger;
    private final String format;

    UnknownPropertyDeserializationProblemHandler(final Logger logger, final String format) {
        this.logger = logger;
        this.format = format;
    }

    @Override
    public boolean handleUnknownProperty(final DeserializationContext context, final JsonParser parser, 
            final JsonDeserializer<?> deserializer, final Object beanOrClass, final String propertyName) {
        
        // TODO based on the documentation this could be a class already, but I couldn't figure out when this happens
        final Class<?> type = beanOrClass.getClass();
        logger.trace(format, type, propertyName);
        
        return false;
    }

}