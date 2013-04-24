/**
 * Copyright (C) 2010-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.flyway.commandline.largetest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Large Test for the Flyway Command-Line Tool Distribution With Spring.
 * <p/>
 * You must run the Maven build once before executing this in IntelliJ.
 */
public class CommandLineDistWithSpringLargeTest extends CommandLineLargeTest {
    @Override
    protected String getInstallDir() {
        return System.getProperty("installDirDistWithSpring",
                "flyway-commandline-largetest/target/install/dist with spring/flyway-commandline-" + getPomVersion());
    }

    /**
     * Execute 1 (SQL), 1.1 (SQL), 1.2 (Spring Jdbc) & 1.3 (Jdbc)
     */
    @Test
    public void migrate() throws Exception {
        String stdOut = runFlywayCommandLine(0, "largeTest.properties", "migrate");
        assertThat(stdOut, containsString("Successfully applied 4 migrations"));
    }
}
