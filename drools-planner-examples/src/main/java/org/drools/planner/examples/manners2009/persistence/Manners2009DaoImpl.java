/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.planner.examples.manners2009.persistence;

import org.drools.planner.examples.common.persistence.XStreamSolutionDaoImpl;
import org.drools.planner.examples.manners2009.domain.Manners2009;

public class Manners2009DaoImpl extends XStreamSolutionDaoImpl {

    public Manners2009DaoImpl() {
        super("manners2009", Manners2009.class);
    }

}
