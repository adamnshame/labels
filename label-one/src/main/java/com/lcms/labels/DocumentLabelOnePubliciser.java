package com.lcms.labels;

public class DocumentLabelOnePubliciser {

	private ValidatorRegistry registry;

	private Validator<DocumentLabelOne> validator;

	public void publicise() {
		// TODO: Make this be called on (bean) initialisation
		this.registry.registerValidator(DocumentLabelOne.class, this.validator);
	}
}
