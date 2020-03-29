package com.lcms.labels;

import java.util.List;

public interface Validator<DocumentLabelType extends DocumentLabel> {

	public List<ValidationResult> validate(final DocumentLabelType label);

}
