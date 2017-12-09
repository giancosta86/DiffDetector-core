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

import java.util.Base64;

/**
 * Left/Right term in a comparison.
 * <p>
 * Contains a string of base64-encoded bytes and supports retrieval
 * of the original data.
 */
public class ComparisonOperand {
    private String base64Data;

    public ComparisonOperand() {
    }

    public ComparisonOperand(byte[] data) {
        this.base64Data =
                new String(
                        Base64.getEncoder().encode(data)
                );
    }


    public String getBase64Data() {
        return base64Data;
    }

    public byte[] getData() {
        return Base64.getDecoder().decode(
                base64Data.getBytes()
        );
    }
}
