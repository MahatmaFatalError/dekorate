/**
 * Copyright 2018 The original authors.
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
 * 
**/
package io.ap4k.decorator;

import io.ap4k.config.Mount;
import io.ap4k.deps.kubernetes.api.model.ContainerBuilder;

public class AddMount extends Decorator<ContainerBuilder> {

  private final Mount mount;

  public AddMount(Mount mount) {
    this.mount = mount;
  }

  @Override
  public void visit(ContainerBuilder container) {
    container.addNewVolumeMount()
      .withName(mount.getName())
      .withMountPath(mount.getPath())
      .withSubPath(mount.getSubPath())
      .withReadOnly(mount.isReadOnly())
      .endVolumeMount();


  }
}
