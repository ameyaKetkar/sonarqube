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
package org.sonarqube.ws.client.usertokens;

import java.util.List;
import javax.annotation.Generated;

/**
 * List the access tokens of a user.<br>The login must exist and active.<br>If the login is set, it requires administration permissions. Otherwise, a token is generated for the authenticated user.
 *
 * This is part of the internal API.
 * This is a POST request.
 * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/user_tokens/search">Further information about this action online (including a response example)</a>
 * @since 5.3
 */
@Generated("https://github.com/SonarSource/sonar-ws-generator")
public class SearchRequest {

  private String login;

  /**
   * User login
   *
   * Example value: "g.hopper"
   */
  public SearchRequest setLogin(String login) {
    this.login = login;
    return this;
  }

  public String getLogin() {
    return login;
  }
}
