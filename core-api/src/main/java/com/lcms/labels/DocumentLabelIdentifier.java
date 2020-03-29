package com.lcms.labels;

public class DocumentLabelIdentifier {

	private final String schemaName;

	private final String schemaVersion;

	public DocumentLabelIdentifier(final String schemaName, final String schemaVersion) {
		if (null == schemaName) {
			throw new IllegalArgumentException("SchemaName cannot be null");
		}
		if (null == schemaVersion) {
			throw new IllegalArgumentException("SchemaVersion cannot be null");
		}
		this.schemaName = schemaName;
		this.schemaVersion = schemaVersion;
	}

	public String getSchemaName() {
		return this.schemaName;
	}

	public String getSchemaVersion() {
		return this.schemaVersion;
	}

	@Override
	public String toString() {
		return String.format("DocumentLabelIdentifier {schema:%s, version:%s}", this.schemaName, this.schemaVersion);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.schemaName.hashCode();
		result = prime * result + this.schemaVersion.hashCode();
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final DocumentLabelIdentifier other = (DocumentLabelIdentifier) obj;
		if (!this.schemaName.equals(other.schemaName)) {
			return false;
		}
		if (!this.schemaVersion.equals(other.schemaVersion)) {
			return false;
		}
		return true;
	}

	public static DocumentLabelIdentifier extract(final Class<? extends DocumentLabel> clazz) {
		// TODO
		return null;
	}

}
