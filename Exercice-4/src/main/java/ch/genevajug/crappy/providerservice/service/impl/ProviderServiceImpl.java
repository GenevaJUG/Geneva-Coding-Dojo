/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.genevajug.crappy.providerservice.service.impl;

import ch.genevajug.crappy.providerservice.dao.ProviderDao;
import ch.genevajug.crappy.providerservice.dao.domain.impl.ServiceArtifact;
import ch.genevajug.crappy.providerservice.domain.ServiceProducer;
import ch.genevajug.crappy.providerservice.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A simple implementation of the providers service. This is the class that's
 * going to be tested using PowerMock.
 */
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderDao providerDao;

	/**
	 * {@inheritDoc}
	 */
	public Set<ServiceProducer> getAllServiceProviders() {
		final Set<ServiceProducer> serviceProducers = getAllServiceProducers();
		if (serviceProducers == null) {
			return Collections.emptySet();
		}
		return serviceProducers;
	}

	/**
	 * {@inheritDoc}
	 */
	public ServiceProducer getServiceProvider(int id) {
		Set<ServiceProducer> allServiceProducers = getAllServiceProducers();
		for (ServiceProducer serviceProducer : allServiceProducers) {
			if (serviceProducer.getId() == id) {
				return serviceProducer;
			}
		}
		return null;
	}

	private Set<ServiceProducer> getAllServiceProducers() {
		Set<ServiceArtifact> serviceArtifacts = providerDao.getAllServiceProducers();
		Set<ServiceProducer> serviceProducers = new HashSet<ServiceProducer>();

		for (ServiceArtifact serviceArtifact : serviceArtifacts) {
			serviceProducers.add(new ServiceProducer(serviceArtifact.getId(), serviceArtifact.getName(), serviceArtifact.getDataProducers()));
		}
		return serviceProducers;
	}
}
