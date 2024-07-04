# Docker Project
### Objective
To deploy a gradle project on docker and executing different APIs

## Description
This gradle project is an example on how to deploy the project in docker and run on network. You will find the Dockerfile with necessary commands to deploy the project and along with this you will find a docker-compose.yml file which is used to map the port, create a volume so that latest code changes are applied whenever the project was edited and deployed without the need of restarting the container.

## How to run

Simply download the code and open it in your favorite editor and ENJOY!!

* To run the project locally you can navigate to the main class i.e, [DockerDeployApplication]() and run it.
* To run the project on docker run the command -  [docker-compose -f docker-compose.yml up]().

### In The Project

You will find many APIs in the project which you can see by first running the project and navigate to 
* if localhost:8080 - [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* if running on network - IP:Port/swagger-ui/index.html

There you will find the necessary API and example APIs


## Sort Methods
Many sort methods were implemented in this project. 
*     radixSort
*     mergeSort
*     bubbleSort
*     insertionSort
*     selectionSort
*     quickSort
*     heapSort

To find more details on how to use those methods. Just give it a try and execute /docker/sort



