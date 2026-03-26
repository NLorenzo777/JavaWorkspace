# Introduction to Gen AI Applications

#### Table of Contents
1. [The Google Workspace](#the-google-workspace-with-gemini-)
2. [Prompting Techniques](#prompting-techniques-)
3. [Gemini Advanced](#gemini-advanced-)
4. [NotebookLM](#notebook-lm-)

#### Summary
- How can AI be integrated to daily workflows
- What are some techniques in improve prompting
- Google's gen AI products that don't require development expertise
- How to develop more automated workflows.


## The Google Workspace with Gemini [^](#introduction-to-gen-ai-applications)

### Google Workspace
A collection of cloud-based productivity and collaboration tools that help people create, communicate, and collaborate.

### Google Workspace business and enterprise
- Is a licensing of Google that comes with extra enterprise-grade data protection for customer's organization. 
- These protections extend to the Google Workspace with Gemini features and the Gemini app (w/ Gemini Advanced).
- The licenses also come with administrative feature for managing the organization's usage and access.


### Google Vids
- an online video creation and editing app available to Google Workspace users through the organization.
- Gemini can be used to generate a first draft of the video.
- As a project manager, this can be used to share project updates, timelines, and key insights with stakeholders to more effectively communicate information than an email or lengthy report can.

### AppSheet
- A no-code app development tool included with Google Workspace enterprise editions.
- Gemini can quickly create apps using AI by describing needs in a prompt using natural language.


## Prompting Techniques [^](#introduction-to-gen-ai-applications)
There are few different approaches when it comes to prompting techniques.

1. **Zero-shot prompting:** Asking a foundation model to complete a task with no prior examples relying solely on its existing knowledge.
2. **One-shot prompting:** Involves showing the foundation model just one example, allowing it to learn and apply that knowledge to similar situations.
3. **Few-shot prompting:** Provides the foundation model with multiple examples to learn from, which it helps it better understand the task and improve its performance.


### Role Prompting
a technique used to guide the behavior of LLMs by assigning them a specific role or persona.

```text
You are a customer service agent for a telecommunications company with ten years of experience. A customer is inquiring about their latest bill, which is higher than expected.
```

### Prompt Chaining
Powerful technique for getting more complex and nuanced results from LLMs like Gemini. 
It's like having a conversation with the AI where each response builds upon the previous one, leading to a more sophisticated and refined outcome.

### Reusing Prompts
Save a repeatedly used prompt as a template and store it on a certain directory accessible to the model.

```text
"Write Python code to [Task]. Use [Libraries/Frameworks] and follow [Coding style guidelines]."
```

## Gemini Advanced [^](#introduction-to-gen-ai-applications)
- An upgraded version of Gemini with extra features, making it far more capable at highly complex tasks, like coding, logical reasoning, following nuanced instructions, and creative collaboration.
- The **Data retention settings** can be adjusted to determine how long information is stored and delete conversation history at any time.

### Saved info
- Using the same prompts in a chain won't always work because sometimes it is only required for the Gen AI tool to remember the context but not everything in the whole conversation history.

### Gems
- These are specific context for particular tasks or conversation.
- This can be important factors such as favorite libraries, coding conventions, access to relevant documentation, programming skills.
- The same with how Kiro is used in TRP project.

### Retrieval-augmented Generation (RAG)
Empowers AI models to go beyond simply memorizing information anf instead learn to effectively access and utilize external knowledge sources
to generate more insightful and reliable outputs.

1. **Retrieving relevant information**
    - The AI model first retrieves relevant information from a vast knowledge base.
    - The retrieval process is often powered by sophisticated techniques like [semantic search](#semantic-search) or [vector database]()
2. **Generating Output**
   - The model the uses the retrieved information to generate the final output.
   - This could be anything from answering a question to writing a creative story.

#### Semantic Search
- A data searching technique that focuses on understanding the contextual meaning and intent behind a user's search query.
- Instead of merely looking for literal matches between search queries and indexed content, it aims to deliver more relevant search.
- Some factors being considered:
  - relationships between words
  - the searcher's location
  - any previous searches
  - the context of the search

#### Vector Database
- any database that allows to store, index, and query vector embeddings, or numerical representations of unstructured data (text, image, video)
- **Vector Embeddings** are numerical representations of data, typically defined as arrays of floating-point numbers.
- How Vector database works:
  - `**Nearest neighbor search (KNN):**` The most common use case is identifying the "k" vectors that are closest to a query vector. This uses distance metrics such as dot product, cosine similarity, or Euclidean distance to measure proximity in the vector space.
  - `**Approximate nearest neighbors (ANN):**` significantly improve search speed by trading off a small amount of accuracy (recall)—an acceptable compromise for most semantic search applications.
  - `**Vector Indexing:**` Organize data so that clusters of nearby vectors are grouped together. Common structures include lists, graphs, and trees
  - `**Metadata Filtering:**` Most applications require more than just semantic similarity. For example, a user might search for a book similar to "a heartwarming story about a fish" (vector search) but limit the results to items "under $20" (metadata filter). Advanced vector databases combine these SQL predicates with vector similarity to execute powerful, hybrid queries.

## Notebook LM [^](#introduction-to-gen-ai-applications)
- NotebookLM is an AI-first notebook, grounded in own documents, designed to help gain insights farther.
- Unique tool that is built using Gemini models acting as a virtual search assistant.
- NotebookLM can be "grounded" in specific sources like documents, presentations, or even audio and video files. This means that the AI assistant will only use information from these sources to answer questions or generate summaries.

### NotebookLM Plus
- A subscription plan that offers benefits like increased capacity, customization of response length and style, and usage analytics.

### NotebookLM Enterprise
- NotebookLM Plus with added compliance and administrative features necessary for enterprise environments.
- Includes extra privacy and security features to give enhanced control over data.
- Notebook information is only shared with chosen collaborators, and can manage access using predefined IAM roles.


## Gemini for Google Cloud
Gemini for Google Cloud offers a suite of AI-powered tools designed to enhance cloud experience.

### Gemini Cloud Assist
- Acts like a cloud AI expert.
- Provides personalized guidance and is integrated with Google Cloud environment to provide application lifecycle management assistance.
- Analyzes cloud environment, resources deployed, as well as metrics and logs to deliver actionable insights tailored to needs.

### Gemini in BigQuery
- Makes data analysis easier and more accessible.
- Help write code, understand data, and even generate insights automatically regardless of SQL experience.
- Promotes faster and more efficient data exploration.

### Gemini Code Assist
- Acts as an AI pair programmer, helping developers write better code.

### Gemini in Colab Enterprise
- A Colab Enterprise notebook is an interactive environment that lets users write and execute code.
- Gemini in Colab Enterprise can use AI to help write python code in notebook by suggesting code segments as you type and generating code based on description.
- Streamlines data analysis and machine learning workflows.

### Gemini in Database
- Helps developers and database administrators manage databases more effectively.
- Uses AI to simplify many aspects of using a database, from building applications with natural language to managing an entire fleet of databases from a single interface.

### Gemini in Looker
- Analyze data and gain insights faster.
- Works as an intelligent assistance which helps understand data, create visualizations, and even generate reports, making data exploration more intuitive.

### Gemini in Security
- Helps security teams detect, contain, and stop threats from spreading.
- Provides near-instant analysis of security findings and potential attack paths.
- Summarizes prevalent tactics, techniques, and procedures used by threat actors, giving customers around the world detailed and timely threat intelligence.





