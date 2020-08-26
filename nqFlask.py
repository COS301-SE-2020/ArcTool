from flask import Flask, request
import json
import nltk
import gensim
import numpy as np
from nltk.stem import WordNetLemmatizer
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize, sent_tokenize, RegexpTokenizer

app = Flask(__name__)

@app.route("/api/nlp/v1", methods=["POST", "GET"])
def home():

# https://www.youtube.com/watch?v=RckLqGAkk5o

	stop_words = set(stopwords.words('english'))

	tokenizer = RegexpTokenizer(r'\w+')

	wnl = WordNetLemmatizer()

	req_data = request.get_json()

	results = []

	percentage = 0.6

	java_doc = req_data['java_doc']

	clients_entry = req_data['clients_entry']

	file_docs = []

	tokens = sent_tokenize(java_doc)
	for line in tokens:
		file_docs.append(line)

	gen_docs = [[w.lower() for w in tokenizer.tokenize(text) if not w in stop_words]
		for text in file_docs]
	dictionary = gensim.corpora.Dictionary(gen_docs)

	corpus = [dictionary.doc2bow(gen_doc) for gen_doc in gen_docs]

	tf_idf = gensim.models.TfidfModel(corpus)

	sims = gensim.similarities.Similarity('workdir/',tf_idf[corpus],
										num_features=len(dictionary))

	file2_docs = []

	tokens = sent_tokenize(clients_entry)
	for line in tokens:
		file2_docs.append(line)

	data = []

	for line in file2_docs:
		query = [w.lower() for w in word_tokenize(line)]
		query_doc = [wnl.lemmatize(i) for i in query]
		query_doc_bow = dictionary.doc2bow(query_doc)
		query_doc_tf_idf = tf_idf[query_doc_bow]
		print("\n", sims[query_doc_tf_idf], "\n") 
		if (np.max(sims[query_doc_tf_idf]) >= percentage):
			data.append(str(np.argmax(sims[query_doc_tf_idf])))


	for n in data:
		results.append(file_docs[int(n)])
	return {"results" : results}


if __name__ == "__main__":
	app.run(debug=True)

