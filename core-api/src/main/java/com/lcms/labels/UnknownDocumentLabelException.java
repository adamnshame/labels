package com.lcms.labels;

public class UnknownDocumentLabelException extends RuntimeException {

	/** Generated UID. */
	private static final long serialVersionUID = -7363875614493292608L;

	public UnknownDocumentLabelException(final DocumentLabelIdentifier identifier) {
		super("Unknown DocumentLabel: " + identifier);
	}

}
