#!/bin/bash

#take in a firstname, lastname, username, password and email
echo 'Please enter your First and Last Name, separated by a space:'
read firstname lastname

echo 'Please register an email:'
read email
# validate that email does not exist in database
# validate that email is formatted correctly
echo 'Enter a new Username:'
read username
# validate that usernames do not already exist in database
echo 'Enter a new Password:'
read password
# bonus: have password be invisible upon input? maybe ask twice
# bonus: validate passwords to have a certain level of complexity eg: "one character and one number and one symbol... ect"
# bonus: encrypt passwords

echo "--------------------------------"
echo "Name: ${firstname} ${lastname}"
echo "Username: ${username}"
echo "Password: *****"
echo "email: ${email}"

#validate that the info is correct

#save this information to a csv file