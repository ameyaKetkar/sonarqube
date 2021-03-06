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
package org.sonarqube.ws.client.users;

import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.sonarqube.ws.MediaTypes;
import org.sonarqube.ws.client.BaseService;
import org.sonarqube.ws.client.GetRequest;
import org.sonarqube.ws.client.PostRequest;
import org.sonarqube.ws.client.WsConnector;
import org.sonarqube.ws.Users.CreateWsResponse;
import org.sonarqube.ws.Users.CurrentWsResponse;
import org.sonarqube.ws.Users.GroupsWsResponse;
import org.sonarqube.ws.Users.IdentityProvidersWsResponse;
import org.sonarqube.ws.Users.SearchWsResponse;

/**
 * Manage users.
 * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users">Further information about this web service online</a>
 */
@Generated("https://github.com/SonarSource/sonar-ws-generator")
public class UsersService extends BaseService {

  public UsersService(WsConnector wsConnector) {
    super(wsConnector, "api/users");
  }

  /**
   * Update a user's password. Authenticated users can change their own password, provided that the account is not linked to an external authentication system. Administer System permission is required to change another user's password.
   *
   * This is part of the internal API.
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/change_password">Further information about this action online (including a response example)</a>
   * @since 5.2
   */
  public void changePassword(ChangePasswordRequest request) {
    call(
      new PostRequest(path("change_password"))
        .setParam("login", request.getLogin())
        .setParam("password", request.getPassword())
        .setParam("previousPassword", request.getPreviousPassword())
        .setMediaType(MediaTypes.JSON)
      ).content();
  }

  /**
   * Create a user.<br/>If a deactivated user account exists with the given login, it will be reactivated.<br/>Requires Administer System permission
   *
   * This is part of the internal API.
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/create">Further information about this action online (including a response example)</a>
   * @since 3.7
   */
  public void create(CreateRequest request) {
    call(
      new PostRequest(path("create"))
        .setParam("email", request.getEmail())
        .setParam("local", request.getLocal())
        .setParam("login", request.getLogin())
        .setParam("name", request.getName())
        .setParam("password", request.getPassword())
        .setParam("scmAccount", request.getScmAccount())
        .setParam("scmAccounts", request.getScmAccounts()),
      CreateWsResponse.parser());
  }

  /**
   * Get the details of the current authenticated user.
   *
   * This is part of the internal API.
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/current">Further information about this action online (including a response example)</a>
   * @since 5.2
   */
  public CurrentWsResponse current() {
    return call(
      new GetRequest(path("current")),
      CurrentWsResponse.parser());
  }

  /**
   * Deactivate a user. Requires Administer System permission
   *
   * This is part of the internal API.
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/deactivate">Further information about this action online (including a response example)</a>
   * @since 3.7
   */
  public String deactivate(DeactivateRequest request) {
    return call(
      new PostRequest(path("deactivate"))
        .setParam("login", request.getLogin())
        .setMediaType(MediaTypes.JSON)
      ).content();
  }

  /**
   * Lists the groups a user belongs to. <br/>Requires Administer System permission.
   *
   * This is part of the internal API.
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/groups">Further information about this action online (including a response example)</a>
   * @since 5.2
   */
  public GroupsWsResponse groups(GroupsRequest request) {
    return call(
      new GetRequest(path("groups"))
        .setParam("login", request.getLogin())
        .setParam("organization", request.getOrganization())
        .setParam("p", request.getP())
        .setParam("ps", request.getPs())
        .setParam("q", request.getQ())
        .setParam("selected", request.getSelected()),
      GroupsWsResponse.parser());
  }

  /**
   * List the external identity providers
   *
   * This is part of the internal API.
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/identity_providers">Further information about this action online (including a response example)</a>
   * @since 5.5
   */
  public IdentityProvidersWsResponse identityProviders() {
    return call(
      new GetRequest(path("identity_providers")),
      IdentityProvidersWsResponse.parser());
  }

  /**
   * Get a list of active users. <br/>Administer System permission is required to show the 'groups' field.<br/>When accessed anonymously, only logins and names are returned.
   *
   * This is part of the internal API.
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/search">Further information about this action online (including a response example)</a>
   * @since 3.6
   */
  public SearchWsResponse search(SearchRequest request) {
    return call(
      new GetRequest(path("search"))
        .setParam("f", request.getF() == null ? null : request.getF().stream().collect(Collectors.joining(",")))
        .setParam("p", request.getP())
        .setParam("ps", request.getPs())
        .setParam("q", request.getQ()),
      SearchWsResponse.parser());
  }

  /**
   * Stores that the user has skipped the onboarding tutorial and does not want to see it after future logins.<br/>Requires authentication.
   *
   * This is part of the internal API.
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/skip_onboarding_tutorial">Further information about this action online (including a response example)</a>
   * @since 6.5
   */
  public void skipOnboardingTutorial() {
    call(
      new PostRequest(path("skip_onboarding_tutorial"))
        .setMediaType(MediaTypes.JSON)
      ).content();
  }

  /**
   * Update a user. If a deactivated user account exists with the given login, it will be reactivated. Requires Administer System permission
   *
   * This is part of the internal API.
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/update">Further information about this action online (including a response example)</a>
   * @since 3.7
   */
  public String update(UpdateRequest request) {
    return call(
      new PostRequest(path("update"))
        .setParam("email", request.getEmail())
        .setParam("login", request.getLogin())
        .setParam("name", request.getName())
        .setParam("scmAccount", request.getScmAccount())
        .setParam("scmAccounts", request.getScmAccounts())
        .setMediaType(MediaTypes.JSON)
      ).content();
  }
}
