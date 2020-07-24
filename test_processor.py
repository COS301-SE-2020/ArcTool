import unittest

from app import NLP_Processor

class TestProcessor(unittest.TestCase):
    def test_no_similarity(self):
        # Assume
        processor = NLP_Processor()

        result = processor.process("ce1.txt", "javaDoc.txt")
        # self.assertFalse(result, "Not the same")

    def test_some_similarity(self):
        # Assume
        processor = NLP_Processor()

        result = processor.process("ce2.txt", "javaDoc.txt")
    # # #     # self.assertFalse(result, "Some what Similar")
    # #
    def test_very_similar(self):
        # Assume
        processor = NLP_Processor()

        result = processor.process("clientsEntry.txt", "javaDoc.txt")
        # self.assertFalse(result, "Some what Similar")