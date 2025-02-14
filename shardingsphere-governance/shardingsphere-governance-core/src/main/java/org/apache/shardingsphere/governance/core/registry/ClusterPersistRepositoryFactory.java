/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.governance.core.registry;

import com.google.common.base.Preconditions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.governance.repository.api.config.ClusterPersistRepositoryConfiguration;
import org.apache.shardingsphere.governance.repository.spi.ClusterPersistRepository;
import org.apache.shardingsphere.infra.spi.ShardingSphereServiceLoader;
import org.apache.shardingsphere.infra.spi.typed.TypedSPIRegistry;

/**
 * Cluster persist repository factory.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClusterPersistRepositoryFactory {
    
    static {
        ShardingSphereServiceLoader.register(ClusterPersistRepository.class);
    }
    
    /**
     * Create new instance of cluster persist repository.
     * 
     * @param config cluster persist repository configuration
     * @return new instance of cluster persist repository
     */
    public static ClusterPersistRepository newInstance(final ClusterPersistRepositoryConfiguration config) {
        Preconditions.checkNotNull(config, "Cluster persist repository configuration cannot be null.");
        ClusterPersistRepository result = TypedSPIRegistry.getRegisteredService(ClusterPersistRepository.class, config.getType(), config.getProps());
        result.init(config);
        return result;
    }
}
