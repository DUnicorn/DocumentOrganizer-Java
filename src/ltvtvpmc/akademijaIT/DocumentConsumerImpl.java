package ltvtvpmc.akademijaIT;

import lt.itakademija.Document;
import lt.itakademija.DocumentConsumer;
import lt.itakademija.FileRepository;

public class DocumentConsumerImpl implements DocumentConsumer {

	FileRepository fileRepository;

	public DocumentConsumerImpl(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	@Override
	public void consumeSpam(Document document) {
		fileRepository.putSpam(document);
	}

	@Override
	public void consumeImportant(Document document) {
		fileRepository.putImportant(document);
	}

	@Override
	public void consumeOrdinary(Document document) {
		fileRepository.putOrdinary(document);
	}
}
