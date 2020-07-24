import gensim
from nltk.tokenize import word_tokenize, sent_tokenize

class NLP_Processor:
    def process(self, clientsEntry, javaDoc):
        file_docs = []
        with open (javaDoc) as f:
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

        with open (clientsEntry) as f:
            tokens = sent_tokenize(f.read())
            for line in tokens:
                file2_docs.append(line)

        for line in file2_docs:
            query_doc = [w.lower() for w in word_tokenize(line)]
            query_doc_bow = dictionary.doc2bow(query_doc)
            query_doc_tf_idf = tf_idf[query_doc_bow]
            print("Similarity Results:", sims[query_doc_tf_idf])

        print("\n\n")