/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.benchmark.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.optaplanner.benchmark.config.PlannerBenchmarkConfig;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.impl.solver.XStreamXmlSolverFactory;
import org.optaplanner.core.impl.testdata.util.PlannerTestUtils;

import static org.junit.Assert.*;

public class XStreamXmlPlannerBenchmarkFactoryTest {

    @Test
    public void configFileRemainsSameAfterReadWrite() throws Exception {
        String plannerBenchmarkConfigResource = "testdataPlannerBenchmarkConfigXStream.xml";
        String originalXml = PlannerTestUtils.readResourceToString(getClass(), plannerBenchmarkConfigResource);
        InputStream originalConfigInputStream = getClass().getResourceAsStream(plannerBenchmarkConfigResource);
        XStreamXmlPlannerBenchmarkFactory plannerBenchmarkFactory = new XStreamXmlPlannerBenchmarkFactory().configure(originalConfigInputStream);
        PlannerBenchmarkConfig benchmarkConfig = plannerBenchmarkFactory.getPlannerBenchmarkConfig();
        String savedXml = plannerBenchmarkFactory.getXStream().toXML(benchmarkConfig);
        assertEquals(originalXml, savedXml);
    }

    @Test
    public void configFileRemainsSameAfterReadWriteBuild() throws Exception {
        String plannerBenchmarkConfigResource = "testdataPlannerBenchmarkConfigXStream.xml";
        String originalXml = PlannerTestUtils.readResourceToString(getClass(), plannerBenchmarkConfigResource);
        InputStream originalConfigInputStream = getClass().getResourceAsStream(plannerBenchmarkConfigResource);
        XStreamXmlPlannerBenchmarkFactory plannerBenchmarkFactory = new XStreamXmlPlannerBenchmarkFactory().configure(originalConfigInputStream);
        PlannerBenchmarkConfig benchmarkConfig = plannerBenchmarkFactory.getPlannerBenchmarkConfig();
        benchmarkConfig.buildPlannerBenchmark();
        String savedXml = plannerBenchmarkFactory.getXStream().toXML(benchmarkConfig);
        assertEquals(originalXml, savedXml);
    }

    @Test
    public void configFileRemainsSameAfterReadWriteWithInherited() throws Exception {
        String plannerBenchmarkConfigResource = "testdataPlannerBenchmarkConfigXStreamInherited.xml";
        String originalXml = PlannerTestUtils.readResourceToString(getClass(), plannerBenchmarkConfigResource);
        InputStream originalConfigInputStream = getClass().getResourceAsStream(plannerBenchmarkConfigResource);
        XStreamXmlPlannerBenchmarkFactory plannerBenchmarkFactory = new XStreamXmlPlannerBenchmarkFactory().configure(originalConfigInputStream);
        PlannerBenchmarkConfig benchmarkConfig = plannerBenchmarkFactory.getPlannerBenchmarkConfig();
        String savedXml = plannerBenchmarkFactory.getXStream().toXML(benchmarkConfig);
        assertEquals(originalXml, savedXml);
    }

    @Test
    @Ignore("Config shouldn't actually remain the same: we inherited the subSingleCount")
    public void configFileRemainsSameAfterReadWriteBuildWithInherited() throws Exception {
        String plannerBenchmarkConfigResource = "testdataPlannerBenchmarkConfigXStreamInherited.xml";
        String originalXml = PlannerTestUtils.readResourceToString(getClass(), plannerBenchmarkConfigResource);
        InputStream originalConfigInputStream = getClass().getResourceAsStream(plannerBenchmarkConfigResource);
        XStreamXmlPlannerBenchmarkFactory plannerBenchmarkFactory = new XStreamXmlPlannerBenchmarkFactory().configure(originalConfigInputStream);
        PlannerBenchmarkConfig benchmarkConfig = plannerBenchmarkFactory.getPlannerBenchmarkConfig();
        benchmarkConfig.buildPlannerBenchmark();
        String savedXml = plannerBenchmarkFactory.getXStream().toXML(benchmarkConfig);
        assertEquals(originalXml, savedXml);
    }
}
