package com.lcms.labels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ValidationService {

	private static final String MODULES_PROPERTY = "validation.modules";

	public static void main(final String[] args) {
		final String modulesProperty = System.getProperty(MODULES_PROPERTY);
		if (null == modulesProperty || modulesProperty.trim().isEmpty()) {
			throw new RuntimeException("Modules must be specified with property: " + MODULES_PROPERTY);
		}
		final List<String> moduleClassNames = Arrays.asList(modulesProperty.split(","));
		System.out.println(MODULES_PROPERTY + ":" + moduleClassNames);
		final List<Module> modules = new ArrayList<>(moduleClassNames.size());
		for (final String moduleClassName : moduleClassNames) {
			System.out.println("Instantiating module: " + moduleClassName);
			final Module module;
			try {
				module = (Module) Class.forName(moduleClassName).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			modules.add(module);
		}
		final Injector injector = Guice.createInjector(modules);

		injector.getInstance(ValidationService.class).start();
	}

	@Inject
	private Map<DocumentLabelIdentifier, Validator> validators;

	public void start() {
		System.out.println("Started with validators:");
		this.validators.entrySet().forEach((entry) -> System.out.println(entry.getKey() + " ::: " + entry.getValue()));
	}

}
