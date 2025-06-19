
# Temporal Hello World

This project was created as a simple example to start with Temporal using the concepts of Worker, Workflow and Activities.

You can change the following configurations in the pom.xml file:
- Maven Compiler Version
- Temporal Version
- Spring Cloud Version




## Run Locally

Clone the project

```bash
  git clone https://github.com/XimCervantesPatlan/Temporal-Hello-World.git
```

Go to the project directory

```bash
  cd hello-world-demo
```

Start the local server

```bash
  temporal server start-dev
```

Run the Main program to start the project and check the status of your workflows in http://localhost:8080/.

To start a Workflow send a GET request like this:

```bash
  http://localhost:8080/greetings/Ximena
```
