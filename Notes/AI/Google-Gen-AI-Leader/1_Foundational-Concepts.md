# Gen AI: Unlock Foundational Concepts

## Understanding AI, ML, and Generative AI
- **Artificial Intelligence (AI):** The broad field of building machines that can perform tasks requiring human intelligence.
  - **Machine Learning:** A subset of AI where machines learn from data. Machines are trained through data to provide insights.
    - **Deep Learning:** Distinguished by use of artificial neural networks. 
    - **Generative AI:** An application of AI that creates new content.

## Importance of Data in AI

### Machine Learning Models (ML Models)
ML Models analyze the data they've been given, identify patterns, and then calculate the likelihood of different outcomes when presented with new information.

### Data Quality
There are five factors to focus on when thinking about data quality.

1. **Accuracy:**
   - If the datas is inaccurate, the model will learn incorrect patterns and make faulty predictions.
2. **Completeness:**
   - Refers to the size of a dataset as well as representation within the dataset.
   - This is important because the model needs enough to make an accurate prediction.
   - The larger the dataset the better the calculation.
3. **Representative:**
   - Data needs to be representative and inclusive, otherwise it can lead to skewed samples and biased outcomes.
   - If a dataset about customer preferences is missing information about a certain demographic, the model might make inaccurate or biased generalizations about that group.
4. **Consistency:**
   - Inconsistent data formats or labeling can confuse the model and hinder its ability to learn effectively.
   - Imagine trying to assemble a puzzle where some pieces are labeled with numbers and others with letters - it would be a mess.
5. **Relevance:**
   - Data must be relevant to the task the AI is designed to perform.
   - Data about traffic patterns in London is unlikely helpful for predicting crop yields in Kansas.

### Data Types
- Various data types can be used in ML, but data is not just about numbers and files.
- Business datasets help organizations understand customers, optimize operations, and drive strategic decisions.

#### Structured Data Type
- Imagine your contact list on your phone. It has names, phone numbers, and maybe addresses, all organized in a list.
- Often stored in something called a **relational database**.

#### Unstructured Data Type
- Data that lacks predefined structure.
- It is messy and complex by nature and cannot be easily organized in rows and columns. Hence, sophisticated analysis is required.
- Examples of unstructured data include things like text documents (PDFs, emails, social media posts), images (photographs, digital artwork, medical scans), audio (speech recordings, music files), and video (movies, YouTube videos, smartphone videos).
- Feedback (free-form text), Product image, email content.


### Labeled Data vs Unlabeled Data
- **Labeled Data**
  - Labeled data has tags such as name, type or number. These tags whether applied manually or automated assign meaning to the data.
  - For instance, an image dataset for training a cat-detection model would label each picture as either a cat or dog. Similarly, a set of customer reviews might be labeled as positive, negative, or neutral.
  - These labels enable algorithms to learn relationships and make accurate predictions.
- **Unlabeled Data**
  - Data that is not tagged or labeled in any way. It is raw, unprocessed information without inherent meaning.
  - Examples of unlabeled data include a collection of unorganized photos, a stream of audio recordings, or website traffic logs without user categorization.
  - In these cases, algorithms must independently discover patterns and structures within the data, as there are no pre-existing labels to guide the learning process.

## Types of Learning
Machine learning has three primary learning approaches.

1. **Supervised models**
   - Trains models on **labeled data**, where each input is pared with its correct output, allowing the model to learn the relationship between them.
   - The model's goal is to identify patterns and relationships within this labeled data, enabling it to accurately predict outputs for new, unseen inputs.
   - **Example:** Predicting housing prices is a common example of supervised learning. A model is trained on a dataset where each house has labeled data, such as its size, number of bedrooms, location, and the corresponding sale price. This labeled data allows the algorithm to learn the relationship between the features of a house and its price. Once trained, the model can then predict the price of a new house based on its features.
  
2. **Unsupervised models**
   - Deals with raw, unlabeled data to find natural groupings.
   - Instead of learning from labeled data, it dives headfirst into a sea of unlabeled data.
   - For example, an unsupervised learning algorithm could analyze customer purchase history from your company's database. It might uncover hidden segments of customers with similar buying habits, even though you never explicitly labeled those segments beforehand. This can be incredibly valuable for targeted marketing or product recommendations.

3. **Reinforcement Learning**
    - All about learning through interaction feedback.
    - Imagine a robot learning to navigate a maze. It starts with no knowledge of the maze's layout. As it explores and interacts with the maze, it collects data - bumping into walls (negative feedback) or finding shortcuts (positive feedback).
    - The algorithm learns which actions lead to the best outcomes through trial and error.

## Data Tools and Management for ML workloads (ML Lifecycle)

