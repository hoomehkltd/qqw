/*
 * Copyright 2012 Soichiro Kashima
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

package com.androidformenhancer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents the value of the field must match the date format.
 * <p/>
 * Use {@link #value()} if you change the default date format. It will be passed
 * to the {@linkplain java.text.SimpleDateFormat()} with the device's default
 * Locale. If you do not change {@link #value()},
 * {@link java.text.DateFormat.SHORT} with the device's default Locale will be
 * used.
 * <p/>
 * If you want to disallow feature date, use {@linkplain PastDate} instead.
 *
 * @author Soichiro Kashima
 * @see PastDate
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DatePattern {
    /**
     * Resource ID of the field name for the error message.<br>
     * This is set to {@code 0}(invalid) as default, and the field name will be
     * used in the error messages.
     */
    int nameResId() default 0;

    /**
     * Date format of the field.
     */
    String value() default "";
}
