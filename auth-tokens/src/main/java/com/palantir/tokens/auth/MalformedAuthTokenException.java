/*
 * (c) Copyright 2019 Palantir Technologies Inc. All rights reserved.
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

package com.palantir.tokens.auth;

import com.google.errorprone.annotations.CompileTimeConstant;
import com.palantir.logsafe.Arg;
import com.palantir.logsafe.SafeLoggable;
import com.palantir.logsafe.exceptions.SafeExceptions;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Exception thrown by {@link BearerToken} for malformed tokens.
 */
public final class MalformedAuthTokenException extends IllegalArgumentException implements SafeLoggable {
    private final String logMessage;
    private final List<Arg<?>> arguments;

    MalformedAuthTokenException(@CompileTimeConstant String message, Arg<?>... arguments) {
        super(SafeExceptions.renderMessage(message, arguments));
        this.logMessage = message;
        this.arguments = Collections.unmodifiableList(Arrays.asList(arguments));
    }

    @Override
    public String getLogMessage() {
        return logMessage;
    }

    @Override
    public List<Arg<?>> getArgs() {
        return arguments;
    }
}
