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
package org.sonarqube.ws.client.qualityprofiles;

import java.util.List;
import javax.annotation.Generated;

/**
 * Change a quality profile's parent.<br>Requires one of the following permissions:<ul>  <li>'Administer Quality Profiles'</li>  <li>Edit right on the specified quality profile</li></ul>
 *
 * This is part of the internal API.
 * This is a POST request.
 * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/qualityprofiles/change_parent">Further information about this action online (including a response example)</a>
 * @since 5.2
 */
@Generated("https://github.com/SonarSource/sonar-ws-generator")
public class ChangeParentRequest {

  private String key;
  private String language;
  private String organization;
  private String parentKey;
  private String parentQualityProfile;
  private String qualityProfile;

  /**
   * Quality profile key
   *
   * Example value: "AU-Tpxb--iU5OvuD2FLy"
   * @deprecated since 6.6
   */
  @Deprecated
  public ChangeParentRequest setKey(String key) {
    this.key = key;
    return this;
  }

  public String getKey() {
    return key;
  }

  /**
   * Quality profile language. If this parameter is set, 'key' must not be set and 'language' must be set to disambiguate.
   *
   */
  public ChangeParentRequest setLanguage(String language) {
    this.language = language;
    return this;
  }

  public String getLanguage() {
    return language;
  }

  /**
   * Organization key. If no organization is provided, the default organization is used.
   *
   * This is part of the internal API.
   * Example value: "my-org"
   */
  public ChangeParentRequest setOrganization(String organization) {
    this.organization = organization;
    return this;
  }

  public String getOrganization() {
    return organization;
  }

  /**
   * New parent profile key.<br> If no profile is provided, the inheritance link with current parent profile (if any) is broken, which deactivates all rules which come from the parent and are not overridden.
   *
   * Example value: "AU-TpxcA-iU5OvuD2FLz"
   * @deprecated since 6.6
   */
  @Deprecated
  public ChangeParentRequest setParentKey(String parentKey) {
    this.parentKey = parentKey;
    return this;
  }

  public String getParentKey() {
    return parentKey;
  }

  /**
   * Quality profile name. If this parameter is set, 'parentKey' must not be set and 'language' must be set to disambiguate.
   *
   * Example value: "Sonar way"
   */
  public ChangeParentRequest setParentQualityProfile(String parentQualityProfile) {
    this.parentQualityProfile = parentQualityProfile;
    return this;
  }

  public String getParentQualityProfile() {
    return parentQualityProfile;
  }

  /**
   * Quality profile name. If this parameter is set, 'key' must not be set and 'language' must be set to disambiguate.
   *
   * Example value: "Sonar way"
   */
  public ChangeParentRequest setQualityProfile(String qualityProfile) {
    this.qualityProfile = qualityProfile;
    return this;
  }

  public String getQualityProfile() {
    return qualityProfile;
  }
}
