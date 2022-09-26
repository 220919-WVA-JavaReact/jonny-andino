#!/bin/bash

key=${2}
value=${3}

sh parser.sh ${1} | grep "^${key}: ${value}$";