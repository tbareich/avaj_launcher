#!/bin/bash

if [[ "$1" == "-f" ]]
then
	find * -name "*.java" > sources.txt
	javac @sources.txt
	java -cp src Simulator $2
elif [[ ! -f sources.txt ]]
then
	find * -name "*.java" > sources.txt
	javac @sources.txt
	java -cp src Simulator $1
else
	java -cp src Simulator $1
fi