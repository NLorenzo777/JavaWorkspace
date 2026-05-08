# AI Concepts

## Predictive AI Model Architectures
- **Classification Models:** Datasets are classified into different categories and relevant information is derived.
- **Regression Models:** Historic data is used to predict a continuous variable like customer lifetime value
- **Clustering Models:** Offers predictions based on common attributes shared by different datasets.
- **Forecast Models:** Predictions are dependent upon historical data and past learnings
- **Time Series Models:** Historical data from a given period is used with other related datasets to predict an outcome over a future period of time.
- **Anomaly detection / Outliers model:** Predicts whether a behavior or data point is abnormal by spotting changes in the usual data pattern.

## LLM Architectures

### Encoder Model
- Widely used for **non-generative tasks** like **classifying** customer feedback and extracting information from long documents.
- Can find and extract useful information from models trained with relatively smaller sets of data.
- **Model Examples:** `Slate`, `BERT`, `RoBERTA`, `DistilBERT`

### Decoder Model
- Trained for **generative tasks** based on their massive, pre-trained datasets to predict the next word without an encoded representation
- Used with chat platforms like ChatGPT to generate new responses, answers or text based on simple input from customers.
- **Model Examples:** `Granite`, `GPT`, `Llama`, `Mistral`

### Encoder-Decoder Model
- Combines features of both **encoder** and **decoder** models.
- Can perform many of the **generative tasks** that decoder-only models can, but their **compact size** makes them **faster** and **cheaper** to tune and serve.
- **Model Examples:** `BART`, `T5`, `Flan-T5`
