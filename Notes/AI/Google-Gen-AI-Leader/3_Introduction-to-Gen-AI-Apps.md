# Introduction to Gen AI Applications

#### Table of Contents
1. [The Google Workspace](#the-google-workspace-with-gemini-)
2. [Prompting Techniques](#prompting-techniques-)
3. [Gemini Advanced](#gemini-advanced-)

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


