# Generative AI Agents

#### Table of Contents
1. [Models](#models-)
2. [Google Gen AI APIs](#google-generative-ai-apis-)
3. [Reasoning Loop](#the-reasoning-loop-)
4. [Prompt Engineering Techniques](#prompt-engineering-techniques-)
5. [Types of Agent Tools](#types-of-agent-tools-)
6. [Google's Agent Tooling](#googles-agent-tooling-)
7. [RAG and Tooling](#rag-and-tooling-)
8. [Search Agents](#search-agents-)
9. [Gen AI for Customer Engagement](#gen-ai-for-customer-engagements-)



## Models [^](#Generative-ai-agents)
Generative AI agents are powered by Generative AI models which serves as the brains of the operation.

Once AI models are trained and ready to go, there are still ways to improve the desired results.
One such way is by adjusting certain parameters and settings.

### Sampling Parameters and Settings
- Sampling parameters act as settings that influence the AI model's behavior, giving more customized results.
- Think of these as knobs and dials that can be adjusted with prompt input to impact the model's output.
- By tweaking these settings, the user can ensure the model's output aligns with specific needs, whether it is generating more creative text,
providing more concise summaries, or staying within a certain tone.

#### 1. Token Count
- Rather than reading the whole sentence at once, the model breaks text down into these chunks.
- A token can be a whole word, part of a word, or even a single space or punctuation mark.
- Models have limits on how many tokens they can handle. A higher token count allows for longer conversations but requires more processing power.
- As a rule of thumb, one token is roughly four characters in English. So, 100 tokens are about 60 to 80 words.

#### 2. Temperature
- Controls the "creativity" of the model, because it adjusts the randomness of word choices during text generation, influencing the diversity and unpredictability of the output.
- A higher temperature makes the output more random and unpredictable, while a lower temperature makes it more focused, deterministic, and repeatable.

#### 3. Top-p (nucleus sampling)
- `Top-p` stands for cumulative probability of the most likely tokens considered during text generation.
- This is another way to control the randomness of the model's output.
- It concentrates the probability on the most likely tokens, making the output more coherent and relevant.
- A lower Top-p value leads to a more focused response, while higher value allows for more diversity.

#### 4. Safety Settings
- Allows to filter out potentially harmful or inappropriate content from the model's output.
- Adjust the level of filtering based on specific needs and preferences.

#### 5. Output Length
- Determines the maximum length of the generated text.
- Can be set to specific number of words or characters to allow the model to generate text until it reaches a natural stopping point.

#### How do these settings and sampling parameters accessed?
- The way these things are accessed varies based on where the models are coming from.
- An application will use an API to send prompt to the model and receive a response. 
- These API often allows to customize the model's behavior by taking settings and parameters as input along with the prompt.

## Google Generative AI APIs [^](#Generative-ai-agents)
Offer pre-trained LLMs that can be fine-tuned for specific tasks. These APIs include capabilities for text completion, 
multi-turn chat, code generation, image generation. For example, Imagen API can be used to generate and customize images.

### Google AI Studio
- a web-based tool that allows developers, students, and researchers to try Gemini models and begin building with the Gemini Developer API.
- Designed for ease of use and accessibility, targeting a broad audience, including non-technical users who want to leverage AI without deep expertise.

### Vertex AI Studio
- A Google Cloud console tool for rapidly prototyping and testing generative AI models.
- Provides developers with a space to test models using prompt samples, design and save prompts, and tune foundation models.

## The Reasoning Loop [^](#Generative-ai-agents)
- A key component of a generative AI that governs how the agent takes information, performs **internal reasoning**, and uses that reasoning to inform its next action or decision.
- An iterative, introspective process that continues until the agent achieves its goal or reaches a stopping point.
- The complexity of the reasoning loop can vary greatly depending on the agent and the task it is performing.

### Key aspect of the reasoning loop
1. **Iterative Process:** The reasoning loop is a cyclical process where the agent continuously evaluates its progress and determine the best course of action.
2. **Internal Reasoning:** The agent uses its underlying LM to think through the steps it needs to take a complete a task.
3. **Decision-Making:** Based on the internal reasoning, the agent decides on the next course of action
4. **Reasoning Framework:** Utilizes various prompt engineering frameworks and techniques to guide reasoning and planning.

## Prompt Engineering Techniques [^](#Generative-ai-agents)
There are many different prompting techniques that one can use. Below are the two common promptings:

1. `ReAct Prompting:`
    - Prompting framework that allows the language model to reason and take action on a user query, with or without context example.
    - Stands for "reasoning and acting".
    - Allows the LLM to not only think about a problem but also take actions to solve it.
    - This is a big step up from traditional prompting, where the LLM could only passively generate text.
    - The LLM can passively **think**, **act**, **observe**, **respond**
      - **Think:** The LLM generate a thought about the problem.
      - **Act:** The LLM decides what action to take.
      - **Observe:** The LLM receives feedback from the action. Such as search result or database entries.
      - **Respond:** The LLM generates a response such as providing an answer or formulating a new thought for the next iteration.
2. `Chain-of-thought Prompting:`
    - Technique where you guide a LM through a problem-solving process by providing examples with intermediate reasoning steps, helping it learn to approach new problems in a more structured and logical way.
    - The user provide examples on how to solve similar problems which shows the steps involved.
    - Key components of CoT
      - **Self-consistency:** Encouraging the LLM to generate multiple solutions and choose the most consistent one.
      - **Active-prompting:** Allowing the LLM to ask clarifying questions or request additional information.
      - **Multimodal CoT:** Combining text with other forms of data, like images, or videos to enhance reasoning.

## Types of agent tools [^](#Generative-ai-agents)
Agent tooling equips agents with the resources they need to be effective. This is like providing the agent with the right skills, connections, and knowledge to achieve its goals.

### 1. Extensions (APIs)
- Extensions bridge between an agent and APIs.
- APIs are set of rules that govern how software interacts.
- Extensions provide a standardized way for agents to use APIs.
- Example, An agent designed to book travel might use an extension to interact with a travel company’s API.

### 2. Functions
- Functions are like specialized tools within the agent's toolbox. They represent **specific actions** the agent can perform.
- An agent's reasoning system selects the appropriate function based on the task at hand.
- Functions can encapsulate complex logic or interactions, making them reusable and manageable.
- Example, A "calculate_price" function might take flight details and passenger information as input and return the total cost

### 3. Data Stores
- Provide agents with **access to information**. This can include real-time data, historical data, or knowledge bases.
- Ensure that the agent's responses are accurate, relevant, and up-to-date.
- Example, An agent might use a data store to access current weather conditions, stock prices, or a database of customer information.

### 4. Plugins
- Extend the agent's capabilities by adding new skills or **integrations**. They can connect the agent to specific services, provide access to specialized tools, or enable interaction with particular platform.
- Example, A plugin could enable an agent to interact with a calendar application, allowing it to schedule appointments.


## Google's Agent Tooling [^](#Generative-ai-agents)
Below are some of the relevant **Google Cloud services** for agent tooling
- `Cloud Storage:` Highly scalable and durable object storage service. Use Cloud Storage to store and retrieve data that agent needs.
- `Databases (Cloud SQL, Spanner, Firestore):` Google Cloud database solutions to suit needs. Agent can use these DBs to store and retrieve information.
- `Cloud Run Functions:` Create serverless functions that act as specialized tool for agent. Easily triggered by agent and scales automatically.
- `Cloud Run:` For more complex agent tools that require containerized environments. Provides a serverless platform for deploying and running stateless containers.
- `Vertex AI:` Agents can use other agents as tooling. Can be used to create models or agents that are called as tooling by other agents.

### Pre-build AI APIs
- `Speech-to-Text API`
- `Text-to-Speech API`
- `Translation API`
- `Document Translation API:` translate formatted documents while keeping the original layout.
- `Document AI API:` Extracts data from various document formats. Automate data capture and document processing.
- `Cloud Vision API:` understand the content of an image by applying powerful ML models
- `Cloud Video Intelligence API:` analyze video content and extract meaningful information.
- `Natural Language API:` Derive insights from unstructured text using Google's ML. Understand the sentiment of text, classify content, and extract important entities such as people, places and events.

### Google's No-Code and Low-Code Tooling
- `Apps Script:`
  - Cloud-based platform that lets automate Google Workspace tasks by leveraging a combination of JS code and Google's build-in services.
  - Can be used with Gemini API to build add-ons that enhance features in Google Workspace using Generative AI.
- `AppSheet:`
  - No-code platform for building custom business apps.
  - Can be used together with App Script to extend capabilities of applications using custom logic or by integrating APIs.

### Reference
- [Creating an AI API Key](99_Ref_Creating-API-Key.md)

## RAG and Tooling [^](#Generative-ai-agents)
- Before RAG, models could not directly learn from tool data.
- They could use tools to fetch information, but lacked the ability to process and integrate data into their knowledge.
- Their understanding was limited to their training data, and tool-retrieved data was used only for the immediate query, not for learning
- RAG solves this by enabling models to retrieve and learn from data provided by tools.

#### 1. Retrieval
- **Data Stores**
  - These can be internal databases or other sources of structured and unstructured data.
- **Vector Databases:**
  - Databases store embeddings (numerical representations) of text, allowing the LLM to find semantically similar information to the user's query.
  - The LLM uses the user query to create an embedding and searches the vector database for matching documents or passages.
- **Search engines:**
  - The LLM can use search engines (via extensions or API) to find relevant web pages, articles, or other online content.
- **Knowledge Graphs:**
  - The LLM can query knowledge graphs to retrieve facts and relationships relevant to the user's query.

#### 2. Augmentation
The retrieved information is then incorporated (or "augmented") into the prompt that is fed to the LLM. This augmented prompt now contains both the user's original query and the relevant context retrieved from external sources.

#### 3. Generation
The LLM processes the augmented prompt and generates a response. Because the prompt includes relevant external information, the LLM can generate a more informed, accurate, and contextually appropriate response. It can also cite the sources of its information, increasing transparency and trustworthiness.

### Iteration
- In some RAG systems, the LLM might iterate on the retrieval process.
- if the initial retrieval doesn't yield satisfactory results, the LLM might refine its query or use different retrieval tools to find more relevant information.
- It could also ask clarifying questions of the user. 
- This iterative process allows the LLM to continuously improve the quality and relevance of its responses.

### Data Stores
RAG allows LLM to access and process information beyond their training data, making them more accurate and relevant.

1. **Websites**
    - Access and process information directly from web pages, enabling the agent to stay up-to-date with current events or access publicly available information
2. **Structured Data:**
    - Connect to information organized in JSON format or tables such as product catalogs, customer DBs, internal knowledge bases.
    - Vertex AI can automatically understand the structure of data or allow to define it.
3. **Unstructured Data:**
    - Utilize files in various formats such as HTML, PDF, and DOCX, making it possible for the agent to access information from a wide range of sources.

## Search Agents [^](#Generative-ai-agents)

### Vertex AI Search
- Vertex AI Search offers both search and recommendation solutions.
- Search allows to create a powerful search experience for public website.
- It can index and search across a variety of data types, including structured data in BigQuery and unstructured documents in Google Cloud Storage.

## Gen AI for Customer Engagements [^](#Generative-ai-agents)

### Gemini Enterprise for CX
- Provides an agentic solution designed to bring shopping and customer service together on a single intelligent interface.
- The tools are built using Gemini Multimodal models, enabling agents to use complex reasoning to understand intent and execute multistep tasks.
- All of this can be built on top of Google's `Contact Center as A Service (CCaaS)`. An enterprise-grade contact center solution that is native to the cloud.
  - CCaaS manages infrastructure, integrates with CRMs, and offers omnichannel support.
  - handles simultaneous multichannel communication, channel switching, multimodal interactions, agent routing, freeing businesses to focus on customer experiences.

#### 1. Customer Experience Agents
- Acts as an effective chatbots communicating with customers.
- `Customer Experience Agent Studio` allows to create powerful CX agents.
- This hybrid approach allows you to build agents that don’t just talk—they take action, such as processing a refund or scheduling a delivery.
- **Deterministic**, **Generative**, **Hybrid**

#### 2. Agent Assist
- Support live human contact center agents
- Supports live human agents with in-the-moment assistance, generated responses, and real-time coaching to help resolve customer issues faster and with greater accuracy.
- Leveraging Gemini multimodal models, this can recommend agent responses to customers, suggest appropriate knowledge base content to solve a customer's issue, transcribe or translate calls in real time, and summarize conversation.


#### 3. Customer Experience Insights
- Gain insights into all communications with customers (through chatbot agents or human agents)
- Analyzes conversational data from across the customer journey to provide contact center leaders and managers with the data-driven insights to boost efficiency.
- Automatically identifies interesting customer interactions in need of further review and automatically score interactions using conditional scorecards.