from flask import Flask, render_template
import nltk
import gensim
import numpy as np
from nltk.tokenize import word_tokenize, sent_tokenize

app = Flask(__name__)

@app.route("/")
def index():
	file_docs = []
	with open ("javaDoc.txt") as f:
		tokens = sent_tokenize(f.read())
		for line in tokens:
			file_docs.append(line)

	gen_docs = [[w.lower() for w in word_tokenize(text)]
		for text in file_docs]
	dictionary = gensim.corpora.Dictionary(gen_docs)

	corpus = [dictionary.doc2bow(gen_doc) for gen_doc in gen_docs]

	tf_idf = gensim.models.TfidfModel(corpus)

	sims = gensim.similarities.Similarity('workdir/',tf_idf[corpus],
										num_features=len(dictionary))

	file2_docs = []

	with open ('clientsEntry.txt') as f:
		tokens = sent_tokenize(f.read())
		for line in tokens:
			file2_docs.append(line)

	data = [1,2,3,4,5]	
	arr = []	

	for line in file2_docs:
		query_doc = [w.lower() for w in word_tokenize(line)]
		query_doc_bow = dictionary.doc2bow(query_doc)
		query_doc_tf_idf = tf_idf[query_doc_bow]
		# arr.append(np.argmax(sims[query_doc_tf_idf], dtype=np.float32))
		# data.append(arr)

	# b = np.array([5, 6])
	# np.concatenate((data, b), axis=0)

	return render_template("index.html")

if __name__ == "__main__":
	app.run(debug=True)