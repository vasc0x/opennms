/*
 * Licensed to The OpenNMS Group, Inc (TOG) under one or more
 * contributor license agreements.  See the LICENSE.md file
 * distributed with this work for additional information
 * regarding copyright ownership.
 *
 * TOG licenses this file to You under the GNU Affero General
 * Public License Version 3 (the "License") or (at your option)
 * any later version.  You may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at:
 *
 *      https://www.gnu.org/licenses/agpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package org.opennms.features.enlinkd.shell;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.opennms.netmgt.enlinkd.api.ReloadableTopologyDaemon;

/**
 * Force enlinkd to reloadTopology via karaf command.
 * Log into console via: ssh -p 8101 admin@localhost
 * Install: feature:install opennms-enlinkd-shell
 * Usage: type 'opennms:enlinkd-reload-topology' in karaf console
 */
@Command(scope = "opennms", name = "enlinkd-reload-topology", description = "Triggers a reload of the topology in case the topology has been updated")
@Service
public class ReloadTopologyCommand implements Action {


    @Reference
    private ReloadableTopologyDaemon reloadableTopologyDaemon;


    @Override
    public Void execute() {
        System.out.println("start reload of topology updaters");
        reloadableTopologyDaemon.reloadTopology();
        System.out.println("end reload of topology updaters");
        return null;
    }

}