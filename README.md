# Robot challenge

## Task (verbatim for reference)

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
3. A interpreter which interprets the output of the parser. 
