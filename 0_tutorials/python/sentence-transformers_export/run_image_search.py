from sentence_transformers import SentenceTransformer, util
from PIL import Image

#Load CLIP model
model = SentenceTransformer('clip-ViT-B-32')

#Encode an image:
img_emb = model.encode(Image.open('/Users/calvin/Documents/image_root/two_dogs_in_snow.jpg'))

#Encode text descriptions
text_emb = model.encode(['Two dogs in the snow'])

#Compute cosine similarities
cos_scores = util.cos_sim(img_emb, text_emb)
print(cos_scores)