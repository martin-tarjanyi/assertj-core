/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.core.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.assertj.core.data.Offset.strictOffset;
import static org.assertj.core.internal.ErrorMessages.offsetValueIsNotPositive;
import static org.assertj.core.internal.ErrorMessages.strictOffsetValueIsNotStrictlyPositive;
import static org.assertj.core.test.ExpectedException.none;

import org.assertj.core.test.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link Offset#offset(Integer)}.
 *
 * @author Yvonne Wang
 */
public class Offset_built_with_Integer_Test {

  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_throw_error_if_value_is_null() {
    thrown.expectNullPointerException();
    Integer value = null;
    offset(value);
  }

  @Test
  public void should_throw_error_if_value_is_negative() {
    thrown.expectIllegalArgumentException(offsetValueIsNotPositive());
    offset(-1);
  }

  @Test
  public void should_throw_error_if_value_is_zero_strict_offset() {
    thrown.expectIllegalArgumentException(strictOffsetValueIsNotStrictlyPositive());
    strictOffset(0);
  }

  @Test
  public void should_create_Offset() {
    Integer value = 8;
    Offset<Integer> offset = offset(value);
    assertThat(offset.value).isSameAs(value);
  }
}
