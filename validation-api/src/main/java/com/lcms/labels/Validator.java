package com.lcms.labels;

import java.util.List;

public interface Validator {

	public List<ValidationResult> validate(final DocumentLabel label);

}
