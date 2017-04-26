/*Copyright 2016.year Open Networking Laboratory

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/
package org.onosproject.yangutils.datamodel;

/**
 * Single interval information of a range.
 *
 * @param <T> range type based on the data type.
 */
public class YangRangeInterval<T extends Comparable<T>> {

    /**
     * Starting value of the range interval.
     */
    private T startValue;

    /**
     * Last value of the range interval.
     */
    private T endValue;

    /**
     * Default constructor.
     */
    public YangRangeInterval() {
    }

    /**
     * Get the starting value of the range interval.
     *
     * @return the starting value of the range interval.
     */
    public T getStartValue() {
        return startValue;
    }

    /**
     * Set the starting value of the range interval.
     *
     * @param startValue the starting value of the range interval.
     */
    public void setStartValue(T startValue) {
        this.startValue = startValue;
    }

    /**
     * Get the last value of the range interval.
     *
     * @return last value of the range interval.
     */
    public T getEndValue() {
        return endValue;
    }

    /**
     * Set the last value of the range interval.
     *
     * @param endValue last value of the range interval.
     */
    public void setEndValue(T endValue) {
        this.endValue = endValue;
    }

}
