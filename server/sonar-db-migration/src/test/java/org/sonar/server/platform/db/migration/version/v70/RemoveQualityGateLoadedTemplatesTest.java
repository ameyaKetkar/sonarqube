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
package org.sonar.server.platform.db.migration.version.v70;

import java.sql.SQLException;
import java.util.stream.IntStream;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.sonar.db.CoreDbTester;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveQualityGateLoadedTemplatesTest {
  public static final String QUALITY_GATE_TYPE = "QUALITY_GATE";
  @Rule
  public CoreDbTester db = CoreDbTester.createForSchema(RemoveQualityGateLoadedTemplatesTest.class, "loaded_templates.sql");

  private RemoveQualityGateLoadedTemplates underTest = new RemoveQualityGateLoadedTemplates(db.database());

  @Test
  public void has_no_effect_if_table_is_empty() throws SQLException {
    underTest.execute();

    assertThat(db.countRowsOfTable("loaded_templates")).isEqualTo(0);
  }

  @Test
  public void migration_should_remove_all_quality_gate_loaded_templates() throws SQLException {
    insertQualkityGateLoadedTemplates(5);

    underTest.execute();

    assertThat(db.countRowsOfTable("loaded_templates")).isEqualTo(0);
  }

  @Test
  public void migration_should_NOT_remove_other_gate_loaded_templates() throws SQLException {
    insertRandomLoadedTemplates(20);

    underTest.execute();

    assertThat(db.countSql("SELECT count(*) FROM loaded_templates WHERE template_type = '" + QUALITY_GATE_TYPE + "'")).isEqualTo(0);
    assertThat(db.countRowsOfTable("loaded_templates")).isEqualTo(20);
  }

  @Test
  public void migration_is_reentrant() throws SQLException {
    insertRandomLoadedTemplates(20);
    insertQualkityGateLoadedTemplates(5);

    underTest.execute();
    underTest.execute();

    assertThat(db.countSql("SELECT count(*) FROM loaded_templates WHERE template_type = '" + QUALITY_GATE_TYPE + "'")).isEqualTo(0);
    assertThat(db.countRowsOfTable("loaded_templates")).isEqualTo(20);
  }


  private void insertRandomLoadedTemplates(int number) {
    IntStream.range(0, number).forEach(i ->
      db.executeInsert("loaded_templates",
        "kee", RandomStringUtils.randomAlphanumeric(10),
        "template_type", RandomStringUtils.randomAlphanumeric(20))
    );
  }

  private void insertQualkityGateLoadedTemplates(int number) {
    IntStream.range(0, number).forEach(i ->
      db.executeInsert("loaded_templates",
        "kee", RandomStringUtils.randomAlphanumeric(10),
        "template_type", QUALITY_GATE_TYPE)
    );
  }
}
