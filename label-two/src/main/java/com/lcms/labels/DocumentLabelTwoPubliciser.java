package com.lcms.labels;

public class DocumentLabelTwoPubliciser {

	private ValidatorRegistry registry;

	private Validator<DocumentLabelTwo> validator;

	public void publicise() {
		// TODO: Make this be called on (bean) initialisation
		this.registry.registerValidator(DocumentLabelTwo.class, this.validator);
	}
}
