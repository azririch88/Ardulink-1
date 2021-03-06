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

import org.zu.ardulink.event.AnalogReadChangeEvent;
import org.zu.ardulink.event.AnalogReadChangeListener;

/**
 * [ardulinktitle] [ardulinkversion]
 * @author Peter Fichtner
 * 
 * [adsense]
 */
public class TimeSliceCompactorLast extends
		SlicedAnalogReadChangeListenerAdapter {

	private boolean firstCall = true;
	private AnalogReadChangeEvent lastEvent;

	public TimeSliceCompactorLast(AnalogReadChangeListener delegate) {
		super(delegate);
	}

	@Override
	public void stateChanged(AnalogReadChangeEvent event) {
		if (this.firstCall) {
			getDelegate().stateChanged(event);
			this.firstCall = false;
		} else {
			this.lastEvent = event;
		}
	}

	@Override
	public void ticked() {
		AnalogReadChangeEvent event = this.lastEvent;
		if (event != null) {
			getDelegate().stateChanged(event);
		}
	}

}