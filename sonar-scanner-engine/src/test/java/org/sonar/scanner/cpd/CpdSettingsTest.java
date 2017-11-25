/*
 * SonarQube
 * Copyright (C) 2009-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.scanner.cpd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.OptionalInt;

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.batch.fs.internal.DefaultInputModule;
import org.sonar.api.batch.fs.internal.InputModuleHierarchy;
import org.sonar.api.config.Configuration;

public class CpdSettingsTest {
  private CpdSettings cpdSettings;
  private Configuration configuration;
  private DefaultInputModule module;

  @Before
  public void setUp() {
    module = mock(DefaultInputModule.class);
    InputModuleHierarchy hierarchy = mock(InputModuleHierarchy.class);
    when(hierarchy.root()).thenReturn(module);
    configuration = mock(Configuration.class);
    cpdSettings = new CpdSettings(configuration, hierarchy);
  }

  @Test
  public void defaultMinimumTokens() {
    when(configuration.getInt(anyString())).thenReturn(OptionalInt.empty());
    assertThat(cpdSettings.getMinimumTokens("java")).isEqualTo(100);
  }

  @Test
  public void minimumTokensByLanguage() {
    when(configuration.getInt("sonar.cpd.java.minimumTokens")).thenReturn(OptionalInt.of(42));
    when(configuration.getInt("sonar.cpd.php.minimumTokens")).thenReturn(OptionalInt.of(33));

    assertThat(cpdSettings.getMinimumTokens("java")).isEqualTo(42);
    assertThat(cpdSettings.getMinimumTokens("php")).isEqualTo(33);
  }
}
