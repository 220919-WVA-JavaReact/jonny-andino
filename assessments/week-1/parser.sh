#!/bin/bash

exec < $1 
read header 

while IFS="," read -r fname lname email uname pw
do
  echo "First name: $fname";
  echo "Last name: $lname";
  echo "Email address: $email";
  echo "Username: $uname";
  echo "Password (encoded): $pw";
  echo "+---------------------------------+";
done