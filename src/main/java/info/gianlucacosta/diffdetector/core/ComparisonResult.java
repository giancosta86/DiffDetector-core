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

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ComparisonResult {
    private boolean sameLength;
    private List<Diff> diffs;

    /**
     * Creates a result when the operands have different lengths
     *
     * @return The comparison result
     */
    public static ComparisonResult ofDifferentLengths() {
        return new ComparisonResult(false, Collections.emptyList());
    }


    /**
     * Creates a result when the operands have equal length and a
     * (possibly empty) list of diffs
     *
     * @param diffs The list of diffs
     * @return The comparison result
     */
    public static ComparisonResult ofDiffs(List<Diff> diffs) {
        return new ComparisonResult(true, diffs);
    }


    private ComparisonResult() {
    }


    private ComparisonResult(boolean sameLength, List<Diff> diffs) {
        this.sameLength = sameLength;
        this.diffs =
                Collections.unmodifiableList(diffs);
    }


    public boolean isSameLength() {
        return sameLength;
    }


    public List<Diff> getDiffs() {
        return diffs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparisonResult that = (ComparisonResult) o;
        return sameLength == that.sameLength &&
                Objects.equals(diffs, that.diffs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameLength, diffs);
    }
}
