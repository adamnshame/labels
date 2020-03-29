package com.lcms.labels;

public interface ValidatorRegistry {

	public <DocumentLabelType extends DocumentLabel> void registerValidator(final Class<DocumentLabelType> clazz,
			final Validator<DocumentLabelType> validator);

	public <DocumentLabelType extends DocumentLabel> Validator<DocumentLabelType> getValidator(
			final Class<DocumentLabelType> labelClass);

}
