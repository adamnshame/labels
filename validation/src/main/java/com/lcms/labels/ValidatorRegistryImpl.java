package com.lcms.labels;

import java.util.HashMap;
import java.util.Map;

public class ValidatorRegistryImpl implements ValidatorRegistry {

	private final Map<DocumentLabelIdentifier, Validator<? extends DocumentLabel>> validators = new HashMap<>();

	public ValidatorRegistryImpl() {
	}

	@Override
	public <DocumentLabelType extends DocumentLabel> void registerValidator(final Class<DocumentLabelType> labelClass,
			final Validator<DocumentLabelType> validator) {
		// TODO Auto-generated method stub
		if (labelClass == null) {
			throw new IllegalArgumentException("DocumentLabel class cannot be null");
		}
		if (validator == null) {
			throw new IllegalArgumentException("Validator cannot be null");
		}
		final DocumentLabelIdentifier identifier = DocumentLabelIdentifier.extract(labelClass);
		if (this.validators.containsKey(identifier)) {
			throw new RuntimeException("Validator already registered for: " + identifier);
		}
		this.validators.put(identifier, validator);
		System.out.println(String.format("Registered [%s] validator: %s", identifier, validator));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <DocumentLabelType extends DocumentLabel> Validator<DocumentLabelType> getValidator(
			final Class<DocumentLabelType> labelClass) {
		final DocumentLabelIdentifier identifier = DocumentLabelIdentifier.extract(labelClass);
		if (!this.validators.containsKey(identifier)) {
			throw new UnknownDocumentLabelException(identifier);
		}
		return (Validator<DocumentLabelType>) this.validators.get(identifier);
	}

}
