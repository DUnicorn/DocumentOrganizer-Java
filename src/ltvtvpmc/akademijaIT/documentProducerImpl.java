package ltvtvpmc.akademijaIT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.IRObject;

import lt.itakademija.Document;
import lt.itakademija.DocumentProducer;

public class documentProducerImpl implements DocumentProducer {

	List<Document> documents = new ArrayList();

	Iterator<Document> iterator = documents.iterator();

	public documentProducerImpl(Iterator<Document> iterator) {
		super();
		this.iterator = iterator;
	}

	@Override
	public Document get() {
		while (iterator.hasNext()) {
			return iterator.next();
		}
		return null;
	}
}

