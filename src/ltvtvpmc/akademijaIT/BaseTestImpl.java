package ltvtvpmc.akademijaIT;

import java.util.Iterator;
import lt.itakademija.*;


public class BaseTestImpl extends BaseTest{

	@Override
	protected DocumentConsumer createDocumentConsumer(FileRepository fileRepository) {
		return new DocumentConsumerImpl(fileRepository);
	}

	@Override
	protected DocumentOrganizer createDocumentOrganizer(DocumentTypeDetector documentTypeDetector) {
		return new DocumentOrganizerImpl(documentTypeDetector);
	}

	@Override
	protected DocumentProducer createDocumentProducer(Iterator<Document> interator) {
		return new documentProducerImpl(interator);
	}
	

}
