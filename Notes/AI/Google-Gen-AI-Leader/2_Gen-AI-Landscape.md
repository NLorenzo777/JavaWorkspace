# Navigate the Gen AI Landscape

## Layers of Gen AI
Generative AI is a powerful technology composed of interconnected layers, each playing a vital role in its capabilities.

1. **Gen AI Applications / Applications**
    - Layer that delivers the AI capability to users through interfaces.
2. **Agents**
    - The layer that utilizes the capabilities of the model layer to perform more complex actions.
    - Interacts with the environment, gathers information and makes decisions and executes actions based on the information received.
3. **Platform**
    - Layer consist of tools and services that help with building and deploying AI models.
    - Includes model training platforms like Vertex AI and data management tools
4. **Models**
   - Where the brain of the AI system reside.
   - Comprised of various algorithms that learns patterns from data and can make predictions or generate new content.
   - Examples are LLMs like Gemini, image recognition models, and recommendation systems.
5. **Infrastructure**
   - The foundation of any AI system comprising the hardware and software that provide the necessary _computing power_, _storage_, and _connectivity_ to train, deploy, and scale AI models.

## Agents
- A gen AI agent is an application that tries to achieve a goal by observing the world and acting upon it using the tools it has at its disposal.
- Think of agents as the intelligent pieces within a larger gen AI powered application.
- Agents can handle multistep processes within an application, such as gathering information, making decisions based on that information, and taking action.
- Agents can learn user preferences and tailor the application accordingly (personalization).

### How Agents Work
There are two categories AI agents falls on: **Conversational** and **Workflow** agents.

1. **Conversational Agents**
    - are designed to understand what you mean, not just what you say, and it responds in a way that makes sense.
    - examples are casual conversation, getting information, answering questions
2. **Workflow Agents**
    - are designed to streamline your work and make sure things get done efficiently and correctly by automating tasks or going through complex processes.
    - examples are order fulfillment, customer onboarding, automated search, security log parsing.
    - Use cases: **Customer service agents**, **Employee productivity agents**, **Creative agents**, **Code agents**, **Data agents**, **Security agents**

## Advanced Prompt Engineering Frameworks
The reasoning loop often utilizes advanced prompt engineering frameworks to guide its decision-making process. These frameworks can include:
- Simple rule-based calculations
- Complex thought chains
- Machine learning algorithms
- Probabilistic reasoning techniques

## The Platform Layer

### Vertex AI's MLOps tools
1. **Feature store:** make ML features reusable and available for use.
2. **Model registry:** Manage model versions, track changes, and organize models throughout their lifecycle.
3. **Model evaluation:** evaluate and compare model performance to identify the best model for use case.
4. **Workflow orchestration:** Automate ML workflows, from data preprocessing to deployment, using `Vertex AI pipelines`.
5. **Model monitoring:** Monitor models for performance, degradation, detect input skew and drift, and trigger updates or retraining.

## The Model Layer
- Think of model as the brain of the operation.
- They are sophisticated mathematical structures trained on massive amounts of data.
- The training process allows model to learn patterns and relationships.

### The Model Garden
- Model Garden on Vertex AI is a service that lets user discover, customize, and deploy existing models from Google and Google partners.
- Gives options to pick from over 160 models and offers options of Google models, third-party models, and open-source models.
- Customize the models through Vertex AI with own data and deploy to custom applications.

## The Infrastructure Layer

### GPUs and TPUs
- Specialized processors and workhorses of AI.
- Excels at parallel processing, doing multiple things at once which is crucial for training large neural networks quickly and efficiently.
- **GPUs** were originally designed for graphics rendering.
- **TPUs** are Google's custom-designed chips specifically optimized for AI tasks.

### Hypercomputer
- Essentially a supercomputer built by connecting many individual computers (nodes) together.
- These node contain GPUs and TPUs.
- By linking these together, they form a high-speed networks and work together as one massive computing unit.

## Costs
The pricing model of gen AI can vary.

### Pricing for using models
1. **Usage based (Pay-as-you-go)**
2. **Subscription based**
3. **Licensing Fees**
4. **Free tiers**

### Pricing metrics for using models
1. **Tokens**
2. **Characters**
3. **Requests**
4. **Compute time**

### Factors affecting costs
1. **Model size**
2. **Context window**
3. **Features**

## Time
The more custom the solution is, the more time and resources it takes to build. Using a prebuilt gen AI application takes seconds.
Therefore, it is important to consider the project's timeline.