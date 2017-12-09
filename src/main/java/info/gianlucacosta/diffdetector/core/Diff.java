/*^
  ===========================================================================
  Diff Detector - Core
  ===========================================================================
  Copyright (C) 2017 Gianluca Costa
  ===========================================================================
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  ===========================================================================
*/

package info.gianlucacosta.diffdetector.core;

import java.util.Objects;

/**
 * A diff between 2 byte arrays, expressed as offset+length
 */
public class Diff {
    private int offset;
    private int length;


    private Diff() {

    }


    public Diff(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }


    public int getOffset() {
        return offset;
    }


    public int getLength() {
        return length;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diff diff = (Diff) o;
        return offset == diff.offset &&
                length == diff.length;
    }


    @Override
    public int hashCode() {
        return Objects.hash(offset, length);
    }
}
