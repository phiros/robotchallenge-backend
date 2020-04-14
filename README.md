# Robot challenge

## Task (verbatim for reference)
```
Develop a simple environment for a robot where you could control it using this predefined script:
POSITION 1 3 EAST //sets the initial position for the robot
FORWARD 3 //lets the robot do 3 steps forward
WAIT //lets the robot do nothing
TURNAROUND //lets the robot turn around
FORWARD 1 //lets the robot do 1 step forward
RIGHT //lets the robot turn right
FORWARD 2 //lets the robot do 2 steps forward
This script should be sent from frontend to backend as a single chunk using POST Method. After script execution UI should render a new robot position on the grid and direction it looks to.
Please implement a movement/business logic using Java+Spring in backend. Frontend should be only responsible for submitting the script and rendering robot on the grid.
For aesthetic reasons you should limit the grid in the Frontend for the robot to 5 x 5 steps. The initial grid position is 0,0 and is in the top left corner.
It is optional, if the backend will be also aware of the grid limits.
Frontend should be styled. You could do it yourself or use some framework.
Please create tests for one component, a full test-coverage is not necessary.
You can spend as much time on this task as you like, however, we don't expect you to invest more than 4 to 6 hours on this task. If you are not able to finish everything in the given time-frame, please add a readme.md file that describes, what you'd tell us about your current status in a daily stand-up meeting. We'd love to know what parts you consider finished, what your next steps would be and which of the things you wrote already you'd still like to improve if there was more time. Please send your solution as an archive or via a public development platform (e.g. GitHub).
```

## My understanding of the task

A system should be written which can (i) interpret scripts similar to the one given in the 
description and (ii) place a robot on a 5x5 grid based on the commands in the script. The script
interpretation must happen in the backend part of the application which needs to be written in 
Java on top of Spring boot. The frontend part of the application needs only to consist of a form 
which allows the script to be submitted to the backend as a whole and a grid which shows the robots
calculated end position. 

Unclear points:
1. Does frontend mean SPA or would a template based solution also suffice?
2. What does "Frontend should be styled" mean?

I interpreted 1. that a template based solution would suffice since there is no mentioning of SPA or
JS in the task description. Point 2 I interpret as: "the frontend should be styled a bit so that it
does not look super ugly".

## Task breakdown based on my understanding

In order to complete the challenge I need to develop the following components:

1. Two frontend "components" (/sites). A form which allows for a script to be submitted and 
a site which displays the robots position based on the script.
2. A parser which parses the script.
3. A interpreter which interprets the output of the parser and returns a calculated position. 

## My solution

The solution you are seeing was mostly developed using outside-in TDD. However, my aim was
not to go for 100% test coverage. Especially, methods such as toString and equals are not
explicitly tested (some are tested implicitly though). Also, I should have started 
with a true end to end test. However, this can be quite costly to setup. This is why I choose not
to go for a true end to end test and instead started my TDD journey in the controller.

### A few words about the backend

I tried to have the least amount of dependencies in what I deemed to be the core domain
logic. As a result I also kept the domain package free of any Lombok or Spring annotation / code.

Error handling is implemented in very rudimentary fashion:

* Script lines which cannot be parsed are transformed into a WaitInstruction. 
  This means a parser error is not propagated to a user.
* Should the robot be in danger of moving off-grid it is moved to the closest in-grid position.

### A few words about the frontend

The frontend is as bare bones as it gets but should be okay to look at. I would have preferred to 
design the backend as a REST-ish system and build an SPA in React as the frontend but that would 
have complicated the setup quite a bit. However, for the purpose of this exercise I am quite 
happy with this self contained solution.

### What would I say during a daily?

Yesterday, I implemented the robot in a grid backend + a simple frontend. The frontend is contained
in the backend, since I decided to use Thymeleaf to implement it. It is relatively basic both in 
terms of functionality and look & feel. However, it is fully functional and ready for a review. 

The only thing that I deem worth improving is:
* The frontend look & fell.
* Adding end to end tests.
* Error handling in so far as that (parsing) errors should be displayed to the user in the frontend.
  Currently, the backend treats parsing errors as a wait instruction (practically a NOOP).
* Allowing users to set a custom grid size. Due to the design that emerged this is hard coded in
  two (technically three) places. However, this could be refactored if needed. 
  
### What would I do before starting this task in the real world

Before starting to work on this task I would have done the following:

1. Clarified what "frontend" means for key stakeholders. Is it really just a form for script 
   submission and a grid? Does it need to be a SPA? Is a template based solution sufficient?
2. Clarified what "styled" means for key stakeholders. Are there any examples for the look & feel?
   Do I need to follow a company design system / use a design language?
3. Clarified why the script needs to be processed on the backend.
4. Clarified what the default heading and position should be if there is no "POSITION" at the start 
   of the script. Is this even possible or should this result in an error? 
