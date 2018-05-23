package ltvtvpmc.akademijaIT;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import lt.itakademija.Document;
import lt.itakademija.DocumentConsumer;
import lt.itakademija.DocumentOrganizer;
import lt.itakademija.DocumentProducer;
import lt.itakademija.DocumentTypeDetector;
import lt.itakademija.UnknownDocumentTypeException;

public class DocumentOrganizerImpl implements DocumentOrganizer {
	
	final static Logger logger = Logger.getLogger(DocumentOrganizerImpl.class);


	DocumentTypeDetector documentTypeDetector;

	private int totalDocumentAmount = 0;
	private int totalDocumentLineCount = 0;

	List<Document> documentList;
	
	/**
	 * This organize documents
	 * @param documentTypeDetector
	 */

	public DocumentOrganizerImpl(DocumentTypeDetector documentTypeDetector) {
		super();
		this.documentTypeDetector = documentTypeDetector;

		documentList = new ArrayList();
	}

	@Override
	public long getTotalCount() {
		return totalDocumentAmount;

	}
	/**
	 * This return totalDocumentLineCount
	 * @return  this is total amount of lines.
	 */

	@Override
	public long getTotalLinesCount() {
		return totalDocumentLineCount;
	}

	/**Orgaznice documets given by documentProducer
	 * @param DocumentProducer
	 * @param documentConsumer
	 * 
	 */
	@Override
	public void organize(DocumentProducer documentProducer, DocumentConsumer documentConsumer) {
		if (documentProducer == null || documentConsumer == null) {
			logger.warn("Given param id or summary are equals null (IllegalArgumentExeption)");
			throw new IllegalArgumentException();
		}
		Document document = documentProducer.get();

		while (document != null) {
			logger.warn("Document added to list");
			documentList.add(document);
			document = documentProducer.get();
		}
		for (Document doc : documentList) {

			switch (documentTypeDetector.detect(doc)) {
			case IMPORTANT:
				documentConsumer.consumeImportant(doc);
				break;
			case ORDINARY:
				documentConsumer.consumeOrdinary(doc);
				break;
			case SPAM:
				documentConsumer.consumeSpam(doc);
				break;
			case UNKNOWN:
				throw new UnknownDocumentTypeException("Unkwnwn document type...");
			default:
				throw new UnknownDocumentTypeException("Unkwnwn document type...");

			}

			totalDocumentAmount++;
			totalDocumentLineCount += doc.getLines().size();
		}
	}

}