### 1. Gather Data
Google Clouds supports data ingestion through several tools.
- **Pub/Sub:** handles real time streaming data processing, regardless of the structure of the data.
- **Cloud Storage:** well-suited for storing unstructured data.
- **Cloud SQL and Cloud Spanner:** for managing structured data.

### 2. Prepare Data
Clean and transform raw data into a usable format for analysis or model training. Involves formatting and labeling data properly.
- **BigQuery** for data analysis to filter data, correct inconsistencies, and handle missing values
- **Data Catalog** for data governance, find relevant data for ML project. Provides centralized repository to easily discover datasets in organization.

### 3. Train Model
- The process of creating ML model using data is called **model training**.
- **Google Cloud's Vertex AI platform** provides a managed environment for training ML models.
  - set parameters and build your model, using prebuild containers for popular machine learning frameworks, custom training jobs, and tools for model evaluation.

### 4. Deploy and Predict
- Process of making a trained model available for use.
- **Vertex AI** simplifies this by providing tools to put the model into action for generating predictions. This includes scaling the deployment.

### 5. Manage the Model
Model management is the process of managing and maintaining models over time. 

Google Cloud offers tools for managing the entire lifecycle of ML models. This includes:
- **Versioning:** Keep track of different versions of model.
- **Performance Tracking:** Review the model metrics
- **Drift monitoring:** Watch for changes in the model's accuracy overtime.
- **Data management:** Use Vertex AI Feature Store to manage the data features the model uses.
- **Storage:** Use Vertex AI Model Garden to store and organize the models in one place.
- **Automate:** Use Vertex AI Pipelines to automate your machine learning tasks.

## Deep Learning
- A powerful subset of machine learning distinguished by its use of artificial neural networks.
- These networks enable the processing of highly complex patterns and the generation of sophisticated predictions.
- Neural networks can leverage both labeled and unlabeled data. A strategy known as **semi-supervised learning**.

**Generative AI** uses the power of deep learning to create new content spanning text, images, audio, and beyond.
**Deep learning techniques**, particularly those centered on neural networks, are the engine behind these generative models.


### Foundation Models
- Foundation models use deep learning.
- They are trained on massive datasets that allow them to learn complex patterns and perform a variety of tasks across different domains.
- Incredibly powerful machine learning models trained on massive scale, often using vast amounts of **unlabeled data** which allows them to develop a broad understanding of the world, capturing intricate patterns and relationships within the data they consume.

### Large Language Models
- A type of foundational models that are specifically designed to understand and generate human language.
- Can translate languages, write different kinds of creative content, answer questions in an informative way, even if the questions are open-ended, challenging, or strange.

### Diffusion Models
- Another type of foundational model that excell in generating high-quality images, audio, and even by iteratively refining noise into structured data.

### Factors in choosing a model

1. **Modality:** Talks about the type of input data the model must handle. _specific modality_ or _multimodal_.
2. **Context Window:** The larger the context window, the longer it remembers previous conversations.
3. **Security:** The model must comply with relevant security standards and regulations for industry.
4. **Availability and Reliability:** consistently available and performs reliably under load.
5. **Cost:** Gen AI models can vary significantly in cost.
6. **Performance:** Accuracy, speed, and efficiency is a critical factor.
7. **Fine-tuning and customization:** for a specialized use case which allows to train models even further.
8. **Ease of integration:** APIs and SDKs

### Google Cloud's ML Models
With Vertex AI, models developed byu Google can be accessed such as:

1. **Gemini:** understand and operate across diverse data format such as text, images, video, and audio.
2. **Gemma:** For developers that offers user-friendly and customizable solution for local deployments and specialize AI applications.
3. **Imagen:** Powerful text-to-image diffusion model for generating high-quality images.
4. **Veo:** A model capable of generating video content. Produce video based on textual descriptions or still images.

### Techniques to overcome limitations

1. **Grounding**
    - The process of connecting the AI's output to verifiable sources of information like giving an AI a reality check.
2. **Retrieval-Augmented Generation (RAG)**
   - A grounding method that uses search to find relevant information from a knowledge base and provides that information to the LLM, giving it necessary context.
   - When a question is asked on an AI, RAG uses a search engine to find relevant information. This search engine uses an index that understands the semantic meaning of the text, not just keywords.
   - The retrieved information is _augmented_ to the prompt given to the AI.
   - The AI then uses the augmented prompt, along with its existing knowledge base to generate a response.
3. **Prompt Engineering**
    - Supplying supplementary background information to models.
    - This involves crafting precise prompts to guide the model towards desired outputs.
4. **Fine-Tuning**
    - Involves further training a pre-trained or foundation model on a new dataset specific to the new task.
    - This process adjusts the model's parameters, making it more specialized for needs.