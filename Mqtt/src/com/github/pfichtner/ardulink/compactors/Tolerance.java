/**
Copyright 2013 project Ardulink http://www.ardulink.org/

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/
package com.github.pfichtner.ardulink.compactors;

import static java.lang.Math.abs;

/**
 * [ardulinktitle] [ardulinkversion]
 * @author Peter Fichtner
 * 
 * [adsense]
 */
public class Tolerance {

	private final int maxTolerance;

	public Tolerance(int maxTolerance) {
		this.maxTolerance = maxTolerance;
	}

	public static Tolerance maxTolerance(int maxTolerance) {
		return new Tolerance(maxTolerance);
	}

	public boolean isZero() {
		return maxTolerance == 0;
	}

	protected boolean inTolerance(int oldValue, int newValue) {
		return abs(oldValue - newValue) <= maxTolerance;
	}

}