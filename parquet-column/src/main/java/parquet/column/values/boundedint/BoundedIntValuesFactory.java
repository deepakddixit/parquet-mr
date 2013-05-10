/**
 * Copyright 2012 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package parquet.column.values.boundedint;

import parquet.column.values.ValuesReader;
import parquet.column.values.ValuesWriter;

public abstract class BoundedIntValuesFactory {
  public static ValuesReader getBoundedReader(int bound) {
    return bound == 0 ? new ZeroIntegerValuesReader() : new BoundedIntValuesReader(bound);
  }

  public static ValuesWriter getBoundedWriter(int bound, int initialCapacity) {
    return bound == 0 ? new DevNullValuesWriter() : new BoundedIntValuesWriter(bound, initialCapacity);
  }
}
