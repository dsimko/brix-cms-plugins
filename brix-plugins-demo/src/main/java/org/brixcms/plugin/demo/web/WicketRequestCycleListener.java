/**
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

package org.brixcms.plugin.demo.web;

import javax.jcr.Session;

import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
import org.brixcms.plugin.demo.BrixApplication;

/**
 * Subclass of {@link AbstractRequestCycleListener} that cleans any open Jcr {@link Session}s at the end of request
 *
 * @author igor.vaynberg
 */
public class WicketRequestCycleListener extends AbstractRequestCycleListener {


    @Override
    public void onEndRequest(RequestCycle cycle) {
        super.onEndRequest(cycle);
        BrixApplication.get().cleanupSessionFactory();
    }
}
