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
package org.sonarqube.ws.client.projects;

import java.util.List;
import javax.annotation.Generated;

/**
 * Update a project or module key and all its sub-components keys.<br>Either 'from' or 'projectId' must be provided.<br> Requires one of the following permissions: <ul><li>'Administer System'</li><li>'Administer' rights on the specified project</li></ul>
 *
 * This is part of the internal API.
 * This is a POST request.
 * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/projects/update_key">Further information about this action online (including a response example)</a>
 * @since 6.1
 */
@Generated("https://github.com/SonarSource/sonar-ws-generator")
public class UpdateKeyRequest {

  private String from;
  private String projectId;
  private String to;

  /**
   * Project or module key
   *
   * Example value: "my_old_project"
   */
  public UpdateKeyRequest setFrom(String from) {
    this.from = from;
    return this;
  }

  public String getFrom() {
    return from;
  }

  /**
   * Project or module id
   *
   * Example value: "AU-Tpxb--iU5OvuD2FLy"
   * @deprecated since 6.4
   */
  @Deprecated
  public UpdateKeyRequest setProjectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

  public String getProjectId() {
    return projectId;
  }

  /**
   * New component key
   *
   * This is a mandatory parameter.
   * Example value: "my_new_project"
   */
  public UpdateKeyRequest setTo(String to) {
    this.to = to;
    return this;
  }

  public String getTo() {
    return to;
  }
}
