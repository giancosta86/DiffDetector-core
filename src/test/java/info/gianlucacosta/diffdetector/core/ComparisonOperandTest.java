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


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ComparisonOperandTest {
    private final byte[] testData =
            "Hello, world!".getBytes();

    private final String testDataAsBase64 =
            "SGVsbG8sIHdvcmxkIQ=="; //Externally computed


    private ComparisonOperand comparisonOperand;


    @BeforeEach
    public void init() {
        comparisonOperand =
                new ComparisonOperand(testData);
    }


    @Test
    void dataShouldBeCorrectlyEncodedToBase64() {
        assertThat(
                comparisonOperand.getBase64Data(),
                equalTo(testDataAsBase64)
        );
    }


    @Test
    public void dataShouldBeCorrectlyRetrieved() {
        assertThat(
                comparisonOperand.getData(),
                equalTo(testData)
        );
    }
}
