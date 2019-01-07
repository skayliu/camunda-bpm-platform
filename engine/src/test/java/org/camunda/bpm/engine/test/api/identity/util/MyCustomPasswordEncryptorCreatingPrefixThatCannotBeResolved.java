/*
 * Copyright © 2013-2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.test.api.identity.util;

import org.camunda.bpm.engine.impl.digest.PasswordEncryptor;

public class MyCustomPasswordEncryptorCreatingPrefixThatCannotBeResolved implements PasswordEncryptor {

  protected int counter = 0;

  @Override
  public String encrypt(String password) {
    return "xxx";
  }

  @Override
  public boolean check(String password, String encrypted) {
    return password.equals("xxx");
  }

  @Override
  public String hashAlgorithmName() {
    counter++;
    return "Bla" + counter;
  }
}