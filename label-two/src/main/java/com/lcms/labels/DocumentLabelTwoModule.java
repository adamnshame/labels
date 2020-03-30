package com.lcms.labels;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class DocumentLabelTwoModule extends AbstractModule {

	@Override
	protected void configure() {
		final MapBinder<DocumentLabelIdentifier, Validator> mapBinder = MapBinder.newMapBinder(this.binder(),
				DocumentLabelIdentifier.class, Validator.class);
		final DocumentLabelIdentifier identifier = DocumentLabelIdentifier.extract(DocumentLabelTwo.class);
		mapBinder.addBinding(identifier).to(DocumentLabelTwoValidator.class);
	}

}
